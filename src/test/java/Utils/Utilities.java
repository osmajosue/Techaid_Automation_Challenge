package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import java.util.ArrayList;


public class Utilities {

    public static String generateEmail(WebDriver driver) throws InterruptedException {

        JavascriptExecutor jsExe = (JavascriptExecutor) driver;
        jsExe.executeScript(Helpers.FAKE_EMAIL_SCRIPT);
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        Thread.sleep(6000);
        String email = driver.findElement(By.id("email")).getText();
        driver.switchTo().window(tabs.get(0));
        return email;
    }

    public static String verificationCode(WebDriver driver) throws InterruptedException {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        Thread.sleep(9000);
        String verificationSentence = driver.findElement(By.xpath("//*[@id='schranka']/tr[1]/td[2]")).getText();
        String[] array = verificationSentence.split("\\s");
        String verificationCode = array[0];
        driver.switchTo().window(tabs.get(0));
        return verificationCode;
    }
}
