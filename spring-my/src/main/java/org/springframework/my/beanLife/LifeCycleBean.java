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
	 */
	public void init() {
		logger.info("PostConstruct....");
	}

	public void destroy() {
		logger.info("销毁");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		logger.info("afterPropertiesSet....");
	}

}
