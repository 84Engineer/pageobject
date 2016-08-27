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
public class TestPage {
    
    public void go() {
        String driverPath = "D:/IEDriver32/IEDriverServer.exe";
        System.setProperty("webdriver.ie.driver", driverPath);
        WebDriver driver = new InternetExplorerDriver();
        
        driver.navigate().to("http://google.com");
    }
    
}
