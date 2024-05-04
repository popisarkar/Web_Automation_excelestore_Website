package pages;

import org.openqa.selenium.By;

public class ProductPage extends BasePage{
    public String productPageURl ="https://www.saucedemo.com/inventory.html";
    public By bikeLight = By.xpath("//div[normalize-space()='Sauce Labs Bike Light']");
    public By addToCard= By.xpath("//button[@id='add-to-cart']");
    public By removeButton= By.xpath("//button[@id='remove']");
    public By shoppingCard = By.xpath("//a[@class='shopping_cart_link']");
    public By productTittle = By.xpath("//div[@class='inventory_details_name large_size']");

    public void addToCardProduct(By locator){
    clickOnElement(locator);
    clickOnElement(addToCard);

    }
}
