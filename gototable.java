import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class gototable extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gototable frame = new gototable();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public gototable() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(131, 22, 275, 228);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JLabel lblNewLabel = new JLabel("GOTO TABLE");
		lblNewLabel.setFont(new Font("Monospaced", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 33, 94, 26);
		contentPane.add(lblNewLabel);
		
		JButton btnBack = new JButton("BACK**");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SimpleLR n=new SimpleLR();
			    n.frame.setVisible(true);
			    
			}
		});
		btnBack.setBounds(32, 192, 89, 23);
		contentPane.add(btnBack);
		SimpleLR obj=new SimpleLR();
		
		    
		    File inputFile1 = new File("C:\\Users\\Harshad\\Desktop\\t6.txt");
			 BufferedReader reader1 = new BufferedReader(new FileReader(inputFile1));

			    String currentLine1;

			    while((currentLine1 = reader1.readLine()) != null)
			    {
			    textArea.append(currentLine1+"\n");
			    }
			    reader1.close();
	}
}
