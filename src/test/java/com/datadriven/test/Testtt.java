package com.datadriven.test;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.datadriven.utility.BaseClass;

public class Testtt extends BaseClass{
	
	@Test
	public void addproductTocart() throws InterruptedException, IOException
	{
		test= extent.createTest("addproductTocart");
		
		test.log(Status.INFO, "Test case execution started");

		hmpg.clickProduct_Link();
		
		com.scrolldown();
		
		prdpg.clickFrstProduct();
		
		prdpg.clickAddToCart();
		
		Thread.sleep(2000);
		
		prdpg.clcikViewCartButton();
		
		cartpg.validateProductInCart();
		
		test.log(Status.PASS, "Test case executed successfully");
	}

}
