/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pageobject.pages;

import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.Driver;
import pages.LoginPage;
import pages.NewPostPage;
import pages.PostPage;


/**
 *
 * @author oslysenko
 */
public class LoginTest extends BaseTest {
    
    @Test
    public void adminUserCanLogin() {    
        assertTrue(DashboardPage.isAt(), "Failed to login.");
    }
    
    @Test(dependsOnMethods = { "adminUserCanLogin" }) 
    public void canCreateABasicPost() {
        NewPostPage.goTo();
        NewPostPage.createPost("Test Post Title")
                .withBody("Body of the Test Post.")
                .publish();
        
        NewPostPage.goToNewPost();
        assertEquals(PostPage.getTitle(), "Test Post Title", "Title did not match new post.");
    }
    
}
