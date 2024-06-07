package org.springframework.my.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.my.bean.Hello;

/**
 * JavaConfig
 *
 * @author XuYang
 * @since 2024/5/21 18:04
 */
@Configuration
public class JavaConfig {

	@Bean(initMethod = "init")
	public Hello hello() {
		return new Hello();
	}
}
