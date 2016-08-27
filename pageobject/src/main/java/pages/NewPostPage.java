/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

/**
 *
 * @author LocalUser
 */
public class NewPostPage {

    public static void goTo() {
        WebElement postMenu = Driver.instance.findElement(By.xpath("//div[@class='wp-menu-name' and contains(text(), 'Posts')]"));
        Actions action = new Actions(Driver.instance);
        action.moveToElement(postMenu).perform();

        WebElement newPostItem = Driver.instance.findElement(By.linkText("Add New"));//findElement(By.xpath("//a[@href='post-new.php' and contains(text(), 'Add New')]"));
        newPostItem.click();
    }

    public static CreatePostCommand createPost(String title) {
        return new CreatePostCommand(title);
    }

    public static class CreatePostCommand {

        private String title;
        private String body;

        private CreatePostCommand(String title) {
            this.title = title;
        }

        public CreatePostCommand withBody(String body) {
            this.body = body;
            return this;
        }

        public void publish() {
            Driver.instance.findElement(By.id("title")).sendKeys(title);

            Driver.instance.switchTo().frame("content_ifr");
            Driver.instance.switchTo().activeElement().sendKeys(body);
            Driver.instance.switchTo().defaultContent();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }

            Driver.instance.findElement(By.id("publish")).click();
        }

    }

    public static void goToNewPost() {
        Driver.instance.findElement(By.id("message"))
                .findElements(By.tagName("a"))
                .get(0)
                .click();
    }

}
