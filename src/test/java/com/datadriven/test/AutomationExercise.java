package com.datadriven.test;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.datadriven.utility.BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationExercise extends BaseClass{
	
	@Test(enabled=false)
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
	
	@Test(enabled=false)
	public void removeProductFromCart() throws InterruptedException, IOException
	{
		test= extent.createTest("removeProductFromCart");
	
		test.log(Status.INFO, "Test case execution started");
		
		hmpg.clickProduct_Link();
		
		com.scrolldown();
		
		prdpg.clickFrstProduct();
		
		prdpg.clickAddToCart();
		
		Thread.sleep(2000);
		
		prdpg.clcikViewCartButton();
		
		cartpg.validateProductInCart();
		
		WebElement removeProd = driver.findElement(By.xpath("//a[@class='cart_quantity_delete']"));
		removeProd.click();
		
		WebElement ele = driver.findElement(By.xpath("(//p[@class='text-center'])[3]//b"));
		String actualText = ele.getText();
		
		
		if(actualText.equalsIgnoreCase("Cart is empty!"))
		{
			System.out.println("cart is empty");
		}
		else
		{
			System.out.println("Cart is not empty");
		}
		
		test.log(Status.PASS, "Test case executed successfully");
	}
	
	@Test(dataProvider="getdata")
	public void searchproduct(String prod,String qty) throws InterruptedException, IOException
	{
		test= extent.createTest("searchproduct");
		
		test.log(Status.INFO, "Test case execution started");
		
		hmpg.clickProduct_Link();
		
		prdpg.searchProduct(prod);
		
		com.scrolldown();
		
		prdpg.clickFrstProduct();
		
		prdpg.enterquantity(qty);
		
		prdpg.clickAddToCart();
		
		Thread.sleep(2000);	
		
		prdpg.clcikViewCartButton();
		
		test.log(Status.PASS, "Test case executed successfully");

	}
	
	@DataProvider
	public String[][] getdata() throws IOException
	{
		return excell.readexcell();
	}

}
