/* 
 * Image Slider
 * 
 * This program enables hoping an image between 4 boxes with a button click.
 * The image may slide only to adjacent buttons, not diagonal ones.
 * The image was taken from the web, it was not created by me. It is used
 * to demonstrate the usage of images.
 * 
 * by Joe Van Deusen
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Imageslider extends JFrame {

  // GUI components
  ImageIcon image, empty;
  JButton bFirst, bSecond, bThird, bForth;
  //JLabel blank;
  Container c;
  ButtonHandler clicker;
  int pos = 0;
  
  // constructor
  public Imageslider() {
    //create GUI components
    image = new ImageIcon("newCar.jpg");
    empty = new ImageIcon();
    bFirst = new JButton(image);
    bSecond = new JButton(empty);
    bThird = new JButton(empty);
    bForth = new JButton(empty);
    //blank = new JLabel();
    c = getContentPane();
    
    //add GUI components
    c.setLayout(new GridLayout(2,2));
    c.add(bFirst);
    c.add(bSecond);
    c.add(bThird);
    c.add(bForth);
    
    //register with buttons
    clicker = new ButtonHandler();
    bFirst.addActionListener(clicker);
    bSecond.addActionListener(clicker);
    bThird.addActionListener(clicker);
    bForth.addActionListener(clicker);
    
    //render the window
    setSize(275*2,195*2);
    setLocation(100,100);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setResizable(false);
    setTitle("Image Slide");
    setVisible(true);
    
  }
  
  private class ButtonHandler implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      if(e.getSource().equals(bFirst)) {
    	  if(pos!=4) {
    		  bFirst.setIcon(image);
    		  bSecond.setIcon(empty);
    		  bThird.setIcon(empty);
    		  bForth.setIcon(empty);
    		  pos = 1;
    	  }
      }
      if(e.getSource().equals(bSecond)){
    	  if(pos!=3) {
    		  bFirst.setIcon(empty);
    		  bSecond.setIcon(image);
    		  bThird.setIcon(empty);
    		  bForth.setIcon(empty);
    		  pos = 2;
    	  }
      }
      if(e.getSource().equals(bThird)){
    	  if(pos!=2) {
    		  bFirst.setIcon(empty);
    		  bSecond.setIcon(empty);
    		  bThird.setIcon(image);
    		  bForth.setIcon(empty);
    		  pos = 3;
    	  }
      }
      if(e.getSource().equals(bForth)){
    	  if(pos!=1) {
    		  bFirst.setIcon(empty);
    		  bSecond.setIcon(empty);
    		  bThird.setIcon(empty);
    		  bForth.setIcon(image);
    		  pos = 4;
    	  }
      }
    }
  }
  public static void main(String[] args) {
    Imageslider myApp = new Imageslider();
  }

}
