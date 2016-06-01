import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class pr extends JFrame {
	static int c = 1;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pr frame = new pr();
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
	public pr() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(183, 11, 216, 239);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton btnNewButton = new JButton("Click ME!!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int temp=0,temp2=0;
				temp2=SimpleLR.in[c];
				for(int i=0;i<temp2 ;i++){
					if(SimpleLR.il[c][i]!=null && temp2>i && SimpleLR.il[c][0]!=null)
					{temp=1;
					textArea.append(SimpleLR.il[c][i]+"->"+SimpleLR.ir[c][i]+"\n");
					}
				 }
				  if(temp==0){
					   textArea.append("SORRY NO PRODUCTION!!! ");
				   }
			}
		});
		btnNewButton.setBounds(40, 41, 100, 50);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back**");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pr newfirst=new pr();
				newfirst.dispose();
				it newset=new it();
				newset.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(40, 161, 89, 41);
		contentPane.add(btnNewButton_1);
	}
	
	/*public pr(int U) {
        c = U;
        initComponents();
    }*/
}
