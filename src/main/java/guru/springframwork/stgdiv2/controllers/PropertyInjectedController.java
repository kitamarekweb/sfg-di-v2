package guru.springframwork.stgdiv2.controllers;

import guru.springframwork.stgdiv2.services.GreetingService;

public class PropertyInjectedController {

    public GreetingService greetingService;

    public String getGreeting() {
        return greetingService.sayGreeting();
    };



}
