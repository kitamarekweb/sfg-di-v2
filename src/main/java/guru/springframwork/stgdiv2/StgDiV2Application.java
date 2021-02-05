package guru.springframwork.stgdiv2;

import guru.springframwork.stgdiv2.controllers.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.convert.Property;

@SpringBootApplication
public class StgDiV2Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(StgDiV2Application.class, args);

		MyController myController = (MyController) ctx.getBean("myController");

		String greeting = myController.sayHello();
		myController.sayHello();
		System.out.println(greeting);

		System.out.println("---- Property");
		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
		// without @Controller on the class we get this error:
		// Exception in thread "main" org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'propertyInjectedController' available
		System.out.println(propertyInjectedController.getGreeting());
		// without @Autowired on field greetingService we get an error:
		// Exception in thread "main" java.lang.NullPointerException

		// without @Service in the GreetingServiceImpl we get an error:
		// Field greetingService in guru.springframwork.stgdiv2.controllers.PropertyInjectedController required a bean of type 'guru.springframwork.stgdiv2.services.GreetingService' that could not be found.
		// Consider defining a bean of type 'guru.springframwork.stgdiv2.services.GreetingService' in your configuration.

		System.out.println("---- Setter");
		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");
		System.out.println(setterInjectedController.getGreeting());

		System.out.println("---- Constructor");
		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
		System.out.println(constructorInjectedController.getGreeting());

		System.out.println("---- Primary Bean");
		PrimaryInjectedController primaryInjectedController = (PrimaryInjectedController) ctx.getBean("primaryInjectedController");
		System.out.println(primaryInjectedController.getGreeting());

		I18nController i18nController = (I18nController) ctx.getBean("i18nController");
		System.out.println("---- Profiles");
		System.out.println(i18nController.sayHello());
		// if two Service has the same label etc. @Service("i18nService") then we have to specify Profiles and configure it in application.properties etc. spring.profiles.active=ES or we get an error:
		// Failed to parse configuration class [guru.springframwork.stgdiv2.StgDiV2Application]; nested exception is org.springframework.context.annotation.ConflictingBeanDefinitionException: Annotation-specified bean name 'i18nGreeting' for bean class [guru.springframwork.stgdiv2.services.I18nSpanishGreetingService] conflicts with existing, non-compatible bean definition of same name and class [guru.springframwork.stgdiv2.services.I18nEnglishGreetingService]
	}

}
