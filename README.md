# Burrito King Program

Application Summary:

A basic Java application called Burrito King imitates the ordering process for meals at the fictional "Burrito King" restaurant. In addition to ordering meals, fries, sodas, and burritos, it also generates a sales report and totals sales. The application has the ability to change food item pricing as well.

Functionalities Achieved:

Ordering System: Users can choose from a menu that includes meals, fries, sodas, and burritos. The quantity of each item they want to order can be entered. In order to avoid mistakes, the application gracefully handles negative input values.

Sales Report: Generates a sales report displaying the total number of items sold and total sales for each item category. Also displays the number of unsold fries left in stock.

Price Update: Enables the user to change the cost of sodas, fries, and burritos. Displays the current prices of all food items.

Class Design:

The program is divided into several classes to encapsulate different functionalities:

Main Class (Main.java): Contains the main method to start the program. Instantiates the Menu class to display the main menu.

Menu Class (Menu.java): Manages the main menu options. Allows users to order food items, view sales reports, and update prices.

Kitchen Class (Kitchen.java): Handles food ordering functionality. Processes user input for ordering food items. Calculates total sales and manages transactions.

Management Class (Management.java): Calculates and displays sales reports. Processes transactions and calculates change for payments.

Data Class (Data.java): Stores static data such as food prices, total items sold, and total sales.

Update Class (Update.java): Manages the functionality to update food item prices.

Preparation Class (Preparation.java): Handles the preparation of food items (burritos, fries, and meals). Calculates preparation times and manages remaining unsold fries.
