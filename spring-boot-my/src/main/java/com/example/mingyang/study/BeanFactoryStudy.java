package com.example.mingyang.study;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigUtils;

/**
 * BeanFactoryStudy
 *
 * @author XuYang
 * @since 2024/5/31 10:15
 */
public class BeanFactoryStudy {
	public static void main(String[] args) {
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		// 这里只是添加了后处理器的beanDefinition
		AnnotationConfigUtils.registerAnnotationConfigProcessors(beanFactory);
		String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			System.out.println(beanDefinitionName);
		}
	}
}
