package guru.springframwork.stgdiv2.controllers;

import guru.springframwork.stgdiv2.services.GreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class ConstructorInjectedController {

    private final GreetingService greetingService;

    //@Autowired // on the constructor @Autowired is optional
    public ConstructorInjectedController(@Qualifier("constructorGreetingService") GreetingService greetingService) {
        // without @Qualifier when we have more then one Service of the specific Service Implementation we get an error:
        // Parameter 0 of constructor in guru.springframwork.stgdiv2.controllers.ConstructorInjectedController required a single bean, but 2 were found:
        // Consider marking one of the beans as @Primary, updating the consumer to accept multiple beans, or using @Qualifier to identify the bean that should be consumed

        this.greetingService = greetingService;
    }

    public String getGreeting() {
        return greetingService.sayGreeting();
    }
}
