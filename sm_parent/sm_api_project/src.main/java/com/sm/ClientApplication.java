package com.sm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ImportResource;

// Spring Boot 应用的标识
@SpringBootApplication
// 加载过滤器
@ServletComponentScan
// 引入配置文件
@ImportResource("classpath:dubbo/consumer.xml")
public class ClientApplication {

	public static void main(String[] args) {
        // 程序启动入口
        // 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
        SpringApplication.run(ClientApplication.class,args);
    }
}
