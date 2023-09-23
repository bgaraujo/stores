package com.home.store.repository;

import com.home.store.entities.Store;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long>{
}
