package br.com.portal.api.config.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ "br.com.portal.api.*" })
public class RootConfig {

}
