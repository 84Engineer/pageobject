/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import selenium.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 *
 * @author oslysenko
 */
public class LoginPage {

    public static void goTo() {
        Driver.instance.navigate().to(Driver.getBaseAddress() + "/wp-login.php");
    }
    
    public static LoginCommand loginAs(String userName) {
        
        return new LoginCommand(userName);
        
    }

    public static class LoginCommand {
        
        private String userName;
        private String password;

        public LoginCommand(String userName) {
            this.userName = userName;
        }
        
        public LoginCommand withPassword(String password) {
            this.password = password;
            return this;
        }
        
        public void login() {
            
            WebElement userLogin = Driver.instance.findElement(By.id("user_login"));
            userLogin.sendKeys(userName);
            
            WebElement passwordInput = Driver.instance.findElement(By.id("user_pass"));
            passwordInput.sendKeys(password);
            
            WebElement submitButton = Driver.instance.findElement(By.id("wp-submit"));
            submitButton.click();
            
        }
    }

}
