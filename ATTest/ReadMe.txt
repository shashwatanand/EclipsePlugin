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
	shashwat.anand@PIT01NB320 MINGW64 /d/Personal/Projects/code/EclipseDi/ATTest/code/advantesttestertool (master)
	$ java -jar target/advantesttestertool-1.0.jar TSuite_win7_D1_D2_D3_2 TSuite_win7_D1_D2_D3_1
	19:06:12.260 [main] INFO com.advantest.sha.assignment.tester.AdvantesttestertoolApplication - STARTING THE APPLICATION
	2019-03-10 19:06:12.578  INFO 21612 --- [           main] c.a.s.a.t.AdvantesttestertoolApplication : Starting AdvantesttestertoolApplication v1.0 on PIT01NB320 with PID 21612 (D:\Personal\Projects\code\EclipseDi\ATTest\code\advantesttestertool\target\advantesttestertool-1.0.jar started by shashwat.anand in D:\Personal\Projects\code\EclipseDi\ATTest\code\advantesttestertool)
	2019-03-10 19:06:12.579  INFO 21612 --- [           main] c.a.s.a.t.AdvantesttestertoolApplication : No active profile set, falling back to default profiles: default
	2019-03-10 19:06:12.962  INFO 21612 --- [           main] c.a.s.a.t.AdvantesttestertoolApplication : Started AdvantesttestertoolApplication in 0.628 seconds (JVM running for 0.919)
	2019-03-10 19:06:12.963  INFO 21612 --- [           main] c.a.s.a.t.AdvantesttestertoolApplication : EXECUTING : command line runner
	2019-03-10 19:06:13.105  INFO 21612 --- [           main] c.a.s.a.t.c.i.TesterToolControllerImpl   : Inside processArguments
	2019-03-10 19:06:13.107  INFO 21612 --- [pool-1-thread-2] c.a.s.a.t.c.impl.TesterExecTask          : Starting processing testsuite filename : TSuite_win7_D1_D2_D3_1
	2019-03-10 19:06:13.107  INFO 21612 --- [pool-1-thread-1] c.a.s.a.t.c.impl.TesterExecTask          : Starting processing testsuite filename : TSuite_win7_D1_D2_D3_2
	2019-03-10 19:06:13.107  INFO 21612 --- [pool-1-thread-2] c.a.s.a.tester.utils.TesterUtil          : Inside TesterUtil.getTestSuiteModel() with filename : TSuite_win7_D1_D2_D3_1
	2019-03-10 19:06:13.107  INFO 21612 --- [pool-1-thread-1] c.a.s.a.tester.utils.TesterUtil          : Inside TesterUtil.getTestSuiteModel() with filename : TSuite_win7_D1_D2_D3_2
	2019-03-10 19:06:13.109  INFO 21612 --- [pool-1-thread-1] c.a.s.a.t.c.impl.TesterExecTask          : Executing TSuite2 on TestSystem3 it will take 2 minutes to complete
	2019-03-10 19:06:13.109  INFO 21612 --- [pool-1-thread-2] c.a.s.a.t.c.impl.TesterExecTask          : Executing TSuite1 on TestSystem3 it will take 1 minutes to complete
	2019-03-10 19:07:13.114  INFO 21612 --- [pool-1-thread-2] c.a.s.assignment.tester.utils.SendMail   : >>> sendEmail >>>
	2019-03-10 19:07:13.128  INFO 21612 --- [pool-1-thread-2] c.a.s.assignment.tester.utils.SendMail   : Unable to send email. Please see log : Local address contains control or whitespace
	2019-03-10 19:07:13.130  INFO 21612 --- [pool-1-thread-2] c.a.s.assignment.tester.utils.SendMail   : Test Suite TSuite1 executed sucessfully
	2019-03-10 19:07:13.130  INFO 21612 --- [pool-1-thread-2] c.a.s.assignment.tester.utils.SendMail   : <<< sendEmail <<<
	2019-03-10 19:08:13.110  INFO 21612 --- [pool-1-thread-1] c.a.s.assignment.tester.utils.SendMail   : >>> sendEmail >>>
	2019-03-10 19:08:13.110  INFO 21612 --- [pool-1-thread-1] c.a.s.assignment.tester.utils.SendMail   : Unable to send email. Please see log : Local address contains control or whitespace
	2019-03-10 19:08:13.110  INFO 21612 --- [pool-1-thread-1] c.a.s.assignment.tester.utils.SendMail   : Test Suite TSuite2 executed sucessfully
	2019-03-10 19:08:13.110  INFO 21612 --- [pool-1-thread-1] c.a.s.assignment.tester.utils.SendMail   : <<< sendEmail <<<
	2019-03-10 19:09:13.108  INFO 21612 --- [           main] c.a.s.a.t.AdvantesttestertoolApplication : APPLICATION FINISHED

