package com.vogella.spring.first.di;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.vogella.spring.first.di.config.Config;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		ITodo todo = context.getBean(ITodo.class);
		System.out.println(todo);
		context.close();
	}
}


/*DI é injeção de depenências*/