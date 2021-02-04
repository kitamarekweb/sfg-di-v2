package guru.springframwork.stgdiv2;

import guru.springframwork.stgdiv2.controllers.MyController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StgDiV2Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(StgDiV2Application.class, args);

		MyController myController = (MyController) ctx.getBean("myController");

		String greeting = myController.sayHello();

		myController.sayHello();

		System.out.println(greeting);
	}

}
