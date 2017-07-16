package com.cdg.eboutique.controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.cdg.eboutique.entities.Categorie;
import com.cdg.eboutique.metier.IAdminCategoriesMetier;

@Controller
@RequestMapping(value = "/adminCat")
public class AdminCategorieController{
	
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
		
		if(c.getIdCategorie() != null)	
			metier.modifierCategorie(c);
		else
		{
			metier.ajouterCategorie(c);
		}
		
		model.addAttribute("categorie",new Categorie());
		model.addAttribute("categories",metier.listCategories());
		return "categories";
	}
	
	@RequestMapping(value="CatPhoto", produces =MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photoCat(@RequestParam Long idCat) throws IOException
	{
		Categorie c = metier.getCategorie(idCat);
		return IOUtils.toByteArray(new ByteArrayInputStream(c.getPhoto()));
	}

	@RequestMapping(value="deleteCat" , method = RequestMethod.GET)
	public String deleteCat(@RequestParam Long idCat, Model model)
	{
		metier.supprimerCategorie(idCat);
		model.addAttribute("categorie",new Categorie());
		model.addAttribute("categories",metier.listCategories());
		return "categories";
	}
	
	@RequestMapping(value="modifierCat" , method = RequestMethod.GET)
	public String modifierCat(@RequestParam Long idCat, Model model)
	{
		
		model.addAttribute("categorie",metier.getCategorie(idCat));
		model.addAttribute("categories",metier.listCategories());
		return "categories";
	}
	
	@RequestMapping(value="editCategValide" , method = RequestMethod.GET)
	public String editCategValide(@Valid Categorie c, Model model)
	{
		
		metier.modifierCategorie(c);
		model.addAttribute("categorie",new Categorie());
		model.addAttribute("categories",metier.listCategories());
		return "categories";
	}

	
	
	
}
