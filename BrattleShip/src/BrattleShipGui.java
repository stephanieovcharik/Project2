import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class BrattleShipGui {

	static int row, col, width, count=0, check =0;
	Random rand = new Random();
	int x= rand.nextInt(row*col);
	
	
    private final List<JButton> list = new ArrayList<JButton>();
   	private boolean target(int r){
   		int [] t= new int [width];
    	t[0]= x;
       	if(row==1 && x % 10 > (col-width)){
    		for(int i=0; i < width; i++){
    		 t[i]= x-(i+1);
    		
    	}
    	}
    	else if(x % 10 > (col-width)){
    		for(int i=1; i < width; i++){
    			
    			t[i]= x-(i);
   
    		}
    	}else{
    			for(int i=1; i < width; i++){
    				
    				t[i]= x+(i);
    			}
    		
    	}
    
    
    	for(int i=0; i < width ; i++)
    		if(t[i]==r){
    			
    			return true;
    		}
    	
    	return false;
    }
    private JButton createGridButton(final int row) {
    	final JButton b = new JButton();
    	
    	b.addMouseListener(new java.awt.event.MouseAdapter(){
    		
    		public void mouseClicked(java.awt.event.MouseEvent e){
    			
    			
    				if(target(row)){
    					b.setBackground(Color.RED);
    					b.setText("HIT");
    					count++;
    					if(width== count){
    						displaySecond();
    					}


    				}else{
    					b.setBackground(Color.WHITE);
    					b.setText("MISS");
    				}
    		}});
    	return b;
    	}
    

    private JPanel createGridPanel() {
        JPanel p = new JPanel(new GridLayout(row,col));
        for (int i = 0; i < row * col; i++) {
            JButton gb = createGridButton(i);

            list.add(gb);
            p.add(gb);
        }
        return p;
    }
    private void displayThird(){
   	 JFrame finish = new JFrame("");
        finish.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        finish.setSize(200,200);
        finish.setLocationRelativeTo(null);
        finish.setVisible(true);
        JButton but = new JButton (" YOU LOST !");
        finish.add(but);
        
   }
    public void displaySecond() {
    	 JFrame finish = new JFrame("");
         finish.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         finish.setSize(200,200);
         finish.setLocationRelativeTo(null);
         finish.setVisible(true);

         JButton but = new JButton ("Winner " );
         finish.add(but);
         
         but.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
            	 System.exit(0);
             }
       });
    }

    private void display() {
        JFrame f = new JFrame("BrattleShip");

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(createGridPanel());
        f.pack();
        f.setSize(1000, 1000);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader("input.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int testCases = Integer.parseInt(in.readLine());
		
		
			String[] input= in.readLine().split(" ");
			row = Integer.parseInt(input[0]);
			col = Integer.parseInt(input[1]);
			width = Integer.parseInt(input[2]);
			
		
		in.close();
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new BrattleShipGui().display();
               
            }
        });
    }
}