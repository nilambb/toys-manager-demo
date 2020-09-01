package com.example.toys.manager.reposity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.toys.manager.model.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Integer> {

}
