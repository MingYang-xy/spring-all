package org.springframework.my.bean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * FactoryBean
 * 工厂bean，针对spring容器中一些创建逻辑比较复杂的bean。全都放在统一的处理逻辑中并不能满足要求，因此spring提供了
 * 手动创建bean的工厂bean，用户可以自定义bean的创建逻辑。FactoryBean<T>传入的泛型表示当前工厂bean创建的对象类型
 * FactoryBean自身是一个bean，并且他的getObject会被容器调用，用来生产任意类型的bean。生产的bean一样会被放入单例池中
 *
 * @author XuYang
 * @since 2024/6/3 10:07
 */
@Component
public class MyHelloFactoryBean implements FactoryBean<CustomBean> {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public CustomBean getObject() throws Exception {
		CustomBean customBean = new CustomBean();
		customBean.setAge(18);
		customBean.setName("张大炮");
		return customBean;
	}

	@Override
	public Class<?> getObjectType() {
		return CustomBean.class;
	}

}
