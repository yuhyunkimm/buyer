package shop.mtcoding.byer.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductRepository {
    public User login(String name, int price, int qty);

    public List<Product> findAll();

    public User findById(int id);

    public int updateById(int id, String name, int price, int qty);

    public int deleteById(int id);

}
