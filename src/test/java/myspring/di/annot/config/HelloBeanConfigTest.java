package myspring.di.annot.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import myspring.di.annot.HelloBean;
import myspring.di.annot.HelloBeanConfig;

@ExtendWith(SpringExtension.class)
///
////@configuration을 위한 특별한 container class인 AnnotationConfigApplicationContext  객체를 로딩해줌
@ContextConfiguration(classes=HelloBeanConfig.class,loader=AnnotationConfigContextLoader.class)
///



public class HelloBeanConfigTest {
	
	@Autowired
	HelloBean hello;
	
	@Test
	void hellobean전략31() {
		
		System.out.println(hello.sayHello());
		
		
	}
	

}
