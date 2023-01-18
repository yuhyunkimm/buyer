package shop.mtcoding.buyer.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository { // CRUD
    public int insert(String username, String password, String email);

    public List<User> findAll();

    public User findById(int id);

    public int updateById(int id, String password);

    public int deleteById(int id);
}
