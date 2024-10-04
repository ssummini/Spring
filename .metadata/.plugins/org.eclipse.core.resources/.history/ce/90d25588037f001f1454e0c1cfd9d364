package sample01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
		//MessageBeanKo messageBeanKo = new MessageBeanKo(); //1대1, 결합도 100%
		//MessageBean messageBean = new MessageBeanEn(); //부모 = 자식, 다형성, 결합도 낮추기
		
		//스프링 설정 파일 이용
		ApplicationContext context = new FileSystemXmlApplicationContext("src/main/resources/applicationContext.xml");
		MessageBean messageBean = (MessageBean) context.getBean("messageBean"); //applicationContext.xml에서 Bean의 id 값을 넣어주면 얻어온다는 것	
		messageBean.sayHello("Spring");
		System.out.println();
		
		MessageBean messageBean2 = (MessageBean) context.getBean("messageBean"); //applicationContext.xml에서 Bean의 id 값을 넣어주면 얻어온다는 것	
		messageBean2.sayHello("Spring");
		System.out.println();
		
		MessageBean messageBean3 = (MessageBean) context.getBean("messageBean"); //applicationContext.xml에서 Bean의 id 값을 넣어주면 얻어온다는 것	
		messageBean3.sayHello("Spring");
		System.out.println();		
	}

}
