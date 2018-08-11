package net.kzm.shoppingbackend.test;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	@BeforeClass
	public static void init() {
		context=new AnnotationConfigApplicationContext();
		context.scan("net.kzn.shoppingbackend");
		context.refresh();
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
	}
	
	/*@Test
	public void testListCategory() {
		
		assertEquals("Successfully fetched list of categories from the table",2,categoryDAO.list().size());
	}*/
	/*@Test
	public void testDeleteCategory() {
		category=categoryDAO.get(1);
		
		assertEquals("Successfully deleted a category in the table",true,categoryDAO.delete(category));
	}*/
	/*@Test
	public void testUpdateCategory() {
		category=categoryDAO.get(1);
		category.setName("Lenovo");
		assertEquals("Successfully updated a category in the table",true,categoryDAO.update(category));
	}*/
	
	/*@Test
	
	public void testGetCategory() {
		category=categoryDAO.get(1);
		assertEquals("Successfully fetched a category from the table","Laptop",category.getName());
	}*/
	
	/*@Test
	public void testAddCategory() {
		category=new Category();
		category.setName("Mobile");
		category.setImageURL("CAT_2.png");
		category.setDescription("This is good Mobile");
		assertEquals("Successfully added a category inside the table",true,categoryDAO.add(category));
	}*/
	
	@Test
	public void testCRUDCategory() {
		//add category
		category=new Category();
		category.setName("Laptop");
		category.setImageURL("CAT_1.png");
		category.setDescription("This is good Laptop");
		assertEquals("Successfully added a category inside the table",true,categoryDAO.add(category));
		
		category=new Category();
		category.setName("Television");
		category.setImageURL("CAT_2.png");
		category.setDescription("This is good Television");
		assertEquals("Successfully added a category inside the table",true,categoryDAO.add(category));
		
		//fetching and updating the category
		
		category=categoryDAO.get(2);
		category.setName("TV");
		assertEquals("Successfully updated a category in the table",true,categoryDAO.update(category));
		
		//deleting the category
		assertEquals("Successfully deleted a category in the table",true,categoryDAO.delete(category));
		
		//fetching the list
		assertEquals("Successfully fetched list of categories from the table",1,categoryDAO.list().size());
	}
}
