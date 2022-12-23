package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.*;

// 만약 DB와 연결하더라도 DB와 연관되어있지 않으면 DB를 안읽은 것으로 처리하기 때문에 exclude가 반드시 필요.
@SpringBootApplication(scanBasePackages="com.example") // (exclude = DataSourceAutoConfiguration.class) exclude로 DB 연결할 때 Error 제거하기
@ComponentScan(basePackages="com.example")
@RestController
public class DemoApplication {
	public static void main(String[] args) {
		System.out.println("Server Start");
		SpringApplication.run(DemoApplication.class, args);
	}
	@GetMapping(value = "/") // Router Table을 만들어주는 것으로 보인다.
	String home() {
		return "SSAFYYYYYY!!!!!!! goood!!!!!!!! Change!! GOOD!! It's~~"; // return값이 데이터에 나온다.
	}
	
	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue="World") String name) {
		return String.format("Hello %s!", name);
	}
	
}
