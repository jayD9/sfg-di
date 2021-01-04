package jd.springframework.sfgdi;

import jd.springframework.sfgdi.controller.ConstructorInjectedController;
import jd.springframework.sfgdi.controller.MyController;
import jd.springframework.sfgdi.controller.PropertyInjectedController;
import jd.springframework.sfgdi.controller.SetterInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

		System.out.println("---- Primary Service ----");
		MyController myController = (MyController) ctx.getBean("myController");
		System.out.println(myController.sayHello());
		System.out.println();

		System.out.println("---- Property ----");
		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.getGreeting());
		System.out.println();

		System.out.println("---- Setter ----");
		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");
		System.out.println(setterInjectedController.getGreeting());
		System.out.println();

		System.out.println("---- Constructor ----");
		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
		System.out.println(constructorInjectedController.getGreeting());
		System.out.println();


	}

}
