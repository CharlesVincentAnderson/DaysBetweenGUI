/***************************************************************************************************************
 * This program creates a menu where "days between" can be selected and the code can be expanded at a later date.
 * Once the days between button has been pressed a new window is created where the user can enter two dates 
 * and find out how many days are in between.
 ***************************************************************************************************************/


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class DaysBetweenGUI extends Application {
	
	int numDays = 0;
	
	@Override 
	public void start(Stage primaryStage) {
		
		// Create a pane and set its properties 
		GridPane pane = new GridPane(); 
		pane.setAlignment(Pos.CENTER); 
		pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5)); 
		pane.setHgap(5.5); 
		pane.setVgap(5.5); 
		
		// Place nodes in the pane 
		Button numDaysButton = new Button("Find Number of Days Between 2 Dates");
		pane.add(numDaysButton, 0, 0); 
	
		// Create a scene and place it in the stage 
		Scene scene = new Scene(pane); 
		primaryStage.setTitle("Menu Main");  
		primaryStage.setScene(scene); 
		primaryStage.show(); 
		
		//Days between dates button pressed
		numDaysButton.setOnAction (new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				
				// Create a pane and set its properties
				GridPane paneDates = new GridPane(); 
				paneDates.setAlignment(Pos.CENTER); 
				paneDates.setPadding(new Insets(11.5, 12.5, 13.5, 14.5)); 
				paneDates.setHgap(5.5); 
				paneDates.setVgap(5.5);
				
				//create and place TextFields to enter start/end dates
				TextField startDayText = new TextField("Starting Day");
				paneDates.add(startDayText, 0, 0);
				TextField startMonthText = new TextField("Starting Month");
				paneDates.add(startMonthText, 0, 1);
				TextField startYearText = new TextField("Starting Year");
				paneDates.add(startYearText, 0, 2);
				TextField endDayText = new TextField("Ending Day");
				paneDates.add(endDayText, 1, 0);
				TextField endMonthText = new TextField("Ending Month");
				paneDates.add(endMonthText, 1, 1);
				TextField endYearText = new TextField("Ending Year");
				paneDates.add(endYearText, 1, 2);
				
				//create Button to calculate days
				Button calcDays = new Button("Calculate Number of Days");
				paneDates.add(calcDays, 2, 0); 

				//create Label and TextArea to display number of days
				TextArea numDaysArea = new TextArea("");
				numDaysArea.setMaxHeight(1);
				numDaysArea.setMaxWidth(10);
				Label numDaysLabel = new Label("Number Of Days = ");
				paneDates.add(numDaysLabel, 2, 1);
				paneDates.add(numDaysArea, 3, 1);
				
				//Calculate days between dates button pressed
				calcDays.setOnAction (new EventHandler<ActionEvent>() {
					public void handle(ActionEvent e) {
						
						//Input validation
						if ((Integer.valueOf(startYearText.getText()) >= 1000) &&  ((Integer.valueOf(startYearText.getText()) <= 3000)) && 
							((Integer.valueOf(startMonthText.getText()) >= 1)) && ((Integer.valueOf(startMonthText.getText()) <= 12))  &&
							((Integer.valueOf(startDayText.getText()) >= 1)) && ((Integer.valueOf(startDayText.getText()) <= 31)) && 
							((Integer.valueOf(endYearText.getText()) >= 1000)) && ((Integer.valueOf(endYearText.getText()) <= 3000)) &&
							((Integer.valueOf(endMonthText.getText()) >= 1)) && ((Integer.valueOf(endMonthText.getText()) <= 12)) && 
							((Integer.valueOf(endDayText.getText()) >= 1)) && ((Integer.valueOf(endDayText.getText()) <= 31))) {
						
						//Create start and end dates
						Calendar start = new GregorianCalendar(Integer.valueOf(startYearText.getText()), Integer.valueOf(startMonthText.getText()), 
																		Integer.valueOf(startDayText.getText()));
						Calendar end = new GregorianCalendar(Integer.valueOf(endYearText.getText()), Integer.valueOf(endMonthText.getText()), 
																	  Integer.valueOf(endDayText.getText()));
						
						
						//Calc number of days by calling getNumDays
						numDays = getNumDays(start, end);
						
						//Display number of days
						numDaysArea.setText(String.valueOf(numDays));
						}//if
						
						else {
							startYearText.setText("Enter a valid year");
							startMonthText.setText("Enter a valid month");
							startDayText.setText("Enter a valid day");
							endYearText.setText("Enter a valid year");
							endMonthText.setText("Enter a valid month");
							endDayText.setText("Enter a valid day");
						}//else
					}//handle
				});//calcDays EventHandler
				
				
				// Create a scene and place it in the stage 
				Scene sceneDates = new Scene(paneDates);
				Stage stageDates = new Stage(); 
				stageDates.setTitle("Number of days"); 
				stageDates.setScene(sceneDates); 
				stageDates.show(); 
				
			}//handle
		});//numDays Eventhandler
		
		
			
	}//start
	
	public static void main(String[] args) {
	    launch(args);
	}//main
	
	public int getNumDays(Calendar d1, Calendar d2) {
		return (int)( (d2.getTime().getTime() - d1.getTime().getTime()) / (1000 * 60 * 60 * 24));
	}//getNumDays(GregorianCalendar d1, GregorianCalendar d2)

}//class
