package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import repositories.ProductRepository;

@Service
public class ProductService {
	
	private final ProductRepository productRepository;
	
	@Autowired
	public ProductService(ProductRepository productRepo) 
	{
		this.productRepository=productRepo;		//ctor injection.
	}
	
	
	//@Transactional(rollbackFor = Exception.class)		//default olarak Exception.class rollback yapamaz biz override ederek rollback yapma özelliği veriyoruz.
		@Transactional	//default runtimeexception can rollback, other exc. cant.
		//@Transactional(noRollbackFor = RuntimeException.class)	//default olarak RuntimeException rollback yapabilir override ederek bu özelliği devre dışı bırakabiliriz.
		//does rollback runtime exception but does not roll back checked exceptions
		public void addProduct(String name) 
		{
			productRepository.addProduct(name);
			throw new RuntimeException("hooop nereye kardeim");		//dbde bir kayıt oluşturuldu fakat hata olduğu için rollback işlemi gerçekleşti. id +1 artsa da dbde hatadan dolayı yazılmayacaktır.
		}
	
	
//	@Transactional		//try catch icinde exception olsa da rollback islemi olmaz. fakat her durumda değil. Aop tabanlı olduğu için belli başlı modifikasyonlar olmalıdır.
//	public void addProduct(String name) 
//	{
//		try {
//		productRepository.addProduct(name);
//		throw new RuntimeException("hooop nereye kardeim");		//dbde bir kayıt oluşturuldu fakat hata olduğu için rollback işlemi gerçekleşti. id +1 artsa da dbde hatadan dolayı yazılmayacaktır.
//		}
//		catch(RuntimeException ex) {
//			ex.printStackTrace();
//		}
//	}
	
	
	
	public int deleteProductById(int id) {
		int row=productRepository.deleteProductById(id);
		if(row != 0 )
			return 1;
		else
			throw new RuntimeException("There is no specific product have an id:"+ id);
	}
}
