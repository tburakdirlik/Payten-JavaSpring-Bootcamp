# 1. Spring dışında dependency injection için kullanabileceğimiz framework’ler / kütüphaneler nelerdir ? (Herhangi bir programlama dili için olabilir.) 
Dependency injection nedir ilk önce onu açıklayalım. Dependency injection yazılımı oluşturan yapıların birbirleri ile olan bağımlılıklarını azaltmayı amaçlayan ve o yazılım parçalarını olabildiğince bağımsızlaştıran bir programlama tekniğidir. Kelime anlamı olarak bağımlılıkların dışardan eklenmesi anlamına gelir. Dependency injection sayesinde yazılımı oluşturan parçaların birbirleri ile olan sıkı bağı azaldığı için uygulamaya yeni özellikler eklenip çıkarılabilmesi daha kolay hale gelir. Uygulamaya yeni özellikler ekleneceği zaman değiştirilmesi veya müdahale edilmesi gereken yerlerin sayısı minimuma iner. Daha test edilebilir yapılar ortaya çıkar. Dependency injection yapabilmek için belli teknikler kütüphaneler ve frameworkler vardır. 

### Dependency Injection teknikleri
- Constructor injection : Bağımlılıklar, sınıfa constructor ile eklenir.
- Setter injection : Bağımlılık, setter metodu ile parametre geçilerek sağlanır.
- Interface inejction : Bağımlılığı, aktaracak olan bir metot sağlar.

### Frameworkler
- Spring (Java)
- Google Guice (Java)
- Dagger (Java and Android)
- Unity (.Net)
- Castle Windsor (.Net)
- Symfony (PHP)

### Kütüphaneler
- Scrutor (Asp.Net)
- Lombok (Java)
- Typedi (JavaScript/TypeScript)


# 2. @SpringBootApplication anotasyonu hangi anotasyonları kapsamaktadır ? Görevlerini kısaca açıklayınız. 
Bu anotasyon **@Configuration @EnableAutoConfiguration @ComponentScan** anotasyonlarını içeren temel bir anotasyondur.

### @Configuration
Java’daki konfigürasyon işlemini yapan anotasyondur. @Bean tanımlaması içerir. Tanımlandığı fonksiyonun return ettiğini context içine ekler.

### @EnableAutoConfiguration
Uygulamaya dahil ettiğimiz jar dosyalarını ve jar bağımlılığı olan sınıfların otomatik olarak konfigüre edilmesini sağlar.  Class ve classpathleri ayarlar.

### @ComponentScan  
Projeye dahil edilen komponentleri otomatik tarar.

# 3. @Primary, @Qualifier anotasyonlarının kullanım amaçlarını açıklayınız. 

### @Primary
Tanımladığımız constructorları çağırdığımızda birisinin default gelmesini istiyorsak @Primary anotasyonunu kullanırız. Aşağıda örnek kullanımı gösterilmiştir.
```java
@Configuration
public class Config {

    @Bean
    public Employee JohnEmployee() {
        return new Employee("John");
    }

    @Bean
    @Primary
    public Employee TonyEmployee() {
        return new Employee("Tony");
    }
}
```
Uygulamamızı main metotta çalıştıralım

```java
AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
Employee employee = context.getBean(Employee.class);
System.out.println(employee);
```
Output aşağıdaki gibi olacaktır. Çünkü TonyEmployee yapıcı sınıfı default olarak tanımlanmıştır.  
**Employee{name='Tony'}**

### @Qualifier
Eğer beanimize değer atamak istiyorsak spring bu tanımlamalardan hangisinin kullanılacağına @Qualifier anotasyonu ile karar verir. Kullanımı --> @Qualifier(“beanName”)

# 4. Convention over configuration kavramını seçtiğiniz bir örnek üzerinden açıklayınız.
Conventiona uyduğunuz sürece olaylar hızlı bir şekilde gelişir. Geliştirici esnekliğini azaltır ama iş yükünden kurtarır. Maven dependency management tool'unda da kullanılan bir tekniktir. Doğru dosyaları doğru klasörlere koyarsak her sey kendiliğinden calisir.
http://devnot.com/2016/convention-over-configuration-coc-nedir/ sitesindeki robot örneği üzerinden esinlendiğim bir örnek: Normalde kapalı ortamlardan dışarı çıkarken kapıyı kendimize doğru çekeriz. İçeri girerkense kapıyı ileriye doğru iteriz. Fakat eve geldik diyelim anahtar bizde yoksa bu durumda evdeki insanlar kapıyı açar biz açmayız.  Bu özel durumun tanımlanması olayı Conventiıon over Configuration kavramına örnek olarak gösterilebilir.

# 5. Aspect Oriented Programlama nedir ? Avantajları ve dezavantajları nelerdir ? 
Aspect Oriented Programming yazılımın karmaşıklığını azaltmaya ve modülariteyi arttırmayı sağlayan bir programlama yaklaşımıdır. **Seperation of Cross Cutting Concerns** kavramı aspect oriented programlama ile beraber kullanılan bir kavramdır. Uygulama içersinde birçok yerde kullanılan fonksiyonel olmayan kodların kesişen ilgilerin kapsül içerisine konularak soyutlanması ve uygulama içersinde birçok yerde kullanılabilir hale getirilmesine denir. Loglama, Exception Handling, Security, Caching, Transaction gibi katman bağımsız parçacıklar bu şekilde soyutlanır ve uygulamanın birçok yerinde kullanılabilmesi sağlanır.

<p align="center">
  <img src="https://devnot.com/wp-content/uploads/2020/02/l4n_1.png" />
</p>

### Avantajları
- Tekrar eden kod bloklarındann kurtulmamızı sağlar.
- Kodlarımız daha abstract hale gelir.
- Bakım ve geliştirme maliyetlerini azaltır.
- Uygulama daha yönetilebilir ve esnek hale gelir.

### Dezavatajları
- Çalışma zamanı yükü artar.
- Bu programlama yaklaşımında debugger kullanılamaz.
- Küçük parçalar aniden büyük nesnelere yol açabilir, kod şişer.

# 6. SOLID prensiplerini kısaca açıklayınız. Sizce her koşulda bu prensipler çerçevesinde mi kod yazılmalıdır ? Neden ? 
Solid prensipleri uzun süreye yayılacak OOP prensiplerinin uygulandığı büyük projelerde uygulanmalıdır ve gereklidir. Bu şekilde projedeki kodlar daha temiz ve esnek hale gelir, üstüne inşa edilmesi daha kolay olur. Proje büyüdükçe birşeyler eklemek istediğimiz zaman bazı yapıları tamamen değiştirmek zorunda kalmayız. Fakat küçük çaplı projeler, belirli amaca hizmet eden küçük script yapılar için solid presiplerinin birebir uygulanması gerektiğini düşünmüyorum. Proje zaten küçük, üstüne birşeyler inşa etmeyeceksem, bir kere kodlayıp sonsuza kadar kullanıcaksam niye bu prensipleri birebir uygulamak için zaman harcayayım diye düşünürüm. Tabiki de bazı prensipleri uygulamak küçük projeler için gerekli olabilir. Fakat bütün prensipleri de uygulamaya çalışmak da gereksiz olabilir.

### S — Single-responsibility principle
Bu prensibe göre bir sınıfa bir görev yüklenmeli birsürü işi yerine getirmeye çalışmamalıdır. Sınıfın veya metotun değişmek için bir sebebi olmalıdır. Birden fazla durum o sınıfı veya metotu değiştirmeye çalışırsa birden fazla sorumluluk yüklenmiş demektir ki bu da bu prensine aykırıdır.
### O — Open-closed principle
Bu prensibe göre classlar gelişime açık fakat değişime kapalı olmalıdır. Yani metot veya sınıflar var olan özelliklerini korumalı fakat yaptığı işin daha iyi yapılabilir olmasına izin vermelidir. O sınıfı veya metotu evirip çevirip daha iyi hale getirebilirsin ama yaptığın iş değişmesin aynı kalsın demektir.
### L — Liskov substitution principle
Bir sınıfta bulunan özellikler kendisinden kalıtım alan sınıfta kullanılmayacaksa bu durum bu prensibe aykırıdır. Aşağıda bu prensibin uygulanmadığı sıkıntılı bir örnek var.
```java
public abstract class Kus
{
    public abstract string Uc();
    public abstract string Yuru();
}
public class Tavuk : Kus
        {
public override string Uc()
        {
        throw new NotImplementedException();
        }
public override string Yuru()
        {
        return "Yürüdü..";
        }
        }
public class Guvercin : Kus
        {
public override string Uc()
        {
        return "Uçtu..";
        }
public override string Yuru()
        {
        return "Yürüdü..";
        }
        }

static void Main(string[] args)
        {
        Kus kanatli = new Guvercin();
        kanatli.Uc();
        kanatli.Yuru();
        kanatli = new Tavuk();
        kanatli.Uc(); //Bu metod çağırıldığında throw new NotImplementedException() 
//hatası fırlatacaktır. Çünkü kullanılmakta fakat metodun içi boş olduğu için bu durum oluşmuştur.
        kanatli.Yuru();
        }
```
Kaynak kod --> https://gist.github.com/brkcskun/b76497824be832151945b4af4da8130d#file-solid_lsp-cs 
Aşağıda da bu prensibin uygulandığı sıkıntılı durumun ortadan kalktığı bir örnek var .
```java
public interface IUcanlar
{
    string Uc();
}
public interface IYuruyenler
{
    string Yuru();
}
public class Tavuk : IYuruyenler
        {
public string Yuru()
        {
        return "Yürüdü..";
        }
        }
public class Guvercin : IYuruyenler, IUcanlar
        {
public string Uc()
        {
        return "Uçtu..";
        }
public string Yuru()
        {
        return "Yürüdü..";
        }
        }
```
Kaynak kod --> https://gist.github.com/brkcskun/369f3561946793d7e4d6fb4e3c33f124#file-solid_lsp_2-cs  
### I — Interface segregation principle
Arayüz (Interface), yapılarını ayırmalı ve olması gerektiği kadar implemente etmeliyiz. Yeteri kadar interface oluşturursak gereksiz metot kullanımını önlemiş oluruz.
### D — Dependency Inversion Principle
Üst seviye sınıflar alt seviye sınıflara bağımlı olmamalıdır. Sınıflar arası bağımlılıklar olabildiğince azaltılmalı, bağımlılıklar abtraction ve interface ile sağlanmalıdır. Birbirine sıkı sıkıya bağımlı yapılar tekrar kullanılabilirliği azaltır bu da istemediğimiz biri durumdur.

# 7. Swagger nedir, ne amaçla kullanılmaktadır ? 
RestApi servisleri için Swagger arayüz oluşturur. Bu arayüz sayesinde kodlara erişmeye gerek kalmadan RestApilerin özelliklerini görüp inceleyebiliriz. Swagger; Postman gibi uygulamalara gerek duymadan uygulamamızı test edebilmemizi sağlar. Swagger web servislerinin dokümantasyonunu kolaylaştırır.

# 8. Richardson Maturity Model’i seviyeleriyle birlikte açıklayınız. 
Bu model rest api lerimizin hangi seviyelerde olduğunu gösteren bir olgunluk seviyesidir. RMM 4 seviyeden oluşur ve yukarı doğru çıkıldıkça daha etkin kullanıldığını ifade eder.

<p align="center">
  <img src="https://bilisim.io/wp-content/uploads/2016/12/Richardson-Maturity-Model.jpg" />
</p>

### Level 0:
Bu seviye transfer protokolü olarak da adlandırılmaktadır ve servisimize sadece tek metot üzerinden POST olarak erişebiliriz.
### Level 1:
Servimizdeki URI üzerinden bir metot üzerinden erişilebildiğimiz seviyedir. Örnek URI http://localhost/students/1
### Level 2:
POST, PUT, GET VE DELETE metotları çağırdığımız seviyedir.
### Level 3:
Servislerimizde URI’nin istek gönderip cevaba göre tekrar URI’ye istek yapabildiğimiz bir seviyedir. Servis üzerinden gelen cevaba göre akıştaki davranışı görebiliriz. 

# 9.URL, URI, URN kavramlarını bir örnek üzerinden açıklayınız. 
### URL (Uniform Resource Locator) 
Internet ile erişilebilecek kaynakların konumu URL ile ifade edilir. URL ve URI ilişkisini bir adres üzerinden anlatacak olursak URL konumu nitelerken, URI konumundaki kişinin adını belirtir. URL konum sağlar. URN o konumdaki birşeyin kimliğini ifade eder.
### URN (Unİform Resource Name)
URN bir kaynağı benzersiz olarak tanımlar. Örnek : urn:isbn:0451450523 ISBN ile bir kitabı işaret eder. 

<p align="center">
  <img src="https://i.stack.imgur.com/2iD7U.jpg" />
</p>

### URI (Uniform Resource Identifier)
İnternet ortamındaki bir kaynağın (resim dosya, belge vs.) tam olarak bütün yolunu içeren karakter dizisidir. URI, URL ve URN olarak 2 kapsama sahiptir. 

<p align="center">
  <img src="https://raw.githubusercontent.com/sumitc91/sumitc91.github.io/master/Blogs/1e0580ab-13aa-4a21-b447-cd35df82db9f_url-uri-urn.png" />
</p>

URL + identifier = URI  --> Örnek: https://www.gate.io/images/coin_icon/64/heart.png

# 10. Idempotency nedir ? Hangi HTTP metotları idempotent’ tir ? 
Idempotency: metotun başarıyla çalıştıktan sonra tekrar çağırılması durumunda mevcut yapı üzerinde değişiklik yapmaması, bir önceki değerle aynı değeri döndürmesi anlamına gelir. Bir metot bir kere çağrıdığında alınan sonuç ile birden fazla kez çağrıldığında alınan sonuç aynı ise o metot idempotent metottur.

|Http Method | Idempotent? |
|------------|-------------|
|Options|Yes|		
|Get|Yes|
|Head|Yes|
|Put|Yes|
|Post|No|
|Delete|Yes|
|Patch|No|

# 11. RFC (Request For Comment) neyi ifade etmektedir ? HTTP hangi RFC dokümanında açıklanmıştır ? Bu dokümanda HTTP hakkında ne tür bilgiler yer almaktadır ?
İnternet standartlarına verilen tanımlamalara RFC denir. Mevcut bütün protokoller RFC dokümanında açıkça tanımlanmıştır. RFC 2068 dokümanında HTTP protokolü tanımlanmıştır.

### RFC 2068 yer alan bilgilerin özeti (wikipedi alıntısıdır)
> Hiper metin aktarma iletişim kuralı (HTTP) elektronik ortamda aktarılan (hypermedia) bilgilerin dağıtılmış, iş birliğine uygun ulaştırılabilmesi için uygulama seviyesinde bir protokoldür. Genel, durumsuz, nesne-yönelimli bir protokoldür. Birçok görev için kullanılabilir, örneğin isim sunucuları (name server) ve dağıtılmış nesne yönetim sistemleri onun istekte bulunma yöntemleriyle (request) birbirine eklenebilir. HTTP nin bir özelliği verinin yazılması ve görüntülenmesinde, sistemlerin yapısından bağımsız olarak birbirine veri aktarabilmesidir. HTTP 1990 yılından bu yana İnternet kullanıcıları tarafından kullanılmaktadır. Bu belirtim "HTTP/1.1" standardını açıklamaktadır.

Wikipedi --> https://tr.wikisource.org/wiki/RFC_2068_-_Http_protokolü 

RFC 2068'in bütün dokümanına şu linkten ulaşabilirsiniz. --> https://datatracker.ietf.org/doc/html/rfc2068