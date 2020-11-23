package com.bigshen.chatDemoService.utils;

import it.sauronsoftware.jave.AudioAttributes;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncodingAttributes;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.File;

/*
 * 播放wav文件，这里是我下一篇文章的部分内容
 */
public class ReadWav {
	private static final Log logger = LogFactory.getLog(ReadWav.class);

	/**
	 * 
	 * @Title: changeToWav @Description: TODO(将语音文件转为wav格式) @param @param
	 * sourcePath @param @param targetPath 参数 @return void 返回类型 @throws
	 */
	public static void changeToWav(File source, File target) {
		try {
			String os = System.getProperty("os.name").toLowerCase();
			// windows操作系统执行
			if (os.indexOf("windows") >= 0) {
				AudioAttributes audio = new AudioAttributes();
				Encoder encoder = new Encoder();
				// 设置解码格式，比特率，位数，声道等信息
				audio.setCodec("PCM");
				/*
				 * audio.setBitRate(new Integer(705000)); audio.setChannels(new
				 * Integer(1)); audio.setSamplingRate(new Integer(44100));
				 * audio.setVolume(new Integer(500));
				 */
				EncodingAttributes attrs = new EncodingAttributes();
				attrs.setFormat("wav");
				attrs.setAudioAttributes(audio);
				// attrs.setDuration(duration);
				encoder.encode(source, target, attrs);
			}
			// linux操作系统执行
			else if (os.indexOf("linux") >= 0) {
				String cmd = "/usr/local/ffmpeg/bin/ffmpeg -i " + source.getAbsolutePath() + " -acodec pcm_s16le "
						+ target.getAbsolutePath()+" -y";
				logger.info("转换指令：" + cmd);
				CmdUtil.executeCmd(cmd);
			}
		} catch (Exception e) {
			logger.error("音频转换异常:" + e.getMessage());
		}
	}

}