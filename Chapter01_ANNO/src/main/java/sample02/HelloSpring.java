package sample02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {	
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Calc calc = (Calc) context.getBean("calcAdd");
		calc.calculate(25, 36);
		
		calc = context.getBean("calcMul", Calc.class); // 이렇게 하면 캐스팅 안 시켜도 된다.
		calc.calculate(25, 36);
	}

}
