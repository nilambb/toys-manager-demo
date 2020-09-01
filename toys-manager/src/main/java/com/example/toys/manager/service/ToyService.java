package com.example.toys.manager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.toys.manager.model.Toy;
import com.example.toys.manager.reposity.ToyRepository;

@Service
public class ToyService {
	@Autowired
	ToyRepository toyRepository;

	public List<Toy> getAllToys() {
		return toyRepository.findAll();
	}

	public Optional<Toy> getToyById(int toyId) {
		return toyRepository.findById(toyId);
	}

	public Toy create(Toy toy) {
		return toyRepository.save(toy);
	}

	public Toy updateToyById(Toy toy, int toyId) throws Exception {
		Optional<Toy> originalStore = getToyById(toyId);
		if (originalStore.isPresent()) {
			originalStore.get().setCategory(toy.getCategory());
			originalStore.get().setIdealAgeYearsLower(toy.getIdealAgeYearsLower());
			originalStore.get().setIdealAgeYearsUpper(toy.getIdealAgeYearsUpper());
			originalStore.get().setToyName(toy.getToyName());
			originalStore.get().setColour(toy.getColour());
			return toyRepository.save(originalStore.get());
		} else {
			throw new Exception("Specified toy doesn't found");
		}

	}

	public void delete(int toyId) {
		toyRepository.deleteById(toyId);

	}

}
