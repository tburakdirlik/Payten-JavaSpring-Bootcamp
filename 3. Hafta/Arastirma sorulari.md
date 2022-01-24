# 1.	Imperative Programming ve Declarative Programming kavramlarını kısaca açıklayıp farklarını belirtiniz. 

İmperative programming bir işi nasıl yapacağını declarative ise ne yapacağını anlattığın programalama şeklidir.
### Imperative Yöntem
```java
// Diktörgen Çizme
> kalemiSuPozisyonaGötür()
> kalemiBastır()
> kalemiSuPozisyonaSürükle()
> kalemiSuPosizyondaDurdur()
> kalemiSuPozisyonaSürükle()
> kalemiSuPosizyondaDurdur()
> kalemiSuPozisyonaSürükle()
> kalemiSuPozisyonaDurdur()
> kalemiSuPozisyonaSürükle()
> kalemiSuPozisyonaDurdur()
> kalemiKaldır()
```
İmperative yöntemde açıklayıcı emirlerle işlemi detaylı bir şekilde gerçekleştiririz.
### Declarative Yöntem
```java
> diktorgen(ciz)
```
### Imperative ve Declarative programlama farkları

|Imperative Programlama|Declarative Programlama|
|----------------------|----------------------|
|Procedural programlama|Mantıksal programlama|
|Object Oriented programlama|Fonksiyonel	Programlama|
|Paralel işleme yaklaşımları|Database işleme yaklaşımları|

# 2. Veri tabanlarının sorgu optimizasyonlarında index oluşturmanın avantajı nedir ? Sık index kullanmak bir probleme yol açar mı? 
Veri tabanlarında index oluşturmak, daha az veri okuyarak sorgu yapmamızı sağlar. İndex oluşturarak tablonun tamamını okumaktansa oluşturacağımız index ile okumak istediğimiz kayıda direk ulaşabiliriz. Böylece tamamlanması saatler sürecek sorgular indeks ile saniyeler içinde halledilir.  Eğer tabloya bir güncelleme yapacak olursak indekssiz tabloya göre daha uzun sürecektir. Çünkü her güncelleme indeks yapısını yeniden kontrol eder bu da ek maliyetlere sebep olur.

Indexler ekstra yer kaplayan objelerdir. Filtreleme yapmayacağımız değerler üzerinde index oluşturmak disk üzerinde gereksiz yer kaplatır. Veri tabanındaki her kayıt için index oluşturmak veya filtreleme yapmayacağımız değerler üzerinde index oluşturmak kötü bir hafıza yönetimine ve güncellemede yavaşlığa sebep olur. 

## 3. İlişkisel veritabanları için normalizasyon kavramı neyi ifade etmektedir ? İlk 3 normal formu örnek üzerinden açıklayınız. 
Normalizasyon veri tabanı üzerinde veri tutarlılığının ve bütünlüğünün korunmasını sağlar. Uygun seviyelerde yapılan normalizasyon aynı zamanda performans artışı sağlar. 6 ayrı normalizasyon seviyesi vardır ancak en çok ilk 3 seviyedeki normalizasyonlar kullanılır.

### 1.	Seviye normalizasyon için gerekli kurallar 
-	Aynı tabloda tekrarlayan kolonların bulunmaması
-	Her kolonda yalnızca bir değer bulunması
-	Her satır için tanımlayıcı bir anahtar kolonun bulunma


|Ad|Soyad|Telefon 1|Telefon 2|Telefon 3|
|--|-----|---------|---------|---------|
|Nurullah|Çakır|(123) 4567890|(123) 1234567|(123) 1231231|
|Hakan|Gürbaşlar|(123) 1111111|	

Bu örnekte Nurullah kullanıcısının 3 telefonu varken diğer kullanıcının 1 tane telefon numarası var, daha fazla sayıda telefon numarasına sahip bir kullanıcı eklendiği zaman eklenecek olan kolon sayısı artacaktır. Tekrarlayan kolonların 1. Normalizasyonda bulunmaması gerektiğinden dolayı tabloyu yeniden oluşturmak gerekir.

Tablonun düzenlenmiş hali 

|ID|Ad|Soyad|Telefon|
|--|--|-----|-------|
|1|Nurullah|Çakır|(123) 4567890|
|1|Nurullah|Çakır|(123) 1234567|
|1|Nurullah|Çakır|(123) 1231231|	
|2|Hakan|Gürbaşlar|(123) 1111111|	

Telefon numaralarını tek bir kolona topladık kullanıcılara id atayarak farklı telefon numaralarının aynı kullanıcıya ait olmayacağını artık anlayabileceğiz.

### 2.	Seviye normalizasyon için gerekli kurallar 
-	Belirli sayıda kolondan oluşan alt kümede tekrarlanan kayıtlar bulunmaması, bu alt küme için ayrı bir tablo oluşturulması.
-	Alt kümeden oluşan tablo ile asıl tablo arasında ilişki tanımlayacak anahtarların (foreign key) tanımlanması.
1.	normalizasyonu uyguladık fakat bir önceki güncellediğimiz tablo üzerinde bir problem var. Id ve isim soyisimi kullanarak telefon numaralarına erişemiyoruz. ID=1 Ad-soyad = Nurullah Çakır dediğimiz zaman karşımıza 3 farklı telefon numarası çıkıyor. Biz her telefona erişebilmek istiyoruz. Bu durumda bir id ataması daha yaparak istediğimiz telefon numarasına istediğimiz kişi üzerinden erişebiliriz.

|ID|Kişi ID|Telefon|
|--|-------|-------|
|1|101	(123)|4567890|
|2|101	(123)|1234567|
|3|101	(123)|1231231|
|4|102	(123)|1111111|

### 3. normalizasyon seviyesi için gerekli kurallar 
- Bir tablonun 3. Normalizasyon seviyesinde olması için öncelikli olarak 2. Seviyede olması gerekir. Bu seviyede ayrıca birincil anahtar (primary key) olmayan her kolonun başka bir kolona bağlı olmaması da kontrol edilir.

|ID|Ad|Soyad|İl|İlçe|
|--|--|-----|--|----|
|101|Nurullah|Çakır|Ankara|Çankaya|	
|102|Hakan|Gürbaşlar|Ankara|Çankaya|

Via : https://www.veritabani.gen.tr/2017/01/30/veritabaninda-normalizasyon-kavrami/
# 4. ORM kütüphaneleri kullanmak her zaman avantajlı mıdır ? ORM kütüphanelerinin ne gibi dezavantajları olabilir ? 
ORM Kullanmak her zaman avantajlı değildir. Karmaşık sorgular için ORM, SQL ile rekabet edemez. ORM kullanmak uygulama hızımızı azaltabilir. Kod üzerindeki hakimiyetimizi kısıtlayabilir bu nedenle her zaman kullanmamak gerek. Öğrenmesi zor deniliyor.
### Peki neden ORM 
ORM kullanmak bize zaman kazandırır. Veri modeli tek bir yere yazılır böylece kodu güncellemek, yeniden kullanmak daha kolaydır
5. Domain Specific Language (DSL) kavramını açıklayınız. 
Programlama dilleri kullanım alanlarına göre özel (Domain specific language )ve genel (General purpose language)olarak 2 ye ayrılır. Specifik bir uygulama geliştireceksek Domain specific diller kullanılır. Akla gelebilecek her türlü iş için özelleştirilmiş diller domain specific dillerdir. Örneğin web uygulamaları için css veritabanı işlermleri için SQL örnek olarak verilebilir. Genel amaçlı diller geniş kapsamlıdır ve birçok amaç için kullanılır. (Java, C, Python) 
# 6. Long lived transaction kavramı hangi tip transactionları ifade etmektedir ? Dezavantajları var mıdır ? Varsa nelerdir ? 
"Transaction", daha küçük parçalara ayrılamayan en küçük işlem yığınına denir. Belirli bir grup işlemin arka arkaya gerçekleşmesine rağmen, işlemlerin seri ya da toplu halde değerlendirilip hepsinin düzgün bir şekilde ele alınması gerektiğinde kullanılır. "Transaction", prensip olarak ya bütün işlemleri gerçekleştirir ya da hiçbirini gerçekleştirmez.  İşlemlerden biri dahi başarısız olursa, bu prensip nedeniyle hiçbir işlem olmamış kabul edilir; ancak tüm işlemler başarılı olduğunda" transaction", içinde gerçekleşen tüm veri değişikliklerini onaylamış demektir.

"Transaction" bloğundaki işlemlerin hepsi başarılı olduğunda "Transaction" Commit (Onaylama) komutu çalışır ve değişiklikler veritabanında gerçekleşmiş olur; ancak bir hata varsa işleyiş bozulur ve "transaction" Rollback (Geridönüş) komutu çalışır, bu şekilde tüm işlemler geri alınır ve en başa dönülür. Böylece veri kaybına karşı bir çeşit koruma mekanizması oluşturulmuş olunur.

Via: https://bidb.itu.edu.tr/seyir-defteri/blog/2013/09/07/t-sql-de-transaction-yapisi-ve-kullanimi


Uzun ömürlü bir işlem, birden çok veritabanı işlemini kapsayan bir işlemdir. İşlem "uzun ömürlü" olarak kabul edilir, çünkü sınırları, iş mantığı gereği, tek bir veritabanı işlemini geçmesi gerekir. Uzun ömürlü bir işlem, tek bir atomik sonuç elde etmek için gruplandırılmış bir veritabanı işlemleri dizisi olarak düşünülebilir.
Yaygın bir örnek, bir web istemcisi aracılığıyla bir kullanıcıyla etkileşimin çok adımlı bir istek ve yanıt dizisidir. Uzun ömürlü bir işlem, eşzamanlılık denetimi ve ölçeklenebilirlik sorunları yaratır. Uzun ömürlü işlemlerin tasarlanmasında temel strateji, sürüm oluşturma ile iyimser eşzamanlılık kontrolüdür.

Via: https://en.wikipedia.org/wiki/Long-lived_transaction
<p align="center">
  <img src="https://miro.medium.com/max/875/1*Vln73f03U2tuNoqgmCZ-rQ.gif" />
</p>

# 7. Thread Pool nedir ? Nerelerde kullanılır ? 
Thread pool çok fazla thread gerektiren uygulamalarda kullanılır. Yeni thread oluşturmak işletim sistemine ekstra maliyet getireceğinden oluşturulan threadler bir havuz da tutulur. Lazım olduğunda oradan çağırılır ve kullanılır. Var olan threadler dönüşümlü olarak kullanılır . İlk olarak Unix işletim sistemi üzerinde oluşturulmuştur.  Veri tabanı, web sunucuları gibi sunucu programları, birden çok istemciden gelen istekleri tekrar tekrar yürüttüğü için bu uygulamalarda thread pool kullanımı faydalıdır. 

# 8. Scalability nedir ? Horizontal ve Vertical Scalability kavramlarını açıklayınız. 
Scalability (Ölçeklenebilirlik) sistemdeki artan kullanıcı sayısıyla beraber bu duruma sistemin nasıl tepki verdiği ile ilgili bir kavramdır.

**Vertical scalability (dikey ölçeklenebilirlik)** Var olan makinemizin donanım özelliklerinin arttırılarak (cpu, ram) sistemin requestleri karşılama yeteneğinin arttırılmasıdır.

**Horizontal (yatay ölçeklenebilirlik)** Var olan kaynak havuzuna yeni makine ekleyerek sistem yükünü dağıtma ve requestleri karşılama yeteneğinin arttırılmasıdır

# 9. Data replication ve sharding nedir ? Aralarında nasıl bir fark bulunmaktadır ?
Replication, sunucu–istemci mimarisine sahip olan tüm yapılarda, aboneler ve sunucular arasında hızlı ve düzenli bir şekilde veritabanı nesnelerini eşitleme imkânı sunan bir yönteme verilen addır.
Bir replikasyon işlemi için bir yayıncı (Publisher) veritabanı seçilir. Bu yayıncı veritabanından yayınlanacak her türlü nesneler tamamı ile belirlenir. Daha sonra yapılacak işlem, Publisher veritabanının bilgilerini ve güncellenen verileri tutması için yayıncı veritabanına aboneler olarak tanımlanır. Bu işlem sayesinde sistemdeki kaynak veritabanı, sürekli güncel halde hızlı bir şekilde başka bilgisayarda da yedeklenmiş ve depolanmış olur.

-	Veriler her zaman daha güvenli ortamda saklanır.
-	Veri sorgularında en hızlı şekilde dönüş alınmasına olanak sağlar.
-	Biriken tüm veritabanı işlemlerini, karmaşıklaştırmadan hızlı bir şekilde tutarlı ve doğru bir kopyasını tutar.
-	Verilerin diğer zamanlara kıyasla sorunsuz kullanabilirliğini artırmaktadır.
-	Sağlamış olduğu yüksek performansı sayesinde birden fazla kullanıcının aynı anda kullanımına açık hale gelir.
Via https://bulutistan.com/blog/veri-replikasyonu-nedir/

Sharding: yatay bölümleme olarak da tanımlanan bir veri tabanı bölümleme şekline verilen isimdir.
İşlem performansını iyileştirme ve sorgu yanıt süresini kısaltma fikri üzerine kurulu olan sharding, çok büyük veri tabanını daha küçük ve daha kolay yönetilebilir bölümlere ayırmayı sağlar.

Replication: Birincil sunucu nodu, verileri ikincil sunucu nodu üzerine kopyalar. Bu, birincil sunucunun arızalanması durumunda veri kullanılabilirliğini artırmaya ve yedek görevi görmeye yardımcı olur. Sharding: Bir shard key kullanarak sunucular arasında yatay ölçeklendirmeyi sağlar. Bu şekilde, verileri bütünsel olarak bir yerde durmak  yerine farklı yerlerde parçalı şekilde durur.

<p align="center">
  <img src="https://miro.medium.com/max/501/1*Hjr0QmleV4ojq6Ew48K6SA.png" />
</p>
