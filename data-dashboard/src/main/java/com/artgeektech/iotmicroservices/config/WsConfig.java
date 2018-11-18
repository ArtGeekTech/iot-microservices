package com.artgeektech.iotmicroservices.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * Created by guang on 1:31 PM 8/26/18.
 */
@Configuration
@EnableWebSocketMessageBroker
public class WsConfig extends AbstractWebSocketMessageBrokerConfigurer {
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
//		config
//			.setApplicationDestinationPrefixes("/app")
//			.enableStompBrokerRelay("/topic")
//			.setRelayHost("localhost")
//			.setRelayPort(61613)
//			.setClientLogin("guest")
//			.setClientPasscode("guest");
        config.setApplicationDestinationPrefixes("/app").enableSimpleBroker("/topic");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/websocket-app").withSockJS();
    }
}
