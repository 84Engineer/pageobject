/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pageobject.pages;

import static org.testng.Assert.*;
import org.testng.annotations.Test;
import pages.TestPage;

/**
 *
 * @author oslysenko
 */
public class NewTest {
    
    @Test
    public void newTest() {
        
        TestPage page = new TestPage();
        page.go();
        
    }
    
}
