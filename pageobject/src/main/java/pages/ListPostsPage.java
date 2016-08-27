/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import org.openqa.selenium.By;

/**
 *
 * @author LocalUser
 */
public class ListPostsPage {

    public static void goTo(PageType pageType) {

        switch (pageType) {
            case PAGE:
                Driver.instance.findElement(By.id("menu-pages")).click();
                Driver.instance.findElement(By.linkText("All Pages")).click();
                break;
        }

    }

    public enum PageType {
        PAGE;
    }
    
    public static void selectPage(String title) {
        Driver.instance.findElement(By.linkText(title)).click();
    }

}
