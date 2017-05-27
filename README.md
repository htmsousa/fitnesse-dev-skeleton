# fitnesse-dev-skeleton

This project was created just to share my experience while working with FitNesse.

You can search and find tutorials on how to run FitNesse and create new tests cases using custom Fixtures (java code). 
Usually these examples show how to add the "bin" folder of your java project in order to execute your java code, which is OK when the class is really simple.
Example:

`!path c:\projects\projectA\bin`

However, in a real world project, Fixture classes can have a lot of dependencies (other components in your product which are in different projects, external dependencies, etc.) and it will be a lot of work to add all of dependencies to FitNesse using the "!path ..."

This project shows a trick to solve that problem. If you have a Maven project, all dependencies are defined in the pom.xml file. Using a modern IDE that understands those dependencies, it is possible to start a Java Application with the classpath using all those dependencies. 
Creating a java class that wraps Fitnesse start up (like `FitnessApp.java` in this project), it is possible to resolve the current classpath and set it as a System Property like `full.classpath`.
Now, it is only necessary to add the following to the fitnesse page (check FitNesseRoot/_root.wiki file):

`!path ${full.classpath}` 
     
Whenever a test page is executed, all Fixture classes will find their dependencies properly. 

To check this behaviour, check out this project, import it to Eclipse as Maven project and launch `FitnesseApp.java`. Open FitNesse in browser http://localhost/FrontPage.HelloWorld (use the FitNesse parameter `-p 8080` to change the HTTP port if you don't want to use port 80).

After test execution (click in "Test"), click in "Execution Log" and it is possible to see the classpath used in the test.  
