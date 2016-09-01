/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import selenium.Driver;
import org.openqa.selenium.By;

/**
 *
 * @author LocalUser
 */
public class PostPage {
    
    public static String getTitle() {
        String titleText = Driver.instance.findElements(By.className("entry-title"))
                .get(0)
                .getText();
        
        return titleText != null ? titleText : "";
    }
}
