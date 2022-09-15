package com.mettl.cloudconfigclient;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

@SpringBootApplication
public class CloudConfigClientApplication {

	private static String overridePropertyLocation;
	static {
		overridePropertyLocation = System.getProperty("user.home") + "/mettlconfig/proctoring/mpaas-gateway-override.properties";
	}

	public static void main(String[] args) {
		SpringApplication.run(CloudConfigClientApplication.class, args);
	}


	@Bean
	public BeanFactoryPostProcessor mpaasGatewayPropertyPlaceHolderConfigurer() {
		PropertySourcesPlaceholderConfigurer bean = new PropertySourcesPlaceholderConfigurer();
		Resource resource = new FileSystemResource(overridePropertyLocation);
		bean.setLocation(resource);
		bean.setIgnoreResourceNotFound(false);
		bean.setPlaceholderPrefix("$mpaas-gateway.props{");
		bean.setOrder(0);
		return bean;
	}
}
