package com.datadriven.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.datadriven.utility.BaseClass;

public class CartPage extends BaseClass{
	
	public static By productInCart = By.xpath("//tr[@id='product-1']");
	
	public void validateProductInCart()
	{

		List<WebElement> products = driver.findElements(productInCart);
		
		if(products.size()!=0)
		{
			System.out.println("Product is added to cart");
		}
		else
		{
			System.out.println("cart is empty !!");
		}
	}

}
