package org.springframework.my.beanLife;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements InstantiationAwareBeanPostProcessor, DestructionAwareBeanPostProcessor {
	private final Log log = LogFactory.getLog(getClass());

	@Override
	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
		if (beanName.equals("lifeCycleBean")) {
			log.info("<<<<<< 实例化之前执行, 这里返回的对象会替换掉原本的 bean");
			// 返回的对象会替换掉原本的 bean，且会直接跳过实例化和属性填充等中间步骤，直达【初始化后】，执行完直接就放入缓存了
			// return new LifeCycleBean();
		}
		return null;
	}

	@Override
	public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
		if (beanName.equals("lifeCycleBean")) {
			System.out.println();
			log.info("<<<<<< 实例化之后执行, 这里如果返回 false 会跳过依赖注入阶段");
			// return false;
		}
		return true;
	}

	@Override
	public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
		if (beanName.equals("lifeCycleBean")) {
			log.info("<<<<<< 依赖注入阶段执行,这里是属性填充的增强逻辑 如 @Autowired、@Value、@Resource");
		}
		return pvs;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if (beanName.equals("lifeCycleBean")) {
			log.info("<<<<<< 初始化之前执行, 这里返回的对象会替换掉原本的 bean, 如 @PostConstruct、@ConfigurationProperties");
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (beanName.equals("lifeCycleBean")) {
			log.info("<<<<<< 初始化之后执行, 这里返回的对象会替换掉原本的 bean, 如代理增强");
		}
		return bean;
	}

	@Override
	public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
		if (beanName.equals("lifeCycleBean")) {
			log.info("<<<<<< 销毁之前执行, 如 @PreDestroy");
		}
	}

}
