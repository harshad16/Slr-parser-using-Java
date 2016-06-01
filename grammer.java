import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class grammer extends JFrame {
    
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					grammer frame = new grammer();
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
	public grammer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(201, 75, 194, 175);
		contentPane.add(editorPane);
		
		JButton btnNewButton = new JButton("Set Grammer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					String content = editorPane.getText();

					File file = new File("C:\\Users\\Harshad\\Desktop\\t1.txt");

					// if file doesnt exists, then create it
					if (!file.exists()) {
						file.createNewFile();
					}

					FileWriter fw = new FileWriter(file.getAbsoluteFile());
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write(content);
					bw.close();

					System.out.println("Done");

				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				grammer g=new grammer();
				g.dispose();
                SimpleLR n=new SimpleLR();
			    n.frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(24, 75, 138, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("SET GRAMMER");
		lblNewLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 18));
		lblNewLabel.setBounds(80, 11, 264, 41);
		contentPane.add(lblNewLabel);
	}
}
