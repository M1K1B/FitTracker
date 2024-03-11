package com.example.demo.services;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.VezbaDTO;
import com.example.demo.repositories.KorisniciRepository;
import com.example.demo.repositories.MisiciRepository;
import com.example.demo.repositories.OmiljeneRepository;
import com.example.demo.repositories.PogadjaRepository;
import com.example.demo.repositories.VezbeRepository;

import model.Korisnici;
import model.Misici;
import model.Omiljene;
import model.Pogadja;
import model.Vezbe;

@Service
public class VezbeService {
	@Autowired
	VezbeRepository vr;
	
	@Autowired
	PogadjaRepository pr;
	
	@Autowired
	MisiciRepository mr;
	
	@Autowired
	KorisniciRepository kr;
	
	@Autowired
	OmiljeneRepository or;
	
	public List<Vezbe> getVezbe(String searchQuery, String idMisica, String samoOmiljeni) {
		List<Vezbe> toReturn = new ArrayList<Vezbe>();
		
		if (!idMisica.contains("-1")) {
			toReturn = pr.findVezbeByMisickId(Integer.parseInt(idMisica));
			System.out.println(idMisica != "-1");
		}
		else if (samoOmiljeni.contains("on")) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			
			if (auth.getName() != "anonymousUser")
				toReturn = or.findVezbeByKorisnikId(kr.findByUsername(auth.getName()).getIdKorisnika());
			
			System.out.println(4);
		}else {
			toReturn = vr.findAllBySearchQuery('%' + searchQuery + '%');
		}
		
		
		return toReturn;
	}
	
	public boolean saveVezba(VezbaDTO fileWrapper, String filePath) {
		try {
			MultipartFile file = fileWrapper.getSlika();

			if (file.isEmpty())
				return false;

			String fileName = fileWrapper.getNaziv().toLowerCase().replace(' ', '-');
			
			File directory = new File(filePath);

			String extension = "";
			String originalFileName = file.getOriginalFilename();
			if (originalFileName != null) {
				String[] slugs = originalFileName.split("\\.");
				extension += slugs[slugs.length - 1];
			}
			uploadVezba(fileWrapper, "../images/" + fileName + "." + extension);
			
			File finalFile = new File(filePath + "/" + fileName + "." + extension);
			file.transferTo(finalFile);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public int uploadVezba(VezbaDTO vezba, String slikaPth) {
		Vezbe nova = new Vezbe();

		nova.setNaziv(vezba.getNaziv());
		nova.setOcena(5);
		nova.setOpis(vezba.getOpis());
		nova.setSlika(slikaPth);

		try {
			
			Vezbe nv = vr.save(nova);
			
			Pogadja pog = new Pogadja();
			pog.setMisici(mr.findById(vezba.getMisicId()).get());
			pog.setVezbe(nv);
			pr.save(pog);
			
			return nv.getIdVezbe();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public List<Vezbe> getOmiljene() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Korisnici k;
		List<Vezbe> lista = new ArrayList<Vezbe>();
		
		if (auth.getName() != "anonymousUser") {
			  k = kr.findByUsername(auth.getName());
			  
			  
			for (Omiljene om : k.getOmiljenes()) {
					lista.add(om.getVezbe());
			}
		}
		
		return lista;
	}
	
	@Transactional
	public void editOmiljenu(int vezbaId, boolean isAdd) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Korisnici k;
		
		if (auth.getName() != "anonymousUser") {
			k = kr.findByUsername(auth.getName());
			
			if (isAdd) {
				Omiljene om = new Omiljene();
				om.setKorisnici(k);
				om.setVezbe(vr.findById(vezbaId).get());
				
				or.save(om);
			} else {
				or.deleteByVezbaAndKorisnik(vezbaId, k.getIdKorisnika());
			}	
		}
	}
}