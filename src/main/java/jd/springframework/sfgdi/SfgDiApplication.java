package jd.springframework.sfgdi;

import jd.springframework.sfgdi.controller.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/* below annotation (@SpringBootApplication) defines - i am going to do component scan from this package and down
* If anything is outside of current file packeage then i wont scan it under the spring framework
*
* If we move 'services' package to outside of current package, then spring framework wont find services
*
* to support that we have to add one more annotation
* @ComponentScan(basePackages = {"jd.springframework.services"}) -- this will take all the from services
* and over right the default component scan. We can also add extra packages by adding another string in
* above annotation separated by comma
*
* */
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

		System.out.println("---- Profile ----");
		I18nController i18nController = (I18nController) ctx.getBean("i18nController");
		System.out.println(i18nController.sayHello());
		System.out.println();

		PetController petController = ctx.getBean("petController", PetController.class);
		System.out.println("--- The Best Pet is ---");
		System.out.println(petController.whichPetIsTheBest());
		System.out.println();


	}

}
