package com.example.toys.manager.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.toys.manager.model.Store;
import com.example.toys.manager.model.Toy;
import com.example.toys.manager.reposity.StoreRepository;
import com.example.toys.manager.reposity.ToyRepository;

@Service
public class StoreService {
	@Autowired
	StoreRepository storeRepostory;

	public List<Store> getAllStores() {
		return storeRepostory.findAll();
	}

	public Optional<Store> getStoreById(int id) {
		return storeRepostory.findById(id);
	}

	public Store create(Store store) {
		return storeRepostory.save(store);
	}

	public void delete(int storeId) {
		storeRepostory.deleteById(storeId);
	}

	public Store updateStoreById(Store store, int storeId) throws Exception {
		Optional<Store> originalStore = getStoreById(storeId);
		if (originalStore.isPresent()) {
			originalStore.get().setCity(store.getCity());
			originalStore.get().setAddress(store.getAddress());
			originalStore.get().setDescription(store.getDescription());
			originalStore.get().setPincode(store.getPincode());
			originalStore.get().setStoreName(store.getStoreName());
			return storeRepostory.save(originalStore.get());
		} else {
			throw new Exception("Specified stoered id is not present");
		}
	}

}
