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
