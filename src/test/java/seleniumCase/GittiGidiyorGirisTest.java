package seleniumCase;

import org.junit.Test;

public class GittiGidiyorGirisTest extends BaseTestKeyword {


    @Test
    public void girisTest() {
        girisYap("mxj84663@xcoxc.com", "Test1234");
        urunAra("Bilgisayar");
        sepeteEkle();

    }


}
