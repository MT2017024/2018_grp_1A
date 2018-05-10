package code;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.*;

@SuppressWarnings("serial")
public class DrawGraph extends JPanel {
	public static int[][] arr1=new int[2][Gen.number];
	public static int[][] arr2=new int[2][Gen.number];
 
   private static final int MAX_SCORE = 20;
   private static final int PREF_W = 1500;
   private static final int PREF_H = 1000;
   private static final int BORDER_GAP = 30;
   private static final Color GRAPH_COLOR = Color.red;
   private static final Color GRAPH_POINT_COLOR = new Color(150, 50, 50, 180);
   private static final Stroke GRAPH_STROKE = new BasicStroke(3f);
   private static final int GRAPH_POINT_WIDTH = 4;
   private static final int Y_HATCH_CNT = 10;
   private ArrayList<Integer> scores;
   int xpre =35,xcur=50;
   public DrawGraph(ArrayList<Integer> scores) {
      this.scores = scores;
   }

   @Override
   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D)g;
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

      double xScale = ((double) getWidth() - 2 * BORDER_GAP) / (scores.size() - 1);
      double yScale = ((double) getHeight() - 2 * BORDER_GAP) / (MAX_SCORE - 1);

      List<Point> graphPoints = new ArrayList<Point>();
      for (int i = 0; i < scores.size(); i++) {
         int x1 = (int) (i * xScale + BORDER_GAP);
         int y1 = (int) ((MAX_SCORE - scores.get(i)) * yScale + BORDER_GAP);
         //graphPoints.add(new Point(x1, y1));
      }

      // create x and y axes 
      g2.drawLine(BORDER_GAP, getHeight() - BORDER_GAP, BORDER_GAP, BORDER_GAP);
      g2.drawLine(BORDER_GAP, getHeight() - BORDER_GAP, getWidth() - BORDER_GAP, getHeight() - BORDER_GAP);

        
        
        g2.setBackground(Color.YELLOW);
       g2.setColor(GRAPH_COLOR);
        
    /*   int arr[][]= {{100,300},
                     {200,500},
                     {400,200},
                     {513,180}};
      
       int arr2[][]= {{60,200},
               {150,300},
               {300,250},
               {419,480}};
	*/
       xpre=arr1[0][0];
       int ypre= arr1[1][0];
       for (int i = 0; i < Gen.number-1; i++) {
         xcur=arr1[0][i+1];
         int ycur= arr1[1][i+1];
         g2.drawLine(xpre, ypre, xcur, ycur);
         xpre=xcur;
         ypre=ycur;
        }
       g2.setColor(Color.green);
       xpre=arr2[0][0];

       ypre= arr2[1][0];
       for (int i = 0; i < Gen.number-1; i++) {
         xcur=arr2[0][i+1];
         int ycur= arr2[1][i+1];
         g2.drawLine(xpre, ypre, xcur, ycur);
         xpre=xcur;
         ypre=ycur;
        }
      Stroke oldStroke = g2.getStroke();
      g2.setColor(GRAPH_COLOR);
      g2.setStroke(GRAPH_STROKE);
      g2.setStroke(oldStroke);      
      g2.setColor(GRAPH_POINT_COLOR);
   
   int x = 35;
      int y ;
      g2.setColor(Color.BLACK);
      for (int i = 0; i < scores.size(); i++) {
          //graphPoints.get(i).y - GRAPH_POINT_WIDTH / 2;;
         int ovalW = GRAPH_POINT_WIDTH;
         int ovalH = GRAPH_POINT_WIDTH;
         g2.fillOval(x, scores.get(i), ovalW, ovalH);
         x=x+15;
      }
   
   
   
   
   
   }
   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   static void createAndShowGui(ArrayList<Integer> score) {
      //ArrayList<Integer> scores = new ArrayList<Integer>();
      ArrayList<Integer> scores1 = new ArrayList<Integer>();
      scores1 = score;
      DrawGraph mainPanel = new DrawGraph(scores1);

      JFrame frame = new JFrame("DrawGraph");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
   }

   public static void cmain() {
       
       ArrayList<Integer> abe = new ArrayList<Integer>();
       
       
       for (int i = 0; i < Gen.number-1; i++)
       {
           for (int j = 0; j < Gen.number-1-i; j++)
           {
               if (arr1[0][j] > arr1[0][j+1])
               {
                   // swap temp and arr[i]
                   int temp1 = arr1[0][j];
                   int temp2 = arr1[1][j];
                   arr1[0][j] = arr1[0][j+1];
                   arr1[1][j] = arr1[1][j+1];
                   arr1[0][j+1] = temp1;
                   arr1[1][j+1] = temp2;
               }
               if (arr2[0][j] > arr2[0][j+1])
               {
                   // swap temp and arr[i]
                   int temp1 = arr2[0][j];
                   int temp2 = arr2[1][j];
                   arr2[0][j] = arr2[0][j+1];
                   arr2[1][j] = arr2[1][j+1];
                   arr2[0][j+1] = temp1;
                   arr2[1][j+1] = temp2;
               }
           }
       }
       
       SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
            createAndShowGui(abe);
         }
      });
      
   }
}