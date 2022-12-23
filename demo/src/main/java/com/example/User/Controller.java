package com.example.User;

import com.example.User.DTO.User;
import com.example.User.UserDAO.DAO;
import com.example.User.UserDAO.Userplus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired // bean에서 사용할 때 변수 형태로 사용하게 하는 어노테이션
    private DAO dao;
    
    @Autowired // Autowired는 하나씩마다 해줘야 한다. (Django처럼 하나의 어노테이션에 여러번 쓰면 안된다.)
    private Userplus userplus;

    @GetMapping("/User")
    public List<User> UserList() {
        return dao.UserData();
    }
    
    @PostMapping("/Userplus") // 어차피 mappers가 따로 분리될 수밖에 없으므로 그냥 라우팅 하나 추가해서 쓴다.
    public void PlusUser(HttpServletRequest request) {
    	try {
	    	User user = new User(); // 객체 생성
	    	user.username = request.getParameter("username"); // getParameter로 Json Key값을 받는다.
	    	user.password = request.getParameter("password");
	    	userplus.PlusUserData(user); // 객체 형태의 데이터를 옮겨준다.
    	}catch(Exception e){
    		e.printStackTrace();
    		throw e;
    	}
    }
}
