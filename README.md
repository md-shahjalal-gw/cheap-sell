# cheap-sell
**Running Requirements:** To run the project you must install:
- Groovy
- Grails
- MySQL 
- RabbitMQ

**Build Process** Run one of the following commands
- ./gradlew clean build
- gradle clean build

**Running Process**
- grails run-app

**Settings:** User name and password and other configuration must be updated in application.yml and application.groovy.

**Version information:** Version information available at build.gradle

**List of Forms**
- Registration
- Login
- Forget Password
- Item
- Wish List
- Cart
- Credit Information
- User Profile
- Buy Item
- Sell Item
- Search Item

**List of Major Plugins**
- rabbitmq: Messaging queue
- smartystreets: For address verification
- joda-time: For date calculation
- mysql-connector: Database connection
- spring-security: Authentication
- mail: Email

**System Function**
- User registration
- User authentication
- Password management
- Role Management
- Create Buyer/Seller profile
- Create Product profile
- Verify Buyer/Seller
- Post Item
- Search Item
- Buy Item
- Price estimation based on usage, condition, purchase price and date
- Give item for free
- Transaction Management for concurrency
- Add to/Remove from cart
- Credit card information
- Credit card verification
- Address verification 
- Price estimation
- Maintaining wish list
- Notify user when item from wish list is available
- System load management by using Messaging queue
