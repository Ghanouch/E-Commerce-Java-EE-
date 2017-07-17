package com.cdg.eboutique.controllers;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cdg.eboutique.entities.Categorie;
import com.cdg.eboutique.entities.Produit;
import com.cdg.eboutique.metier.IAdminProduitsMetier;

@Controller
@RequestMapping(value="adminProd")
public class AdminProduitsController {
	
	@Autowired
	IAdminProduitsMetier metier;
	
	@RequestMapping(value="/index" , method =  RequestMethod.GET)
	public String index(Model model)
	{
		model.addAttribute("produits",metier.listProduits());
		model.addAttribute("categories",metier.listCategories());
		model.addAttribute("produit", new Produit());
		
		return "produits";
	}
	
	@RequestMapping(value="/saveProd" , method =  RequestMethod.POST)
	public String save(@Valid Produit p, BindingResult bindingResult ,@RequestParam("file") MultipartFile file , Model model) throws IOException
	{
		if(bindingResult.hasErrors())
		{
			model.addAttribute("produits",metier.listProduits());
			model.addAttribute("categories",metier.listCategories());
			return "produits";
		}
		// Ici on veut enrigitrer sous format fichier
		String path = System.getProperty("java.io.tmpdir");
		if(!file.isEmpty())
		{
			p.setPhoto(file.getOriginalFilename());
			Long idProd = metier.ajouterProduit(p, p.getCategorie().getIdCategorie());
			file.transferTo(new File(path+'/'+"PROD_"+idProd+"_"+file.getOriginalFilename()));
		}
		else
		{
			p.setCategorie(metier.getCategorie(p.getCategorie().getIdCategorie()));
			metier.ajouterProduit(p, p.getCategorie().getIdCategorie());
		}
		//model.addAttribute("path",path);
		model.addAttribute("produits",metier.listProduits());
		model.addAttribute("categories",metier.listCategories());
		model.addAttribute("produit", new Produit());
		
		
		return "produits";
	}
	
	@RequestMapping(value="ProdPhoto", produces =MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photoProd(@RequestParam Long idProd) throws IOException
	{
		Produit p = metier.getProduit(idProd);
		File file = new File( System.getProperty("java.io.tmpdir")+'/'+"PROD_"+idProd+"_"+p.getPhoto());
		return IOUtils.toByteArray(new FileInputStream(file));
	}
	
	@RequestMapping(value="deleteProd" , method = RequestMethod.GET)
	public String deleteProd(@RequestParam Long idProd, Model model)
	{
		metier.supprimerProduit(idProd);
		model.addAttribute("produits",metier.listProduits());
		model.addAttribute("categories",metier.listCategories());
		model.addAttribute("produit", new Produit());
		return "produits";
	}
	
	@RequestMapping(value="editProd" , method = RequestMethod.GET)
	public String editProdProd(@RequestParam Long idProd, Model model)
	{
		
		model.addAttribute("produits",metier.listProduits());
		model.addAttribute("categories",metier.listCategories());
		model.addAttribute("produit",metier.getProduit(idProd));
		return "produits";
	}
	
	
	
	

}
