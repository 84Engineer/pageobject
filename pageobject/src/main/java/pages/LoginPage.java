/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 *
 * @author oslysenko
 */
public class LoginPage {

    public static void goTo() {
        String driverPath = "D:/IEDriver32/IEDriverServer.exe";
        System.setProperty("webdriver.ie.driver", driverPath);
        WebDriver driver = new InternetExplorerDriver();

        Driver.insatnce().navigate().to("http://localhost:18881/wp-login.php");
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
            
        }
    }

}
