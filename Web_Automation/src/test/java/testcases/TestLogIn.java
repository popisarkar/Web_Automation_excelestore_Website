package testcases;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LogInPage;
import pages.ProductPage;
import utilities.DataSet;
import utilities.DriverSetUp;

public class TestLogIn extends DriverSetUp {


//    HomePage homePage =new HomePage();
//    SignInPage signInPage =new SignInPage();
    LogInPage logInPage= new LogInPage();
    ProductPage productPage= new ProductPage();

    @Test(description = "Test With valid login")
    @Description("user trying login with valid username and password")

    public void testlog(){

     getBrowser().get(logInPage.logInPageURl);
     logInPage.writeOnElement(logInPage.emailInputBox,"standard_user");
     logInPage.takeScreenShot("After Username");
     logInPage.writeOnElement(logInPage.passwordInputBox,"secret_sauce");
        logInPage.takeScreenShot("After password");
     logInPage.clickOnElement(logInPage.logInButton);
     Assert.assertEquals(getBrowser().getCurrentUrl(),productPage.productPageURl);
        logInPage.takeScreenShot("After login");



//     homePage.hoverOnElement(homePage.logInLogo);
//     homePage.clickOnElement(homePage.logInOption);
//     signInPage.writeOnElement(signInPage.emailField,signInPage.email);
//     signInPage.writeOnElement(signInPage.passwordField,signInPage.password);
//     signInPage.clickOnElement(signInPage.rememberMeField);
//     signInPage.clickOnElement(signInPage.logInButton);
//     homePage.clickOnElement(homePage.signInButton);
//     signInPage.writeOnElement(signInPage.emailInputBox,signInPage.email);
//     signInPage.clickOnElement(signInPage.continueButton);

    }



    @Test(dataProvider = "invalidUsr",dataProviderClass = DataSet.class)
    public void ErrorTestLogCredentials(String email, String password,String errorMsg) {

        getBrowser().get(logInPage.logInPageURl);
        logInPage.writeOnElement(logInPage.emailInputBox, email);
        logInPage.writeOnElement(logInPage.passwordInputBox, password);
        logInPage.clickOnElement(logInPage.logInButton);
        Assert.assertTrue(logInPage.getElement(logInPage.errorMsg).isDisplayed());
        Assert.assertEquals(logInPage.elementText(logInPage.errorMsg), errorMsg);

    }
}
