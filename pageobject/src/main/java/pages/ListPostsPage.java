/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import java.util.List;
import selenium.Driver;
import navigation.LeftNavigation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author LocalUser
 */
public class ListPostsPage {

    private static int lastCount;

    public static void goTo(PageType pageType) {

        switch (pageType) {
            case PAGE:
                LeftNavigation.Pages.AllPages.select();
                break;
            case POSTS:
                LeftNavigation.Posts.AllPosts.select();
                break;
        }
    }

    public enum PageType {
        PAGE,
        POSTS;
    }

    public static void selectPage(String title) {
        Driver.instance.findElement(By.linkText(title)).click();
    }

    public static void storeCount() {
        lastCount = getPostCount();
    }

    private static int getPostCount() {
        String countText = Driver.instance.findElement(By.className("displaying-num")).getText();
        return Integer.parseInt(countText.split(" ")[0]);
    }

    public static int previousPostCount() {
        return lastCount;
    }

    public static int currentPostCount() {
        return getPostCount();
    }

    public static boolean doesPostExistWithTitle(String title) {
        return Driver.instance.findElements(By.linkText(title)).size() > 0;
    }

    public static void trashPost(String title) {
        List<WebElement> rows = Driver.instance.findElements(By.tagName("tr"));
        for (WebElement row : rows) {
            List<WebElement> links = Driver.instance.findElements(By.linkText(title));
            if (links.size() > 0) {
                
                row.findElement(By.xpath("//input[@type='checkbox' and @name='post[]']")).click();
                Select select = new Select(Driver.instance.findElement(By.id("bulk-action-selector-bottom")));
                
                select.selectByVisibleText("Move to Trash");
                
                Driver.instance.findElement(By.id("doaction2")).click();
                /*Actions action = new Actions(Driver.instance);
                action.moveToElement(links.get(0));
                action.perform();
                //row.findElement(By.className("submitdelete")).click();
                row.findElement(By.className("trash")).click();*/
                return;
            }
        }
    }

}
