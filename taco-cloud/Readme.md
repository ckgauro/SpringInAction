### Spring Boot Application

You may recognize this as a typical Maven or Gradle project structure, where application source code is placed under
src/main/java, test code is placed under src/test/java, and non-Java resources are placed under src/main/resources.
Within that project structure, you’ll want to take note of these items:

 mvnw and mvnw.cmd—These are Maven wrapper scripts. You can use these scripts to build your project even if you don’t
have Maven installed on your machine.

 pom.xml—This is the Maven build specification. We’ll look deeper into this in a moment.

 TacoCloudApplication.java—This is the Spring Boot main class that bootstraps the project. We’ll take a closer look at
this class in a moment.

 application.properties—This file is initially empty, but offers a place where you can specify configuration
properties. We’ll tinker with this file a little in this chapter, but I’ll postpone a detailed explanation of
configuration properties to chapter 5.

 static—This folder is where you can place any static content (images, stylesheets, JavaScript, and so forth) that you
want to serve to the browser. It’s initially empty.

 templates—This folder is where you’ll place template files that will be used to render content to the browser. It’s
initially empty, but you’ll add a Thymeleaf template soon.

 TacoCloudApplicationTests.java—This is a simple test class that ensures that the Spring application context loads
successfully. You’ll add more tests to the mix as you develop the application.

#### Spring Boot Main

Although there’s little code in TacoCloudApplication, what’s there packs quite a punch. One of the most powerful lines
of code is also one of the shortest. The @SpringBootApplication annotation clearly signifies that this is a Spring Boot
application. But there’s more to @SpringBootApplication than meets the eye.

###### @SpringBootApplication is a composite application that combines three other annotations:

 @SpringBootConfiguration—Designates this class as a configuration class. Although there’s not much configuration in
the class yet, you can add Javabased Spring Framework configuration to this class if you need to. This annotation is, in
fact, a specialized form of the @Configuration annotation.

 @EnableAutoConfiguration—Enables Spring Boot automatic configuration. We’ll talk more about autoconfiguration later.
For now, know that this annotation tells Spring Boot to automatically configure any components that it thinks you’ll
need.

 @ComponentScan—Enables component scanning. This lets you declare other classes with annotations like @Component,
@Controller, @Service, and others, to have Spring automatically discover them and register them as components in the
Spring application context.
