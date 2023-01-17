package shop.mtcoding.byer.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/*
 * 회원가입 / 로그인 / 회원탈퇴 / 회원수정 
 */
// 만약 프로젝트 시 어떤 기능이 있을지 모를때 = CRUD
@Mapper
public interface UserRepository { // CRUD
    public User login(String username, String password);

    public List<User> findAll();

    public User findById(int id);

    public int updateById(int id, String password);

    public int deleteById(int id);

    // // 회원가입
    // public User login(String username, String password, String email);

    // // 로그인
    // public User login(String username, String password);

    // // 회원탈퇴
    // public int delete(int id);

    // // 회원수정
    // public int updatePassword(int id, String Password);
}
