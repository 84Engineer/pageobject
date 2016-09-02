/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selenium;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;

/**
 *
 * @author oslysenko
 */
public class Driver {

    public static WebDriver instance;

    public static void initialize() {
        String driverPath = "D:/IEDriver32/IEDriverServer.exe";
        System.setProperty("webdriver.ie.driver", driverPath);
        instance = new InternetExplorerDriver();

        turnOnWait();
    }

    public static void close() {
        instance.close();
    }

    public static String getBaseAddress() {
        return "http://localhost:18881";
    }

    public static void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
    }
    
    public static void noWait(Action action) {
        turnOffWait();
        System.out.println("Turning off wait");
        action.perform();
        System.out.println("Turning on wait");
        turnOnWait();
    }
    
    private static void turnOffWait() {
        instance.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }
    
    private static void turnOnWait() {
        instance.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

}
