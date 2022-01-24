# Regression test nedir ?
Yazılımda herhangi ufak bir değişiklik ya da yeni bir fonksiyon birçok beklenmedik sonuç doğurabilir. Regresyon testinin amacı, bu değişiklikler sonrası yazılımın hala doğru şekilde çalıştığını kontrol etmektir. Regresyon testi canlıda çalışan kodun üzerinde yapılan değişikliklerin kontrolü için kullanılır. Bu değişiklikler yeni bir fonksiyon, hata çözümü ya da performans geliştirmesi olabilir. Regresyon testleri genellikle değişiklikler son aşamaya geldiğinde ve yazılımın yeni sürümü yayınlamadan önce gerçekleştirilir. Regresyon testlerinin öncelikli amacı, uygulamanın kritik alanlarının hala beklendiği gibi çalıştığını kontrol etmektedir. 
Regresyon testleri:
- Yazılımın değişiklik sonrasında son kalitesinin kontrol edilmesini
- Daha önce çıkan hataların düzeldiğinin kontrolünü
- Yazılım ekibinin ürün hakkında güveninin artmasını sağlar

Regresyon testleri maliyeti büyük testlerdir. Yazılım firmasında maliyet = zamandır ve sürümün hızlı şekilde canlı ortama aktarılması büyük önem taşır. Bu sebeple regresyon test adımları seçiminde bazı önemli noktaları göz önüne almalıyız. Bunlar:
-	Kullanıcıların yoğun olarak kullanıldığı alanlar
-	Genellikle hata çıkan uygulama alanları
-	Ana fonksiyonlar
-	Yüksek karmaşık fonksiyonlar
-	Son değişikliklerin yapıldığı alanlar
-	Önemli entegrasyonlar
Regresyon testlerinin doğru şekilde planlanması ve gerçekleştirilmesi, yazılım projelerinin başarıya ulaşması için önemlidir. Bu nedenle canlı geçişleri öncesi, regresyon testleri gerçekleştirerek yazılıma duyulan güveni arttırabiliriz.

# A/B test nedir ?

A / B testi (bölme testi veya kova testi olarak da bilinir) hangisinin daha iyi performans gösterdiğini belirlemek için bir web sayfasının veya uygulamanın iki sürümünü birbiriyle karşılaştırmanın bir yöntemidir. AB testi, esas olarak, bir sayfanın iki veya daha fazla varyantının rasgele kullanıcılara gösterildiği bir deneydir ve hangi varyasyonun belirli bir dönüşüm hedefi için daha iyi performans gösterdiğini belirlemek için istatistiksel analiz kullanılır. Bir varyasyonu güncel bir deneyimle doğrudan karşılaştıran bir AB testi yayınlamak, web sitenizdeki veya uygulamanızdaki değişiklikler hakkında odaklanmış sorular sormanıza ve ardından bu değişikliğin etkisiyle ilgili verileri toplamanıza olanak tanır.

# Black box / white box test kavramlarını açıklayınız.

## Black box test
Yazılımın iç yapısı incelenmeden sisteme yapılan giriş ve çıkış değerlerinin incelendiği bir test türüdür. Bu testin amaçları şöyle sıralanabilir.

- Sistemin açılış ve kapanış esnasında karşılaşılacak problemlerin keşfi.
- Yanlış ve ya eksik çalışan fonksiyonların keşfi.
- Ara yüz zafiyetlerinin keşfi.
- Veri tabanına erişim kayıtlanma veya olası diğer zafiyetlerin keşfi.
- Sistemin davranışsal hatalarının ve uygulama sorunlarının keşfi.

## White box test

Kod içindeki sorunları tespit etmek için yapılan testlere denir. Sistemin işleyişi ve kod bilgisi önemlidir. Çünkü testler bu bilgilere göre yapılır.
Sistemdeki kodların uyumluluğunu ve doğruluğunu bu test sayesinde anlarız.
Kodun optimizasyonunu sağlar. White box test neyi amaçlar

- Testteki her hangi bir potansiyel hata verecek kod yapısını tespiti.
- İlerleyen süreçlerde çıkacak olan gizli hataların olmaması birim aşamada emin olmak.

<p align="center">
  <img src="https://miro.medium.com/max/626/1*mCKlxuntIR99t_jfg_fk4w.png" />
</p>

<p align="center">
  <img src="https://miro.medium.com/max/624/1*7ujXlwrf8bexK0ttWPY0aw.png" />
</p>

# Mutation test nedir ? Kısaca açıklayınız.

Türkçe'ye mutasyon testi olarak geçen mutation test, test case'lerin kalitesini ölçmek ve arttırmak için uygulanan bir test türüdür.
Bu test türünde yazılımın içine hatalar konulur ve test caselerin bu hataları bulma oranı hesaplanır.
Yazılımın değiştirilmiş her haline mutant denir. Test caselerin bu yazılımdaki değişiklikleri yani mutasyonu bulması beklenir.
Tespit edilen her mutasyona göre başarı oranı hesaplanır. Ne kadar çoksa başarı oranı o kadar fazladır. 
Mutation test kısaca testin testidir.

<p align="center">
  <img src="https://miro.medium.com/max/1400/1*Xo-UF0x8tGEAIZy52d-zPw.png" />
</p>

<p align="center">
  Mutasyon testin çalışma mantığı
</p>

# Behavior Driven Development (BDD) nedir, neyi amaçlamaktadır ?

Test driven developmentın karmaşıklığını gidermek için ortaya çıkan bir test yaklaşım biçimidir. Yazılım süreçleri daha test odaklı gider. Test senaryoları  Given, when, then olarak 3 başlıkta ilerler.

- Given --> belirlenen test senaryosu bu başlıkta oluşturulur. 
- When  --> testin  gerçekleşeceği zamanı anlatır.
- Then  --> test ile alakalı belirlenen senaryonun ve aksiyonun sonucu burada belli olur. Kısaca test sonucu burada belli olur.

Müşteri ihtiyaçlarına yönelik test senaryoları koda dökülerek test senaryoları hazırlanır. Bu yüzden ihtiyaçlar daha iyi karşılanır.

<p align="center">
  <img src="https://miro.medium.com/max/625/1*Xi8OSu86TMg5iGNdODoLUw.jpeg" />
</p>


# Agile test quadrant nedir ? Quadrant’ların kapsamını kısaca açıklayınız.
Test Türlerinin iki yönünü birleştiren Çevik Test Çeyrekleri Brian Marick tarafından türetilmiştir.

<p align="center">
  <img src="https://www.tutorialspoint.com/agile_testing/images/quadrants.jpg" />
</p>

Çevik Test Çeyrekleri, ekiplerin ihtiyaç duyulan testi belirlemesine, planlamasına ve uygulamasına yardımcı olmak için yararlı bir sınıflandırma sağlar.

Quadrant Q1 − Birim Düzeyi, Teknolojiye Yönelik ve geliştiricileri destekler. Birim testleri bu Çeyreğe aittir. Bu testler Otomatik testler olabilir.

Quadrant Q2 – Sistem düzeyi, işle ilgili ve uygun ürün davranışı. Fonksiyonel testler bu çeyreğe aittir. Bu testler manuel veya otomatiktir.

Quadrant Q3 − Sistem veya Kullanıcı Kabul Düzeyi, İşe Yönelik ve gerçek zamanlı senaryolara odaklanma. Kullanıcı Kabul Testleri bu çeyreğe aittir. Bu testler manueldir.

Quadrant Q4 − Sistem veya Operasyonel Kabul Düzeyi, Teknolojiyle Karşılaşılan ve Performansa Odaklanma, Yük, Stres, Sürdürülebilirlik, Ölçeklenebilirlik Testleri. Otomasyon testleri ile birlikte bu testler için özel araçlar kullanılabilir.

Bunları birleştirerek, Ne-Test-Ne Zaman'ı yansıtan Çevik Test Çeyrekleri aşağıdaki gibi görselleştirilebilir.

<p align="center">
  <img src="https://www.tutorialspoint.com/agile_testing/images/testing_quadrants.jpg" />
</p>

