import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class it extends JFrame {

	static int o =0;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					it frame = new it();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	
	
	public it() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ITEM SETS");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 24));
		lblNewLabel.setBounds(67, 11, 246, 33);
		contentPane.add(lblNewLabel);
		
		System.out.println("Inside main"+SimpleLR.ns);
	    int i=0;
	    final int k=0;
		int x=10,x2=120,x3=210, y=75, width=89, height=23; //choose whatever you want
        JButton[] btn = new JButton[SimpleLR.ns];
        for( i=0; i<(SimpleLR.ns); i++, y+=20) 
        {
			System.out.println("Inside button i:"+i+"and y:"+y);
            btn[i] = new JButton("I"+i);
            if(i>7){x=x2;}
            if(i>14){x=x3;}
            if(y>=235){y=75;}
            
            btn[i].setBounds(x, y, width, height);
            btn[i].addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				/*File te = new File("C:\\Users\\Harshad\\Desktop\\t6.txt");
    			     if (!te.exists()) {
    						try {
    							te.createNewFile();
    						} catch (IOException e1) {
    							// TODO Auto-generated catch block
    							e1.printStackTrace();
    						}
    					}
    			     BufferedWriter wr = null;
    					try {
    						wr= new BufferedWriter(new FileWriter(te));
    					} catch (IOException e1) {
    						// TODO Auto-generated catch block
    						e1.printStackTrace();
    					}
    					StringBuffer ta = new StringBuffer();
    					ta.append(i);
    					try {
							wr.write(ta.toString());
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}*/
    				o=1;
    				it newset=new it();
    				newset.dispose();
    				pr newfirst=new pr();
    				newfirst.setVisible(true);
    				//k++;
    			}
    		});
           contentPane.add(btn[i]);
        }
        
        JButton btnNewButton_12 = new JButton("MAIN");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						
					    SimpleLR n=new SimpleLR();
					    n.frame.setVisible(true);
						
						
				
			}
		});
		btnNewButton_12.setBounds(323, 20, 89, 33);
		contentPane.add(btnNewButton_12);
		
	}
}
