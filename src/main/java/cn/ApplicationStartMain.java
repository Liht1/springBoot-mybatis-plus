package cn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@MapperScan("cn.rails.rsems.mapper*")
@SpringBootApplication
@EnableScheduling
public class ApplicationStartMain {

	public static void main(String[] args) {

		SpringApplication.run(ApplicationStartMain.class, args);
	}


}
