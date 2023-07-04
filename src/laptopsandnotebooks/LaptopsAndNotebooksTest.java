package laptopsandnotebooks;

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
import java.util.List;

public class LaptopsAndNotebooksTest extends Utility {
    @Before
    public void setUp() {
        openBrowser();
    }

    public void selectMenu(String menu) {

        driver.findElement(By.xpath("//ul[@class='nav navbar-nav']//li/div/a[text()='" + menu + "']")).click();
    }

    Boolean ascendingCheck(List<Float> data) {
        for (int i = 0; i < data.size() - 1; i++) {
            if (data.get(i) > data.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
//    1.1 Mouse hover on Laptops & Notebooks Tab.and click
        Actions actions = new Actions(driver);
        WebElement desktop = getElement(By.xpath("//ul[@class='nav navbar-nav']//li/a[text()='Laptops & Notebooks']"));
        actions.moveToElement(desktop).build().perform();
//    1.2 Click on “Show All Laptops & Notebooks”
        selectMenu("Show AllLaptops & Notebooks");
//    1.3 Select Sort By "Price (High > Low)"
        WebElement dropDown = driver.findElement(By.id("input-sort"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Price (High > Low)");

//    1.4 Verify the Product price will arrange in High to Low order.
        List<WebElement> price = driver.findElements(By.tagName("h4"));
        List<Float> priceList = new ArrayList<>();
        try {
            for (WebElement web : price) {
                priceList.add(Float.parseFloat(web.getText()));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (!ascendingCheck(priceList)) {
            Assert.fail("Not is ascending order");
        }
    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws Exception {
//    2.1 Mouse hover on Laptops & Notebooks Tab and click
        Actions actions = new Actions(driver);
        WebElement desktop = getElement(By.xpath("//ul[@class='nav navbar-nav']//li/a[text()='Laptops & Notebooks']"));
        actions.moveToElement(desktop).build().perform();
//    2.2 Click on “Show All Laptops & Notebooks”
        selectMenu("Show AllLaptops & Notebooks");
//    2.3 Select Sort By "Price (High > Low)"
        WebElement dropDown = driver.findElement(By.id("input-sort"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Price (High > Low)");
//    2.4 Select Product “MacBook”
        clickOnElement(By.xpath("//a[text()='MacBook']"));
//    2.5 Verify the text “MacBook”
        String actualTitle = gettextFromElement(By.xpath("//h1[contains(text(),'MacBook')]"));
        String expectedTitle = "MacBook";
        Assert.assertEquals("Wrong title", actualTitle, expectedTitle);
//    2.6 Click on ‘Add To Cart’ button
        clickOnElement(By.xpath("//button[@id='button-cart']"));
//    2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        String actualSuccessMessage = gettextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        String expectedSuccessMessage = "Success: You have added MacBook to your shopping cart!\n" + "×\n";
        //Assert.assertEquals("Wrong message",actualSuccessMessage,expectedSuccessMessage);
        //    2.8 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));
//    2.9 Verify the text "Shopping Cart"
        String actualCartText = gettextFromElement(By.xpath(" //h1[contains(text(),' (0.00kg)')]"));
        String expectedCartText = "Shopping Cart  (0.00kg)";
        Assert.assertEquals("Wrong text", actualCartText, expectedCartText);
//    2.10 Verify the Product name "MacBook"
        Thread.sleep(200);
//        String actualProduct=gettextFromElement(By.xpath("//h1[text()='MacBook']"));
//        String expectedProduct="MacBook";
//        Assert.assertEquals("Wrong text",actualProduct,expectedProduct);
//    2.11 Change Quantity "2"
        driver.findElement(By.xpath("//div[@class='input-group btn-block']//input[@class='form-control']")).clear();
        sendTextToElement(By.xpath("//div[@class='input-group btn-block']//input[@class='form-control']"), "2");
//    2.12 Click on “Update” Tab
        clickOnElement(By.xpath("//button[@class='btn btn-primary']"));
//        2.13 Verify the message “Success: You have modified your shopping cart!”

//        2.14 Verify the Total £737.45
        String total = gettextFromElement(By.xpath("//tbody/tr[1]/td[6]"));
        String exTotal = "$1,204.00";
        Assert.assertEquals(total, exTotal);
//        2.15 Click on “Checkout” button
        clickOnElement(By.xpath("//a[contains(text(),'Checkout')]"));
//        2.16 Verify the text “Checkout”
        String checkOut = gettextFromElement(By.xpath("//h1[contains(text(),'Checkout')]"));
        String excheckOut = "Checkout";
        Assert.assertEquals(checkOut, excheckOut);
//        2.17 Verify the Text “New Customer”
        String newCustomer = gettextFromElement(By.xpath("//h2[contains(text(),'New Customer')]"));

//        String exnewCustomer="New Customer";
//        Assert.assertEquals(newCustomer,exnewCustomer);
//        2.18 Click on “Guest Checkout” radio button
        clickOnElement(By.xpath("//input[@value='guest']"));
//        2.19 Click on “Continue” tab
        clickOnElement(By.xpath("//input[@id='button-account']"));
//        2.20 Fill the mandatory fields
        sendTextToElement(By.id("input-payment-firstname"), "Sonia");
        sendTextToElement(By.id("input-payment-lastname"), "GoGo");
        sendTextToElement(By.id("input-payment-email"), "abc@gmail.com");
        sendTextToElement(By.id("input-payment-telephone"),"0783809807");
        sendTextToElement(By.id("input-payment-address-1"),"34 Maple drive");
        sendTextToElement(By.id("input-payment-city"),"Derby");
        sendTextToElement(By.id("input-payment-postcode"),"De73 6BB");
        WebElement country=driver.findElement(By.name("country_id"));
        Select select1=new Select(country);
        select1.selectByIndex(3);
        WebElement region=driver.findElement(By.name("zone_id"));
        Select select2=new Select(region);
        select2.selectByVisibleText("Bulqize");
        //        2.21 Click on “Continue” Button
        clickOnElement(By.xpath("//input[@id='button-guest']"));
//        2.22 Add Comments About your order into text area
        sendTextToElement(By.tagName("textarea"),"comment");
//        2.23 Check the Terms & Conditions check box
        clickOnElement(By.xpath("//input[@name='agree']"));
//        2.24 Click on “Continue” button
        clickOnElement(By.xpath("//input[@id='button-payment-method']"));
//        2.25 Verify the message “Warning: Payment method required!”
        String warningMessage = gettextFromElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
        System.out.println(warningMessage);
      String expectedWarningMessage="Warning: Payment method required!\n" +
              "×";
       Assert.assertEquals(warningMessage,expectedWarningMessage);



    }

    @After
    public void tearDown() {
        //closeBrowser();
    }
}
