package com.google.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.base.Base;

public class googleSearch extends Base {

	@BeforeMethod
	public void setUp() {
		initialization();
	}

	@Test
	public static void searchvalue() throws InterruptedException {
		String searchKey = "Canberra";
		WebElement searchBox = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
		searchBox.sendKeys(searchKey);

		List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li"));
		System.out.println("Total number of suggestions: " + list.size());

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getText());
			if (list.get(i).getText().contains(searchKey)) {
				list.get(i).click();
				break;
			}
		}

		WebElement img = driver.findElement(By.xpath("//div[contains(text(),'Images')]"));
		img.click();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
