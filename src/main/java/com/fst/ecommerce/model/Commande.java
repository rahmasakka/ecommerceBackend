package com.fst.ecommerce.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="commande")
public class Commande {
	 @Id
    @GeneratedValue
    private Integer id;
	 
    @ManyToOne
    @JoinColumn
    private User user;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "commande_produit", 
      joinColumns = @JoinColumn(name = "commande_id"), 
      inverseJoinColumns = @JoinColumn(name = "produit_id"))
    Set<Produit> produits;
    
 
    

}
