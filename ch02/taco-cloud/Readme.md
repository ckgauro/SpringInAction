### To run

$mvn spring-boot:run

#### Performing validation at form binding

The @Valid annotation tells Spring MVC to perform validation on the submitted Taco object after it’s bound to the
submitted form data and before the processDesign() method is called. If there are any validation errors, the details of
those errors will be captured in an Errors object that’s passed into processDesign(). The first few lines of
processDesign() consult the Errors object, asking its hasErrors() method if there are any validation errors. If there
are, the method concludes without processing the Taco and returns the "design" view name so that the form is
redisplayed.

#### Displaying validation errors

Thymeleaf offers convenient access to the Errors object via the fields property and with its th:errors attribute. For
example, to display validation errors on the credit card number field, you can add a <span> element that uses these
error references to the order form template, as follows.

#### Working with view controllers

Thus far, you’ve written three controllers for the Taco Cloud application. Although each controller serves a distinct
purpose in the functionality of the application, they all pretty much follow the same programming model:

* They’re all annotated with @Controller to indicate that they’re controller classes that should be automatically
  discovered by Spring component scanning and instantiated as beans in the Spring application context.

* All but HomeController are annotated with @RequestMapping at the class level to define a baseline request pattern that
  the controller will handle.

* They all have one or more methods that are annotated with @GetMapping or @PostMapping to provide specifics on which
  methods should handle which kinds of requests.

## Summary

* Spring offers a powerful web framework called Spring MVC that can be used to develop the web frontend for a Spring
  application.

* Spring MVC is annotation-based, enabling the declaration of request-handling methods with annotations such as
  @RequestMapping, @GetMapping, and @PostMapping.

* Most request-handling methods conclude by returning the logical name of a view, such as a Thymeleaf template, to which
the request (along with any model data) is forwarded.

* Spring MVC supports validation through the Java Bean Validation API and implementations of the Validation API such as
Hibernate Validator.

* View controllers can be used to handle HTTP GET requests for which no model data or processing is required.

* In addition to Thymeleaf, Spring supports a variety of view options, including FreeMarker, Groovy Templates, and
Mustache.