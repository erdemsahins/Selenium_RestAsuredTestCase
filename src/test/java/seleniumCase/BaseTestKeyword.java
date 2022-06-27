package seleniumCase;

public class BaseTestKeyword extends BaseTestAssert {

    public void girisYap(String kullaniciAdi, String sifre) {
        checkTitle("GittiGidiyor - Türkiye'nin Öncü Alışveriş Sitesi");
        clickByXpath("//*[@title = 'Giriş Yap']");
        clickByDataCy("header-login-button");
        sendById("L-UserNameField", kullaniciAdi);
        sendById("L-PasswordField", sifre);
        clickById("gg-login-enter");
        checkXpath("//*[@data-cy='header-user-menu']/div[@title='Hesabım']");
    }

    public void urunAra(String keyword) {
        callHomePage();
        checkTitle("GittiGidiyor - Türkiye'nin Öncü Alışveriş Sitesi");
        clickByText("Kapat");
        sendByDataCy("header-search-input", keyword);
        clickByDataCy("search-find-button");
        clickByXpath("//*[@data-testid='pagination-list-item']/a[@aria-label='2. sayfa']");
        checkXpathValue("//*[@data-testid='pagination-list-item']/a[@aria-current='true']", "2");
    }

    public void sepeteEkle() {
        randomSelectXpath("//*[@data-cy='product-card-item']//a");
        getByIdAndSave("sp-title");
        getByIdAndSave("sp-subTitle");
        getByIdAndSave("sp-price-highPrice");
        getItemPrice();
        clickById("add-to-basket");
        clickByText("Sepete Git");
        getBasketItemPrice();
        selectByXpath("//*[@class='amount']", "2");
        checkSelectByXpath("//*[@class='amount']", "2");
        clickByXpath("(//a[@title='Sil'])[1]");
    }


}
