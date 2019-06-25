package net.zhanglin.feignhystrixdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ServiceHiApplication {
	private static Logger logger = LoggerFactory.getLogger(ServiceHiApplication.class);
	
    public static void main(String[] args) {
        SpringApplication.run( ServiceHiApplication.class, args );
    }

    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    public String home(@RequestParam(value = "name", defaultValue = "forezp") String name) {
    	logger.info("Executing feignhystrixdemo-provider");
        return "hi " + name + " ,[Executed in "+System.getenv("ENVIRONMENT_NAME_KEY")+"]: i am from IP:"+ System.getenv("MY_POD_IP") +" Port:" + port;
    }
    
}



