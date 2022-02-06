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
