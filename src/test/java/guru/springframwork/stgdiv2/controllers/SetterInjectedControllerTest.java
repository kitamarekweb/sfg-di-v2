package guru.springframwork.stgdiv2.controllers;

import guru.springframwork.stgdiv2.services.ConstructorGreetingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SetterInjectedControllerTest {

    SetterInjectedController controller;

    @BeforeEach
    void setUp() {
        controller = new SetterInjectedController();
        controller.setGreetingService(new ConstructorGreetingService());

    }

    @Test
    void setGreetingService() {

        System.out.println(controller.getGreeting());
    }
}