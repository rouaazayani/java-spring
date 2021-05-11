package net.itbs.spring.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.itbs.spring.data.dao.ProduitRepository;
import net.itbs.spring.data.entites.Produit;

@SpringBootApplication
public class SringMvcApplication implements CommandLineRunner {
	@Autowired
	ProduitRepository produitRep;

	public static void main(String[] args) {
		SpringApplication.run(SringMvcApplication.class, args); 
	}  

	@Override
	public void run(String... args) throws Exception {
		
		/*
		 * produitRep.save(new Produit(null,"Samsung A30",750.00,40));
		 * produitRep.save(new Produit(null,"ASUS",1850.00,35)); produitRep.save(new
		 * Produit(null,"HP FX25",1250.00,10)); produitRep.save(new
		 * Produit(null,"HP",850.00,30)); produitRep.save(new
		 * Produit(null,"Iphone ",2850.00,10)); produitRep.save(new
		 * Produit(null,"Apple ",1550.00,25)); produitRep.save(new
		 * Produit(null,"ACER",1400.00,10)); produitRep.save(new
		 * Produit(null,"HP FX25",1250.00,10)); produitRep.save(new
		 * Produit(null,"Imprimante FEX25",750.00,12)); produitRep.save(new
		 * Produit(null,"Iphone 7",1850.00,14)); produitRep.save(new
		 * Produit(null,"Samsung A71",1850.00,5)); produitRep.save(new
		 * Produit(null,"Lenovo XFS45",2850.00,20)); produitRep.save(new
		 * Produit(null,"DELL",2250.00,8)); produitRep.save(new
		 * Produit(null,"Imprimante LX2",480.00,10)); produitRep.save(new
		 * Produit(null,"Iphone X",3250.00,20));
		 */
		 
		
		
	}

}
