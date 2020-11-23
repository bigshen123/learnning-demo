package com.bigshen.chatDemoService.utils.enums;



import com.bigshen.chatDemoService.utils.VO.FastdfsClientVO;
import com.bigshen.chatDemoService.utils.config.ConfigSerivce;
import com.bigshen.chatDemoService.utils.config.FastdfsConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FastdfsUtil {
	public static FastdfsClientVO vo = new FastdfsClientVO();
	private static final Logger logger = LoggerFactory.getLogger(FastdfsUtil.class);

	static {
		ApplicationContext context = new AnnotationConfigApplicationContext(ConfigSerivce.class);
		FastdfsConfig config = (FastdfsConfig) context.getBean("fdfs");
		Properties pro = new Properties();

		try {
			File file=new File("." + System.getProperty("file.separator") + "fdfs.properties");
			System.out.println(file.getAbsolutePath());
			pro.load(new FileInputStream(file));
		} catch (Exception e) {
			try {
				pro.load(FastdfsUtil.class.getClassLoader().getResourceAsStream("fdfs.properties"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

		if (config.getTrackerNginx().contains("127.0.0.1")) {
			vo.setTracker_nginx((String) pro.get("tracker_nginx"));
			vo.setTracker_server((String) pro.get("tracker_server"));
			vo.setOut_tracker_nginx((String)pro.get("out_tracker_nginx"));
		} else {

			vo.setTracker_nginx(config.getTrackerNginx());
			vo.setOut_tracker_nginx(config.getOutTracker_nginx());
			vo.setTracker_server(config.getTrackerServer());
		}
		logger.info("nginx:" + vo.getTracker_nginx() + ",tracker" + vo.getTracker_nginx());

	}

	public static FastdfsClientVO getClientConfig() {
		return vo;
	}

}
