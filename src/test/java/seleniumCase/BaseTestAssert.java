package seleniumCase;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;


public class BaseTestAssert extends BaseTest {


    public void checkTitle(String title) {
        assertEquals(title, getTitle());
        logger.info("Title kontrolü gerçekleştirildi.");
    }

    public void checkXpathValue(String key, String value) {
        assertEquals(value, driver.findElement(By.xpath(key)).getText());
        logger.info("xpath: '" + key + "' için değerin '" + value + "' geldiği konrol edilir.");
    }


    public void checkXpath(String key) {
        Assert.assertTrue("Element sayfada bulunamadı !", findElementByXpath(key));
        logger.info("xpath: '" + key + "' için elementin bulunduğu konrol edilir.");
    }

    public void checkSelectByXpath(String xpath, String value) {
        String selected = new Select(driver.findElement(By.xpath(xpath))).getFirstSelectedOption().getText();
        assertEquals(value, selected);
        logger.info("xpath: '" + xpath + "' için değerin '" + value + "' geldiği konrol edilir.");
    }

    public void checkId(String key) {
        Assert.assertTrue("Element sayfada bulunamadı !", findElementById(key));
        logger.info("id: '" + key + "' için elementin bulunduğu konrol edilir.");
    }

    public void checkLogin() {
        Assert.assertTrue("Login islemi gerceklesmedi !", findElementByXpath("//*[text()='Hesabım']"));
        logger.info("login işleminin gerçekleştiği konrol edilir.");
    }

    public void checkText(String value) {
        Assert.assertTrue("Element sayfada bulunamadı !", findElementByXpath("//*[text()='" + value + "']"));
        logger.info("Text: '" + value + "' için elementin bulunduğu konrol edilir.");

    }

    public boolean findElementByXpath(String xpath) {
        return driver.findElement(By.xpath(xpath)) != null;
    }

    public boolean findElementById(String id) {
        return driver.findElement(By.id(id)) != null;
    }
}
