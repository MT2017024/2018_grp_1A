package code;

import java.awt.*;
import java.awt.geom.*;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Cartesian {
	public static double[][] arr1=new double[2][10];
	public static double[][] arr2=new double[2][10];
 public static void cmain() {
	// System.out.println("cartesaina");
  SwingUtilities.invokeLater(new Runnable() {
   
   @Override
   public void run() {
    CartesianFrame frame = new CartesianFrame();
    frame.showUI();
   }
  });
 }

}

class CartesianFrame extends JFrame {
 CartesianPanel panel;
 
 public CartesianFrame() {
  panel = new CartesianPanel();
  add(panel);
 }
 
 public void showUI() {
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setTitle("Cartesian");
  setSize(700, 700);
  setVisible(true);
 }
}

class CartesianPanel extends JPanel {
 // x-axis coord constants
 public static final int X_AXIS_FIRST_X_COORD = 50;
 public static final int X_AXIS_SECOND_X_COORD = 600;
 public static final int X_AXIS_Y_COORD = 600;
 
 // y-axis coord constants
 public static final int Y_AXIS_FIRST_Y_COORD = 50;
 public static final int Y_AXIS_SECOND_Y_COORD = 600;
 public static final int Y_AXIS_X_COORD = 50;
 
 //arrows of axis are represented with "hipotenuse" of 
 //triangle
 // now we are define length of cathetas of that triangle
 public static final int FIRST_LENGHT = 10;
 public static final int SECOND_LENGHT = 5;
 
 // size of start coordinate lenght
 public static final int ORIGIN_COORDINATE_LENGHT = 6;
 
 // distance of coordinate strings from axis
 public static final int AXIS_STRING_DISTANCE = 20;
 
 
 public void paintComponent(Graphics g) {
  
  super.paintComponent(g);
  
  Graphics2D g2 = (Graphics2D) g;
  
  g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
    RenderingHints.VALUE_ANTIALIAS_ON);
  
  // x-axis
  g2.drawLine(X_AXIS_FIRST_X_COORD, X_AXIS_Y_COORD,
     X_AXIS_SECOND_X_COORD, X_AXIS_Y_COORD);
  // y-axis
  g2.drawLine(Y_AXIS_X_COORD, Y_AXIS_FIRST_Y_COORD,
     Y_AXIS_X_COORD, Y_AXIS_SECOND_Y_COORD);
  
  // x-axis arrow
  g2.drawLine(X_AXIS_SECOND_X_COORD - FIRST_LENGHT,
     X_AXIS_Y_COORD - SECOND_LENGHT,
     X_AXIS_SECOND_X_COORD, X_AXIS_Y_COORD);
  g2.drawLine(X_AXIS_SECOND_X_COORD - FIRST_LENGHT,
    X_AXIS_Y_COORD + SECOND_LENGHT,
    X_AXIS_SECOND_X_COORD, X_AXIS_Y_COORD);
  
  // y-axis arrow
  g2.drawLine(Y_AXIS_X_COORD - SECOND_LENGHT,
     Y_AXIS_FIRST_Y_COORD + FIRST_LENGHT,
     Y_AXIS_X_COORD, Y_AXIS_FIRST_Y_COORD);
  g2.drawLine(Y_AXIS_X_COORD + SECOND_LENGHT, 
     Y_AXIS_FIRST_Y_COORD + FIRST_LENGHT,
     Y_AXIS_X_COORD, Y_AXIS_FIRST_Y_COORD);
  
  // draw origin Point
  g2.fillOval(
    X_AXIS_FIRST_X_COORD - (ORIGIN_COORDINATE_LENGHT / 2), 
    Y_AXIS_SECOND_Y_COORD - (ORIGIN_COORDINATE_LENGHT / 2),
    ORIGIN_COORDINATE_LENGHT, ORIGIN_COORDINATE_LENGHT);
  
  // draw text "X" and draw text "Y"
  g2.drawString("X", X_AXIS_SECOND_X_COORD - AXIS_STRING_DISTANCE / 2,
     X_AXIS_Y_COORD + AXIS_STRING_DISTANCE);
  g2.drawString("Y", Y_AXIS_X_COORD - AXIS_STRING_DISTANCE,
     Y_AXIS_FIRST_Y_COORD + AXIS_STRING_DISTANCE / 2);
  g2.drawString("(0, 0)", X_AXIS_FIRST_X_COORD - AXIS_STRING_DISTANCE,
     Y_AXIS_SECOND_Y_COORD + AXIS_STRING_DISTANCE);
  
  // numerate axis
  int xCoordNumbers = 10;
  int yCoordNumbers = 10;
  int xLength = (X_AXIS_SECOND_X_COORD - X_AXIS_FIRST_X_COORD)
      / xCoordNumbers;
  int yLength = (Y_AXIS_SECOND_Y_COORD - Y_AXIS_FIRST_Y_COORD)
      / yCoordNumbers;
  
  // draw x-axis numbers
  for(int i = 1; i < xCoordNumbers; i++) {
   g2.drawLine(X_AXIS_FIRST_X_COORD + (i * xLength),
     X_AXIS_Y_COORD - SECOND_LENGHT,
     X_AXIS_FIRST_X_COORD + (i * xLength),
     X_AXIS_Y_COORD + SECOND_LENGHT);
   g2.drawString(Integer.toString(i), 
     X_AXIS_FIRST_X_COORD + (i * xLength) - 3,
     X_AXIS_Y_COORD + AXIS_STRING_DISTANCE);
  }
  
  //draw y-axis numbers
  for(int i = 1; i < yCoordNumbers; i++) {
   g2.drawLine(Y_AXIS_X_COORD - SECOND_LENGHT,
     Y_AXIS_SECOND_Y_COORD - (i * yLength), 
     Y_AXIS_X_COORD + SECOND_LENGHT,
     Y_AXIS_SECOND_Y_COORD - (i * yLength));
   g2.drawString(Integer.toString(i), 
     Y_AXIS_X_COORD - AXIS_STRING_DISTANCE, 
     Y_AXIS_SECOND_Y_COORD - (i * yLength));
  }
     final int PAD = 20;
     int h= getHeight();
     int w= getWidth();
  //   System.out.println("h : "+h);
   //  System.out.println("w : "+w);
     int[] data = {
        21, 14, 18, 03, 86, 88, 74, 87, 54, 77,
        61, 55, 48, 60, 49, 36, 38, 27, 20, 18
    };
     double xInc = (double)(w - 2*PAD)/(data.length-1);
        double scale = (double)(h - 2*PAD)/88;
     //final int PAD = 20;
     
     
     
        // Mark data points.
      //  g2.setPaint(Color.green);
        for(int i = 0; i < data.length; i++) {
         ////   double x = PAD + i*xInc;
          ////  double y = h - PAD - scale*data[i];
            double x = PAD + i;
            double y = h - PAD - scale*data[i];
           
            g2.fill(new Ellipse2D.Double(x, y, 4, 4));
        }
 }
}