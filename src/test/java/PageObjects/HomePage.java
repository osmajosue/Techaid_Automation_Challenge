package PageObjects;

import Utils.Helpers;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;


public class HomePage {
    private static WebElement element = null;
    private static final WebElement elements = null;


    public static WebElement contentBox(WebDriver driver){
        element = driver.findElement(By.xpath("//*/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div[2]/" +
                "div/div/div/div"));
        return element;
    }

    public static WebElement tweetBtn(WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        element = driver.findElement(By.xpath("//*/div[4]/div/div/div[2]/div[3]"));
        return element;
    }

    public static WebElement tweetMedia(WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        element = driver.findElement(By.xpath("//*/div[1]/input"));
        return element;
    }

    public static  WebElement firstTweetHomePage(WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        element = driver.findElement(By.xpath("//*/div[1]/div/div/article/div/div/div/div[2]/div[2]/div[2]/div[1]/div"));
        return element;
    }

    public static WebElement twitterAccountCreated(WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        element = driver.findElement(By.xpath("//*/div[2]/div/div[2]/div[1]/div/div/div/div[1]/a"));
        return element;
    }

    public static WebElement videoElement(WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        List<WebElement> elements = driver.findElements(By.xpath("//*/video"));
        element = elements.get(0);
        return element;

    }

    public static WebElement linkElement(WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        element = driver.findElement(By.xpath("//*/div[4]/div/div/section/div/div/div[1]/div/div/article/div/div" +
                "/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div[2]/a"));
        return element;
    }

    public static void tweetText(WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        HomePage.contentBox(driver).sendKeys(Helpers.TEXT_TWEET);
        HomePage.tweetBtn(driver).click();
        Thread.sleep(1000);
    }

    public static void tweetLink(WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        HomePage.contentBox(driver).sendKeys(Helpers.TEXT_TWEET + Helpers.LINK_TWEET);
        HomePage.tweetBtn(driver).click();
        Thread.sleep(1000);
    }

    public static void tweetImage(WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        HomePage.tweetMedia(driver).sendKeys(Helpers.IMAGE_SRC);
        Thread.sleep(1000);
        HomePage.contentBox(driver).sendKeys(Helpers.TEXT_IMAGE);
        HomePage.tweetBtn(driver).click();
        Thread.sleep(2000);
    }

    public static void tweetVideo(WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        HomePage.tweetMedia(driver).sendKeys(Helpers.VIDEO_SRC);
        Thread.sleep(1000);
        HomePage.contentBox(driver).sendKeys(Helpers.TEXT_VIDEO);
        HomePage.tweetBtn(driver).click();
        Thread.sleep(7000);
    }


    public static void playVideo(WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        JavascriptExecutor jScript = (JavascriptExecutor) driver;
        jScript.executeScript("arguments[0].play()", HomePage.videoElement(driver));
        Boolean paused = (Boolean) jScript.executeScript("return arguments[0].paused", HomePage.videoElement(driver));
        Assertions.assertTrue(!paused);
    }

    public static void pauseVideo(WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        JavascriptExecutor jScript = (JavascriptExecutor) driver;
        jScript.executeScript("arguments[0].pause()", HomePage.videoElement(driver));
        Boolean paused = (Boolean) jScript.executeScript("return arguments[0].paused", HomePage.videoElement(driver));
        Assertions.assertTrue(paused);
    }

    public static void muteVideo(WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        JavascriptExecutor jScript = (JavascriptExecutor) driver;
        jScript.executeScript("arguments[0].muted=true", HomePage.videoElement(driver));
        Boolean muted = (Boolean) jScript.executeScript("return arguments[0].muted", HomePage.videoElement(driver));
        Assertions.assertTrue(muted);
    }

    public static void unMuteVideo(WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        JavascriptExecutor jScript = (JavascriptExecutor) driver;
        jScript.executeScript("arguments[0].muted=false", HomePage.videoElement(driver));
        Boolean muted = (Boolean) jScript.executeScript("return arguments[0].muted", HomePage.videoElement(driver));
        Assertions.assertTrue(!muted);
    }

    public static Boolean isTextTweeted(WebDriver driver) throws InterruptedException {
        if (Helpers.TEXT_TWEET.equals(HomePage.firstTweetHomePage(driver).getText())){
            return true;
        }
        return false;
    }

    public static Boolean imageIsDisplayed(WebDriver driver){
        WebElement imageLoaded = driver.findElement(By.xpath("//*/div[1]/div/div/article/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div/a/div/div[2]/div/img"));
        return (Boolean)((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" " +
                "&& arguments[0].naturalWidth > 0", imageLoaded);
    }

    public static Boolean isThatAVideo(WebDriver driver) throws InterruptedException {
        if (videoElement(driver).getTagName().equals("video")){
            return true;
        }
        return false;
    }

    public static Boolean isThatAlink(WebDriver driver) throws InterruptedException {
        if (linkElement(driver).getTagName().equals("a")){
            return true;
        }
        return false;
    }
}
