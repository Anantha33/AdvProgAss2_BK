module AdvProg_Assignment2 {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	requires javafx.base;
	requires javafx.graphics;
	requires junit;
	
	opens BurritoKing_A2 to javafx.graphics, javafx.fxml, javafx.base;
}
