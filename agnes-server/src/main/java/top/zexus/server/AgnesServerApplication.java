package top.zexus.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
//@EnableEurekaServer启动服务注册中心
@EnableEurekaServer
@SpringBootApplication
public class AgnesServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AgnesServerApplication.class, args);
    }
}
