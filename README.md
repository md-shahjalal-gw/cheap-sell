# cheap-sell: The hundred dollar shop
**Presentation Slide** [Slide](https://docs.google.com/presentation/d/1P50tzUtDCGKjlweBPq8L2sOVu1GoQDx1MfVYJh9guw4/edit#slide=id.g61ba13d400_0_5)

**Presentation Video** [Video](https://drive.google.com/file/d/1CLRtYNFWZROAElaZTawrsgoadsP2Thmq/view)

**Google Drive** [Drive](https://drive.google.com/drive/folders/1NQdiA0By_d9yk7ABQ93cuweIZmiHzZun?usp=sharing)

**Running Requirements**
- Groovy
- Grails
- MySQL 
- RabbitMQ

**Build Process** Run one of the following commands
- ./gradlew clean build
- gradle clean build

**Running Process**
- grails run-app

**Settings:** User name and password and other configuration must be updated in [application.yml](https://github.com/md-shahjalal-gw/cheap-sell/blob/master/grails-app/conf/application.yml) and [application.groovy](https://github.com/md-shahjalal-gw/cheap-sell/blob/master/grails-app/conf/application.groovy).

**Version information:** Version information available at [build.gradle](https://github.com/md-shahjalal-gw/cheap-sell/blob/master/build.gradle)

**Initializer:** [BootStrap](https://github.com/md-shahjalal-gw/cheap-sell/blob/master/grails-app/init/cheap/sell/BootStrap.groovy)

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
- Email verification
- User authentication
- Password management
- Role management
- Create Buyer/Seller profile
- Create product profile
- Verify Buyer/Seller
- Post item
- Search item
- Buy item
- Price estimation based on usage, condition, purchase price and date
- Give item for free
- Transaction management for concurrency
- Add to/Remove from cart
- Credit card information
- Credit card verification
- Address verification 
- Price estimation
- Maintaining wish list
- Notify user when item from wish list is available
- System load management by using Messaging queue
