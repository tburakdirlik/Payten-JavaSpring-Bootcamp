# HOMEWORK 1

# 1. Pass by value, pass by reference kavramları nedir ? Java’ ile ilişkili olarak açıklayınız.

Pass by value metotlara değişken geçirme yöntemidir. Bu yöntemde; metotlara geçilen değişkenin kendisi değil kopyası gönderilir. Bütün işlem değişkenin kopyası üzerinden döner. Orijinal değişkenin adres alanındaki değerine dokunulmaz. Bu şekilde metot içindeki değişkenin değeri sadece metot içinde geçerlidir. Metot dışına çıkıldığı an değişkenin orijinal adresindeki değer geçerlidir. Java dilinde de pass by value yaklaşımı uygulanır. Java dili üzerinde örnek verelim.

```
public class Test {
    	protected static void changeValue(int n) {
        		n = n * 10;
        		System.out.println("addValue method    -->" + " number:" + n); 
    }

public static void main(String[] args) {

        	Test T = new Test();
        	int number = 10;
        	System.out.println("Before method call -->"+ " number:" + number);
        	changeValue(number);
        	System.out.println("After method call  --> " + "number:" + number);        
    }
} 
```

Output:
Before method call --> number:10

addvalue method    --> number:100

After method call  --> number:10

Örnekte de görüldüğü üzere number değişkenine ilk olarak 10 değeri atanmıştır. changeValue metodu ile değişkenin değeri 100 olacak şekilde bir işlem yapılmıştır. Metot içerisinde değişkenin değerini yazdırdığımızda 100 olarak görürüz. Değişkenin değerini metot dışında tekrardan yazdırmak istersek 10 değeri ile karşılaşırız. Çünkü metot içerisinde değişkenin orjjinal adres alanındaki değer üzerinde değil kopyası üzerinde değişiklik yapılmıştır. Bu pass by value yaklaşımıdır. Özet olarak metot içine geçirilen değişken metot içinde kalır. Dışarının haberi olmaz.

## Pass by reference
Türkçesi referans ile geçirmedir. Bu yaklaşımda metota değişkenin kopyası değil direk adres alanı geçirilir. Metot içinde, değişkenin adres alanındaki değer üzerinde değişiklik yapabildiğimiz için değişken üzerindeki herhangi bir değişiklik o değişkeni kullanan bütün metotları, yapıları etkiler.  Özetlersek metot içinde değişken üzerindeki değişiklik metot dışına da yansır. C, C++ dilleri pass by reference yaklaşımını uygular. 

# 2. Immutability nedir, neden önemlidir ? Bir Java sınıfı nasıl immutable yapılır ?

## Immutability nedir?
Immutability değişmezlik demektir. Java’da immutable sınıflar, nesneleri oluşturulduktan sonra üzerinde oynama yapılamayan, içeriği değiştirilemeyen sınıflardır. Nesneler oluşturulurken ilk değer atanır ve bir daha o değere dokunulmaz. Bunun tersi de mutable (değişebilir) sınıflardır. Burda nesneler immutable yapılmadığı sürece üzerlerinde istenilen değişiklikler yapılabilinir. Immutability bazı ihtiyaçlardan dolayı doğmuştur. Örnek vermek gerekirse çok iş parçacıklı ortamlarda (multithreaded) immutable şekilde oluşturulan nesnelerin değerleri ne kadar thread çalışırsa çalışsın değişmeyeceği için o nesneyi güvenilir yapar. Başka bir threadin nesneyi değiştiren bir iş parçacığının neden olduğu hataları önler. Immutability; çok iş parçacıklı ortamlarda, streamlerde nesneyi değişmez yapma, güvenilir yapma özelliğinden dolayı önemlidir ve tercih sebebidir. Immutable nesne veya sınıf kullanımın da bazı dezavantajları vardır. Eğer o nesneyi değiştirmek istersek kopyasını oluşturmalı ve onun üzerinden işlem yapmalıyız. Bu da bellek, zaman konusunda ek maliyetlere neden olur. Java’da immutable classlara örnek verecek olursak String ve tüm ilkel sarmalayıcı sınıflar (wrapper class) Byte, Short, Integer, Long, Float, Double, Char, Boolean, Byte, BigDecimal, BigInteger immutable sınıflardır.  

## Bir Java sınıfı nasıl immutable yapılır ?

•	Classın başına final anahtarı getirilir.Bu şekilde extend olayı önlenmiş olur.

•	Classın tüm değişkenleri private yapılır. Doğrudan erişime bu şekilde izin verilmez.

•	Tüm değiştirilebilir alanlara final anahtarı eklenir.

•	Final işaretlenen alanların ilk değerleri constructor ile atanır.

•	Değişkenlere setter metotlar oluşturulmaz, varsa kaldırılır. Tekrardan değer ataması önlenir

```
public final class ImmutableClassExample {
	private final int age;    
	private final String name;
    	private final String surname;
    public ImmutableClassExample (final int age, final String name, final String surname) {
        	this.age = age;
        	this.name = name;
        	this.surname = surname;        
    }
    public int getAge() {
        return age;
    }   
    public String getName() {
        return name;
    }
    Public String getSurname() {
        return surname;
	}
}
```

# 3. Framework ve library arasındaki fark nedir ?

Framework ve Library anlam olarak birbirine benzeyen teknik kavramlardır. Benzerliklerini ve amaçlarını da anlatırsak daha anlaşılır olacaktır. İkisi de başkaları tarafında oluşturulmuş daha basit ve daha az kod yazmamızı sağlayan hazır kod yapılarıdır. Aynı amaca hizmet eder. Daha basit ve daha az kod yazmak, sonuç olarak ikisi de işleri kolaylaştırır. Farklılıkları teknik kısımda ortaya çıkar. Library kullanırken, library bize bazı özellikleri verir ve o özellikleri kodda nerede ve ne şekilde kullanacağımıza karışmaz. Library’nin vermiş olduğu özellikleri kodun istediğimiz yerinde kullanabiliriz. Library kullanırken programcı kodu kontrol eder. Framework de ise durum tersidir. Framework kodu kontrol eder.
Framework, kodu nerede ve ne zaman yazacağımızı söyler. Genellikle kod yazarken frameworkün belirlediği kurallar dizinin dışına çıkamayız. Eğer frameworkün istemediği şekilde kod yazarsak bu sefer kod çalışmaz. İkinci fark ise şudur. Library görece daha basit ve bir konuya yönelik işleri gerçekleştirmek için kullanılır. Örnek vermek gerekirse sadece görüntü işleme için OpenCV, email işlemleri için JODD email gibi kütüphaneler oluşturulmuştur. Framework ise daha karmaşık işler için kullanılır. Mesela bir projede hem veri tabanı bağlantısı hem loglama gibi işler yapmak istiyorsak bunları içeren frameworkler kullanmamız gerekir. Frameworkleri kütüphaneler topluluğu olarak düşünebiliriz. Örnek; oyun için Unity, uygulama için Spring frameworkü geliştirilmiştir.

# 4. Java’da Garbage Collector’ un görevi nedir ?

Belleği otomatik olarak yönetmek için kurulmuş bir mekanizmadır. Garbage Collector bizim için memory allocation ve deallocation işlemlerini arka planda yapar. Gereksiz oluşturduğunuz nesneleri yok eder, böylece OutOfMemory, memory leak, gibi problemlerin önüne geçer.

# 5. Memory leak nedir ? Java’da memory leak oluşması mümkün müdür ?

Kullanılmayan nesnelerin erişilebilir nesneler tarafından bir şekilde başvurulduğu durumlarda, Garbage collection bu nesneleri yararlı nesne olarak işaretler, Bu nesneler bellekte kalmaya devam eder ve program işi bittikten sonra kullandığı hafıza bloğunu serbest bırakamaz. Memory leak budur. Memory leake sahip bir program zaman içinde giderek daha fazla hafıza kullanır. Bu da sistem kaynaklarının fazlaca tüketilmesine en son uygulamanın hata verip kapanmasına sebep olur. Java’da memory leak oluşabilir. Kaydı sonlandırılmamış dinleyiciler, kapatılmamış açık akışlar ve bağlantılar, anonim sınıflar, içi içe sınıf referansları Java’da memory leak oluşturabilir. 

# 6. Yeni Java sürümleri ne sıklıkla çıkmaktadır ?

Oracle; Long Term Support (LTS) yani uzun süre destekli Java sürümlerini her 3 yılda bir, onun dışında non-LTS yani kısa süre destekli sürümleri 6 ayda bir çıkaracağını duyurdu.
•	Java 7 --> 2011
•	Java 8 --> 2014
•	Java 9 --> 2017
•	Java 10 --> 2018

# 7. Stack ve Heap nedir ? Java’da hangi yapılar stack ile, hangi yapılar heap ile ilişkilidir ?

Stack ve heap ikisi de ramin mantıksal bölümleridir. Stack; LIFO (Last in first out) yani son gelen ilk çıkar mantığına göre çalışır. Stack; Heap’e göre daha hızlıdır ve veriler art arda sıralanmıştır. Stack’de veri hemen silinebilir. Java’da primitive type yani ilkel veri tipleri Stack’de tutulur. Bunlar int, short, byte, long, double, float vs.
Heap de verilerin tutulduğu bir alandır ve veriler karışık bir şekilde tutulur. Heap’de silme işlemi garbage collector yapısına bağlıdır. Java’da class interface, array  gibi referans veri tipleri heap kullanır.

# 8. OpenJDK ve OracleJDK arasındaki farklar nelerdir ?
 
•	OpenJDK ve OracleJDK arasında yayın takvimi açısından farklar vardır.
•	OracleJDK 3 yılda bir yeni sürüm çıkarırıken OpenJDK 6 ayda bir sürüm çıkarır. Bu  yüzden Oracle ‘ın sürümleri daha tutarlı ve problemsizdir.
•	OracleJDK uzun süreli destek sağlarken OpenJDK uzun süreli destek sağlamaz. 
•	Oracle aynı zamanda daha fazla Garbage Collector seçeneğine sahiptir ve performans açısından daha iyidir.

# 9. @FunctionalInterface anotasyonu nerelerde kullanılabilir, neleri sağlar ?

Functional interface; içinde sadece bir tane abstract method olan interfacelerdir. Functional interface’i belirtmek için @FunctionalInterface anotasyonu kullanılması zorunlu değildir bu sadece validasyon sağlar. Fuctional intefaceler lambda expressionların kullanılabilmesini sağlarlar. Böylece kod yazarken daha az kod yazarız.

```
@FunctionalInterface
public interface Runnable{
	public abstract void run();		        
	}}

//Lambda olmadan kullanımı
new Thred(new Runnable(){
@Override
public void run(){
	System.out.println(“Thread çalışıyor.”);
	}}.start();

//Lambda ile kullanımı
new Thread(() -> System.out.println(“Thread çalışıyor.”).start();
```

# 10. Java’da hangi functional interface’ler yer almaktadır ? Yaptığınız araştırmada en popüler/göze çarpanlar hangileridir ?

java.util.function paketindeki yer alan functional interfaceler.    				 
Consumer : Bir argüman alır ve geri bir şey döndürmez.  
Predicate : Bir argüman alır ve bir boolean değer döndürür.   
Function : Bir argüman alır ve geri bir değer döndürür. 
Supplier : Argüman almaz ve geri bir değer döndürür. 
BiConsumer : İki argüman alır ve geri bir şey döndürmez. 
BiPredicate : İki argüman alır ve geriye bir boolean değer döndürür. 
BiFunction : İki argüman alır ve tek bir değer döndürür. 
UnaryOperator : Argüman alır ve yine aynı argümanı geri döndürür. Function'dan türer. 
BinaryOperator : İki argüman alır ve yine aynı tipte bir argüman döner. BiFunction'dan türer.
                                                                             ***
java.util.function paketi altında 4 tane göze çarpan önemli functional interface vardır. Bunlar Predicate, Function, Consumer ve Supplier interfaceleridir.         

10. Soru Kaynak -->  https://www.fibiler.com/Functional-Interface_Kategori_1276

# HOMEWORK 2
## First Encounters
İlk olarak Unix de bash dilinde pipeline nasıl yapılır onlar gösterilmiş. Smalltalk, Ruby, Lisp, Clojure gibi fonksiyonel dillerde pipeline ile ilgili ufak örnekler gösterilmiş.
## Defining Collection Pipeline
Collection pipeline bir programlama modelidir. Collection pipeline koleksiyon sınıfını bir dizi işleme göre düzenler. Her işlem input olarak bir collection yapısı alır ve başka bir collection yapısına output olarak verir. Unix işletim sisteminde, nesne yönelimli ve fonksiyonel dillerde ayrı ayrı oluşturulma şekilleri vardır.
## Exploring more pipelines and operations
Pipeline ların birçok kullanım ve oluşturulma şekli gösterilmiş. Bunlara alternatif yöntemlerde gösterilmiş. Döngü ile nasıl yapıldığı açıklanmış.
## Nested Operator Expressions
Collectionları set işlemleriyle ve iç içe opratörlerle manipüle edebiliriz.
## Laziness
Tembellik fonksiyonel programlama dünyasından gelen bir özellik. Collection üzerinde tamamen dolaşmak yerine bize lazım olan verileri birkaç adımda elde etme yöntemi. Fakat bazı pipeline lar tembel çalışamaz. Sorting buna bir örnek.
## Parallelism
Birçok pipeline işlemi paralel çağrı ile iyi çalışır. Ancak paralelleştirme her zaman performansı artırmaz. Bazen paralel dağıtımı kurmak, paralellikten elde ettiğimiz zamandan daha fazlasını alır. Bu yüzden paralel sistemlerde performans testleri yapılmalı ve performans artışının olup olmadığı test edilmeli.
## Immutability
Collection pipeline immutable (değişmez) veri yapılarında kullanımı uygundur.
#Debugging 
Collection pipeline ları debug etmenin zor olduğundan bahsedilmiş. Uygun bir debugger ile collection pipeline ları debug etmek için, pipeline içinde kesme noktaları belirlemeli bu noktalardan sonra neler olduğuna bakılmalı denilmiş.
## When to use it
Bu modeli kullanabildiğimiz durumlar ve kullandığımız zaman sıkıntı yaratan durumlar vardır.
Temiz lambda ifadelerini kullanabilmek için iyi bir dil desteğinin olması gerekiyor. Yoksa sıkıntı yaratabilir. Bu ifadeleri Ruby ve Clojure dilleri çok iyi destekler. 


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

HOMEWORK 5 
# 1. Concurrent programlama ve Parallel Programlama nedir ? Aralarında çalışma şekli olarak nasıl bir fark bulunmaktadır ? 

### Concurrent programmimg 

Concurrent programming; (eş zamanlı programlama) aşina olduğumuz multithreaded programmingdir. Bize aynı aynı anda birden fazla processi işlemeyi sağlar. 
Concurrent programmingde, tek bir işlem ünitesinde birden çok işlemi yapmaya yöneliriz. 

### Parallel Programming
Parallel programlama; gelen taskların birden fazla işlem ünitesi ile aynı anda çalıştırılmasıdır. Daha hızlı sonuç verebilir. Taskların birden fazla işlem ünitesinde çalıştırılması demek, taskların birden fazla cpu üzerinde çalışması demektir. Bu da daha fazla donanım kaynağının kullanılması anlamına gelir.

Concurrency ve parallelism arasındaki fark en sade şekliyle şudur; Concurrency bir çok taskı aynı anda yürütmek, parallelism aynı anda bir çok taskı yan yana yürütmektir.

<p align="center">
  <img src="https://miro.medium.com/max/1400/1*cFUbDHxooUtT9KiBy-0SXQ.jpeg" />
</p>

<p align="center">    Concurrency vs Parallelism   </p>

# 2. Mutex ve Semaphore kavramlarını açıklayınız. Hangi tür durumlarda bunlara başvurmamız gerekir ?
### Mutex
Açılımı mutual exclusion dur. Multitasking sistemlerde deadlock denilen durumu engellemek için kullanılan bir mekanizma. Mutex i anlamak için Deadlock kavramını da bilmek gerekir.

Deadlockda birçok thread birbirini bekliyor ve ilerleme gerçekleşmiyor.
Bir işlemi gerçekleştirmek için 2 tane anahtara ihtiyacımız var diyelim. 2 tane threadden biri bir locku diğeride diğer locku alınca her 2 thread de 2 lock a aynı anda sahip olamıyor. Hiçkimse de bir lock u bırakıp diğerine vermediği için ilerleme gerçekleşmiyor ve deadlock oluşuyor. Deadlock adından anlaşılacağı üzere işlemlerin kilitlenmesidir. Threadler yürümez bu durumu engellemek için mutex denilen mekanizma geliştirilmiş.

Şöyle özetleyelim elimizde bir task var bunu en iyi maliyetle bitirmek için threadleri kullanıyoruz. Fakat 2 thread aynı anda bir dosya üzerinde çalışırsa dosyanın yapısı bozulur ve çalışamaz hale gelir. Bu yüzden threadler, dosya üzerinde sırayla çalışmalı, bir thread bir dosya üzerinde çalışırken başka bir thread çalışmamalıdır. Threadlerin sırayla çalışmasını sağlamak, aralarındaki senkronizasyon problemini halletmek için mutex denilen yapılar geliştirilmiştir. Mutex bir iş parçacığını alır ve kilitler. Ve o iş parçacığı işini halledene kadar başka thread tarafından kullanılamaz. Bir mutex'e ayni anda sadece bir thread sahip olabilir. Digerleri sahip olmak isterlerse beklemek zorundadır.

<p align="center">
  <img src="https://raw.githubusercontent.com/Payten-Java-Spring-Bootcamp/tunahan-burak-dirlik/main/5.%20Hafta/mutex%20ornegi.png" />
</p>
<p align="center">
  Daha önce Operating Systems dersi kapsamında yaptığım C dilinde  mutex örneği
</p>


### Semaphore
Semaphoreu anlatmak için otel örneği kullanılabilir.
Otelin resepsiyoncusu semaphore'u; odaları müşterilere vermek için kullanır. Aklında otel tamamen boşken otelde kaç odanın müsait olduğunu tutar, ki bu otelin oda sayısıdır. Müşteri geldikçe aklındaki bu oda sayısını düşürür, insanlar çıkış yaptığında bu sayıyı arttırır. Bu rakam sıfıra ulaştığında boşta odasının olmadığını ve isterlerse lobide beklemelerini söyler. Bu bekleyenler sırayla alınırlar.

Mutex'ler Critical Section yönetimi sağlamak üzere tasarlandığı için kendilerini bırakan Thread'in alan Thread olmasını gerekli tutmaktadır. 
Semaphore'da ise böyle bir kısıtlama yoktur hatta birçok durumda Semaphore'u bırakan Thread alan Thread'den farklıdır.Lock ve mutex'in aksine senkronize erişimi tamamen bekletmek için değil sınırlandırmak için kullanılabilir denilebilir. Sınırlı bir resource a sahipsiniz, aynı anda 3 thread'in bu kaynağa erişmesini istiyorsunuz daha fazlası sizin için bir sorun oluşturuyor.Kodun o kısmını bütün thread'lerin kullanımına açmıyorsunuz, orada sayaca sahip bir lock kullanıyorsunuz. İşte semaphore bu. Semaforların çalışması sırasında bölünmezlik (atomicity) ön plandadır. Yani bir semafor’un içerisinde yapılan birden fazla iş, program tarafından sanki tek bir iş gibi algılanmalı ve araya başka işin girmesine izin verilmemelidir. Semaphore, belirli bir kaynak için tüketici sayısını sınırlamanın bir yoludur.

<p align="center">
  <img src="https://raw.githubusercontent.com/Payten-Java-Spring-Bootcamp/tunahan-burak-dirlik/main/5.%20Hafta/semaphore%20ornegi.png" />
</p>

<p align="center">
  C dilinde Semaphore örneği
  </p>

# 3. Java’da Error ve Exception arasındaki fark nedir ? Throwable ile ilişkileri nasıldır ? Hangi tür durumlarda Error hangi tür durumlarda Exception meydana gelebilir ? Örneklerler açıklayınız. 

### Error
Error handle edilemeyen hatalardır. Program akışının durmasına sebep olur. Uygulamanın yakalamaya çalışmaması gereken ciddi sorunları gösteren Throwable dan türeyen bir alt sınıftır.
### Exception
Exceptio -ı ise try catch bloklarıyla yakalayabiliriz. Program akışı; exception eğer yakalandıysa devam eder. Exception yaşandığında; bunun program için arasıra yaşansa da sorun olmayacağı uygulamanın devam edebileceği anlaşılır. Exception ve Error; ikisi de Throwable sınıfından türer. Aşağıdaki görsel ile aralarındaki ilişkiyi daha net görebiliriz.

<p align="center">    <img src="https://www.fatalerrors.org/images/blog/7bba3f7352c8c8b15be1f90568857dce.jpg" /> </p>
<p align="center">    <img src="https://i.stack.imgur.com/v2NAj.png" /> </p>
Exception programın kodlanmasında yapılan hataların sonucudur, Error sistemin yanlış çalışmasının sonucudur.

# 4. Spring’te yer alan @Scheduled anotasyonunun kullanım amaçlarını ve kullanım şeklini açıklayınız.

Periyodik olarak yapmak istediğimiz metodun başına @Scheduled anotasyonunu ekleriz. Uygulamamıza @EnableScheduling anotasyonunu @Scheduled ı kullanabilmek için eklemek gerek. Zamanlamak istediğimiz metoda da @Scheduled anotasyonunu ekleriz. Belli bi sürede veya aralıkta çalışması gereken metotlarda kullanılır.

```java
@EnableScheduling
public class ScheduledTasks {
@Scheduled(fixedRate = 5000)
public void task1() {
System.out.println(Thread.currentThread().getName()+" Task 1 executed at "+ new Date());
    }
@Scheduled(fixedRate = 1000)
public void task2() {
System.out.println(Thread.currentThread().getName()+" Task 2 executed at "+ new Date());
    }
}
```

# 5. Spring’te yer alan @Async anotasyonunun kullanım amaçlarını ve kullanım şeklini açıklayınız.
Bir bean’in methoduna @Async annotationu eklemek onun main thread’den farklı olarak ayrı bir threadde çalıştırılmasını sağlar. Yani call edilen methodun tamamlanmasını
call eden kısım beklemez. Kod böylece async olarak çalışmış olur.

Kullanımı 
```java
//Main class
@SpringBootApplication
@EnableAsync
public class SpringAsyncApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAsyncApplication.class, args);
    }
}
```

```java

@Async // add to method
public void asyncMethod() {
    System.out.println("Async Method");
}
//bu metot public olmalı
```


# 6. High Availability (HA) kavramını kısa açıklayınız. 
Yüksek erişilebilirlik, 7×24 çalışan sistemlerin gerek otomatik gerekse manual sebeplerden dolayı yazılım veya donanımdan kaynaklanacak kesintilere uğramaksızın hizmet vermesidir. 
Internet gibi dağıtık ortamlarda hizmet veren sistemlerin kısa da sürse kesintiye uğraması önemsenecek maddi kayıplara neden olabilir. 
Büyük yazılım firmaları sistemlerin 7×24×365 hizmet vermesini garanti etmek için yani high availability sağlamak için çeşitli teknikler kullanırlar. Bazıları ; 
-	Failover Clustering (Yedekli Kümeleme )
-	Log Shipping (Günlük Gönderme)
-	Data Replication (Veri Yineleme)
-	Database Mirroring (Veritabanı Aynalama)

Herhangi bir sistemin yüksek düzeyde erişilebilirlik sunması için, sistemin parçalarının kullanılmadan önce iyi tasarlanmış ve kapsamlı bir şekilde test edilmiş olması gerekir. 

# 7. Entity ve Value Object kavramlarını Domain Driven Design (DDD) kapsamında açıklayınız. 
DDD, karmaşık yazılım projelerine belli başlı çözümler getiren bir yaklaşımdır. Var olan ve yaşanan problemlerin Domain esas alınarak analiz edilmesi ve çözülmesi gerektiğini 
savunan ve bunun için Domain’in net bir şekilde anlaşılmasının gerekli olduğunu söyleyen bir programlama yaklaşımıdır.
### Entity & Value Object
Unique(Benzersiz) bir kimliği olan nesneler entity olarak adlandırılır. Entity herhangi bir şey için modellenmiş nesnelere karşılık gelmektedir. 
Bahsedilen kimlik ise bu nesnelerin her biri için yaratıldığı süreçten itibaren diğerlerinden ayırmamızı sağlayan ve değişmeden taşınan Id değeridir.
Kendine ait bir kimliği olmayanlar ise value object olarak adlandırılır.
Value object, herhangi bir kimlik(Id) değeri olmayan ve böylece aynı değerlere sahip iki value object nesnesinin değersel açıdan aynı olarak kabul edilebilir olmasını sağlayan 
ve dolayısıyla birbirlerinin yerine geçebilecekleri anlamına gelen bir nesnedir. İşte bu nedenle value object’ler her daim değişmez(immutable)dirler

# 8. Ubiquitous Language kavramını DDD kapsamında açıklayınız. Sizce neden önemli olabileceğini belirtiniz.
Ubiquitous Language; domain expert ile developer arasındaki ortak dildir. Domain expert; hangi alanda yazılım yapılacaksa o alan ile ilgili bilgiye tecrübeye sahip kişidir. 
Bir araziyi sulamak için bir makinaya yazılım yapalım diyelim. O araziye ne aralıkta ne kadar süre ile su verileceğinin bilen kişi çiftçidir. 
Çiftçi domain expert oluyor. Bu bilgileri yazılımcıya ortak anlaşabilecekleri bir dil ile developera aktarır. 
Ve developer bu bilgileri kullanarak yazılımı geliştirir. Kısaca müşterinin yazılımcıya işi nasıl yapacağını anlatması Ubiquitous Language dir. 
İşin yazılımcıya nasıl yapılacağının Ubiquitous Language diye şaşalı bi şekilde isimlendirilmesinin gereği varmıydı, bence yoktu. 
Fakat bu kavram önemli midir, tabiki de önemlidir. Yazılımın nasıl yapılacağını domain expert güzel bir şekilde şekil falan çizerek anlatacak ki developer konuyu anlayabilsin ve 
yazılımı yapabilsin.
# 9. Core Domain, Supporting Domain, Generic Domain kavramlarını DDD kapsamında açıklayınız. 

Core domain - iş için gerekli olan en önemli alt alan. Onsuz, iş başarısız olur.

Supporting domain - iş için core domain etki alanından daha az değerli olan alt domain. Onsuz iş, bir süre hayatta kalabilir . Ancak yine de oldukça önemlidir (core domaini destekler), ayrıca alana özeldir ve geliştirilmesi gerekir. 

Generic Domain - ?
# 10. Anemic Domain Model ve Rich Domain Model kavramlarını kıyaslayarak açıklayınız. 
Anemic Domain Model : DDD kullanmıyorsak ya da DDD’yi ilk implemente edişimiz ise sık karşılaşabileceğimiz bir durum. Martin Fowler'in bir anti-pattern olarak bahsettiği, domain logic icermeyen domain modellere verdigi isim. Anemic model pseucode gibi aslında.

Wiki den basit örnek:

Anemic
```java
class Box
{
    public int Height { get; set; }
    public int Width { get; set; }
}
```

Rich Domain Model ise anladığım kadarıyla anemic domain modelin tam tersi.
OOP paradigmalarını domain logicleri  içeren model. 

# References
- https://www.gencayyildiz.com/blog/domain-driven-design-stratejik-ve-taktiksel-olarak-derinlemesine-inceleme/
- https://www.ahmetkaymaz.com/2008/01/02/sql-server-yuksek-erisilebilirlik-high-availability/
- https://tugrulbayrak.medium.com/spring-scheduled-task-bc14d5695dc9
- https://medium.com/@eomercelik/async-in-spring-e86173f61b56#:~:text=Basitçe%20söylemek%20gerekirse%2C%20bir%20bean,böylece%20async%20olarak%20çalışmış%20olur.
- mutex - semaphore -- > https://eksisozluk.com
- https://stackoverflow.com/questions/25274226/ddd-identifying-the-core-domain

# HOMEWORK 6
## 1. Conway’in Kanunu’ nu (Conway’s Law) açıklayınız.
“Sistemleri tasarlayan organizasyonlar kendi iletişim yapılarının birer kopyasını üretmekle sınırlıdır” 

Melvin Conway

Conway abimiz burda diyor ki developerların kendi aralarında kurduğu iç ileitişim direkt ürüne yansıyor. Diğer bir deyişle ürün bu iletişimin şekillendirdiği bir süreçte tasarlanıyor ve ortaya çıkıyor.

## 2. Software as a Service (SaaS), Platform as a Service (PaaS), Infrastructure as a Service (IaaS), On-Premises kavramlarını örneklerle açıklayınız.

### SaaS (Software as a Service)

SaaS kısaca müşterilere bulut tabanlı yazılım sağlama servisidir. Bu yazılımın "ürünün" sunucu ve veritabanı gibi sistemleri yazılım sağlayıcısı tarafından sağlanır.
Şöyle özetleyebiliriz. Bir yazılım satın aldık, bu yazılımın verdiği hizmeti tek seferde ödeyerek veya dönemsel olarak abone olarak kullanıyoruz. Bu yazılımın verdiği hizmetin veritabanı sunucu gibi sistemleri de tamamen yazılımın üreticisi tarafından karşılanıyor.
Google GSuite (Apps), Dropbox, Slack, Canva ...

### Platform as a Service (PaaS)

Developeralara donanım ve yazılım katmanları sağlayarak onların proje geliştirmesini sağlayan servis şeklidir.
Bu servisin, geliştirme ortamı, işletim sistemi, veritabanı gibi platformları servis sağlayıcı tarafından sağlanır. Müşteri sadece uygulamayı kullanır, kendi verilerini falan bu platformlar üzerinden yönetir.
Windows Azure, Heroku, Google App Engine ...


### Infrastructure as a Service (IaaS)
IaaS, bilgisayarlara, ağlara, depolama alanlarına ve diğer servislere erişmek ve bunları izlemek için tamamen self servistir. IaaS işletmelerin donanım satın almak yerine talep üzerine ve ihtiyaç duydukları kaynakları satın almalarını sağlar.
Microsoft Azure, Amazon Web Service, Google Cloud, IBM Cloud ...
<p align="center">
  <img src="https://i1.wp.com/ipwithease.com/wp-content/uploads/2016/09/saas-vs-paas-vs-iaas.jpg?w=800&ssl=1" />
</p>

## 3. Continuous Integration, Continuous Delivery ve Continuous Deployment kavramlarını açıklayınız.

### Continuous Integration
Yaptığımız geliştirmelerin, refactorlerin, yazdığımız kodların, kontrollerden geçtiği sürece denir.
Bu süreçte yapılan geliştirmelerin sorunlara yol açıp açmadığı kontrol edilir, sistemin çalışırlığı test edilir.
bu geliştirmeler belli testlere tabi tutulur, kontrol edilir, sistemde bi yerleri kırarsa veya hataya zorlarsa, ilgili developerlara
bu bilgilendirmeler yapılarak, sorunun bir an önce giderilmesi sağlanır, bu şekilde her zaman çalışabilen bir sürüm sağlanmış olur.

### Continuous Delivery 
Yapılan geliştirmelerin CI sürecinden (bir önceki süreç) geçtikten sonra build alınıp deploya hazır hale gelmesinin sağlandığı aşamadır.
### Continuous Deployment
Burda da paketler ürünler sunucuya kurulur, canlıya alınır.

### Yaygın kullanılan CI/CD araçları 

- Jenkins
- Travis CI
- CircleCI
- Jetbrains TeamCity
- Atlassian Bamboo
- GitLab
- Codeship
- Buddy
- Semaphore

<p align="center">
<img src="https://academy.hsoub.com/uploads/monthly_2020_09/CI-CD-graphic.png.1ab84d2956eedf36cd527f2eada53654.png"/>
</p>

## 4. API Gateway pattern’ı açıklayınız.

Clientlerin servislerimize elini kolunu sallayarak direk girmesini istemiyorsak, yani burda bir yönlendirme söz konusu, öncesinde burda bir entry point tasarlanır. Bu Api gateway dir.
Gelen request bu api gateway üzerinden güvenlik ve yetkilendirme kontrollerinden geçerek uygun servislere yönlendirilir. Bar kapısındaki bodyguard olarak düşünebilir. 
Api gateway ile güvenlik ile ilgili riskler azaltılır.

<p align="center">
<img src="https://www.gencayyildiz.com/blog/wp-content/uploads/2020/06/Microservice-Mimarisinde-API-Gateway-Nedir.png"/>
</p>


<p align="center">
<img src="http://cagataykiziltan.net/wp-content/uploads/2019/09/1_7CTHAQGtEQDU8TpMtdiEDg-768x601.png"/>
</p>


## 5. Backend for frontend (BFF) pattern’ ı açıklayınız.

ilgili frontende özgü ihtiyaçlar doğrultusunda geliştirilmiş backend diyebiliriz. 
Yani farklı farklı frontendler için geliştirilmiş, o frontende özgü olarak, onun ihtiyaçlarını göz önüne alarak geliştirilmiş sunucu uygulamaları.

Tek bir API varsa genel amaçlı API (general purpose API Gateway) oluyor, istemcilere göre veya fonksiyonlara göre özelleştirince, istemciye veya fonksiyonlara göre özelleştirilmiş API’ler (client-specific APIs veya BFFs) oluyor. Ben microservice in de microsu olarak tanımladım.

Burdan alıntıdır > [-->]https://medium.com/bilişim-hareketi/backend-for-what-backend-for-frontend-bff-102737928c6b 
> Kavram SoundCloud tarafından ortaya atılmış. Yeni bir yaklaşım/mimari kalıp olmaktan çok yeni bir isimlendirme. Hikayesi şöyle. SoundCloud’un Ruby on Rails ile yazılmış monolitik bir uygulaması varmış. Bu uygulama içine gömülü bir katman olarak dışa açık bir API bulunuyormuş. Hem SoundCloud’un kendi geliştirdiği mobil/web uygulamalar, hem web uygulamalarında gömülü olarak çalışan küçük uygulamacıklar (web widgets), hem de 3. partiler aynı API’yi kullanıyormuş. Ön tarafta çalışan tüm uygulamaların ortak kullandığı genel amaçlı bir API. Burada karşılaşılan iki ana problem şöyle:
İlk olarak mobil uygulamalar (front-end) bir değişik fonksiyonanlara ihtiyaç duyduğunda ortak API’de bu değişikliği yapmak zaman alıyormuş. Çünkü büyük bir uygulama, bir değişiklik herkes tarafından görülecek ve herkesi etkileyecek, ayrıca API’yi geliştiren ekip ile mobil ekip ayrı dolayısıyla bir iletişim yükünü taşımak zorunda kalıp, yavaş hareket etmek zorunda kalıyorlarmış. API ekibine istek iletilecek, planlama yapılacak, farklı ekiplerden gelen istekler arasında önceliklendirilecek, geliştirilecek, devreye alınacak. Hızlı hareket etmenin, denemeler yapmanın önünde bir engel, yeni özellik eklemek çok kolay değil, süreç uzun ve iletişim sürtünme katsayısı yüksek.
Diğer bir sebep ise genel amaçlı API’nin ön uçta çalışan farklı tipteki uygulamaların ihtiyaçlarına karşılamakta yetersiz kalması. Mesela mobil uygulamalar daha az veri istiyor çünkü ekranlar web uygulamalarına göre küçük, ayrıca iletişim hızı daha yavaş olabiliyor, bant genişliği hassasiyeti var, istek frekansları farklı olabiliyor, ayrıca fonksiyonlar da farklı olabiliyor. Mesela webde ürünler listelenip ardından sipariş akışına girilirken, mobil tarafta önce barkod okutup ardından bu barkoda ait ürünün bulunup sipariş akışına girilmesi gibi bir fonksiyonel farklılık olabiliyor.
Dolayısıyla SoundCloud bir taraftan yeni özellikler için veya bazı ana uygulamadaki bazı özellikleri aktarmak mikroservisler geliştirip modern mimariyi deneyimlerken bir yandan da bu problemlere çözüm bulmaya çalışmışlar. Hem fonksiyon hem de platform farklılığı temelinde özelleşmiş API’ler yazmışlar.

>SoundCloud’ı alacak olursak en başta tek bir monolitik uygulamaları varmış. Ardından 2013'te 20 civarında mikroservisleri olmuş. Sonra yavaş yavaş artmış ve şimdi 120 civarında mikroservisten bahsediyorlar.



## 6. Circuit-breaker pattern’ ı açıklayınız.

Circuit breaker, hizmet alınan serviste, o servise gelen istekleri, sayısını kontrol eden, hataları algılayan, sistemin kötü durumlara karşı çalışabilirliğini sağlamaya çalışan pattern çeşididir. Sistemin sağlıklı işleyişi için gereklidir.
Başarısız isteklerde bu istekleri alternatif api lere yönlendirebilir. Elektirik devresindeki sigortalar da bir circuit breakerdır. Bu kavram aslında ordan gelmiş, aynı mantık burda da geçerli, 

## 7. Microservice chassis pattern’ ı kısaca açıklayınız.
Cross cutting concern leri servislerimizden ayırarak ayrı servise yazarız böylelikle koda reusebality sağlar, kod tekrarının önüne geçmiş oluruz, böyle bir pattern. 

### KAYNAKÇA
- https://caylakyazilimci.com/post/ci-cd-nedir
- https://ipwithease.com/saas-vs-paas-vs-iaas/
- https://www.argenova.com.tr/saas-software-as-a-service-nedir
- https://medium.com/peoplebox-ats/saas-nedir-faydaları-nelerdir-2a866b13315d
- https://medium.com/bilişim-hareketi/backend-for-what-backend-for-frontend-bff-102737928c6b

