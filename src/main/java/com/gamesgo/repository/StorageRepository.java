package com.gamesgo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gamesgo.model.Storage;

public interface StorageRepository extends JpaRepository<Storage, Integer> {

}
