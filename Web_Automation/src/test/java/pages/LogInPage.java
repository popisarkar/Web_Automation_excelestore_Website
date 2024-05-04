package pages;

import org.openqa.selenium.By;

public class LogInPage extends BasePage{

    public String logInPageURl ="https://www.saucedemo.com/";
    public String email = "";
    public String password = "";
    public By emailInputBox = By.xpath("//input[@id='user-name']");
    public By passwordInputBox = By.xpath("//input[@id='password']");
    public By errorMsg = By.xpath("//div[@class='error-message-container error']");
    public By logInButton = By.xpath("//input[@id='login-button']");

    public void doLogIn(String email,String password){
     loadWebUrl(logInPageURl);
      writeOnElement(emailInputBox,email);
      writeOnElement(passwordInputBox,password);
      clickOnElement(logInButton);
    }

}
