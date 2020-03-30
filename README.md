# GoJekUI
Repo for GoJek UI Assignment
Following tools I have used for automation-

Java Programming language-jdk1.8.0_241
IDE- Intellij Idea 
Selenium WebDrivers-selenium-java-3.141.59
Test Execution- TestNG-7.0.0
Logging- log4j-1.2.17
Build Tool- apache-maven-3.1.1
geckodriver-v0.26.0-win64
chromedriver_win32

Steps to execute automation test-
Download and keep gecko drivers in src-main-resources
Go to project directory from IDE terminal and run-
mvn clean
mvn compile
mvn package
mvn install -Dtest=Pillow_Purchase test

All the dependencies are managed through POM.xml

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>org.example</groupId>
    <artifactId>GoJekUI</artifactId>
    <version>1.0.0</version>
    <packaging>jar</packaging>
    <build>
        <resources>
            <resource>
                <directory>src/main/resources</directory>
            </resource>
        </resources>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.0.0-M1</version>
            </plugin>
        </plugins>
    </build>
    <dependencies>
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>3.141.59</version>
        </dependency>
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-server</artifactId>
            <version>3.141.59</version>
        </dependency>
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-firefox-driver</artifactId>
            <version>3.141.59</version>
        </dependency>
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-chrome-driver</artifactId>
            <version>3.141.59</version>
        </dependency>
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-remote-driver</artifactId>
            <version>3.141.59</version>
        </dependency>
        <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.13</version>
    </dependency>
        <dependency>
            <groupId>log4j</groupId>
            <artifactId>log4j</artifactId>
            <version>1.2.17</version>
        </dependency>
        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>7.0.0</version>
            <scope>compile</scope>
        </dependency>
        <dependency>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-surefire-plugin</artifactId>
            <version>2.19.1</version>
        </dependency>
    </dependencies>
</project>

Entire GoJek UI project zipped folder is avaialble at : https://drive.google.com/open?id=1YpQqZm2TPh4y3HHQAsXjXF5WhkCbRwgU

Note :
Pillow_Purchase.java covers 3 test cases- 
valid purchase with valid card
invalid purchase with invalid Card
invalid purchase with invalid Promo
