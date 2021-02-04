package guru.springframwork.stgdiv2;

import guru.springframwork.stgdiv2.controllers.ConstructorInjectedController;
import guru.springframwork.stgdiv2.controllers.MyController;
import guru.springframwork.stgdiv2.controllers.PropertyInjectedController;
import guru.springframwork.stgdiv2.controllers.SetterInjectedController;
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
	}

}
