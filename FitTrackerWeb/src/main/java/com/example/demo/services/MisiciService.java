package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repositories.MisiciRepository;

import model.Misici;

@Service
public class MisiciService {
	@Autowired
	MisiciRepository mr;
	
	public List<Misici> getMisici() {
		return mr.findAll();
	}
}