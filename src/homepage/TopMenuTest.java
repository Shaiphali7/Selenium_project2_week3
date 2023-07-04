package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

public class TopMenuTest extends Utility {
    @Before
    public void setUp()
    {
        openBrowser();
    }
    public void selectMenu(String menu)
    {

        driver.findElement(By.xpath("//ul[@class='nav navbar-nav']//li/div/a[text()='"+menu+"']")).click();
    }
    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully()
    {
//        1.1 Mouse hover on “Desktops” Tab and click
        Actions actions=new Actions(driver);
        WebElement desktop=getElement(By.xpath("//ul[@class='nav navbar-nav']//li/a[text()='Desktops']"));
       actions.moveToElement(desktop).build().perform();
        //        1.2 call selectMenu method and pass the menu = “Show All Desktops”

        selectMenu("Show AllDesktops");
//        1.3 Verify the text ‘Desktops’
        String actualText=gettextFromElement(By.tagName("h2"));
        String expectedText="Desktops";
        Assert.assertEquals("Error mesage",actualText,expectedText);
    }
    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully()
    {
//        2.1 Mouse hover on “Laptops & Notebooks” Tab and click

        Actions actions=new Actions(driver);
        WebElement laptop=getElement(By.xpath("//ul[@class='nav navbar-nav']//li/a[text()='Laptops & Notebooks']"));
        actions.moveToElement(laptop).build().perform();
//        2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        selectMenu("Show AllLaptops & Notebooks");
//        2.3 Verify the text ‘Laptops & Notebooks’

        String actualText=gettextFromElement(By.tagName("h2"));
        String expectedText="Laptops & Notebooks";
        Assert.assertEquals("Error mesage",actualText,expectedText);

    }
    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully()
    {
//        3.1 Mouse hover on “Components” Tab and click
        Actions actions=new Actions(driver);
        WebElement components=getElement(By.xpath("//ul[@class='nav navbar-nav']//li/a[text()='Components']"));
        actions.moveToElement(components).build().perform();
//        3.2 call selectMenu method and pass the menu = “Show All Components”
        selectMenu("Show AllComponents");
//        3.3 Verify the text ‘Components’

        String actualText=gettextFromElement(By.tagName("h2"));
        String expectedText="Components";
        Assert.assertEquals("Error mesage",actualText,expectedText);


    }

    @After
    public void tearDown()
    {
        closeBrowser();
    }
}
