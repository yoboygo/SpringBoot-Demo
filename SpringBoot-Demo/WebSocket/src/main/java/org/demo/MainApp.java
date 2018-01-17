package org.demo;

import org.demo.data.dao.psecs.CustomRepositoryFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryFactoryBeanClass = CustomRepositoryFactoryBean.class)
public class MainApp {

	public static void main(String[] args) {
		SpringApplication.run(MainApp.class,args);
	}

}
