package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static utilities.DriverSetUp.getBrowser;

public class BasePage {

    public WebElement getElement(By locator){

      return getBrowser().findElement(locator);
    }

    public void clickOnElement(By locator){

        getElement(locator).click();
    }

    public void writeOnElement(By locator,String text){
        getElement(locator).sendKeys(text);
    }

    public void hoverOnElement(By locator){
        Actions action = new Actions(getBrowser());
        action.clickAndHold(getElement(locator)).build().perform();
    }

 public void loadWebUrl( String url){
        getBrowser().get(url);


 }

 public String elementText(By locator){
     return    getElement(locator).getText();

 }

}
