package com.example.demo;

import javax.servlet.MultipartConfigElement;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.AbstractHttp11Protocol;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.demo.common.update.SFTPClientUtils;
import com.example.demo.common.update.SFTPConnectionFactory;

@Configuration//  上传大小限制
@EnableTransactionManagement // 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
@SpringBootApplication
@MapperScan("com.example.demo.dao") // mybatis 的  java dao  注入
public class DemoApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	
    
	/**
     * 文件上传配置
     * @return
     */
	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		//文件最大
		factory.setMaxFileSize("30240KB"); //KB,MB  经过实际测试 只有KB 起作用
		/// 设置总上传数据总大小
		factory.setMaxRequestSize("902400KB");
		return factory.createMultipartConfig();
	}
    
    
    
    
    
    
    //获取文件内容
    /* @Value("${http.port}")
    Integer httpPort;
 
	//正常启用的https端口 如443
	@Value("${server.port}")
	Integer httpsPort;*/
	 /*@Bean
	    public TomcatServletWebServerFactory servletContainer() {
	        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
	            @Override
	            protected void postProcessContext(Context context) {
	                SecurityConstraint constraint = new SecurityConstraint();
	                constraint.setUserConstraint("CONFIDENTIAL");
	                SecurityCollection collection = new SecurityCollection();
	                collection.addPattern("/*");
	                constraint.addCollection(collection);
	                context.addConstraint(constraint);
	            }
	        };
	        tomcat.addAdditionalTomcatConnectors(httpConnector());
	        return tomcat;
	    }*/
	/* @Bean
	    public Connector httpConnector() {
	        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
	        connector.setScheme("http");
	        //Connector监听的http的端口号
	        connector.setPort(httpPort);
	        connector.setSecure(false);
	        //监听到http的端口号后转向到的https的端口号
	       // connector.setRedirectPort(httpsPort);
	        return connector;
	 }*/

	
}
