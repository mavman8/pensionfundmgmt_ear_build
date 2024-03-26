package com.pensionfundmgmt.main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages={
		"com.pensionfundmgmt"})
@EnableJpaRepositories("com.pensionfundmgmt")
@EntityScan("com.pensionfundmgmt")
public class PensionFundMgmtApplication extends SpringBootServletInitializer
{
@Override
protected SpringApplicationBuilder configure(SpringApplicationBuilder application) 
{
return application.sources(PensionFundMgmtApplication.class);
}
public static void main(String[] args) 
{
SpringApplication.run(PensionFundMgmtApplication.class, args);
}
}
