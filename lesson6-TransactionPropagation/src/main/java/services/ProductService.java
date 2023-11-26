package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import repositories.ProductRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepo;


    /*
    Propagations =>yayılma
       *REQUIRED (default)  ->required=gerekli ( iç içe işlemlerden herhangi biri başarısız olursa, tüm işlem geri alınır.)
       * REQUIRES_NEW
       * MANDATORY  mandatory = zorunlu
       * NEVER
       * SUPPORTS    support=destek
       * NOT_SUPPORTED
       * NESTED
       *
       *
     */
    public void addProduct(String name)
    {
        productRepo.addProduct(name);
    }

        @Transactional(propagation = Propagation.REQUIRED)
    public void addTenProduct(){    //created
        for (int i = 1; i <=10 ; i++) {
            productRepo.addProduct("Product"+i);
            if(i == 5) throw new RuntimeException("i is 5");
        }
    } //commits
}

/*
Spring Framework içindeki `@Transactional` annotasyonu, işlemlerin veritabanı üzerinde nasıl yönetileceğini belirlemek için kullanılır. Bu annotasyonun `propagation` özelliği, bir işlemin mevcut bir işlem içinde veya bağımsız bir işlem olarak nasıl çalıştırılacağını belirler. `propagation` özelliği, işlem sırasında meydana gelen hatalara ve işlemin sonucuna nasıl tepki verileceğini de belirleyebilir.

Spring'de `propagation` için kullanılabilecek bazı seçenekler şunlardır:

1. `REQUIRED` (Varsayılan): Eğer mevcut bir işlem (transaction) varsa, mevcut işlem içinde çalışır. Eğer bir işlem başlatılmamışsa yeni bir işlem başlatır. Bu seçenek, işlemlerin iç içe çalışmasına izin verir ve işlemler mevcut işlem içinde başladıkları gibi bitirilir. Ancak, iç içe işlemlerden herhangi biri başarısız olursa, tüm işlem geri alınır.

2. `SUPPORTS`: Eğer mevcut bir işlem (transaction) varsa, mevcut işlem içinde çalışır. Ancak, yeni bir işlem başlatmaz. Eğer bir işlem başlatılmamışsa işlem kullanılmaz.

3. `MANDATORY`: Eğer mevcut bir işlem (transaction) varsa, mevcut işlem içinde çalışır. Eğer bir işlem başlatılmamışsa bir istisna fırlatılır.

4. `REQUIRES_NEW`: Her zaman yeni bir işlem başlatır. Eğer mevcut bir işlem varsa, mevcut işlem askıya alınır ve yeni işlem başlatılır. Eğer yeni işlem başarısız olursa, mevcut işlem devam eder.

5. `NOT_SUPPORTED`: İşlem kullanılmaz. Eğer mevcut bir işlem varsa, işlem askıya alınır ve işlem dışında çalışır. Eğer işlem dışında bir hata oluşursa, işlem başlatılmadan önceki duruma geri dönülmez.

6. `NEVER`: İşlem kullanılmaz. Eğer mevcut bir işlem varsa, bir istisna fırlatılır.

7. `NESTED`: İç içe işlemleri destekler, ancak bunlar ayrı bağımsız işlemler gibi yönetilirler. İç içe işlem başarısız olursa, sadece iç içe işlem geri alınır ve dış işlem devam eder.

`propagation` özelliği, işlemlerin nasıl yönetileceği konusunda büyük bir esneklik sağlar ve uygulamanın ihtiyacına göre uygun seçeneği seçmek önemlidir. Her seçenek farklı kullanım senaryolarına uygun olabilir. Örneğin, veri bütünlüğünün korunması gereken bir işlem için `REQUIRED` kullanılabilirken, bir işlem sırasında mevcut işlemi askıya almak istenirse `REQUIRES_NEW` kullanılabilir. İşlem propagasyonunun yanı sıra `isolation`, `timeout`, ve `readOnly` gibi diğer özellikler de `@Transactional` annotasyonu ile yapılandırılabilir.
 */
