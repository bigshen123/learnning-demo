package com.bigshen.chatDemoService.utils.config;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableApolloConfig({ "fdfs" })
public class ConfigSerivce {
	
	@Bean(name = "fdfs")
	public FastdfsConfig fastdfsConfig() {
		return new FastdfsConfig();
	}



}
