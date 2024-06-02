# Burrito King Program - Assignment 2 - s4023336

1) IDE used and IDE version:

	The IDE used is Eclipse and the version is 2023-12

2) Java version, JavaFX version, Database:
	
	The Java version used is 1.8.0_411
	The JavaFX version used is 22.0.1 Windows x64
	The database used is SQLiteStudio, version - 3.4.4

3) Steps to install and run the code:


4) Class Diagram:



Functionalities Achieved:

Sign-up: New users have the option to signup to the program.

Login: Existing users can login into the program using their respective usernames and passwords.



Ordering System (Cart): Users can choose from a menu that includes meals, fries, sodas, and burritos. 
The quantity of each item they want to order can be entered. 
In order to avoid mistakes, the application gracefully handles negative input values.



Class Design:

The program is divided into several classes to encapsulate different functionalities:

Main Class (Main.java): Contains the main method to start the program. Instantiates the Menu class to display the main menu.

Menu Class (Menu.java): Manages the main menu options. Allows users to order food items, view sales reports, and update prices.

Kitchen Class (Kitchen.java): Handles food ordering functionality. Processes user input for ordering food items. Calculates total sales and manages transactions.

Management Class (Management.java): Calculates and displays sales reports. Processes transactions and calculates change for payments.

Data Class (Data.java): Stores static data such as food prices, total items sold, and total sales.

Update Class (Update.java): Manages the functionality to update food item prices.

Preparation Class (Preparation.java): Handles the preparation of food items (burritos, fries, and meals). Calculates preparation times and manages remaining unsold fries.
