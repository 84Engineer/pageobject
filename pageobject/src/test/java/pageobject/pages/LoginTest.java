/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pageobject.pages;

import static org.testng.Assert.*;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.TestPage;

/**
 *
 * @author oslysenko
 */
public class LoginTest {
    
    @Test
    public void adminUserCanLogin() {
        LoginPage.goTo();
        LoginPage.loginAs("Alex")
                .withPassword("Alx545684")
                .login();
        
        assertTrue(DashboardPage.isAt(), "Failed to login.");
    }
    
}
