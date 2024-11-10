Karate DSL implementation for Automation

# Setup
### 1) Java 21
### 2) Maven dependency
#### Karate-core dependency is enough for basic testing but JUnit5 version provides better options by leveraging JUnit 5 features

i.e.
- Can have multiple methods in a test-class. 
- Only 1 import is needed 
- Instead of a class-level annotation, we use a nice DRY and fluent-api to express which tests and tags we want to use.
- When we use the JUnit runner - after the execution of each feature, an HTML report is output to the target/karate-reports folder and the full path will be printed to the console

~~~
<dependency>
    <groupId>io.karatelabs</groupId>
    <artifactId>karate-junit5</artifactId>
    <version>1.5.0</version>
    <scope>test</scope>
</dependency>
~~~

#### In case the project has other dependencies and one is getting conflicts then use karate-core dependency.

~~~
<dependency>
  <groupId>io.karatelabs</groupId>
  <artifactId>karate-core</artifactId>
  <version>${karate.version}</version>
  <classifier>all</classifier>
  <scope>test</scope>
</dependency>
~~~

# Folder Structure
A Karate test script has the file extension `.feature` which is the standard followed by Cucumber.  You are free to organize your files using regular Java package conventions.

The Maven tradition is to have non-Java source files in a separate `src/test/resources` folder structure - but we recommend that you keep them side-by-side with your `*.java` files. When you have a large and complex project, you will end up with a few data files (e.g. `*.js`, `*.json`, `*.txt`) as well and it is much more convenient to see the `*.java` and `*.feature` files and all related artifacts in the same place.

This can be easily achieved with the following tweak to your maven `<build>` section.
```xml
<build>
    <testResources>
        <testResource>
            <directory>src/test/java</directory>
            <excludes>
                <exclude>**/*.java</exclude>
            </excludes>
        </testResource>
    </testResources>        
    <plugins>
    ...
    </plugins>
</build>
```

This is very common in the world of Maven users and keep in mind that these are tests and not production code.  


## Application
For initial testing we will be using the site
https://conduit.bondaracademy.com/

### APIS
- GET https://conduit-api.bondaracademy.com/api/tags  - To get all tags
- GET
  https://conduit-api.bondaracademy.com/api/articles?limit=10&offset=0  - To get articles
- GET https://conduit-api.bondaracademy.com/api/articles/Discover-Bondar-Academy:-Your-Gateway-to-Efficient-Learning-1  - To Fetch the article
- GET https://conduit-api.bondaracademy.com/api/articles/Discover-Bondar-Academy:-Your-Gateway-to-Efficient-Learning-1/comments   - To fetch all comments of the article
