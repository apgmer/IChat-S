package me.xiaotian.ichat.family;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by guoxiaotian on 2017/5/16.
 */

@SpringBootApplication
@ImportResource({"classpath:spring/dubbo-customer.xml"})
@ComponentScan(basePackages = "me.xiaotian.ichat.family")
public class App {
    public static void main(String[] argv) {
        SpringApplication.run(App.class, argv);
    }

}
