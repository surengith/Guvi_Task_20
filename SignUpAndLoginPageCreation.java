package com.SeleniumPracticeTask20.org;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SignUpAndLoginPageCreation {

	public static void main(String[] args) throws InterruptedException {

		// Create driver instance for ChromeBrowser
		WebDriver driver = new ChromeDriver();

		// Maximize the window
		driver.manage().window().maximize();

		// Initiate global wait (implicitlyWait) for 10 seconds to get the URL
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Navigate to requirement URL
		driver.get("https://www.guvi.in/");

		// XPath for SignUp button and Click action
		WebElement signupButton = driver
				.findElement(By.xpath("//a[@class='nav-link btn btn-primary text-white px-4' and text()='Sign up']"));
		signupButton.click();

		// XPath for SignUp name field and passing the data
		WebElement fullName = driver.findElement(By.xpath("//input[@id='name']"));
		fullName.sendKeys("Suren");

		// XPath for SignUp email field and passing the data
		WebElement signUpEmail = driver.findElement(By.xpath("//input[@id='email']"));
		signUpEmail.sendKeys("abc.surendhar19@gmail.com");

		// XPath for SignUp password field and passing the data
		WebElement signUpPassword = driver.findElement(By.xpath("//input[@id='password']"));
		signUpPassword.sendKeys("Abcsuren@321$");

		// XPath for SignUp mobile number field and passing the data
		WebElement mobileNumber = driver.findElement(By.xpath("//input[@id='mobileNumber']"));
		mobileNumber.sendKeys("3214569870");

		// XPath for click the SignUp button action
		WebElement registerSignupButton = driver.findElement(By.xpath("//a[@class='btn signup-btn']"));
		registerSignupButton.click();

		// XPath for click the May be later button
		WebElement mayBeLaterButton = driver.findElement(By.xpath("//a[text()='May be later']"));
		mayBeLaterButton.click();

		// Verify that the user has successfully registered and print the message in
		// console
		WebElement verification = driver.findElement(By.xpath("//section[@class='signup-success-pg']"));
		boolean signupPageContains = verification.getText().contains("Almost Done! Check Your Inbox!");
		System.out.println("Verify that the user is successfully SignUp : " + signupPageContains);

		// Login page form
		// Navigate to requirement URL
		driver.get("https://www.guvi.in/");

		// XPath for LoginButton and click the button
		WebElement loginButton = driver.findElement(By.xpath("//a[@class='nav-link  text-primary text-center px-4']"));
		loginButton.click();

		// XPath for Login email field and passing the data
		WebElement loginPageEmail = driver.findElement(By.xpath("//input[@id='email']"));
		loginPageEmail.sendKeys("abc.surendhar19@gmail.com");

		// XPath for Login password field and passing the data
		WebElement loginPagePassword = driver.findElement(By.xpath("//input[@id='password']"));
		loginPagePassword.sendKeys("Abcsuren@321$");

		// XPath for Login Register button and click the button
		WebElement registerLoginButton = driver.findElement(By.xpath("//a[@id='login-btn']"));
		registerLoginButton.click();

		// Wait for 2 seconds and verify the page that user has successfully logged in
		Thread.sleep(2000);
		boolean loginPageContains = driver.findElement(By.xpath("//h4[@id='title']")).getText().contains("Activation");
		System.out.println("Verify that the user is successfully Login : " + loginPageContains);

		// Wait for 2 seconds and close the browser
		Thread.sleep(2000);
		driver.close();

	}
}
