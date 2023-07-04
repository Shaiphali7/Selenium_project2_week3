package myaccounts;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class MyAccountsTest extends Utility {
    @Before
    public void setUp()
    {
        openBrowser();
    }

    public void selectMyAccountOptions(String option)
    {

        try {
            List<WebElement> Register = driver.findElements(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//li"));
            for (WebElement element : Register) {
                if (element.getText().equals(option)) {
                    element.click();
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully()
    {
        //Click in My account
        clickOnElement(By.xpath("//span[text()='My Account']"));
        selectMyAccountOptions("Register");
        String actualText=gettextFromElement(By.xpath("//h1[text()='Register Account']"));
        String expectedText="Register Account";
        Assert.assertEquals(expectedText,actualText);
    }
    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully()
    {
        //Click in My account
        clickOnElement(By.xpath("//span[text()='My Account']"));
        selectMyAccountOptions("Login");
        String actualText=gettextFromElement(By.xpath("//h2[text()='New Customer']"));
        String expectedText="New Customer";
        Assert.assertEquals(expectedText,actualText);
    }
    @Test
    public void verifyThatUserRegisterAccountSuccessfully()
    {
//Click in My account
        clickOnElement(By.xpath("//span[text()='My Account']"));
//        3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions("Register");
//        3.3 Enter First Name
        sendTextToElement(By.id("input-firstname"),"Sonia");
//        3.4 Enter Last Name
        sendTextToElement(By.id("input-lastname"),"Jain");
//        3.5 Enter Email
        sendTextToElement(By.id("input-email"),"abcd12ttd@gmail.com");
//        3.6 Enter Telephone

        sendTextToElement(By.id("input-telephone"),"07845672910");
//        3.7 Enter Password

        sendTextToElement(By.id("input-password"),"Abcd123#");
//        3.8 Enter Password Confirm
        sendTextToElement(By.id("input-confirm"),"Abcd123#");
//        3.9 Select Subscribe Yes radio button
        clickOnElement(By.xpath("//input[@name='newsletter' and @value='1']"));
//        3.10 Click on Privacy Policy check box
        clickOnElement(By.xpath("//input[@name='agree']"));
//        3.11 Click on Continue button
        clickOnElement(By.xpath("//input[@class='btn btn-primary']"));
//        3.12 Verify the message “Your Account Has Been Created!”
        String actualText=gettextFromElement(By.xpath("//h1[contains(text(),'Your')]"));
        String expectedText="Your Account Has Been Created!";
        Assert.assertEquals(expectedText,actualText);
//        3.13 Click on Continue button
        clickOnElement(By.xpath("//a[@class='btn btn-primary']"));
//        3.14 Clickr on My Account Link.
//Click in My account
        clickOnElement(By.xpath("//span[text()='My Account']"));
//        3.15 Call the method “selectMyAccountOptions” method and pass the parameter“Logout”
        selectMyAccountOptions("Logout");
//        3.16 Verify the text “Account Logout”

        String actualText1=gettextFromElement(By.xpath("//h1[text()='Account Logout']"));
        String expectedText1="Account Logout";
        Assert.assertEquals(expectedText1,actualText1);


    }
    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully()
    {

//        4.1 Clickr on My Account Link.
        clickOnElement(By.xpath("//span[text()='My Account']"));

//        4.2 Call the method “selectMyAccountOptions” method and pass the parameter“Login”
        selectMyAccountOptions("Login");
//        4.3 Enter Email address
        sendTextToElement(By.id("input-email"),"abcd12ttd@gmail.com");
//        4.4 Enter Last Name
//        4.5 Enter Password
        sendTextToElement(By.id("input-password"),"Abcd123#");
//        4.6 Click on Login button
        clickOnElement(By.xpath("//input[@class='btn btn-primary']"));
//        4.7 Verify text “My Account”

        String actualText=gettextFromElement(By.xpath("//h2[text()='My Account']"));
        String expectedText="My Account";
        Assert.assertEquals(expectedText,actualText);

//        4.8 Clickr on My Account Link.
        clickOnElement(By.xpath("//span[text()='My Account']"));
//        4.9 Call the method “selectMyAccountOptions” method and pass the parameter“Logout”
        selectMyAccountOptions("Logout");
//        4.10 Verify the text “Account Logout”
        String actualText1=gettextFromElement(By.xpath("//h1[text()='Account Logout']"));
        String expectedText1="Account Logout";
        Assert.assertEquals(expectedText1,actualText1);
//        4.11 Click on Continue button
        clickOnElement(By.xpath("//a[@class='btn btn-primary']"));
    }

    @After
    public void tearDown() {
        //closeBrowser();
    }
}
