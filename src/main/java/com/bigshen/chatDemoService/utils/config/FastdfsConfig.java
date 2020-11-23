package com.bigshen.chatDemoService.utils.config;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:fdfs.properties")
@EnableApolloConfig("fdfs")
public class FastdfsConfig {

	@Value("${network_timeout:5}")
	  private String connectTimeout;
	@Value("${network_timeout:30}")
	  private String networkTimeout;
	@Value("${charset:utf-8}")
	  private String charset;
	@Value("${tracker_nginx:127.0.0.1:8090}")
	  private String trackerNginx;
	@Value("${out_tracker_nginx:127.0.0.1:8090}")
	  private String outTracker_nginx;
	@Value("${tracker_server:127.0.0.1:22122}")
	  private String trackerServer;
	@Value("${secret_key:FastDFS1234567890}")
	  private String secretKey;
	@Value("${anti_steal_token:no}")
	  private String token;
	@Value("${productname:ds}")
	  private String productname;
	public String getConnectTimeout() {
		return connectTimeout;
	}
	public void setConnectTimeout(String connectTimeout) {
		this.connectTimeout = connectTimeout;
	}
	public String getNetworkTimeout() {
		return networkTimeout;
	}
	public void setNetworkTimeout(String networkTimeout) {
		this.networkTimeout = networkTimeout;
	}
	public String getCharset() {
		return charset;
	}
	public void setCharset(String charset) {
		this.charset = charset;
	}
	public String getTrackerNginx() {
		return trackerNginx;
	}
	public void setTrackerNginx(String trackerNginx) {
		this.trackerNginx = trackerNginx;
	}
	public String getTrackerServer() {
		return trackerServer;
	}
	public void setTrackerServer(String trackerServer) {
		this.trackerServer = trackerServer;
	}
	public String getSecretKey() {
		return secretKey;
	}
	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getOutTracker_nginx() {
		return outTracker_nginx;
	}
	public void setOutTracker_nginx(String outTracker_nginx) {
		this.outTracker_nginx = outTracker_nginx;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	
	


}
