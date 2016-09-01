/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import selenium.Driver;
import pages.LoginPage;

/**
 *
 * @author LocalUser
 */
public class BaseTest {

    @BeforeClass
    public void init() {
        Driver.initialize();
        
        LoginPage.goTo();
        LoginPage.loginAs("Alex")
                .withPassword("Alx545684")
                .login();
    }

    @AfterClass
    public void cleanUp() {
        Driver.close();
    }

}
