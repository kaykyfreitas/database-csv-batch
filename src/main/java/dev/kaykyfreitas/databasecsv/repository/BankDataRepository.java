package dev.kaykyfreitas.databasecsv.repository;


import dev.kaykyfreitas.databasecsv.entity.BankData;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankDataRepository extends JpaRepository<BankData, Integer> {

    Optional<BankData> findByPersonId(Integer personId);

}
