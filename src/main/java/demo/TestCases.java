package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.awt.*;
///
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

public class TestCases {
    ChromeDriver driver;

    public TestCases() {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    // post image on linkdin
    public void testCase07() throws InterruptedException, AWTException {
        driver.get("https://www.linkedin.com/feed/");
        // click on sign in Using Locator "XPath" //a[contains(@Class,'nav__button-s')]

        WebElement signin = driver
                .findElement(By.xpath("//a[contains(text(),'Sign in')]"));
        signin.click();
        // Enter email
        WebElement email = driver.findElement(By.xpath("//input[@id='username' and @name='session_key']"));
        email.sendKeys("moresupriyasunil@gmail.com");

        // Enter pass word using xpath //input[@id='password' and @type='password']
        WebElement password = driver.findElement(By.xpath("//input[@id='password' and @type='password']"));
        password.sendKeys("heemalaya12");
        // click on sign in button[type="submit"] and click on it
        WebElement sign = driver.findElement(By.cssSelector("button[type='submit']"));
        sign.click();
        // implicitly wait

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        Thread.sleep(5000);
        // click on post tab
        WebElement testpost = driver
                .findElement(By.xpath("//span[text()='Start a post']"));
        testpost.click();
        Thread.sleep(5000);
        // find image path webelement
        WebElement imagepath = driver.findElement(By.xpath("//button//following::span[text()='Add a photo'][1]"));
        Actions act = new Actions(driver);
        act.moveToElement(imagepath).click().perform();
        // imagepath.click();
        Thread.sleep(4000);

        StringSelection s = new StringSelection("C:\\Users\\EXPERT\\Desktop\\download.png");
        Thread.sleep(5000);
        // use robot class to upload image
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
        Robot robot = new Robot(); // Robot class throws AWT Exception
        robot.delay(250);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(150);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(3000);
        // click o done
        WebElement ToDone = driver
                .findElement(By.xpath("//span[text()='Done']"));
        act.moveToElement(ToDone).click().perform();
        Thread.sleep(5000);
        // click on post
        WebElement ToPost = driver
                .findElement(By.xpath("//span[text()='Post']"));
        act.moveToElement(ToPost).click().perform();
        // verify image is posted successfully or not
        WebElement message = driver
                .findElement(By.cssSelector("p[class*='artdeco-toast-item__message'][role='alert']"));
        boolean status = message.isDisplayed();
        if (status == true) {
            System.out.println("Post is posted successfully");
        } else {
            System.out.println("Not posted successfully");
        }
    }
}
