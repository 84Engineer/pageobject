/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import selenium.Driver;
import pages.LoginPage;
import workflows.PostCreator;

/**
 *
 * @author LocalUser
 */
public class BaseTest {

    @BeforeMethod
    public void init() {
        Driver.initialize();
        
        PostCreator.initialize();

        LoginPage.goTo();
        LoginPage.loginAs("Alex")
                .withPassword("Alx545684")
                .login();
    }

    @AfterMethod
    public void cleanUp() {
        PostCreator.cleanUp();
        Driver.close();
    }

}
