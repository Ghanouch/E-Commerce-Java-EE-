package com.cdg.eboutique.controllers;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cdg.eboutique.entities.Categorie;
import com.cdg.eboutique.metier.IAdminCategoriesMetier;

@Controller
@RequestMapping(value = "/adminCat")
public class AdminCategorieController {
	
	@Autowired
	IAdminCategoriesMetier metier;
	
	@RequestMapping(value="/index")
	public String home(Model model)
	{
		model.addAttribute("categorie",new Categorie());
		model.addAttribute("categories",metier.listCategories());
		return "categories";
	}
	
	@RequestMapping(value="saveCat" , method = RequestMethod.POST)
	public String saveCat(@Valid Categorie c ,BindingResult bindingResult, Model model, @RequestParam("file") MultipartFile multipartFile) throws IOException
	{
		
		/*  Si Il ya des Erruers */
		if(bindingResult.hasErrors())
		{
			model.addAttribute("categories",metier.listCategories());
			return "categories";
		}
		/*  Si Il ya un Upload*/
		if(! multipartFile.isEmpty() )
		{
			// TESTER QU IL S AGIT D UNE IMAGE ( MEME ON PEUT LA RETOUCHER )
			BufferedImage bi = ImageIO.read(multipartFile.getInputStream());  // S il est autre qu une image, il va lever une exception
			c.setPhoto(multipartFile.getBytes());
			c.setNomPhoto(multipartFile.getOriginalFilename());
		}
		
		metier.ajouterCategorie(c);
		model.addAttribute("categorie",new Categorie());
		model.addAttribute("categories",metier.listCategories());
		return "categories";
	}

}
