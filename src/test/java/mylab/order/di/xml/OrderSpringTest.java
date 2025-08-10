package mylab.order.di.xml;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OrderSpringTest {
	ApplicationContext context;
	@BeforeEach
	void createcontext() {
		context = new ClassPathXmlApplicationContext("classpath:mylab-order-di.xml");
	
	}
	@Test
	void testShoppingcartAndOrderService() {
		
		OrderService os = (OrderService) context.getBean("orderService");
		ShoppingCart sc = (ShoppingCart) context.getBean("shoppingCart");
		
		Product pd1 = (Product) context.getBean("product1");
		Product pd2 = (Product) context.getBean("product2");
		
		List<Product> productList = new ArrayList<Product>();
		productList.add(pd1);
		productList.add(pd2);
		productList.add(pd2);
		
		sc.setProducts(productList);
		
		System.out.println(sc.toString());
		System.out.println("SC에서의 총합"+sc.getTotalPrice());
		
		//OS의 Shoppingcart를 SC로 설정
		os.setShoppingCart(sc);
		
		System.out.println("OS에서의 총합 :"+os.calculateOrderTotal());
		
		
		
		
		
//		System.out.println(sc.getTotalPrice());
		
		
	}
	@Test
	void testShoppingcart() {
		
		
	}
	
	

}
