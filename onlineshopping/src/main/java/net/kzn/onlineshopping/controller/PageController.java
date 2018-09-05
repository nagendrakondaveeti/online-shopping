package net.kzn.onlineshopping.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.kzn.onlineshopping.exception.ProductNotFoundException;
import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dao.ProductDAO;
import net.kzn.shoppingbackend.dto.Category;
import net.kzn.shoppingbackend.dto.Product;

@Controller
public class PageController {
	private static final Logger logger=LoggerFactory.getLogger("PageController.class");
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(value= {"/","/home","/index"})
	public ModelAndView index() {
		ModelAndView mav=new ModelAndView("page");
		mav.addObject("title","HomePage");
		logger.info("inside pagecontroller index method - INFO");
		logger.debug("inside pagecontroller index method -DEBUG");
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
	
	/*
	 * viewing a single product
	 */
		@RequestMapping(value="/show/{id}/product")
		public ModelAndView showSingleProduct(@PathVariable("id") int id) throws ProductNotFoundException{
			
			ModelAndView mv= new ModelAndView("page");
			Product product=productDAO.get(id);
			if(product==null) throw new ProductNotFoundException();
			//update the view count
			product.setViews(product.getViews()+1);
			productDAO.update(product);
			mv.addObject("title",product.getName());
			mv.addObject("product", product);
			mv.addObject("userClickShowProduct", true);
			return mv;
		}
}
