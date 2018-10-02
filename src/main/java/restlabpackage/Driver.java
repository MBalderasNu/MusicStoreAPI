package restlabpackage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import restlabpackage.repos.PictureMongoRepository;


@Configuration
@EnableAutoConfiguration
@ComponentScan
@EntityScan(basePackages="restlabpackage")
@EnableJpaRepositories(basePackages="restlabpackage.repos")
@EnableMongoRepositories(basePackageClasses=PictureMongoRepository.class)
public class Driver extends SpringBootServletInitializer {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SpringApplication.run(Driver.class,args);
		
		
	}

}
