package com.spring_greeting_app.GreetingAppApplication;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, World!";
    }
    @Autowired
    private GreetingService greetingService;
    @GetMapping("/service")
    public String sayHelloFromService() {
        return greetingService.getGreetingMessage();
    }
    @GetMapping("/personalized")
    public String personalizedGreeting(@RequestParam(required = false) String firstName,
                                       @RequestParam(required = false) String lastName) {
        return greetingService.getPersonalizedGreeting(firstName, lastName);
    }
    @PostMapping("/save")
    public Greeting saveGreeting(@RequestBody Greeting greeting) {
        return greetingService.saveGreeting(greeting);
    }

    @GetMapping("/find/{id}")
    public Optional<Greeting> findGreetingById(@PathVariable Long id) {
        return greetingService.findGreetingById(id);
    }

    @GetMapping("/all")
    public List<Greeting> getAllGreetings() {
        return greetingService.getAllGreetings();
    }
}
