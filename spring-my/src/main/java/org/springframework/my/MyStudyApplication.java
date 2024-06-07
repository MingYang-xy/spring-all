package org.springframework.my;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.my.bean.Hello;


@ComponentScan
public class MyStudyApplication {
	public static void main(String[] args) throws Exception {
		// 1.直接指定配置类，内部会自动扫描+refresh
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyStudyApplication.class);
		// 2.手动指定一些配置类，需要自己refresh
		// AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		// context.register(MyStudyApplication.class);
		// context.refresh();
		Hello bean = context.getBean(Hello.class);
		System.out.println(bean);
	}
}