package desktops;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopsTest extends Utility {
    @Before
    public void setUp() {
        openBrowser();
    }

    public void selectMenu(String menu) {

        driver.findElement(By.xpath("//ul[@class='nav navbar-nav']//li/div/a[text()='" + menu + "']")).click();
    }

    @Test
    public void verifyProductArrangeInAlphaBeticalOrder() {
//        1.1 Mouse hover on Desktops Tab.and click
        Actions actions = new Actions(driver);
        WebElement desktop = getElement(By.xpath("//ul[@class='nav navbar-nav']//li/a[text()='Desktops']"));
        actions.moveToElement(desktop).build().perform();
//        1.2 Click on “Show All Desktops”
        selectMenu("Show AllDesktops");
//        1.3 Select Sort By position "Name: Z to A"
        WebElement dropDown = driver.findElement(By.id("input-sort"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Name (Z - A)");

//        1.4 Verify the Product will arrange in Descending order
        List<WebElement> products = driver.findElements(By.xpath("//div[@class='caption']"));
        List<String> productName=new ArrayList<>();
        List<String> sortedProductName=new ArrayList<>();
        for (WebElement list:products) {
            productName.add(list.getText().toLowerCase());
            sortedProductName.add(list.getText().toLowerCase());
            System.out.println(list.getText());

        }
        Collections.sort(sortedProductName,Collections.reverseOrder());
        Assert.assertTrue(productName.equals(sortedProductName));
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() {
//        2.1 Mouse hover on Desktops Tab. and click
        Actions actions = new Actions(driver);
        WebElement desktop = getElement(By.xpath("//ul[@class='nav navbar-nav']//li/a[text()='Desktops']"));
        actions.moveToElement(desktop).build().perform();
//        2.2 Click on “Show All Desktops”
        selectMenu("Show AllDesktops");
//        2.3 Select Sort By position "Name: A to Z"
        WebElement dropDown = driver.findElement(By.id("input-sort"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Name (A - Z)");
//        2.4 Select product “HP LP3065”
        clickOnElement(By.linkText("HP LP3065"));
//        2.5 Verify the Text "HP LP3065"
        String actualText = gettextFromElement(By.xpath("//h1[contains(text(),'HP LP3065')]"));
        String expectedText = "HP LP3065";
        Assert.assertEquals("Wrong text", actualText, expectedText);
//        2.6 Select Delivery Date "2022-11-30"
//        2.7.Enter Qty "1” using Select class.
//        WebElement textBox = getElement(By.id("input-quantity"));
//        Select select1 = new Select(textBox);
//        select1.selectByValue("1");

//        2.8 Click on “Add to Cart” button
        clickOnElement(By.xpath("//button[@id='button-cart']"));
//        2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        String actualSuccessMessage=gettextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));

        String expectedSuccessMessage="Success: You have added HP LP3065 to your shopping cart!\n" +
                "×";
        Assert.assertEquals("Wrong message",actualSuccessMessage,expectedSuccessMessage);
//        2.10 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[text()='shopping cart']"));
//        2.11 Verify the text "Shopping Cart"
        String actualCartText=gettextFromElement(By.xpath("//div[@id='content']//h1"));

        //System.out.println(actualCartText);
        String expectedcartText="Shopping Cart  (1.00kg)";
        Assert.assertEquals("Wrong message",actualSuccessMessage,expectedSuccessMessage);

//        2.12 Verify the Product name "HP LP3065"
        String actualProductName=gettextFromElement(By.xpath("(//a[text()='HP LP3065'])[1]"));
        System.out.println(actualProductName);
//        2.13 Verify the Delivery Date "2022-11-30"
//        2.14 Verify the Model "Product21"
        String actualModalName=gettextFromElement(By.xpath("//td[text()='Product 21']"));
        String expectedModalName="Product 21";
        Assert.assertEquals("Wrong product name",expectedModalName,actualModalName);
//        2.15 Verify the Todat "£74.73"
        String actualTotal=gettextFromElement(By.xpath("//td[@class='text-right'][text()='$122.00']"));
        System.out.println(actualTotal);


    }

    @After
    public void tearDown() {
        //closeBrowser();
    }
}
