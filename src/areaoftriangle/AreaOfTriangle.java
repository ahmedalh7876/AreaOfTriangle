/*
 * Author: Ahmed Al-Hayali
 * Date of Completion: 19/02/2020
 * This program calculates and displays the area of a scalene triangle when a user inputs an angle and 3 side lengths.
 */
package areaoftriangle;

import javax.swing.JOptionPane;

/**
 *
 * @author Ahmed
 */
public class AreaOfTriangle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        //Declares and initializes the boolean "userDone" to indicate whether the user is done using the program.
        boolean userDone = false;

        //Initiates a while loop to prompt user for input when the boolean userDone is false.
        while (userDone == false) {
            
            //Try statement to ensure any exceptions caused by taking input from the user are caught.
            try {
                //Wanted to use JOptionPane.showConfirmDialog() to give option between providing side C or angle C but not sure how to use it yet.

                //Declares and initializes all appropriately named variables and prompts user for input, all while parsing to a double value.
                double C = Double.parseDouble(JOptionPane.showInputDialog("Please enter the known angle ∠C in degrees"));
                double c = Double.parseDouble(JOptionPane.showInputDialog("Please enter the reasonable length of side c, opposite to angle ∠C"));
                double a = Double.parseDouble(JOptionPane.showInputDialog("Please enter the reasonable length of side a, adjacent to side c but opposite to side b"));
                double b = Double.parseDouble(JOptionPane.showInputDialog("Please enter the reasonable length of side b, adjacent to side c but opposite to side a"));
                
                //Declares and initializes semiperimeter variable.
                double s = (a + b + c) / 2;
                
                //Declares and calculates the area of the triangle according to Heron's formula and trigonometry respectively.
                double areaHeron = Math.sqrt((s) * (s - a) * (s - b) * (s - c));
                //The areaTrig calculation gives the incorrect answer if the user provides the incorrect angle to produce side c in the triangle.
                double areaTrig = (a * b * Math.sin(Math.toRadians(C))) / 2;
                
                //Outputs the area of the triangle using both methods.
                System.out.println("Using Heron's formula, the area of the triangle is approximately " + (int) Math.ceil(areaHeron) + " units squared.");
                System.out.println("Using trigonometry, the area of the triangle is approximately " + (int) Math.ceil(areaTrig) + " units squared.");
                
                //Setting the boolean userDone to true to end the while loop since user has successfully run program with valid inputs.
                userDone = true;

                //Catch statement catches a number format exception in case the user inputs a non-numeric value, preventing crashing.
            } catch (NumberFormatException e) {
                //In red text, the user is told that his or her input cannot be processed, which allows the program to run again.
                System.err.println("Please don't do that :(, your input cannot be processed.");

                //Second catch statement catches a null pointer exception to cleanly exit program without error text.
            } catch (NullPointerException e) {
                //Outputs text to inform the user the program is being exited from.
                System.out.println("Exiting Program");
                //Converts userDone boolean to true to stop the while loop from running again, thus terminating program. Can also be done using System.exit(0).
                userDone = true;

            }
        }

    }
}
