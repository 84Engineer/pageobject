/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 *
 * @author oslysenko
 */
public class Driver {

    public static WebDriver instance;

    public static void initialize() {
        String driverPath = "D:/IEDriver/IEDriverServer.exe";
        System.setProperty("webdriver.ie.driver", driverPath);
        instance = new InternetExplorerDriver();

        instance.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public static void close() {
        instance.close();
    }

    public static String getBaseAddress() {
        return "http://localhost:7503";
    }

    public static void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
    }

}
