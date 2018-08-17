package top.zexus.manager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableFeignClients(basePackages = {"top.zexus"})
@SpringBootApplication(scanBasePackages = {"top.zexus.manager","top.zexus.common"})
@MapperScan("top.zexus.common.mapper")
public class AgnesManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AgnesManagerApplication.class, args);
    }
}
