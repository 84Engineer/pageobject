/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navigation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import selenium.Driver;

/**
 *
 * @author oslysenko
 */
public class LeftNavigation {

    public static class Posts {
        public static class AddNew {
            public static void select() {
                MenuSelector.select("menu-posts", "Add New");
            }
        }
        
        public static class AllPosts {
            public static void select() {
                MenuSelector.select("menu-posts", "All Posts");
            }
        }
    }

    public static class Pages {
        public static class AllPages {
            public static void select() {
                MenuSelector.select("menu-pages", "All Pages");
            }
        }
    }

    public static class MenuSelector {
        public static void select(String topLevelMenuId, String subMenuLinkText) {
            Driver.instance.findElement(By.id(topLevelMenuId)).click();
            Driver.instance.findElement(By.linkText(subMenuLinkText)).click();
        }
    }

}
