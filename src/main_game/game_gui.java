package main_game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class game_gui  {

	public static class Global {
	   
	    public static int[][] a=new int[4][4];
	    public static int[][] flag=new int[4][4];   
	    public static volatile boolean left_flag;
	    public static volatile boolean right_flag;
		public static volatile boolean up_flag;
		public static volatile boolean down_flag;
		
	}
	

	
	public static volatile boolean key_pressed=false;
	public static volatile JTable table;
	public static volatile JFrame frame=new JFrame("2048 : Puzzle Game");
	public static volatile JLabel emptyLabel =new JLabel("");
	public static JLabel score_area=new JLabel();
	public static int w=475;
	public static int h=400;
	
	public static int score=0;
	
	public static Object[][] data1;
	
	public static JLabel add_action(JLabel emptyLabel)
	{
		System.out.println("Add action entered");
		emptyLabel.setFocusable(true);
        
        Action left_action = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
            	key_pressed=true;
            	Global.left_flag=true;
            	//System.out.println("key pressed :"+key_pressed);
            	//System.out.println("left"+Global.left_flag);
                //do nothing
            	
            	
            }
        };
        Action right_action = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
            	key_pressed=true;
            	Global.right_flag=true;
            	//System.out.println("right");
                //do nothing
            }
        };
        Action up_action = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
            	Global.up_flag=true;
            	key_pressed=true;
            	//System.out.println("up"+Global.up_flag);
                //do nothing
            }
        };
        Action down_action = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
            	Global.down_flag=true;
            	key_pressed=true;
            	//System.out.println("down");
                //do nothing
            }
        };
        emptyLabel.getInputMap().put(KeyStroke.getKeyStroke("LEFT"),"left");
        emptyLabel.getActionMap().put("left", left_action);
        emptyLabel.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"),"right");
        emptyLabel.getActionMap().put("right", right_action);
        emptyLabel.getInputMap().put(KeyStroke.getKeyStroke("UP"),"up");
        emptyLabel.getActionMap().put("up", up_action);
        emptyLabel.getInputMap().put(KeyStroke.getKeyStroke("DOWN"),"down");
        emptyLabel.getActionMap().put("down", down_action);
        
        return emptyLabel;
	}
	
	public static void createAndShowGUI() {
	        //Create and set up the window.
	        //frame = 

		  	frame.setResizable(false);
		  
	        frame.setPreferredSize(new Dimension(w,h));//875,800
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setIconImage(new ImageIcon("menu.jpg").getImage());
	        emptyLabel.setPreferredSize(new Dimension(w,h-100));       
	        
	        emptyLabel=add_action(emptyLabel);
	        Font f = new Font("serif", Font.PLAIN, 15);
	        JLabel score_area = new JLabel();	        
        	score_area.setFont(f);
        	score_area.setText("Score:"+score);
        	score_area.setBounds(w-130, 0, 130, 50);
        	//score_area.setPreferredSize(new Dimension(100,50));
        	
        	JTable table= addtable(Global.a);
        	
        	table.setBounds(0,50,w,h-100);
        	//emptyLabel.add(score_area);
        	emptyLabel.add(table);
	       
        	frame.add(emptyLabel); 	
        	frame.invalidate();
	        frame.validate();
	        frame.repaint();
        	//frame.add(emptyLabel); 	
        	/*frame.invalidate();
  	        frame.validate();
  	        frame.repaint();*/
	       
	        //Display the window.
	        frame.pack();	        
	        frame.setVisible(true);      
	  }
	  
	  public static JTable addtable(int[][] a)
	  {
		  //System.out.println("add game_gui entered");  
		  //grid.print_grid(a);
		  String[] columnNames = {"First Name",
                  "Last Name",
                  "Sport","sample"
                  };
		  
	       data1= new Object[4][4];
	       for(int i=0;i<a.length;i++){
	    	   for(int j=0;j<a.length;j++)
	    	   {
	    		   if(a[i][j]!=0)
	    			   data1[i][j]=(Object)a[i][j];
	    	   }
	       }
	       
	       Font f = new Font("serif", Font.PLAIN, 55);
	       table = new JTable( data1, columnNames){
	    	   Object x;
	    	   JLabel label;
	    	   @Override
	    	   public Component prepareRenderer(TableCellRenderer renderer,
	    			int row, int column) 
	    	   {
	    		   if(true)//table.getModel().getValueAt(row, column)!=null)
	    		   {
	    			   x=table.getModel().getValueAt(row, column);
	    			   //  System.out.println(x+","+row+","+column);
	    			   label = (JLabel) super.prepareRenderer(renderer, row, column);
	    			   Component x1= super.prepareRenderer(renderer, row, column);
	    			   if (!isRowSelected(row))
	    			   {
	    				  if(x==(Object)2 || x==(Object)64)
	    				   {
	    					   x1.setBackground(new Color(235,225,211));
	    				   }
	    				   else if(x==(Object)4||x==(Object)128)
	    				   {
	    					   x1.setBackground(new Color(214,213,218));
	    				   }
	    				   else if(x==(Object)8||x==(Object)256)
	    				   {
	    					   x1.setBackground(new Color(231,199,150));
	    				   }		
	    				   else if(x==(Object)16||x==(Object)512)
	    				   {
	    					   x1.setBackground(new Color(249,235,200));
	    				   }
	    				   else if(x==(Object)32||x==(Object)1024)
	    				   {
	    					   x1.setBackground(new Color(224,226,228));
	    				   }
	    				   else if(x==(Object)2048||x==(Object)4096)
	    				   {
	    					   x1.setBackground(new Color(113,99,62));
	    				   }
	    				   else
	    				   {
	    					   x1.setBackground(getBackground());
	    				   }
	    				   
	    				  ///x1.setBackground(x==(Object)2||x==(Object)4 ?new Color(152,156,123):(x==(Object)16 || x==(Object)8 ?Color.blue: (x==(Object)2||x==(Object)4 ?new Color(152,156,123):(x==(Object)16 || x==(Object)8 ?Color.blue:getBackground() ))));
	    			   }
	    			   
	    		   }
			      return label;
			   };
	       };
	       table.setRowHeight(75);//
	       table.setEnabled(false);
	       DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();  
	        dtcr.setHorizontalAlignment(SwingConstants.CENTER); 
	        table.getColumnModel().getColumn(0).setCellRenderer(dtcr);
	        table.getColumnModel().getColumn(1).setCellRenderer(dtcr);
	        table.getColumnModel().getColumn(2).setCellRenderer(dtcr);
	        table.getColumnModel().getColumn(3).setCellRenderer(dtcr);
	        //table.setShowGrid(false);
	        table.setGridColor(new Color(201,197,198));
	        //table.setBounds(100, 100, w-300, h-300);
	        table.setFont(f);
	        //frame.add(table);
	        return table;
	       
	  }
	  
	  
	  public static void main(String[] args) {
		  
		  int[][] flag2 = new int[4][4];
		  //the main program starts here :
		  grid.create_grid(Global.a, Global.flag);
		  // fill 1 st grid element
		  logic.fill_next_random(Global.a, Global.flag);
		  // show UI
		  //createAndShowGUI();
		 javax.swing.SwingUtilities.invokeLater(new Runnable() {
          public void run() {
              createAndShowGUI();
          }
		 });	  
		  boolean valid_user_move=false;
		  //System.out.println("UI created");
		  
		  while(true)
		  {		  
			  //System.out.println("loop entered"+Global.left_flag);
			  if(key_pressed)
			  {
				  //System.out.println(key_pressed);
				  //System.out.println("key pressed");
				  main_game_without_gui.deep_copy(Global.flag,flag2);
				  key_pressed=false;
				  
				  //check which key is pressed 				  
				  if(Global.left_flag)
				  {
					  Global.left_flag=false;
					  score=logic.left_movement(Global.a, Global.flag,score);
				  }
				  if(Global.right_flag)
				  {
					  Global.right_flag=false;
					  score=logic.right_movement(Global.a, Global.flag,score);
				  }
				  if(Global.up_flag)
				  {
					  score=logic.up_movement(Global.a, Global.flag,score);
					  Global.up_flag=false;
				  }
				  if(Global.down_flag)
				  {
					  score=logic.down_movement(Global.a, Global.flag,score);
					  Global.down_flag=false;
				  }
				  //replace all 2's of flag
				  main_game_without_gui.flag_2_replace(Global.flag);
				  //check if its valid movement
				  valid_user_move=logic.movement_checker(Global.flag, flag2);
				 if(valid_user_move)
				  {			
					 update_ui();
					 logic.fill_next_random(Global.a, Global.flag);
					 //user _defined delay
					 int i=0;
					 while(i<34834915)
					 {
						 i++;
					 }
					 update_ui();					 
				  }
				  if(winner.out_condition(Global.a, Global.flag))
				  {
						System.out.println("you lose");
						System.out.println("your score  : "+score);
						//frame.remove(table);
						emptyLabel.invalidate();
						emptyLabel.validate();
						emptyLabel.remove(table);
						emptyLabel.remove(score_area);
						Font f = new Font("serif", Font.PLAIN, 35);
			        	JLabel displayArea = new JLabel("<html> You Lost !<br> <br>\n Your score : "+score+"</html>",SwingConstants.CENTER);
			        	displayArea.setBounds(0, 0, w, h);
			        	displayArea.setFont(f);
			        	
			        	emptyLabel.add(displayArea);
			        	emptyLabel.repaint(); 
			        	frame.invalidate();
			        	frame.validate();
			        	frame.repaint();
						break;
					}
				  if(winner.win_condition(Global.a))
					{
						//you won
					  	emptyLabel.invalidate();
						emptyLabel.validate();
						emptyLabel.remove(table);
						emptyLabel.remove(score_area);
					  	System.out.println("your score  : "+score);
					  	Font f = new Font("serif", Font.PLAIN, 35);
					  	JLabel displayArea = new JLabel("<html>  Congrats ! You won!<br> Your score : "+score+"</html>",SwingConstants.CENTER);
					  	displayArea.setBounds(0, 0, w, h);			        	
					  	displayArea.setFont(f);			        	
					  	emptyLabel.add(displayArea);
			        	emptyLabel.repaint(); 
			        	frame.invalidate();
			        	frame.validate();
			        	frame.repaint();
						break;
					}				 
				  
				 
			  }
		  }		 
	  }
	  public static void update_ui()
	  {
		  emptyLabel.invalidate();
		  emptyLabel.validate();
		  emptyLabel.remove(table);
		  emptyLabel.remove(score_area);
		  // emptyLabel=add_action(emptyLabel);
		  Font f = new Font("serif", Font.PLAIN, 15);
	      //score_area = new JLabel();
	      score_area.setFont(f);
	      score_area.setText("Score:"+score);
	      score_area.setBounds(w-130, 0, 130, 50);	
	      emptyLabel.setFocusable(true);
	      emptyLabel.add(score_area);					  
		  table=addtable(Global.a);
		  
		  table.setBounds(0, 50, w, h-100);
		  emptyLabel.add(table);
		  
		  emptyLabel.repaint();
		  
		  //TODO
		  frame.invalidate();
		  frame.validate();
		  frame.repaint();			
	  }
	  
	
}
