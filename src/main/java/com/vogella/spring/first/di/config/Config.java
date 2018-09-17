package com.vogella.spring.first.di.config;

import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages={ "com.vogella.spring.first.di" })
public class Config {
	
    @Bean
    public Long getId() {
        return Long.valueOf(0);
    }

    @Bean
    public String getSummary() {
        return "Spring DI";
    }

    @Bean
    public Boolean isDone() {
        return Boolean.FALSE;
    }

    @Bean
    public Date getDueDate() {
        return new Date();
    }

}

/*Usamos @Bean para evitar dar new em vários locais da aplicação e passar apenas a recebê-los 
 * como dependências das nossas classes.
 * Usamos a anotação @Bean em um método de uma classe gerenciada pelo Spring, 
 * criamos o objeto dentro do método anotado e retornamos sua instância.
 * declaramos a api como dependência através da anotação @Autowired.
 * */

