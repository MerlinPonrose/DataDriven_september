package com.datadriven.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.datadriven.utility.BaseClass;

public class HomePage extends BaseClass{
	

	public static By productLink = By.xpath("//a[@href='/products']");
	
	
	public static void clickProduct_Link() throws IOException
	{
		com.clickelement(productLink,"Product Link");
	
	}
	
	

}
