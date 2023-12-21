Cash and Carry System

This system incorporates functionalities pertinent to admin and customer roles, facilitating various operations within a store-like environment.

Admin Class
Account Creation:
Enables creation of admin accounts with customized usernames and passwords.
Subsequently, allows admin login authentication.

Art Class
Holds a graphical representation (ASCII art) of the cash and carry title.
Cart Class
Manages the customer's cart.
Facilitates addition, removal, and viewing of products in the cart.
Generates an invoice as a text summary of the cart contents.

CashAndCarry Class
Main entry point of the system.
Offers interactive menus for both admin and customer functionalities.
Admin Features:
View, add, update, and remove items in the store.
Customer Features:
View store items, add to cart, view cart, remove items from cart, and email the invoice.

Customer Class
Inherits from the User class, managing customer-specific functionalities.
Allows creation of customer accounts with username and password.

EmailSender Class
Facilitates sending emails, including attachments, utilizing SMTP properties.

Product Class
Represents a product within the system.
Manages product attributes such as name, price, and quantity.
Supports operations like decreasing quantity and displaying product details.

ProductManager Class
Singleton class managing the list of products available in the store.
Handles operations like adding, updating, removing, and viewing products.
Allows product quantity management and finding products by ID.

User Class
Base class for user-related functionalities.
Holds user-specific details like username, ID, and password.
Authenticates user login credentials.
