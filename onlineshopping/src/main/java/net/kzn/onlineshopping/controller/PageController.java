package net.kzn.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;

@Controller
public class PageController {
	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping(value= {"/","/home","/index"})
	public ModelAndView index() {
		ModelAndView mav=new ModelAndView("page");
		mav.addObject("title","HomePage");
		mav.addObject("categories",categoryDAO.list());
		mav.addObject("userClickHome",true);
		return mav;
	}
	
	@RequestMapping(value="/about")
	public ModelAndView about() {
		ModelAndView mav=new ModelAndView("page");
		mav.addObject("title","About us");
		mav.addObject("userClickAbout",true);
		return mav;
	}
	
	@RequestMapping(value="/contact")
	public ModelAndView contact() {
		ModelAndView mav=new ModelAndView("page");
		mav.addObject("title","Contact us");
		mav.addObject("userClickContact",true);
		return mav;
	}
	/*
	 * Methods to load all the categories based on category
	 */
	
	@RequestMapping(value= "show/all/products")
	public ModelAndView showAllProducts() {
		ModelAndView mav=new ModelAndView("page");
		mav.addObject("title","All Products");
		mav.addObject("categories",categoryDAO.list());
		mav.addObject("userClickAllProducts",true);
		return mav;
	}
	
	@RequestMapping(value= "show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		ModelAndView mav=new ModelAndView("page");
		
		Category category=null;
		category=categoryDAO.get(id);
		mav.addObject("title",category.getName());
		mav.addObject("categories",categoryDAO.list());
		mav.addObject("category",category);
		mav.addObject("userClickCategoryProducts",true);
		return mav;
	}

}
