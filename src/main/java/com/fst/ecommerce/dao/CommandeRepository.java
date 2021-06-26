package com.fst.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fst.ecommerce.model.Commande;

public interface CommandeRepository extends JpaRepository<Commande,Integer> {

}
