/* 
 * Image Slider
 * 
 * This program enables hoping an image between 4 boxes with a button click.
 * This program is currently not completely functioning. It was discovered that the image was not
 * showing properly because it was in the wrong location. It is now showing the image, the image
 * needed to be in the CSII folder. All that is left is to fix the logic of the event handler.
 * As this program as surpasses the expectations of the assignment, It is unsure when full functionality
 * will be achieved.
 * 
 * Note: This was moved to a new project called ImageSlide
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
  
  // constructor
  public Imageslider() {
    //create GUI components
    image = new ImageIcon("aCar.png");
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
  
  /* Temporarily not needed
  class ImageButton extends JButton {

	  public ImageButton (String img) {
	    this(new ImageIcon(img));
	  }

	  public ImageButton(ImageIcon icon) {
	    setIcon(icon);
	    setMargin(new Insets(0,0,0,0));
	    setIconTextGap(0);
	    setBorderPainted(false);
	    setBorder(null);
	    setText(null);
	    setSize(icon.getImage().getWidth(null), icon.getImage().getHeight(null));
	  }
  } */
  
  private class ButtonHandler implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      int pos = 1;
      if (e.getSource().equals(bFirst)) {
    	  if(pos==2) {
    		  bFirst.setIcon(image);
    		  bSecond.setIcon(empty);
    		  pos = 1;
    	  }
    	  else if(pos==3){
    		  bFirst.setIcon(image);
    		  bThird.setIcon(empty);
    		  pos = 1;
    	  }
      }
      else if(e.getSource().equals(bSecond)){
    	  if(pos==1) {
    		  bFirst.setIcon(empty);
    		  bSecond.setIcon(image);
    		  pos = 2;
    	  }
    	  else if(pos==4){
    		  bForth.setIcon(empty);
    		  bSecond.setIcon(image);
    		  pos = 2;
    	  }
      }
      else if(e.getSource().equals(bThird)){
    	  if(pos==1) {
    		  bFirst.setIcon(empty);
    		  bThird.setIcon(image);
    		  pos = 3;
    	  }
    	  else if(pos==4){
    		  bForth.setIcon(empty);
    		  bThird.setIcon(image);
    		  pos = 3;
    	  }
      }
      else if(e.getSource().equals(bForth)){
    	  if(pos==2) {
    		  bForth.setIcon(image);
    		  bSecond.setIcon(empty);
    		  pos = 4;
    	  }
    	  else if(pos==3){
    		  bForth.setIcon(image);
    		  bThird.setIcon(empty);
    		  pos = 4;
    	  }
      }
    }
  }
  public static void main(String[] args) {
    Imageslider myApp = new Imageslider();
  }

}
