package repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int addProduct(String productName) {
		String sql = "INSERT INTO product values (Null,?)";
		int rowEffectedNum=jdbcTemplate.update(sql,productName);
		return rowEffectedNum;
	}
	
	public int deleteProductById(int productId) 
	{
		String sql = "Delete from  product where id = ?";
		return jdbcTemplate.update(sql, productId);
			}
}
