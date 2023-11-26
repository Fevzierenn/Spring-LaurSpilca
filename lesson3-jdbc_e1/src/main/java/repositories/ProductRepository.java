package repositories;


import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {

    @Autowired          //ctor injection daha iyidir ama simdilik bu
    JdbcTemplate jdbcTemplate;

    public void addProduct(Product product)
    {
        String sql = "INSERT INTO product values (NULL,?,?)";
        jdbcTemplate.update(sql,product.getName(), product.getPrice());
    }

    public List<Product> getProducts(){
        String sql = "SELECT * FROM product";
        return jdbcTemplate.query(sql,(rs, rowNum) -> {
            Product tempProduct = new Product();
            tempProduct.setId(rs.getInt("id"));
            tempProduct.setName(rs.getString("name"));
            tempProduct.setPrice(rs.getDouble("price"));
            return  tempProduct;
        });
    }

    public int updateProductNameById(int id, String name){
        String sql = "UPDATE product set name = ? where id = ?";
        return jdbcTemplate.update(sql, name, id);              //basarili islemse 1, degilse 0 doner.
    }


//    public List<Product> getProducts(){
//        String sql = "SELECT * FROM product";
//        return jdbcTemplate.query(sql, new RowMapper<Product>() {
//            @Override
//            public Product mapRow(ResultSet resultSet, int rowNum) throws SQLException{
//                Product tempProduct = new Product(
//                        resultSet.getString("name"),
//                        resultSet.getDouble("price")
//                );
//                return tempProduct;
//            }
//        });
//    }
}
