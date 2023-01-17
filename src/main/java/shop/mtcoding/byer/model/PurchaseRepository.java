package shop.mtcoding.byer.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PurchaseRepository {
    public User login(int userId, int productId);

    public List<Purchase> findAll();

    public Purchase findById(int id);

    public int updateById(int id, int userId, int productId);

    public int deleteById(int id);
}
