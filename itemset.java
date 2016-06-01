import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class itemset extends JFrame {
static int o=0;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					itemset frame = new itemset();
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
	public itemset() {
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
		
		JButton btnNewButton = new JButton("I 0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				itemset newset=new itemset();
				newset.dispose();
				First newfirst=new First();
				newfirst.setVisible(true);
			}
		});
		btnNewButton.setBounds(39, 75, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("I 1");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				o=1;
				itemset newset=new itemset();
				newset.dispose();
				First newfirst=new First();
				newfirst.setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(39, 119, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("I 2");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				o=2;
				itemset newset=new itemset();
				newset.dispose();
				First newfirst=new First();
				newfirst.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(39, 166, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("I 3");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				o=3;
				itemset newset=new itemset();
				newset.dispose();
				First newfirst=new First();
				newfirst.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(39, 212, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("I 4");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				o=4;
				itemset newset=new itemset();
				newset.dispose();
				First newfirst=new First();
				newfirst.setVisible(true);	
			}
		});
		btnNewButton_4.setBounds(165, 75, 89, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("I 5");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				o=5;
				itemset newset=new itemset();
				newset.dispose();
				First newfirst=new First();
				newfirst.setVisible(true);
			}
		});
		btnNewButton_5.setBounds(165, 119, 89, 23);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("I 6");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				o=6;
				itemset newset=new itemset();
				newset.dispose();
				First newfirst=new First();
				newfirst.setVisible(true);
			}
		});
		btnNewButton_6.setBounds(165, 166, 89, 23);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("I 7");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				o=7;
				itemset newset=new itemset();
				newset.dispose();
				First newfirst=new First();
				newfirst.setVisible(true);
			}
		});
		btnNewButton_7.setBounds(165, 212, 89, 23);
		contentPane.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("I 8");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				o=8;
				itemset newset=new itemset();
				newset.dispose();
				First newfirst=new First();
				newfirst.setVisible(true);
			}
		});
		btnNewButton_8.setBounds(275, 75, 89, 23);
		contentPane.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("I 9");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				o=9;
				itemset newset=new itemset();
				newset.dispose();
				First newfirst=new First();
				newfirst.setVisible(true);
			}
		});
		btnNewButton_9.setBounds(275, 119, 89, 23);
		contentPane.add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("I 10");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				o=10;
				itemset newset=new itemset();
				newset.dispose();
				First newfirst=new First();
				newfirst.setVisible(true);
			}
		});
		btnNewButton_10.setBounds(275, 166, 89, 23);
		contentPane.add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("I 11");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				o=11;
				itemset newset=new itemset();
				newset.dispose();
				First newfirst=new First();
				newfirst.setVisible(true);
			}
		});
		btnNewButton_11.setBounds(275, 212, 89, 23);
		contentPane.add(btnNewButton_11);
		
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
