package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.TreningDTO;
import com.example.demo.repositories.KorisniciRepository;
import com.example.demo.repositories.TreninziRepository;
import com.example.demo.repositories.UradioRepository;
import com.example.demo.repositories.VezbeRepository;

import model.Korisnici;
import model.Pogadja;
import model.Treninzi;
import model.Uradio;
import model.Vezbe;

@Service
public class TreninziService {
	@Autowired
	TreninziRepository tr;
	
	@Autowired
	KorisniciRepository kr;
	
	@Autowired
	VezbeRepository vr;
	
	@Autowired
	UradioRepository ur;
	
	public List<Treninzi> getTreninzi() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Korisnici k = kr.findByUsername(authentication.getName());
		
		return tr.findAllByUser(k.getIdKorisnika());
	}
	
	public int uploadTrening(TreningDTO trening) {
		try {
			Treninzi trn = new Treninzi();
			
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			Korisnici k = kr.findByUsername(authentication.getName());
			
			trn.setDatum(trening.getDatum());
			trn.setKorisnici(k);
			trn.setNaziv(trening.getNaziv());
			
			Treninzi trF = tr.save(trn);
			
			for (int i = 0; i < trening.getIdVezbi().length; i++) {
				Uradio singleUr = new Uradio();
				
				singleUr.setVezbe(vr.findById(trening.getIdVezbi()[i]).get());
				singleUr.setBrPonavljanja(trening.getPonavljanja()[i]);
				singleUr.setBrSerija(trening.getSerije()[i]);
				singleUr.setTreninzi(trF);
				
				ur.save(singleUr);
			}
			
			return trF.getIdTreninga();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	@Transactional
	public void obrisiTrening(int id) {
		tr.deleteById(id);
	}
}