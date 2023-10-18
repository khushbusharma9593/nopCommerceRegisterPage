package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Register
{
    protected static WebDriver driver;

    public static void main(String[] args)
    { System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().fullscreen();
        driver.get("https://demo.nopcommerce.com/");

        driver.findElement(By.linkText("Register")).click();//click on register button

        driver.findElement(By.id("FirstName")).sendKeys("Khushi");//enter firstname

        driver.findElement(By.name("LastName")).sendKeys("Verma");//enter last name

        driver.findElement(By.id("Email")).sendKeys("verma123@yahoo.com");//enter email id

        driver.findElement(By.id("gender-female")).click();//select female option

        driver.findElement(By.name("Company")).sendKeys("J.K Ltd");//Enter company name

        driver.findElement(By.xpath("//input[@id='Newsletter']")).isSelected();//Click in the checkbox

        driver.findElement(By.name("Password")).sendKeys("K@12345");//Enter password in the box

        driver.findElement(By.name("ConfirmPassword")).sendKeys("K@12345");//Enter confirm password in the box

        driver.quit();//Closed the application 



    }
}


