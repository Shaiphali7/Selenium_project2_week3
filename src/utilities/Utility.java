package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Utility extends BaseTest {
    //This method will click on element
    public void clickOnElement(By by)
    {
        driver.findElement(by).click();

    }
    /*
    This method will send text to element
     */
    public void sendTextToElement(By by,String text)
    {

        driver.findElement(by).sendKeys(text);
    }
    //This method will get the text from element
    public String gettextFromElement(By by)
    {
        return driver.findElement(by).getText();
    }
    public WebElement getElement(By by)
    {
        return driver.findElement(by);
    }
    public void sleep(){

    }
}
