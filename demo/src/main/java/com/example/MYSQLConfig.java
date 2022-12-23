package com.example;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.*;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
@MapperScan("com.example") // 혹시 Bean Error가 난다면 MapperScan을 먼저 확인하자. => 엄청 고생했다.. (MapperScan을 다중으로 할 필요없이 그냥 아예 전체를 하는게 나을듯 싶다.)
public class MYSQLConfig{
	
    @Bean // Bean의 경우에는 Public을 앞으로 안써도 상관 없게 변경됨. Bean의 개념에 대한 이해 필요.
    SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        
        // classpath : src/main/resources 의미, mappers라는 파일에서 SQL을 들고 오겠다는 것을 의미함.
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sessionFactory.setMapperLocations(resolver.getResources("classpath:mappers/*.xml"));
        
        // 내가 SQL문을 들고 올 때 어떤 방식으로 들고 올 것인가를 명시하는 방법(mybatis-config.xml에서 습관 정의)
        Resource myBatisConfig = new PathMatchingResourcePatternResolver().getResource("classpath:mybatis-config.xml");
        sessionFactory.setConfigLocation(myBatisConfig);

        return sessionFactory.getObject();
    }
}