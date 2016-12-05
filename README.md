# Guess It

'Guess It' is developed to demonstarte 'Information Theory' under 'CS Unplugged' activities.

  - Tools and Technologies - Java , Greenfoot, MongoDb.
  - Deployed on Heroku container.
  
## Compiler Instruction

### Requirements

* Java JDK Version 1.8
* Greenfoot Version 3.0.4
* MongoDb (mLab)
* Eclipse Mars Release (4.5.0)
* Tomcat 1.7.0

And of course Dillinger itself is open source with a [public repository][dill]
 on GitHub.

### Installation

* GuessIt requires Java 1.8. Download it and add bin folders path to system path.Install [Java 1.8](http://www.oracle.com/technetwork/java/javase/downloads/java-archive-javase8-2177648.html#jdk-8u102-oth-JPR)
* Download and install [Greenfoot](http://www.greenfoot.org/download).
* Clone this repository to your local machine and click on 'project' icon.This will open the game in greenfoot ide.

### Database SetUp

We are using mongodb, hosted on mLab for storing game's information. Otherwise you can also use [mLab database connection URL]("mongodb://guessitadmin:techadmin@ds151137.mlab.com:51137/guessit")

#### Steps to create your own databse
Create an account in [mLab](https://mlab.com/) and add a new deployement database using 'Create' button.Cloud provider will be Amazon AWS Single Node Cluster.Provide deployment's name as 'guessit'.
Now copy the MongoDB URI.You can use this uri in web service to store and get data.

Install the dependencies and devDependencies and start the server.

### Deployment in Heroku
Guessit's webservice is very easy to modify and deploy in a Heroku Container.
By default, pom.xml is added to take care of the deployement process. So in your eclipse project you have to do this following steps to deploy webservice in cloud.
* Login to Heroku and create an app.
* Set this app name in pom.xml under 
<plugin>
      	<groupId>com.heroku.sdk</groupId>
      	   <artifactId>heroku-maven-plugin</artifactId>
      	   <version>0.3.4</version>
      	   <configuration>
      	      <appName>app_name</appName>
      	   </configuration>
</plugin>
* Click on Project-> Run As -> Maven build
* Give a name to this deployment logic.i.e. guessit_deployment
* Include 'heroku:deploy-war' in goals field
* Go to tab environment add a new venvironment variable with name 'HEROKU_API_KEY'
* Now Click on 'Run'.

Everytime you change code, you first need to use 'maven claen', 'maven install' and lastly deploy using 'maven-build'(using guessit_deployment configuration)

More details steps can be found [here](https://devcenter.heroku.com/articles/deploying-java-applications-to-heroku-from-eclipse-or-intellij-idea#deploying-from-eclipse)

License
----

MIT

**Free Software, Hell Yeah!**

