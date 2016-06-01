import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JTextField;

public class First extends JFrame {
    static int c=0;
	private JPanel contentPane;
	private final Action action = new SwingAction();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JButton button;
	private JLabel lblNewLabel_1;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					itemset newobj=new itemset();
		             c=newobj.o;  			
					First frame = new First();
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
	public First() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		SimpleLR obj=new SimpleLR();
		itemset newobj=new itemset();
        c=newobj.o; 
	    button = new JButton("Click ME!!");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int temp=0,temp2=0;
				temp2=obj.in[c];
				if(obj.il[c][0]!=null && temp2>0)
				{   temp=1;
					textField.setText(obj.il[c][0]+"->"+obj.ir[c][0]);
				}
				if(obj.il[c][1]!=null && obj.il[c][0]!=null && temp2>1)
				{   
					textField_1.setText(obj.il[c][1]+"->"+obj.ir[c][1]);
				}
				if(obj.il[c][2]!=null && obj.il[c][0]!=null && temp2>2)
				{   textField_2.setText(obj.il[c][2]+"->"+obj.ir[c][2]);
				}
				if(obj.il[c][3]!=null && obj.il[c][0]!=null && temp2>3)
				{   textField_3.setText(obj.il[c][3]+"->"+obj.ir[c][3]);
				}
				if(obj.il[c][4]!=null && obj.il[c][0]!=null && temp2>4)
				{   textField_4.setText(obj.il[c][4]+"->"+obj.ir[c][4]);
				}
				if(obj.il[c][5]!=null && obj.il[c][0]!=null && temp2>5)
				{   textField_5.setText(obj.il[c][5]+"->"+obj.ir[c][5]);
				}
				if(obj.il[c][6]!=null && obj.il[c][0]!=null && temp2>6)
				{   textField_6.setText(obj.il[c][6]+"->"+obj.ir[c][6]);
				}
					System.out.println("c:"+c+"and o:"+newobj.o+"and value of in:"+temp2);
				
			   if(temp==0){
				   lblNewLabel_1.setText("SORRY NO PRODUCTION!!! ");
			   }
				
			}
		});
		button.setBounds(40, 89, 89, 23);
		contentPane.add(button);
		
		textField = new JTextField();
		textField.setFont(new Font("Monospaced", Font.PLAIN, 14));
		textField.setColumns(10);
		textField.setBounds(215, 51, 86, 20);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Monospaced", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(215, 82, 86, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Monospaced", Font.PLAIN, 14));
		textField_2.setColumns(10);
		textField_2.setBounds(215, 111, 86, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Monospaced", Font.PLAIN, 14));
		textField_3.setColumns(10);
		textField_3.setBounds(215, 143, 86, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Monospaced", Font.PLAIN, 14));
		textField_4.setColumns(10);
		textField_4.setBounds(215, 174, 86, 20);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Monospaced", Font.PLAIN, 14));
		textField_5.setColumns(10);
		textField_5.setBounds(215, 203, 86, 20);
		contentPane.add(textField_5);
		
		JLabel lblNewLabel = new JLabel("ITEMS");
		lblNewLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 22));
		lblNewLabel.setBounds(40, 11, 169, 34);
		contentPane.add(lblNewLabel);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Monospaced", Font.PLAIN, 14));
		textField_6.setBounds(215, 234, 86, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(25, 143, 150, 80);
		contentPane.add(lblNewLabel_1);
		
		btnBack = new JButton("BACK**");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				First newfirst=new First();
				newfirst.dispose();
				itemset newset=new itemset();
				newset.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Copperplate Gothic Light", Font.ITALIC, 12));
		btnBack.setBounds(335, 227, 89, 23);
		contentPane.add(btnBack);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
