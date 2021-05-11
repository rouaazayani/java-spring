package net.itbs.spring.data.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.itbs.spring.data.dao.ProduitRepository;
import net.itbs.spring.data.entites.Produit;

@Controller
public class ProduitController {
	@Autowired
	private ProduitRepository produitRep; 
	
	@RequestMapping(value = "/user/produit") 
	public String index(Model model,
			@RequestParam(name = "page",defaultValue = "0") int p,
			@RequestParam(name = "size",defaultValue = "5")int s,
			@RequestParam(name = "motCle",defaultValue = "")String mc) {
		Page<Produit> produits=produitRep.chercher("%"+mc+"%",PageRequest.of(p, s));
		//Page<Produit> produits=produitRep.findAll(PageRequest.of(p, s));
		model.addAttribute("listProduits", produits.getContent()); //getContent() ==> traja3 list
		int[] pages=new int[produits.getTotalPages()]; 
		model.addAttribute("pages", pages);
		model.addAttribute("size", s);
		model.addAttribute("pageCourante", p);  
		model.addAttribute("motCle", mc);
		return "produits";   //nom de page html
	}
	@RequestMapping(value="/admin/delete")
	public String delete(Long id,String motCle,int page,int size) {
		produitRep.deleteById(id);
		return "redirect:/user/produit?page="+page+"&size="+size+"&motCle="+motCle;
	}
	@RequestMapping(value = "/admin/formAjoutProduit",method = RequestMethod.GET)
	public String formProduit(Model model) {
		model.addAttribute("produit", new Produit());
		return "formAjoutProduit";
	}
	@RequestMapping(value = "/admin/saveProduit",method = RequestMethod.POST)
	public String saveProduit(Model model,@Valid Produit produit,BindingResult bindingResult) { //bindingResult traja3 collection des errors
		if(bindingResult.hasErrors())
			{return "formAjoutProduit";}
		else{
			produitRep.save(produit);
			return "confirmation";
		}
		//return "redirect:/produit";
		
	}
	@RequestMapping(value = "/admin/edit",method = RequestMethod.GET)
	public String edit(Model model,Long id) {
		Produit p=produitRep.getOne(id);
		model.addAttribute("produit", p);
		return "editProduit";
	}
	@RequestMapping(value = "/")
	public String home(){
		return "redirect:/user/produit";
	}
	
	@RequestMapping(value = "/403")
	public String accessDenied(){
		return "403";
	}
}
