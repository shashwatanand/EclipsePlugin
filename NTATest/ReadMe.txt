Readme - NTA Homework
====================================================================

Launching the application :
--------------------------------------------------------------------

1) Extract the NTATest.zip 
2) Goto NTATest\executable
3) You will find nashtechhw.exe, which is used to lanuch the application.
4) Once the application is launched, then click on select file button to select the input file (I kept input.txt at NTATest folder which I used for my testing).
5) Once the file is selected, you can click on Load File Button which will load the file.
6) If there is any error in pattern or duplicate tuples are present, then application will show error at the bottom part in RED color.
7) If the file is loaded without any issue, application will display 3 widgets  1) Select Query combo, 2) Search, 3) Dump result to file. 
8) You can select 4 kinds of search query, by ID, by Name, by Pattern and by Flag.
9) Once you select the type of query, then you can write your search item and click Search button.
10) On success, application will show output in GREEN color and for failuer it will show output in RED color.
11) For search by flag, checkbox can be used to pass true and false value for searching. Check box needs to be checked for true and unchecked for false.
12) When you want to dump the results to file then click on Dump results to file.
13) Then file dialog will open, where you need to select the file where you want to dump the result. Only GREEN color output will be dumped in file.
14) If file is of known type like .txt, the application will try to lanuch the configured windows application (like notepad) for output file. (Tested on Windows 7)


Source structure:
--------------------------------------------------------------------

In NTATest folder you will find code folder where there are 4 plugins
1) com.nashtech.hw.shashwat.parent - This contains pom for packging eclipse plugins used maven tycho.
2) com.nashtech.hw.shashwat.app - This plugin in the main eclipse plugin of application.
3) com.nashtech.hw.shashwat.app.test - This plugin is test plugin which has Junit tests.
4) com.nashtech.hw.shashwat.product - This plugin is having eclipse product file which is used to gererate application.exe