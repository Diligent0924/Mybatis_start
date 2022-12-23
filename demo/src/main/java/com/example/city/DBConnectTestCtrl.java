package com.example.city;
import com.example.city.DAO.TestDAO;
import com.example.city.DTO.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DBConnectTestCtrl {

    @Autowired
    private TestDAO testDAO;

    @GetMapping("/hello")
    public List<city> HelloWorld() {
        return testDAO.getTestData();
    }
}
