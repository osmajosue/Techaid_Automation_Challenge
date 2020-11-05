package Tests;

import PageObjects.HomePage;
import PageObjects.SignUpPage;
import Utils.Helpers;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;


public class TestPlan {
    public static WebDriver driver;

    @BeforeAll
    public static void setUp(){
        System.setProperty(Helpers.SETUP_DRIVER, Helpers.CHROME_DRIVER_LOCATION);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(Helpers.BASE_URL);
    }

    @Test
    public void createNewTwitterAccount() throws InterruptedException {
        SignUpPage.signUpProcess(driver);
        Assertions.assertTrue(SignUpPage.isAccountCreated(driver));
    }

    @Test
    public void tweetText() throws InterruptedException{
        HomePage.tweetText(driver);
        Assertions.assertTrue(HomePage.isTextTweeted(driver));
    }

    @Test
    public void tweetImage() throws InterruptedException{
        HomePage.tweetImage(driver);
        Assertions.assertTrue(HomePage.imageIsDisplayed(driver));
    }

    @Test
    public void tweetVideo() throws InterruptedException{
        HomePage.tweetVideo(driver);
        Assertions.assertTrue(HomePage.isThatAVideo(driver));
        HomePage.pauseVideo(driver);
        HomePage.playVideo(driver);
        HomePage.unMuteVideo(driver);
        HomePage.muteVideo(driver);
    }

    @Test
    public void tweetLink() throws InterruptedException{
        HomePage.tweetLink(driver);
        Assertions.assertTrue(HomePage.isThatAlink(driver));
    }


    @AfterAll
    public static void tearDown(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.quit();
    }

}
