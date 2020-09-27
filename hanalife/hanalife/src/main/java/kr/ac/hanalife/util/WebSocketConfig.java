package kr.ac.hanalife.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
	
	@Autowired
	SocketHandler socketHandler;
	
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(socketHandler, "/chat/{roomNumber}").addInterceptors(new HttpSessionHandshakeInterceptor()).setAllowedOrigins("*");
	}
	

	@Bean
	public ServletServerContainerFactoryBean createWebSocketContainer() {
	   ServletServerContainerFactoryBean container = new ServletServerContainerFactoryBean();
	   container.setMaxTextMessageBufferSize(8192);
       container.setMaxBinaryMessageBufferSize(8192);
	   return container;
   }
	
}
