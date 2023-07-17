package com.magicroom.albumservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class AlbumServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlbumServiceApplication.class, args);
	}

}

@RefreshScope
@RestController
class MessageRestController {

	@Value("${server.url:Unable to connect to config server}")
	private String url;

	@RequestMapping("/server/url")
	String getURL() {
		return this.url;
	}
}

