package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckOutPage;
import pages.LogInPage;
import pages.ProductPage;
import utilities.DriverSetUp;

public class TestProductPage extends DriverSetUp {
    ProductPage productPage =new ProductPage();
    LogInPage logInPage= new LogInPage();
   CheckOutPage checkOutPage =new CheckOutPage();



    @Test(description = "click on product")
    public void testProductPage(){
        logInPage.doLogIn("standard_user","secret_sauce");
         productPage.clickOnElement(productPage.bikeLight);
         productPage.takeScreenShot("click on bikelight");
        Assert.assertEquals(productPage.elementText(productPage.productTittle),"Sauce Labs Bike Light");

    }

    @Test(description = "Add To Card")
    public void testAddToCard(){
        logInPage.doLogIn("standard_user","secret_sauce");
        productPage.clickOnElement(productPage.bikeLight);
        productPage.clickOnElement(productPage.addToCard);
        productPage.takeScreenShot("After Add to Card");
        Assert.assertTrue(productPage.getElement(productPage.removeButton).isDisplayed());
    }

    @Test(description = "productPurchase")
    public void purchaseProduct() throws InterruptedException {
        logInPage.doLogIn("standard_user","secret_sauce");
        logInPage.takeScreenShot("After login");
        productPage.clickOnElement(productPage.bikeLight);
        productPage.takeScreenShot("click on bikelight");
        productPage.clickOnElement(productPage.shoppingCard);
        productPage.takeScreenShot("after shopping Card");
        checkOutPage.clickOnElement(checkOutPage.checkoutButton);
        checkOutPage.takeScreenShot("after click on checkout button");
        checkOutPage.writeOnElement(checkOutPage.firstName,"popy");
        checkOutPage.writeOnElement(checkOutPage.lastName,"sarkar");
        checkOutPage.writeOnElement(checkOutPage.postalCode,"1234");
        checkOutPage.takeScreenShot("after fillup ");
        checkOutPage.clickOnElement(checkOutPage.continueButton);

//      checkOutPage.clickOnElement(checkOutPage.finishButton);
        checkOutPage.clickOnElement(checkOutPage.manu);
        checkOutPage.takeScreenShot("after Click manu");
        checkOutPage.clickOnElement(checkOutPage.logOut);
        checkOutPage.takeScreenShot("after click logout ");

    }
}
