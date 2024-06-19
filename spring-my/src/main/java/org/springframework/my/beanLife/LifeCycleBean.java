package org.springframework.my.beanLife;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class LifeCycleBean implements InitializingBean {

	private final Log logger = LogFactory.getLog(getClass());

	public LifeCycleBean() {
		logger.info("实例化.....");
	}

	/**
	 * Autowired 用在set或ctor方法上时会自动解析方法参数注入，并自动调用该方法。
	 */
	@Autowired
	public void autowire(@Value("${JAVA_HOME}") String home) {
		logger.info("依赖注入:" + home);
	}

	/**
	 * 这里的 PostConstruct应该解释为 依赖注入之后
	 * InitDestroyAnnotationBeanPostProcessor在postProcessBeforeInitialization初始化前方法处理了该注解
	 * 该BeanPostProcessor主要处理@PostConstruct和@PreDestroy
	 */
	// @PostConstruct
	public void postConstruct() {
		logger.info("PostConstruct....");
	}

	// @PreDestroy
	public void destroy() {
		logger.info("销毁");
	}

	/**
	 * 当前步骤属于初始化阶段，在执行initMethod之前会检查是否实现InitializingBean接口，调用当前方法
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		logger.info("afterPropertiesSet....");
	}

}
