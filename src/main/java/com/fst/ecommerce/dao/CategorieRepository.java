package com.fst.ecommerce.dao;

import com.fst.ecommerce.model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.fst.ecommerce.dao")
public interface CategorieRepository extends JpaRepository<Categorie,Integer> {
}
