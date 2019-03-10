# Adavantest Assignment

## Prerequisite
* Mimimum `JDK 8` is required to compile the source code
* `Maven` is need to compile

## Steps to be followed
* Extract `ATTest.zip`
* You will find code folder and `ATTest.docx` file which contains application, database and testcase design and other informations.
* Please navigate to `advantesttestertool\src\main\resources`'s `application.properties` file where you can modify SMTP details which is need to send email. If it is not set, then application will log error while sending email and output the execution status on console
* In  `advantesttestertool\src\main\resources`'s you can will find `testsuites` folder which contains the **supported testsuite**. Some test suite names are:
    * TSuite_mac_D1_D2_D3_3
    * TSuite_win7_D1_D2_D3_1
* Here `TSuite_mac_D1_D2_D3_3` require mac os and 3 devices name D1, D2 and D3 and will take **3 minutes to execute**.
* After modifying the `application.properties` file. Please come back to `advantesttestertool` folder where pom file is present. You can open command prompt and run `mvn clean package` command.
* Following is example to start the application. I will start the execution of 2 test suites.
	Example:
    `$ java -jar target/advantesttestertool-1.0.jar TSuite_win7_D1_D2_D3_2 TSuite_win7_D1_D2_D3_1`