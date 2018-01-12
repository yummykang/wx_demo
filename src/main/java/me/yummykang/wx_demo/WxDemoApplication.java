package me.yummykang.wx_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.weixin4j.Configuration;
import org.weixin4j.Weixin;
import org.weixin4j.WeixinException;

@SpringBootApplication
@EnableWebMvc
public class WxDemoApplication {
	public static Weixin weixin = new Weixin();

	{
		try {
			weixin.login(Configuration.getOAuthAppId(), Configuration.getOAuthSecret());
		} catch (WeixinException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(WxDemoApplication.class, args);
	}
}
