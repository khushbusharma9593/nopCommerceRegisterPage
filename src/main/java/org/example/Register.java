package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;

public class Register
{
    public static String timeStamp()//timestamp method for email id generated automatically for reusability
    {
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());//object created
        return timeStamp;
    }
    protected static WebDriver driver;

    public static void clickOnElement(By by)//Create clickOnElement method for reusability purpose while we click on different kind of buttons
    {
        driver.findElement(by).click();//click on register button

    }
    public static void typeText(By by , String text)//Create typeText method for reusability purpose while we type information in the box
    {
        driver.findElement(by).sendKeys(text);//enter firstname, last name,password,email id company name etc.

    }
    public static String getTextFromElements(By by)//Create getTextFromElement method while we completed registration process and then
                                          //when we can see that your process is completed message at that time we can use this method
    {        return driver.findElement(by).getText();

    }

    public static void waitForClickable(By by)//Create waitForClickable method
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
        element.click();

    }

    public static void waitForVisible(By by) //Create waitForVisible method
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        element.click();
    }
    public static boolean waitForURLToBe(String URL)//Create waitForURL METHOD
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        boolean element = wait.until(ExpectedConditions.urlToBe(URL));
        return element;
    }
    public static boolean waitForInVisible(By by) //Create waitForInvisible method
    { WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        boolean element = wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
        return element;
    }
    public static void waitForDisappear(By by) //create waitForDisappear method
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
        element.click();
    }


    public static void main(String[] args) //Create main method
    { System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().fullscreen();
        driver.get("https://demo.nopcommerce.com/");



        //driver.findElement(By.linkText("Register")).click();  //click on register button
        //clickOnElement(By.linkText("Register"));  //click on register button by using reusability method
        waitForClickable(By.linkText("Register"));  //wait while clicking on register button by using this method
        waitForURLToBe("https://demo.nopcommerce.com/register?returnUrl=%2F");

        //driver.findElement(By.id("gender-female")).click();  //select female option
        //clickOnElement(By.id("gender-female"));  //click on female option by using this method
        waitForClickable(By.id("gender-female")); //wait for clicking on female option by using this method


        //driver.findElement(By.id("FirstName")).sendKeys("Khushi");//enter firstname
        typeText(By.id("FirstName"),"Khushi"); //enter first name by using typeText method


        //driver.findElement(By.name("LastName")).sendKeys("Verma");//enter last name
        typeText(By.name("LastName"),"Verma"); //enter last name by using typeText method

        Select selectDay= new Select(driver.findElement(By.name("DateOfBirthDay"))); //Create object of selectDay
        selectDay.selectByVisibleText("8"); //enter date of birth

        Select selectMonth= new Select(driver.findElement(By.name("DateOfBirthMonth"))); //Create object of selectMonth
        selectMonth.selectByIndex(2); //enter month of birth

        Select selectYear = new Select(driver.findElement(By.name("DateOfBirthYear"))); //Create object of selectYear
        selectYear.selectByValue("1995"); //enter year of birth

        String email= "khushi"+timeStamp()+"@yahoo.com";
        //driver.findElement(By.id("Email")).sendKeys("Khushi"+timeStamp()+"@yahoo.com");//enter email id
        typeText(By.id("Email"),"Khushi"+timeStamp()+"@yahoo.com"); //enter email id by using typeText method
        System.out.println(email); //Print of email id



        //driver.findElement(By.name("Company")).sendKeys("J.K Ltd");//Enter company name
        typeText(By.name("Company"),"J.K Ltd"); //enter company name by using typeText method

        driver.findElement(By.xpath("//input[@id='Newsletter']")).isSelected();//Click in the checkbox


       // driver.findElement(By.name("Password")).sendKeys("K@12345");//Enter password in the box
        typeText(By.name("Password"),"K@12345"); //enter password  by using typeText method

        //driver.findElement(By.name("ConfirmPassword")).sendKeys("K@12345");//Enter confirm password in the box
        typeText(By.name("ConfirmPassword"),"K@12345"); //enter confirm password by using typeText method

        //driver.findElement(By.name("register-button")).click();
        clickOnElement(By.name("register-button")); //click on register button fill all the information by using this method

        System.out.println(getTextFromElements(By.xpath("//div[@class='result']"))); //After fill all the boxes then click on the register button
        //then we can see that your registration is completed by using this method

        //driver.quit();//Closed the application



    }
}


