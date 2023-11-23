package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class RegisterTest extends BaseTest {

    String baseUrl =  "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test

    public void verifyThatSignInPageDisplay(){
        //find the create an account link and click on it
        driver.findElement(By.linkText("Create an Account")).click();

        //verify the text
        String expectedText = "Create New Customer Account";
        String actualText = driver.findElement(By.className("base")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void userShouldRegisterAccountSuccessfully()  {

        //find the create an account link and click on it
        driver.findElement(By.linkText("Create an Account")).click();

        //find first name field and enter a name
        driver.findElement(By.id("firstname")).sendKeys("harshiv");

        //find last name field and enter last name
        driver.findElement(By.name("lastname")).sendKeys("malaviya");

        //find email id field and enter email
        driver.findElement(By.id("email_address")).sendKeys("harshumalaviya@gmail.com");

        //find password field and enter password
        driver.findElement(By.id("password")).sendKeys("Harsh@123");

        //find confirm password field and click on it
        driver.findElement(By.id("password-confirmation")).sendKeys("Harsh@123");

        //find create an account button and click on it
        driver.findElement(By.xpath("//button[@title='Create an Account']//span[contains(text(),'Create an Account')]")).click();

        //verify text
        String expectedText ="Thank you for registering with Main Website Store." ;
        String actualText = driver.findElement(By.xpath("//div[@class='message-success success message']//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")).getText();
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



    @After
    public void tearDown(){
        closeBrowser();
    }

}
