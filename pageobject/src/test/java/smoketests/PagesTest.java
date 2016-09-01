/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smoketests;

import utils.BaseTest;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DashboardPage;
import selenium.Driver;
import pages.ListPostsPage;
import pages.LoginPage;
import pages.NewPostPage;
import pages.PostPage;

/**
 *
 * @author LocalUser
 */
public class PagesTest extends BaseTest {

   /* @Test
    public void adminUserCanLogin() {
        LoginPage.goTo();
        LoginPage.loginAs("Alex")
                .withPassword("Alx545684")
                .login();

        assertTrue(DashboardPage.isAt(), "Failed to login.");
    }

    @Test(dependsOnMethods = {"adminUserCanLogin"})*/
    @Test
    public void openSamplePage() {
        ListPostsPage.goTo(ListPostsPage.PageType.PAGE);
        ListPostsPage.selectPage("Sample Page");
        
        assertTrue(NewPostPage.isInEditMode(), "Wasn't in edit mode");
        assertEquals("Sample Page", NewPostPage.getTitle(), "Title didn't match");
    }

}
