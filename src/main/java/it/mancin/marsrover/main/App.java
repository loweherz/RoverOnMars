package it.mancin.marsrover.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.logging.Logger;

import it.mancin.marsrover.Coordinates;
import it.mancin.marsrover.Direction;
import it.mancin.marsrover.Point;
import it.mancin.marsrover.Rover;

public class App {

	static int xMax, yMax;
	
	public static void main(String[] args) throws Exception {
		System.out.println("Welcome on Mars!\n");
		
        final BufferedReader in = new BufferedReader(new FileReader("input.txt"));

        final String grid = in.readLine();
        final String[] dimensions = grid == null ? new String[] { "5", "5" } : grid.split(" ");
        xMax = Integer.parseInt(dimensions[0]);
        yMax = Integer.parseInt(dimensions[1]);

        String position1[], position2[], instructions1, instructions2;
        
        try{
	        position1 = in.readLine().split(" ");
	        instructions1 = in.readLine();
	        
	        position2 = in.readLine().split(" ");
	        instructions2 = in.readLine();
        }
        catch(Exception e){
        	System.err.println(e.getMessage());
        	throw new Exception("Error on read input command file.");
        }
        finally {
			in.close();
		}
        
        /*
         * Set Rover1
         * */
        Rover rover1 = new Rover(
        			new Coordinates(
	        					new Point(Integer.valueOf(position1[0]), xMax), 
	        					new Point(Integer.valueOf(position1[1]), yMax), 
	        					Direction.valueOf(position1[2])
        					)
        			);
        
        /*
         * Set Rover2
         * */
        Rover rover2 = new Rover(
    			new Coordinates(
        					new Point(Integer.valueOf(position2[0]), xMax), 
        					new Point(Integer.valueOf(position2[1]), yMax), 
        					Direction.valueOf(position2[2])
    					)
    			);
        
        
        System.out.println("Start position:");
        System.out.println("Rover 1: " + rover1.getPosition());
        System.out.println("Rover 2: " + rover2.getPosition());
        
        /*
         * First Rover
         * */
        System.out.println("\nMove rover1..." + instructions1);
        rover1.receiveCommands(instructions1);
        
        /*
         * Second Rover
         * */
        System.out.println("Move rover2..." + instructions2);
        rover2.receiveCommands(instructions2);
        
        System.out.println("\nLast position:");
        System.out.println("Rover 1: " + rover1.getPosition());
        System.out.println("Rover 2: " + rover2.getPosition());
        
        
        /*
         * Write on file
         * */
        FileWriter fw = new FileWriter(new File("output.txt"));
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(rover1.getPosition());
		bw.write("\r\n");
		bw.write(rover2.getPosition());
		bw.close();
    }

}
