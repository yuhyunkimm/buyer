package shop.mtcoding.byer.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/*
 * 회원가입 / 로그인 / 회원탈퇴 / 회원수정 
 */
// 만약 프로젝트 시 어떤 기능이 있을지 모를때 = CRUD
@Mapper
public interface UserRepository { // CRUD
    public int insert(@Param("name") String username, @Param("password") String password, @Param("email") String email);

    public List<User> findAll();

    public User findById(int id);

    public int updateById(@Param("id") int id, @Param("password") String password);

    public int deleteById(int id);

    public User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

}
