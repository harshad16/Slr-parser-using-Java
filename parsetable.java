import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class parsetable extends JFrame {
	static char ntermnl[],termnl[];
	static int ntlen,tlen;
	static String grmr[][],fst[],flw[];
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					parsetable frame = new parsetable();
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
	public parsetable() throws IOException {
		SimpleLR obj=new SimpleLR();
		 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textArea.setBounds(125, 11, 283, 239);
		contentPane.add(textArea);
		
	    textArea.setLineWrap(true);
	    textArea.setEditable(false);
	    
	    JLabel lblNewLabel = new JLabel("FOLLOW:");
	    lblNewLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 16));
	    lblNewLabel.setBounds(10, 11, 92, 37);
	    contentPane.add(lblNewLabel);
	    
	    JButton btnNewButton = new JButton("BACK**");
	    btnNewButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		SimpleLR n=new SimpleLR();
			    n.frame.setVisible(true);
	    	}
	    });
	    btnNewButton.setBounds(13, 227, 89, 23);
	    contentPane.add(btnNewButton);
	    textArea.setVisible(true);
	    File inputFile = new File("C:\\Users\\Harshad\\Desktop\\t4.txt");
		 BufferedReader reader = new BufferedReader(new FileReader(inputFile));

		    String currentLine;

		    while((currentLine = reader.readLine()) != null)
		    {
		    textArea.append(currentLine+"\n");
		    }
		    reader.close();
	}
}
