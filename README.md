## Gittigidiyor Selenium & Trello Rest-Asured Test Case

Maven projesi olarak birlikte yazılmıştır. 
Selenium, JUnit, Log4J, Rest-Asured ve TestNG  kütüphanelerini kullanılmıştır.

### Gittigidiyor Selenium Case

- www.gittigidiyor.com sitesi açılır.
- Ana sayfanın açıldığı kontrol edilir. Siteye login olunur
- Login işlemi kontrol edilir.
- Arama kutucuğuna bilgisayar kelimesi girilir.
- Arama sonuçları sayfasından 2.sayfa açılır.
- 2.sayfanın açıldığı kontrol edilir.
- Sonuca göre sergilenen ürünlerden rastgele bir ürün seçilir.
- Seçilen ürünün ürün bilgisi ve tutar bilgisi txt dosyasına yazılır.
- Seçilen ürün sepete eklenir.
- Ürün sayfasındaki fiyat ile sepette yer alan ürün fiyatının doğruluğu karşılaştırılır.
- Adet arttırılarak ürün adedinin 2 olduğu doğrulanır.
- Ürün sepetten silinerek sepetin boş olduğu kontrol edilir.


### Trello Rest-Asured Test Case

- Trello üzerinde bir board oluşturulur.
- Oluşturduğumuz board’ a iki tane kart oluşturulur.
- Oluşturduğumuz bu iki karttan random olacak sekilde bir tanesini güncellenir.
- Oluşturduğumuz kartlar silinir.
- Oluşturduğumuz board silinir.
