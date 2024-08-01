package com.example.tibcoems.config;

import com.tibco.tibjms.TibjmsConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.ConnectionFactory;

@Configuration
public class TibcoEmsConfig {

    @Value("${tibco.ems.server.url}")
    private String serverUrl;

    @Value("${tibco.ems.credentials.username}")
    private String username;

    @Value("${tibco.ems.credentials.password}")
    private String password;

    @Bean
    public ConnectionFactory connectionFactory() {
        TibjmsConnectionFactory factory = new TibjmsConnectionFactory();
        factory.setServerUrl(serverUrl);
        factory.setUserName(username);
        factory.setPassword(password);
        return factory;
    }
}

