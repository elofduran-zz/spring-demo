package com.example.demo.api;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class FooController {

    // A Simple Mapping
    // http://localhost:8080/api/foos?id=abc
    @GetMapping("/api/foos")
    @ResponseBody
    public String getFoos(@RequestParam String id) {
        return "ID: " + id;
    }

    //  Specifying the Request Parameter Name
    @PostMapping
    @ResponseBody
    public String addFoo(@RequestParam(name = "id") String fooId, @RequestParam String name) {
        return "ID: " + fooId + " Name: " + name;
    }

    // or

    @PostMapping(params = "id")
    @ResponseBody
    public String addFoo2(@RequestParam("id") String fooId, @RequestParam String name) {
        return "ID: " + fooId + " Name: " + name;
    }


    // Making an Optional Request Parameter
    // Method parameters annotated with @RequestParam are required by default.
    // http://localhost:8080/api/foos or http://localhost:8080/api/foos?id=abc
    @GetMapping("/api/foos")
    @ResponseBody
    public String getFoosOptional1(@RequestParam(required = false) String id) {
        return "ID: " + id;
    }

    //or

    @GetMapping("/api/foos")
    @ResponseBody
    public String getFoosOptional2(@RequestParam Optional<String> id){
        return "ID: " + id.orElseGet(() -> "not provided");
    }

    // A Default Value for the Request Parameter
    // This is like required=false, in that the user no longer needs to supply the parameter.
    // Note that when we set the defaultValue attribute, required is, indeed, set to false.
    // http://localhost:8080/api/foos or http://localhost:8080/api/foos?id=abc
    @GetMapping("/api/foos")
    @ResponseBody
    public String getFoosWithDefaultValue(@RequestParam(defaultValue = "test") String id) {
        return "ID: " + id;
    }

    // Mapping a Multi-Value Parameter
    // http://localhost:8080/api/foos?id=1,2,3 or http://localhost:8080/api/foos?id=1&id=2
    @GetMapping("/api/foos")
    @ResponseBody
    public String getFoosMultiValues(@RequestParam List<String> id) {
        return "IDs are " + id;
    }


    // URI Path
    // http://localhost:8080/foos/abc
    @GetMapping("/foos/{id}")
    @ResponseBody
    public String getFooByIdUsingURIPath(@PathVariable String id) {
        return "ID: " + id;
    }

    // Query Parameter
    // http://localhost:8080/foos?id=abc
    @GetMapping("/foos")
    @ResponseBody
    public String getFooByIdUsingQueryParam(@RequestParam String id) {
        return "ID: " + id;
    }

    // Optional URI Path Variable
    // http://localhost:8080/myfoos/optional/abc or http://localhost:8080/myfoos/optional
    @GetMapping({"/myfoos/optional", "/myfoos/optional/{id}"})
    @ResponseBody
    public String getFooByOptionalId(@PathVariable(required = false) String id){
        return "ID: " + id;
    }

}
