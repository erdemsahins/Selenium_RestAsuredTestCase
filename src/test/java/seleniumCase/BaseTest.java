package seleniumCase;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public final Logger logger = LogManager.getLogger(this.getClass());
    public WebDriver driver;
    String StringPrice;
    String StringBasketPrice;

    private static String clearData(String data) {
        data = data.replaceAll("\n", "");
        data = data.replaceAll("TL", "");
//        data = data.replaceAll(",", "");
        data = data.replaceAll("\\.", "");
        data = data.trim();
        return data;

    }

    @Before
    public void startTest() throws InterruptedException {
        BasicConfigurator.configure();

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        logger.info("Chrome driver baslatildi.");

        this.driver.get("https://www.gittigidiyor.com/");
        Thread.sleep(2000);
        //close new popup
        driver.findElement(By.xpath("//*[@class=\"wis_clsbtn\"]")).click();
    }

    @After
    public void endTest() throws InterruptedException {
        Thread.sleep(2000);
        logger.info("Test Sonlandırıldı.");
        driver.quit();
    }

    public String getTitle() {
        logger.info("Title bilgisi getirildi.");
        return driver.getTitle();
    }

    public void clickByText(String text) {
        driver.findElement(By.xpath("//*[text()='" + text + "']")).click();
        logger.info("Text: " + text + " olan elemente tıklandı.");
    }

    public void clickByLintext(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
        logger.info("linktext: '" + linkText + "' olan elemente tıklandı.");
    }

    public void sendById(String id, String value) {
        driver.findElement(By.id(id)).sendKeys(value);
        logger.info("id bilgisi '" + id + "' olan elemente '" + value + "' değeri yazıldı.");
    }

    public void clickById(String id) {
        driver.findElement(By.id(id)).click();
        logger.info("id bilgisi '" + id + "' olan elemente tıklandı.");
    }

    public void clickByName(String name) {
        driver.findElement(By.name(name)).click();
        logger.info("name bilgisi '" + name + "' olan elemente tıklandı.");
    }

    public void clickByXpath(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
        logger.info("xpath: '" + xpath + "' olan elemente tıklandı.");

    }

    public void callHomePage() {
        driver.get("https://www.gittigidiyor.com/");
        logger.info("Ana Sayfa çağırıldı.");
    }

    public void clickByClassName(String className) {
        driver.findElement(By.className(className));
        logger.info("Class Name: '" + className + "' olan elemente tıklandı.");

    }

    public void selectById(String id, String value) {
        new Select(driver.findElement(By.id(id))).selectByValue(value);
        logger.info("id: '" + id + "' olan select de '" + value + "' değeri seçildi.");
    }

    public void selectByXpath(String xpath, String value) {
        new Select(driver.findElement(By.xpath(xpath))).selectByValue(value);
        logger.info("xpath: '" + xpath + "' olan select de '" + value + "' değeri seçildi.");
    }

    public void clickByDataCy(String dataCy) {
        driver.findElement(By.xpath("//*[@data-cy='" + dataCy + "']")).click();
    }

    public void sendByDataCy(String dataCy, String value) {
        driver.findElement(By.xpath("//*[@data-cy='" + dataCy + "']")).clear();
        driver.findElement(By.xpath("//*[@data-cy='" + dataCy + "']")).sendKeys(value);
        logger.info("data-cy: '" + dataCy + "' olan elemente '" + value + "' değeri yazıldı.");

    }

    public void randomSelectXpath(String xpath) {
//        driver.get("https://www.gittigidiyor.com/arama?k=bilgisayar&sf=2");
        driver.navigate().refresh();
        List<WebElement> pageResult = driver.findElements(By.xpath(xpath));
        Random random = new Random();
        pageResult.get(random.nextInt(pageResult.size())).click();
        logger.info("Random fonksiyonu çalıştırılarak bir ürün seçilir.");
    }

    public void getByIdAndSave(String id) {
        String text = driver.findElement(By.id(id)).getText();
        logger.info("kaydedilen text: '" + text + "'");

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt", true));
            writer.append(text + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getItemPrice() {
        StringPrice = driver.findElement(By.id("sp-price-highPrice")).getText();
        StringPrice = clearData(StringPrice);
    }

    public void getBasketItemPrice() {
        StringBasketPrice = driver.findElement(By.xpath("//*[@class='total-price']")).getText();
        StringBasketPrice = clearData(StringBasketPrice);
        boolean check = StringBasketPrice.equals(StringPrice);
        Assert.assertTrue(check);
        logger.info("Ürün sayfasındaki fiyat ile sepette yer alan ürün fiyatının doğruluğu karşılaştırılır.");

    }


}
