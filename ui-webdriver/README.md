#Selenium webdriver java 

##References 
```
https://testautomationu.applitools.com/selenium-webdriver-tutorial-java
https://www.oracle.com/technetwork/java/javase/downloads/jdk12-downloads-5295953.html
https://chromedriver.chromium.org/downloads
https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-chrome-driver/3.141.59
https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/chrome/ChromeDriver.html
https://the-internet.herokuapp.com/
```

#Page Object Oriented Model design pattern
```
The main folder is where people typically put their framework
The test folder is where people typically put their tests 
All of your interactions with the web browser — basically all of the coding that's done under the covers of the application — should be in your framework. 
And your test files should just focus on the test itself.
Things like finding the elements and clicking on them are things that should be done in the framework. Your test itself wouldn't focus on finding a specific element by its locator.
Your test would do things like specify, “I want to click a link.”
The internals of how that link gets clicked should be in your framework section.
The way the Page Object Model design pattern works is that you create a class in your framework section of the project that represents a page in your application — 
and for every page in your application you'd create a new class in the framework section of your project.
```