package com.mexpedition.repository;

import com.mexpedition.model.Expedition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExpeditionRepository extends JpaRepository<Expedition, Long> {
    Optional<Expedition> findByIdCommande(int idCommande);
}