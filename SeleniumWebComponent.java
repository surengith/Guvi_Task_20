package com.SeleniumPracticeTask20.org;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumWebComponent {

	public static void main(String[] args) throws InterruptedException {

		// Create driver instance for ChromeBrowser
		WebDriver driver = new ChromeDriver();

		// Maximize the window
		driver.manage().window().maximize();

		// Initiate global wait (implicitlyWait) for 10 seconds to get the URL
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Navigate to requirement URL
		driver.get("https://jqueryui.com/datepicker/");

		// Get iFrame XPath and switching into it and verifying the iFrame title
		WebElement DatepickerFrame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		String frameTitle = driver.switchTo().frame(DatepickerFrame).getTitle();

		if (frameTitle.contains("Datepicker")) {
			System.out.println("You are in Datepicker Frame and Actual Title is: " + frameTitle);
		} else {
			System.out.println("You are not in Datepicker Frame and Actual Title is: " + frameTitle);
		}

		// Finding XPath for DatePicker column 
		WebElement monthField = driver.findElement(By.xpath("//input[@id='datepicker']"));
		monthField.click();

		// Finding XPath to click the next month
		WebElement nextMonth = driver.findElement(By.xpath("//a[@title='Next']"));
		nextMonth.click();

		// Finding XPath to pick the date
		WebElement daySelect = driver.findElement(By.xpath("//tbody/tr[4]/td[5]/a[text()='22']"));
		daySelect.click();

		// Verify the selected date and print it in console
		System.out.println("Selected Date is: " + daySelect.getText());

		// Wait for 1 second and close the browser and quite the driver instance
		Thread.sleep(1000);
		driver.close();
		driver.quit();
	}
}
