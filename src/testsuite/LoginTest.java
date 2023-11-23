package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //find the sign in link and click on it
        driver.findElement(By.linkText("Sign In")).click();

        //find email id field and enter email
        driver.findElement(By.name("login[username]")).sendKeys("tamudhaduk@gmail.com");

        //find password field and enter password
        driver.findElement(By.name("login[password]")).sendKeys("Dhaduk@123");

        //find out sign in button and click on it
        driver.findElement(By.xpath("//fieldset[@class='fieldset login']//span[contains(text(),'Sign In')]")).click();

        //verify text
        String expectedText = "Welcome, Shraddha Dhaduk!";
        String actualText = driver.findElement(By.xpath("(//li[@class='greet welcome']//span[contains(text(),'Welcome, Shraddha Dhaduk!')])[1]")).getText();
        Assert.assertEquals(expectedText, actualText);
    }
    @Test
    public void verifyTheErrorMessageWithInvalidCredentials(){//find the sign in link and click on it
        driver.findElement(By.linkText("Sign In")).click();

        //find email id field and enter email
        driver.findElement(By.name("login[username]")).sendKeys("shraddhadhaduk@gmail.com");

        //find password field and enter password
        driver.findElement(By.name("login[password]")).sendKeys("Prime@123");

        //find out sign in button and click on it
        driver.findElement(By.xpath("//fieldset[@class='fieldset login']//span[contains(text(),'Sign In')]")).click();


        //verify text
        String expectedText = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
        String actualText = driver.findElement(By.xpath("//div[@class='message-error error message']//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void userShouldLogOutSuccessfully(){
        //find the sign in link and click on it
        driver.findElement(By.linkText("Sign In")).click();

        //find email id field and enter email
        driver.findElement(By.name("login[username]")).sendKeys("tamudhaduk@gmail.com");

        //find password field and enter password
        driver.findElement(By.name("login[password]")).sendKeys("Dhaduk@123");

        //find out sign in button and click on it
        driver.findElement(By.xpath("//fieldset[@class='fieldset login']//span[contains(text(),'Sign In')]")).click();

        //verify text
        String expectedText = "Welcome, Shraddha Dhaduk!";
        String actualText = driver.findElement(By.xpath("(//li[@class='greet welcome']//span[contains(text(),'Welcome, Shraddha Dhaduk!')])[1]")).getText();
        Assert.assertEquals(expectedText, actualText);

        //click on down arrow
        driver.findElement(By.xpath("//div[@class='panel header']//button[@type='button']")).click();

        //click on sign out
        driver.findElement(By.xpath("//div[@aria-hidden='false']//a[normalize-space()='Sign Out']")).click();

        //verify the text
        String expectedText1 = "You are signed out";
        String actualText1 = driver.findElement(By.xpath("//span[@class='base']")).getText();
        Assert.assertEquals(expectedText1, actualText1);
    }
     @Before
    public void tearDown(){
        closeBrowser();
     }

}
