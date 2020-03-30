import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class Pillow_Purchase {

        private WebDriver driver;
        Logger logger = Logger.getLogger(Pillow_Purchase.class.getName());

        @BeforeMethod
        public void setUp() {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\bachals\\IdeaProjects\\GoJekUI\\src\\main\\resources\\geckodriver-v0.26.0-win64\\geckodriver.exe");
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\bachals\\IdeaProjects\\GoJekUI\\src\\main\\resources\\chromedriver_win32\\chromedriver.exe");
            driver = new FirefoxDriver();
            driver.get("https://demo.midtrans.com/");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }

        @AfterMethod
        public void tearDown() {
            driver.quit();
        }

        @Test (priority = 1, description="Tests a valid purchase")
        public void valid_purchase() {
            driver.findElement(By.linkText("BUY NOW")).click();
            driver.findElement(By.cssSelector(".cart-checkout")).click();
            driver.switchTo().frame(0);
            driver.findElement(By.cssSelector(".button-main-content")).click();
            driver.findElement(By.cssSelector(".with-promo .list-title")).click();
            driver.findElement(By.name("cardnumber")).click();
            driver.findElement(By.name("cardnumber")).sendKeys("4811 1111 1111 1114");
            driver.findElement(By.cssSelector(".col-xs-7 > input")).sendKeys("03 / 20");
            driver.findElement(By.cssSelector(".col-xs-5 > input")).sendKeys("123");
            driver.findElement(By.cssSelector(".input-row > div:nth-child(2)")).click();
            driver.findElement(By.cssSelector(".button-main-content")).click();
            driver.switchTo().frame(0);
            driver.findElement(By.cssSelector("#PaRes")).sendKeys("112233");
            driver.findElement(By.name("ok")).click();
            driver.switchTo().defaultContent();
            String actual_result = driver.findElement(By.className("trans-success")).getText();
            logger.info(actual_result);
            Assert.assertTrue(actual_result.contains("Thank you for your purchase"));
        }

        @Test (priority = 2, description="Tests a invalid purchase")
        public void invalid_purchase_invalidCard() {
            driver.findElement(By.linkText("BUY NOW")).click();
            driver.findElement(By.cssSelector(".cart-checkout")).click();
            driver.switchTo().frame(0);
            driver.findElement(By.cssSelector(".button-main-content")).click();
            driver.findElement(By.cssSelector(".with-promo .list-caption")).click();
            driver.findElement(By.name("cardnumber")).sendKeys("4811 1111 1111 1113");
            String invalid_card_message = driver.findElement(By.xpath("//*[@id=\"application\"]/div[3]/div/div/div/form/div[2]/div[1]/div/span")).getText();
            logger.info(invalid_card_message);
            Assert.assertTrue(invalid_card_message.equals("Invalid card number"));
        }

        @Test (priority = 3, description="Tests a invalid purchase")
        public void invalid_purchase_invalidPromo() {
            driver.findElement(By.linkText("BUY NOW")).click();
            driver.findElement(By.cssSelector(".cart-checkout")).click();
            driver.switchTo().frame(0);
            driver.findElement(By.cssSelector(".button-main-content")).click();
            driver.findElement(By.cssSelector(".with-promo .list-caption")).click();
            driver.findElement(By.name("cardnumber")).sendKeys("4811 1111 1111 1114");
            driver.findElement(By.cssSelector(".col-xs-7 > input")).sendKeys("03 / 20");
            driver.findElement(By.cssSelector(".col-xs-5 > input")).sendKeys("123");
            driver.findElement(By.cssSelector(".button-main-content")).click();
            String invalid_promo_message = driver.findElement(By.cssSelector("#application > div.pop-wrapper.has-close.danger.show > span > span")).getText();
            logger.info(invalid_promo_message);
            Assert.assertEquals(invalid_promo_message,"Promo is not available");
          }
}

