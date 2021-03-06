package com.Hibernate.backdemo;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import model.dao.ProductDAO;
import model.entity.Product;

public class ProductTestCase {

	private static AnnotationConfigApplicationContext context;
	
	
	private static ProductDAO ProductDAO;
	
	
	private Product product;
	
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("model");
		context.refresh();
		ProductDAO = (ProductDAO)context.getBean("ProductDAO");
	}

	@Test
	public void testCRUDProduct() {
		
		// create operation
	/*	product = new Product();
				
		product.setName("MI LED 4A");
		product.setBrand("Xiaomi");
		product.setDescription("This is some description for Xiaomi television!");
		product.setUnitPrice(25000);
		product.setActive(true);
		product.setCategoryId(2);
		product.setSupplierId(3);
		
		assertEquals("Something went wrong while inserting a new product!",
				true,ProductDAO.add(product));		
	*/
		
		// reading and updating the category
	product = ProductDAO.get(5);
	product.setQuantity(0);
	assertEquals("Something went wrong while updating the existing record!",
			true,ProductDAO.update(product));		
		/*product.setName("Acer Predator");
		product.setUnitPrice(200000);
		product.setDescription("some description for acer");
		product.setBrand("Acer");
		
*/
		/*product=ProductDAO.get(38);
		assertEquals("Something went wrong while deleting the existing record!",
				true,ProductDAO.delete(product));		
		*/
		/*// list
		assertEquals("Something went wrong while fetching the list of products!",
				6,ProductDAO.list().size());		
	*/			
	}
			
	
	/*@Test
	public void testListActiveProducts() {
		assertEquals("Something went wrong while fetching the list of products!",
				5,ProductDAO.listActiveProducts().size());				
	} 
	
	
	@Test
	public void testListActiveProductsByCategory() {
		assertEquals("Something went wrong while fetching the list of products!",
				3,ProductDAO.listActiveProductsByCategory(3).size());
		assertEquals("Something went wrong while fetching the list of products!",
				2,ProductDAO.listActiveProductsByCategory(1).size());
	} 
	
	@Test
	public void testGetLatestActiveProduct() {
		assertEquals("Something went wrong while fetching the list of products!",
				3,ProductDAO.getLatestActiveProducts(3).size());
		
	} 
*/	
	
	
		
}
