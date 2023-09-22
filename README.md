# Bank Management Application 
## Overview
This Java-based project is a bank management system. It consists of several classes representing various aspects of the banking system, including actors (customers and managers), account levels, and user interface components. The project primarily focuses on user authentication, customer management, and basic banking operations. The project integrates with an SQLite database to store customer and manager information. It retrieves and updates data from this database as needed for authentication and customer management. SHA256 is used for password hashing to ensure security. 

## Project Functionality

- Users can log in as either customers or managers.
- Customers can view their account balance and account level (Silver, Gold, Platinum).
- Customers can withdraw and deposit funds, with their account level determining transaction fees.
- Managers can add and remove customers from the system.
- User authentication is performed securely using SHA-256 password hashing.
- The project utilizes JavaFX for a user-friendly graphical interface.

## Video Demo
<iframe width="560" height="315" src="https://www.youtube.com/embed/VIDEO_ID_HERE" frameborder="0" allowfullscreen></iframe>

## Class Descriptions

### Actor Class
- This class serves as the base class for all actors in the system, such as customers and managers.
- It encapsulates properties for username, password, and role.
- The constructor initializes these properties.
- Methods for setting and getting these properties are provided.
- It includes a `LoginCheck` method for user authentication, which is overridden by subclasses.

### Customer Class
- Extends the Actor class and represents bank customers.
- Contains properties for the customer's account level and fee.
- The `changeLevels` method updates the customer's account level based on their balance.
- Methods for retrieving the fee and account level are provided.
- Additional methods are available for managing the customer's balance.

### Manager Class
- Also extends the Actor class and represents bank managers.
- Provides methods for authenticating as a manager, adding customers, and removing customers from the database.

### Levels Class
- An abstract class representing different account levels (Silver, Gold, Platinum).
- Defines abstract methods for calculating fees and retrieving the level name.

### Gold, Platinum, and Silver Classes
- Subclasses of the Levels class, each representing a specific account level with its associated fee.

### SHA256 Class
- A utility class for performing SHA-256 hashing.

### Bank Class
- The entry point of the application.
- Utilizes JavaFX for creating a graphical user interface (GUI).
- Handles user logouts.

## Controller Classes

#### LoginController Class
- Acts as the controller for the login functionality.
- Handles user authentication and navigation to manager or customer windows after login.
- Utilizes SHA-256 hashing for password security.

#### Manager_WindowController Class
- Manages the manager's window, allowing managers to add and remove customers from the system and log out.

#### Customer_WindowController Class
- Controls the customer's window, displaying customer-specific information like balance and account level.
- Allows customers to perform banking operations such as withdrawals and deposits and provides a logout option.

