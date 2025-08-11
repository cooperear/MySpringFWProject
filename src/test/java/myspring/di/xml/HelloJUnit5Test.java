package myspring.di.xml;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.junit.jupiter.api.BeforeEach;

//Static import
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring-beans.xml")

public class HelloJUnit5Test {

	ApplicationContext context;

	@BeforeEach
	void createContainer() {
		// 1. container 객체 생성
		context = new GenericXmlApplicationContext("classpath:spring-beans.xml");
	}
	

	@Test
	void helloBean() {

		// 2 Container가 생성한 Hello 스프링빈 요청

		Hello hellobyId = (Hello) context.getBean("hello");
		Hello helloByType = context.getBean("hello", Hello.class);

		// 주소 비교하여 SingleTon인지 확인
		// System.out.println(helloByType == hellobyId);
		// assertSame을 이용해서 singleton인지 확인

		assertSame(helloByType, hellobyId); // class 이름 생략가능

		assertEquals("Hello 스프링", helloByType.sayHello());

		helloByType.print();

		// StringPrinter Bean 요청
		// 부모 클래스 호출해도됨
		Printer printer = context.getBean("stringPrinter", Printer.class);

		assertEquals("Hello 스프링", printer.toString());
	}
	
	

}
