package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SaleTest extends BaseTest {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void verifyTheTotalItemsDisplayedOnTheWomensJacketsPage(){
        //find the sale link and click on it
        driver.findElement(By.id("ui-id-8")).click();

        //find the jacket link and click on it
        driver.findElement(By.linkText("Jackets")).click();

        //verify text
        String expectedText = "Jackets";
        String actualText = driver.findElement(By.xpath("//span[@class='base']")).getText();
        Assert.assertEquals(expectedText, actualText);

        List<WebElement> list = driver.findElements(By.className("toolbar-amount"));
        list.size();

        System.out.println("Olivia 1/4 Zip Light Jacket");
        System.out.println("Juno Jacket");
        System.out.println("Neve Studio Dance Jacket");
        System.out.println("Nadia Elements Shell");
        System.out.println("Jade Yoga Jacket");
        System.out.println("Adrienne Trek Jacket");
        System.out.println("Inez Full Zip Jacket");
        System.out.println("Riona Full Zip Jacket");
        System.out.println("Ingrid Running Jacket");
        System.out.println("Augusta Pullover Jacket");
        System.out.println("Josie Yoga Jacket");
        System.out.println("Stellar Solar Jacket");

        //verify 12 items
        String expectedItem = "12 Items";
        String actualItem = driver.findElement(By.xpath("(//div[@class='toolbar toolbar-products']//p[@id='toolbar-amount'])[1]")).getText();
        Assert.assertEquals(expectedItem, actualItem);

    }
    @After
    public void tearDown(){
        closeBrowser();
    }

}
