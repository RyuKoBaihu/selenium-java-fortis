This project aims to simulate a client buying an item on the test website "Saucedemo".


Following the security recomendations the user.properties that contains the username and password are in gitignore so for your tests you should create one.

The Saucedemo website provides the username and password standard that are:


username = standard_user

password = secret_sauce

So, you should create in the folder resources (path: src/test/resources/application.properties) a file user.properties and put the username and password provided above.
