# Techaid_Automation_Challenge
This is my solution to automate and validate various twitter functionalities. This is done using Selenium Webdriver, Java, Junit, and Maven.

## REQUIREMENTS
### Before running this test framework, you will need:
* Java version 15.0.1 installed ([Download](https://www.java.com/en/download/))
* Maven version 3.6.3 installed ([Download](https://maven.apache.org/download.cgi)), ([Installation](https://maven.apache.org/install.html), [Configure](https://maven.apache.org/configure.html))
* Maven compiler needs to be 1.6 or higher (1.8 on the project)
* Maven and Java environment setup ([Setup](https://www.tutorialspoint.com/maven/maven_environment_setup.htm))
* IntelliJ IDE (optional) ([Download](https://www.jetbrains.com/idea/download/))


## USAGE

In order to run these tests from the terminal you will need to be on the project path and use the following command:
```shell
mvn test
```

## RUNTIME EXPLANATION

Here is a briefly explanation on how the code works, the outstanding classes and their purpose on the project.

### PageObjects Classes
In the project are two main page object classes:
* SignUpPage: This class contains the web elements and some of the behaviour of the signup page of the web application being tested (https://twitter.com)
* HomePage: This class contains the web elements and the behaviour of the home page or account page of the web application being tested (https://twitter.com)

For the sake of this project, because of its simplicity, I decided not to abstract more using a locators class containing the elements. However, using a class for this purpose is the recommended way to do it in a Page Object Model designed project.

### Utils Classes
In the project are two Utils classes, aimed at helping with data storage and scripting functionalities that are out of the main page objects.
* Helpers: This class contains data variables that are useful on every stage of the tests. This data variables are static, but can be dynamically changed if needed.
* Utilities: This class contains two methods for getting a Fake email account and a verification code. This serves the purpose of one of the stages of the test.


### TestPlan Class
In this main test class, all the tests are performed. Assertions are made in some instances of this class.
This class contains Test methods for the five test scenarios requested.

### Media Interaction
There is a Test method that uploads a video and interacts with it.

### Time Considerations
Inside all the methods called by the test methods, there is waiting time period to emulate how a real user would interact with the application.
