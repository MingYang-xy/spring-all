package org.springframework.my.beanLife;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan
public class BeanLifeApplication {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanLifeApplication.class);
		context.close();
		// <<<<<< 实例化之前执行, 这里返回的对象会替换掉原本的 bean
		// 实例化.....
		// <<<<<< 实例化之后执行, 这里如果返回 false 会跳过依赖注入阶段
		// <<<<<< 依赖注入阶段执行, 如 @Autowired、@Value、@Resource
		// user构造器
		// 依赖注入: D:\java8
		// <<<<<< 初始化之前执行, 这里返回的对象会替换掉原本的 bean, 如 @PostConstruct、@ConfigurationProperties
		// PostConstruct....  这个注解是 通过一个beanPostProcessor在初始化前方法处理的
		// afterPropertiesSet.... 这里就是在执行init-method之前代码检查有没有实现InitializingBean接口，如果有就执行
		// 可以通过xml或者@Bean指定init-method自定义初始化过程
		// <<<<<< 初始化之后执行, 这里返回的对象会替换掉原本的 bean, 如代理增强
		// <<<<<< 销毁之前执行, 如 @PreDestroy
		// 销毁
	}
}
