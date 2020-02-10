package com.mastek.inventory.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.mastek.inventory.dao.CategoryDAO;
import com.mastek.inventory.dao.CustomersDAO;
import com.mastek.inventory.dao.IngredientsDAO;
import com.mastek.inventory.dao.OrdersDAO;
import com.mastek.inventory.dao.ProductsDAO;
import com.mastek.inventory.entities.Category;
import com.mastek.inventory.entities.Customers;
import com.mastek.inventory.entities.Orders;
import com.mastek.inventory.entities.Products;

@Component
public class InventoryServices {

	@Autowired
	CategoryDAO catDAO;

	@Autowired
	CustomersDAO cusDAO;

	@Autowired
	IngredientsDAO ingDAO;

	@Autowired
	OrdersDAO ordDAO;

	@Autowired
	ProductsDAO proDAO;

	@Transactional // this will keep the session open until the method returns the value.
	public Orders assignOrderToCustomer(int orderNo, int custId) {
		Orders ord = ordDAO.findById(orderNo).get();
		Customers cus = cusDAO.findById(custId).get();

		//assign the association between employee and department
		ord.setCurrentCustomer(cus);
		cus.getCustomers().add(ord);

		cusDAO.save(cus);
		ordDAO.save(ord);

		return ord;

	}

	@Transactional
	public Orders assignOrderToProducts(int orderNo, int productID) {
		Orders ord = ordDAO.findById(orderNo).get();
		Products prod = proDAO.findById(productID).get();

		ord.getProductList().add(prod);
		ordDAO.save(ord);

		return ord;

	}

	@Transactional
	public Products assignProductToCategory(int productID, int catID) {
		Products prod = proDAO.findById(productID).get();
		Category cat = catDAO.findById(catID).get();


		prod.setCurrentCategory(cat);
		cat.getProductList().add(prod);	
		
		proDAO.save(prod);
		catDAO.save(cat);
		
		return prod;

	}

}
