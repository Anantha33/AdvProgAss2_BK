# Burrito King Program - Assignment 2 - s4023336

1) IDE used and IDE version:

	1.1) The IDE used is Eclipse and the version is 2023-12

2) Java version, JavaFX version, Database:
	
	2.1) The Java version used is 1.8.0_411
	2.2) The JavaFX version used is 22.0.1 Windows x64
	2.3) The database used is SQLiteStudio, version - 3.4.4

3) Steps to install and run the code:
	
	3.1) Import the submitted files, retaining the whole package hierarchy.
	3.2) Modify the module path by adding the necessary javafx jar files.
	3.3) Modify the class path by adding the necessary SQLite jdbc jar file.
	3.4) Run the Main.java file.

4) Class Diagram:



Functionalities Achieved:

Sign-up: New users have the option to signup to the program.

Login: Existing users can login into the program using their respective usernames and passwords.

Dashboard: Orders that are waiting to be collected are shown in the dashboard. The first and last name of the user is 
also shown, along with various other buttons to navigate through the program.

Edit profile: Users have different options to edit either their first name, last name, and/or password.

Ordering System (Cart): Users can choose from a menu that includes meals, fries, sodas, and burritos. 
The quantity of each item they want to order can be entered. 
In order to avoid mistakes, the application gracefully handles negative input values.

Cancel Order: Users have the option to cancel an order that is waiting to be collected.

Collect Order: Users can collect the order they want, provided it is ready to be collected.

View All Orders: Users can view all their orders (newest order first).

Collecting credits (for VIP Users): The program collects credits for each order made by a VIP user.

Redeeming credits (for VIP Users): The program allows VIP users to redeem credits, providing them appropriate discounts,
while collecting credits on the discounted cost.

Logout: Logging out of the dashboard successfully.