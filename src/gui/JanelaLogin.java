package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class JanelaLogin extends javax.swing.JFrame {

   private JFrame frame;
   
   public JanelaLogin() {
	   
	   frame = new JFrame("ISCTE");
	   
	   frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		frame.setLayout(new GridLayout(4,1));
		
		addFrameContent();
		
		frame.pack();
   }
   
   public void open() {
	   frame.setVisible(true);
   }
   
 
   
   private void addFrameContent() {
	   frame.setLayout(new GridLayout(4,1));
	   JLabel label1 = new JLabel("email");
		frame.add(label1);
	

		JTextField text = new JTextField(" ");
		frame.add(text);
		
		JLabel label2 = new JLabel("password");
		frame.add(label2);
		
		JTextField text2 = new JTextField(" ");
		frame.add(text2);
		
		JButton button = new JButton("Entrar");
		frame.add(button);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JanelaAplicacao j = new JanelaAplicacao();
				j.open();
				frame.setVisible(false);
				
				
			}
		});
		
   }
   
   public static void main(String[] args) {
	   JanelaLogin window = new JanelaLogin();
	   window.open();
   }
   }
