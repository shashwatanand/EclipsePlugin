Readme - Adavntest Assignment
====================================================================

Prerequisite

1) Mimimum JDK 8 is required to compile the source code
2) Maven is need to compile

Steps to be followed

1) Extract ATTest.zip
2) You will find code folder and ATTest.docx file which contains application, database and testcase design and other informations.
3) Please navigate to advantesttestertool\src\main\resources's application.properties file where you can modify SMTP details which is need to send email. If it is not set, then application will log error while sending email and output the execution status on console
4) In advantesttestertool\src\main\resources's you can will find testsuites folder which contains the supported testsuite. Some test suite names are:
		TSuite_mac_D1_D2_D3_3
		TSuite_win7_D1_D2_D3_1
5) Here TSuite_mac_D1_D2_D3_3 require mac os and 3 devices name D1, D2 and D3 and will take 3 minutes to execute.
6) After modifying the application.properties file. Please come back to advantesttestertool folder where pom file is present. You can open command prompt and run mvn clean package command.
7) Following is example to start the application. I will start the execution of 2 test suites.
	Example:
	$ java -jar -debug target/advantesttestertool-1.0.jar TSuite_win7_D1_D2_D3_2 TSuite_win10_D1_D2_D3_12
		19:22:06.137 [main] INFO com.advantest.sha.assignment.tester.AdvantesttestertoolApplication - STARTING THE APPLICATION
		2019-03-10 19:22:06.437  INFO 22132 --- [           main] c.a.s.a.t.AdvantesttestertoolApplication : Starting AdvantesttestertoolApplication v1.0 on PIT01NB320 with PID 22132 (D:\Personal\Projects\code\EclipseDi\ATTest\code\advantesttestertool\target\advantesttestertool-1.0.jar started by shashwat.anand in D:\Personal\Projects\code\EclipseDi\ATTest\code\advantesttestertool)
		2019-03-10 19:22:06.437  INFO 22132 --- [           main] c.a.s.a.t.AdvantesttestertoolApplication : No active profile set, falling back to default profiles: default
		2019-03-10 19:22:06.807  INFO 22132 --- [           main] c.a.s.a.t.AdvantesttestertoolApplication : Started AdvantesttestertoolApplication in 0.599 seconds (JVM running for 0.887)
		2019-03-10 19:22:06.807  INFO 22132 --- [           main] c.a.s.a.t.AdvantesttestertoolApplication : EXECUTING : command line runner
		2019-03-10 19:22:06.807  INFO 22132 --- [           main] c.a.s.a.t.c.i.TesterToolControllerImpl   : Inside processArguments
		2019-03-10 19:22:06.807  INFO 22132 --- [pool-1-thread-1] c.a.s.a.t.c.impl.TesterExecTask          : Starting processing testsuite filename : TSuite_win7_D1_D2_D3_2
		2019-03-10 19:22:06.807  INFO 22132 --- [pool-1-thread-2] c.a.s.a.t.c.impl.TesterExecTask          : Starting processing testsuite filename : TSuite_win10_D1_D2_D3_12
		2019-03-10 19:22:06.807  INFO 22132 --- [pool-1-thread-2] c.a.s.a.tester.utils.TesterUtil          : Inside TesterUtil.getTestSuiteModel() with filename : TSuite_win10_D1_D2_D3_12
		2019-03-10 19:22:06.807  INFO 22132 --- [pool-1-thread-1] c.a.s.a.tester.utils.TesterUtil          : Inside TesterUtil.getTestSuiteModel() with filename : TSuite_win7_D1_D2_D3_2
		2019-03-10 19:22:06.807  INFO 22132 --- [pool-1-thread-2] c.a.s.assignment.tester.data.TestSuites  : Test suite exists
		2019-03-10 19:22:06.807  INFO 22132 --- [pool-1-thread-1] c.a.s.assignment.tester.data.TestSuites  : Test suite exists
		2019-03-10 19:22:06.807  INFO 22132 --- [pool-1-thread-1] c.a.s.a.t.c.impl.TesterExecTask          : Executing TSuite2 on TestSystem3 it will take 2 minutes to complete
		2019-03-10 19:22:06.807  INFO 22132 --- [pool-1-thread-2] c.a.s.a.t.c.impl.TesterExecTask          : Executing TSuite12 on TestSystem5 it will take 12 minutes to complete
		2019-03-10 19:22:08.817  INFO 22132 --- [pool-1-thread-1] c.a.s.assignment.tester.utils.SendMail   : >>> sendEmail >>>
		2019-03-10 19:22:08.832  INFO 22132 --- [pool-1-thread-1] c.a.s.assignment.tester.utils.SendMail   : Unable to send email. Please see log : Local address contains control or whitespace
		2019-03-10 19:22:08.832  INFO 22132 --- [pool-1-thread-1] c.a.s.assignment.tester.utils.SendMail   : Test Suite TSuite2 executed successfully
		2019-03-10 19:22:08.832  INFO 22132 --- [pool-1-thread-1] c.a.s.assignment.tester.utils.SendMail   : <<< sendEmail <<<
		2019-03-10 19:22:18.823  INFO 22132 --- [pool-1-thread-2] c.a.s.assignment.tester.utils.SendMail   : >>> sendEmail >>>
		2019-03-10 19:22:18.823  INFO 22132 --- [           main] c.a.s.a.t.AdvantesttestertoolApplication : APPLICATION FINISHED
		2019-03-10 19:22:18.823  INFO 22132 --- [pool-1-thread-2] c.a.s.assignment.tester.utils.SendMail   : Unable to send email. Please see log : Local address contains control or whitespace
		2019-03-10 19:22:18.823  INFO 22132 --- [pool-1-thread-2] c.a.s.assignment.tester.utils.SendMail   : Test Suite TSuite12 executed successfully
		2019-03-10 19:22:18.823  INFO 22132 --- [pool-1-thread-2] c.a.s.assignment.tester.utils.SendMail   : <<< sendEmail <<<

