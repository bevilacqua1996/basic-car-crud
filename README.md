# Basic Car Crud

Basic CRUD with Integration Tests and connection with MongoDB

## How to run

``mvn spring-boot:run``

Make sure that you set a *MongoDB* connection on your _application.properties_.

Example: 
``spring.data.mongodb.uri=mongodb://<MONGO_DB_USER>:<MONGO_DB_PWD>@ac-gak5z3o-shard-00-00.clyunur.mongodb.net:27017,ac-gak5z3o-shard-00-01.clyunur.mongodb.net:27017,ac-gak5z3o-shard-00-02.clyunur.mongodb.net:27017/?ssl=true&replicaSet=atlas-bpsrr0-shard-0&authSource=admin&retryWrites=true&w=majority``

## Integration Tests

This project uses _testcontainers_ dependency in order to execute Integration tests with MongoDB database.
Make sure you have Docker installed on your environment.

``mvn verify``

_Verify_ step will execute integration tests. To do that, a MongoDB container will be created on your local environment. If you don't have MongoDB image, it will be downloaded as well during the process. 

## Want to know more about?

You can see more in the article that I have writen in Substack in this link: [Substack article]([https://pages.github.com/](https://bevilacqua96.substack.com/p/initialize-and-test-integration-between)https://bevilacqua96.substack.com/p/initialize-and-test-integration-between)
