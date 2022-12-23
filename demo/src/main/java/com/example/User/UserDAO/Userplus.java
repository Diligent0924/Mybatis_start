package com.example.User.UserDAO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.example.User.DTO.User;

public interface Userplus {
	void PlusUserData(User user);
//	public void PlusUserData(@Param("username") String username, @Param("password") String password);
}
