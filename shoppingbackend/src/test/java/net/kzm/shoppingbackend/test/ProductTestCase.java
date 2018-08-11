package net.kzm.shoppingbackend.test;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.kzn.shoppingbackend.dao.ProductDAO;
import net.kzn.shoppingbackend.dto.Product;

public class ProductTestCase {
	private static AnnotationConfigApplicationContext context;
	private static ProductDAO productDAO;
	private Product product;

	@BeforeClass

	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.kzn.shoppingbackend");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productDAO");
	}

	/*@Test

	public void testCRUDProduct() {
		// create operation
		product = new Product();
		product.setName("Oppo selfie s3");
		product.setBrand("Oppo");
		product.setDescription("Some description for oppo mobiles");
		product.setUnitPrice(25000);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(3);

		assertEquals("product added", true, productDAO.add(product));

		// reading and updating
		product = productDAO.get(2);
		product.setName("Samsung Galaxy S7");
		assertEquals("product udated", true, productDAO.update(product));
		assertEquals("product udated", true, productDAO.delete(product));
		// list
		assertEquals("products retrieved", 6, productDAO.list().size());

	}
*/
	/*@Test
	
	public void testListActiveProducts() {
		assertEquals("products retrieved", 5, productDAO.listActiveProducts().size());
	}*/
	
	/*@Test
	public void testListActiveProductsByCategory() {
		assertEquals("products retrieved", 3, productDAO.listActiveProductsByCategory(3).size());
		assertEquals("products retrieved", 2, productDAO.listActiveProductsByCategory(1).size());
	}*/
	
	@Test
	public void testGetLatestActiveProducts() {
		assertEquals("products retrieved", 3, productDAO.getLatestActiveProducts(3).size());
	}
}
