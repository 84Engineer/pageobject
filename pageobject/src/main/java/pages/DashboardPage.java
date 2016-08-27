/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 *
 * @author LocalUser
 */
public class DashboardPage {
    
    public static boolean isAt() {
        List<WebElement> elements = Driver.instance.findElements(By.tagName("h1"));
        return elements.get(0).getText().equals("Dashboard");
    }
    
}
