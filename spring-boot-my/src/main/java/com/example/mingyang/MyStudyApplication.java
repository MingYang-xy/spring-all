package com.example.mingyang;

import com.example.mingyang.controller.TestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(exposeProxy = true)
public class MyStudyApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MyStudyApplication.class, args);
		System.out.println("(♥◠‿◠)ﾉﾞ  启动成功   ლ(´ڡ`ლ)ﾞ  \n");
		// TestController testController = context.getBean(TestController.class);
		// testController.test();
		// context.close();
	}
}
