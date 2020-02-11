package com.mastek.inventory;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mastek.inventory.dao.CategoryDAO;
import com.mastek.inventory.dao.CustomersDAO;
import com.mastek.inventory.dao.IngredientsDAO;
import com.mastek.inventory.dao.OrdersDAO;
import com.mastek.inventory.dao.ProductsDAO;
import com.mastek.inventory.entities.Category;
import com.mastek.inventory.entities.Customers;
import com.mastek.inventory.entities.Ingredients;
import com.mastek.inventory.entities.Orders;
import com.mastek.inventory.entities.Products;
import com.mastek.inventory.services.InventoryServices;

@SpringBootTest
class InventoryApplicationTests {

	@Autowired
	InventoryServices invSer1;
	
	@Autowired
	CustomersDAO cusDAO;
	
	@Autowired
	CategoryDAO catDAO;
	
	@Autowired
	IngredientsDAO ingDAO;
	
	@Autowired
	OrdersDAO ordDAO;
	
	@Autowired
	ProductsDAO proDAO;	
	
	@Test
	void testAddCustomer() {
	Customers cus = new Customers();
	cus.setEmailAddress("Example6@mastek.com");
	cus.setName("Example6");
	
	cus=cusDAO.save(cus);
	System.out.println(cus);
	
	}
	
	@Test
	void testAddCategory() {
		Category cat = new Category();
		cat.setName("Desserts");
		cat=catDAO.save(cat);
		
		System.out.println(cat);
	}

	
	@Test
	void testAddIngredients() {
		Ingredients ing = new Ingredients();
		ing.setIngName("Cabbage");
		
		ing=ingDAO.save(ing);
		System.out.println(ing);
	}
	
	@Test
	void testAddOrders() {
		Orders ord = new Orders();
		ord.setPrice(4.00);
		ord.setQuantity(3);
		ord=ordDAO.save(ord);
		System.out.println(ord);
	}
	
	@Test
	void testAssignCustomersAndOrders() {
		Orders ord=invSer1.assignOrderToCustomer(1, 51);
		assertNotNull(ord.getCurrentCustomer(),"Not Worked");
	}
	
	@Test
	void testAddProducts() {
		Products pro = new Products();
		pro.setUnitPrice(0.69);
		pro.setName("Example");
		
		pro=proDAO.save(pro);
		System.out.println(pro);
	}
	
	@Test
	void testAssignOrdersAndProducts() {
		Orders ord=invSer1.assignOrderToProducts(1, 1);
		assertTrue(ord.getProductList().size()>0);
	}
	
	//@Test
	void testRemoveCustomer() {
	cusDAO.deleteById(54);
	}
	
	@Test
	void testLinkProductsAndCategories() {
		Products pro=invSer1.assignProductToCategory(2, 60);
		assertNotNull(pro.getCurrentCategory(),"failed");
	}
	

	
}
