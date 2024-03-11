package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.VezbaDTO;
import com.example.demo.services.MisiciService;
import com.example.demo.services.VezbeService;

import jakarta.validation.Valid;
import model.Misici;
import model.Vezbe;

@Controller
@RequestMapping("/vezbe/")
public class VezbeController {
	@Autowired
	MisiciService ms;
	
	@Autowired
	VezbeService vs;
	
	@GetMapping("sveVezbe")
	public String sveVezbe (@RequestParam(name = "searchQuery", required = false, defaultValue="") String searchQuery, @RequestParam(name = "misicId", required = false, defaultValue="-1") String idMisica, @RequestParam(name = "samoOmiljeni", required = false, defaultValue="false") String samoOmiljeni, Model m) {
		m.addAttribute("vezbe", vs.getVezbe(searchQuery, idMisica, samoOmiljeni));
		return "index";
	}
	
	@GetMapping("dodajOmiljenu")
	public String dodajOmiljenu(@RequestParam(name = "id", required = true) Integer vezbaId) {
		vs.editOmiljenu(vezbaId, true);
		
		return "redirect:/vezbe/sveVezbe";
	}
	
	@GetMapping("ukloniOmiljenu")
	public String ukloniOmiljenu(@RequestParam(name = "id", required = true) Integer vezbaId) {
		vs.editOmiljenu(vezbaId, false);
		
		return "redirect:/vezbe/sveVezbe";
	}
	
	@GetMapping("dodajVezbu")
	public String dodajVezbu () {
		return "nova-vezba";
	}
	
	@ModelAttribute("misici")
	public List<Misici> getMisici() {
		return ms.getMisici();
	}
	
	@ModelAttribute("omiljene")
	public List<Vezbe> getOmiljene() {
		return vs.getOmiljene();
	}
	
//	@ModelAttribute("vezbe")
//	public List<Vezbe> getVezbe() {
//		return vs.getVezbe();
//	}
	
	@ModelAttribute("vezbaDTO")
	public VezbaDTO newFile () {
		return new VezbaDTO();
	}
	
	
	@PostMapping("sacuvajVezbu")
	public String sacuvajVezbu(@Valid VezbaDTO file, BindingResult result, Model m) {
		if (result.hasErrors()) {
			m.addAttribute("errors", result.getAllErrors());
		} else {
			boolean ok = vs.saveVezba(file, "/Users/milan/Projects/College/RIS/FitTracker/FitTrackerWeb/src/main/webapp/images");
			
			if (ok) {
				m.addAttribute("message", "Vežba je uspešno dodata.");
			} else {
				m.addAttribute("message", "Dodavanje vežbe nije uspelo.");
			}
		}
		
		return "nova-vezba";
	}
	
}