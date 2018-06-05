# dell_test

Hello and welcome do Dell Test application.
This read me will cover two major points, how to setup the application and how to verify its functionality.

1.Application Setup

a.Source code

If you have the source code you need to have Java 8 installed on local machine and Maven 3.0 +.
After you check these please open a command console and navigate to the location of the sources in the root folder (the 
folder that contains the pom.xml file for the project).
 Once there please run the "mvn clean install" command.
 This command should clean the workspace and build a new JAR archive that you can use to deploy on a server.
 If the command finished succesfully then in the "target" folder you should find an archive called 
 "dell_test-1.0-SNAPSHOT.jar" or something similar.  

b.JAR file

After completing point a. or if you recieved the JAR file directly then we can continue.
Now deppending on what application server you have installed you need to do the following. In this example we will 
use a Tomcat application server example.
Another prerequisite is to have a MySql DB installed and a schema called "dell_test" and a table named "customer" 

Navigate to tomcat\webapps folder and copy the JAR archive here.
Start the Tomcat server and the application will be deployed automatically.

2.Testing the application

Now after the server has started and the application was deployed without any errors is time to test the implemetation.
To do that we can first check if the application is responding. To do that you can open a web browser and type 
"http://localhost:8080/" (default port in case you have different settings on your Tomcat)
If everything is fine then you should see a "Hello There" message. This is another confirmation that the application 
has been deployed properly.

Now for the customer functionality we need to make a POST request to the server. In our example we use a chrome 
extension called Postman.
Here we set the url to "http://localhost:8080/addOrUpdateCustomer", the method to "POST" and the request body to the 
following

{
	"name":"testName",
	"mail":"test@mail.com",
	"comment":"test comment "
}

After this press the send button and if everything is configured correctly you should recive the following message

{
    "id": 1,
    "name": "testName",
    "mail": "test@mail.com",
    "comment": "test comment ",
    "responseMessage": "Customer was successfully created"
}

You can also check all the added values in the MySql schema.
You can also find a sample.txt file where you have the request example in a more simplified way for easier use.

3.Conclusion

This was the small setup and testing tutorial of the application. If there were any errors or issues with the setup 
or functionality of it please don't hesitate to contact the developer for more information.

