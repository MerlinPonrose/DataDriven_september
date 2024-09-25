package com.datadriven.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.datadriven.utility.BaseClass;

public class ProductPage extends BaseClass{
	
	
	public static By frstProduct = By.xpath("//a[@href='/product_details/1']");
	public static By AddToCartButton = By.xpath("//button[@type='button']");
	public static By viewCartButton = By.xpath("(//a[@href='/view_cart'])[2]");
	public static By searchbox = By.id("search_product");
	public static By searchIcon = By.id("submit_search");
	public static By quantity = By.id("quantity");
	
	
	public static void clickFrstProduct() throws IOException
	{
		com.clickelement(frstProduct,"First Product");
	}

	public void clickAddToCart() throws IOException
	{
		com.clickelement(AddToCartButton," Add To Cart Button");
	}
	
	
	public void clcikViewCartButton() throws IOException
	{
		com.clickelement(viewCartButton,"View Cart Button");
	}
	
	public void searchProduct(String prod) throws IOException
	{
		com.enterValue(searchbox, prod);
		com.clickelement(searchIcon,"Search Icon");
	}
	
	public void enterquantity(String quantityy) throws IOException
	{
		com.enterValue(quantity, quantityy);
	}
}
