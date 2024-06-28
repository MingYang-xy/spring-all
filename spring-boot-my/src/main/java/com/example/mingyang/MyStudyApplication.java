package com.example.mingyang;

import com.example.mingyang.controller.TestProxyController;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * EnableAspectJAutoProxy 内部引入了AspectJAutoProxyRegistrar
 * exposeProxy = true则可以通过AopContext.currentProxy()获取当前代理对象
 */
@SpringBootApplication
@EnableAspectJAutoProxy(exposeProxy = true)
public class MyStudyApplication {

	public static void main(String[] args) {
		// 将debug过程中产生的代理对象都存放在指定目录
		System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,
				"D:\\workspace-gitee\\spring-all\\spring-boot-my\\build\\classes\\java\\main");
		ConfigurableApplicationContext context = SpringApplication.run(MyStudyApplication.class, args);
		ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
		TestProxyController controller = beanFactory.getBean(TestProxyController.class);
		System.out.println("controller = " + controller);
		System.out.println("(♥◠‿◠)ﾉﾞ  启动成功   ლ(´ڡ`ლ)ﾞ  \n");
	}
}
