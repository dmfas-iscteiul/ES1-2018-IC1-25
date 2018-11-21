package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

	public class JanelaAplicacao {
	private JFrame frame;
	   
	   public JanelaAplicacao() {
		   frame = new JFrame("API");
		   
		   frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			
			frame.setLayout(new GridLayout(4,1));
			
			addFrameContent();
			
			frame.pack();
	   }
	   
	   public void open() {
		   frame.setVisible(true);
	   }
	   
	   private void addFrameContent() {
		   frame.setLayout(new BorderLayout());
		   JPanel paineltotal = new JPanel();
			paineltotal.setLayout(new GridLayout(1,4));
			
			JPanel painel1 = new JPanel();
			painel1.setLayout(new BorderLayout());
			JPanel painel2 = new JPanel();
			painel2.setLayout(new BorderLayout());
			JPanel painel3 = new JPanel();
			painel3.setLayout(new BorderLayout());
		  
			
			JLabel label1 = new JLabel("email");
			
		

			JTextField text1 = new JTextField(" ");
			text1.setPreferredSize( new Dimension( 400, 400 ) );
			
			JButton button1 = new JButton("ACTIVAR/DESATIVAR");
			button1.setBackground(Color.RED);
			
			button1.addActionListener(new ActionListener()  {
				@Override
				public void actionPerformed(ActionEvent arg0) {
				
					if(button1.getBackground().equals(Color.RED)) {
						button1.setBackground(Color.GREEN);
					}else {
						button1.setBackground(Color.RED);
					}
				}
			});
			painel1.add(label1, BorderLayout.NORTH);
			painel1.add(text1, BorderLayout.CENTER);
			painel1.add(button1, BorderLayout.SOUTH);
			
			JLabel label2 = new JLabel("facebook");
			
			JTextField text2 = new JTextField(" ");
			text2.setPreferredSize( new Dimension( 400, 400 ) );
			
			JButton button2 = new JButton("ACTIVAR/DESATIVAR");
			button2.setBackground(Color.RED);
			
			button2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
				
					if(button2.getBackground().equals(Color.RED)) {
						button2.setBackground(Color.GREEN);
					}else {
						button2.setBackground(Color.RED);
					}
				}
			});

			painel2.add(label2, BorderLayout.NORTH);
			painel2.add(text2, BorderLayout.CENTER);
			painel2.add(button2, BorderLayout.SOUTH);
			
			
			JLabel label3 = new JLabel("twitter");
		
			JTextField text3 = new JTextField(" ");
	text3.setPreferredSize( new Dimension( 400, 400 ) );
			
			JButton button3 = new JButton("ACTIVAR/DESATIVAR");
			button3.setBackground(Color.RED);
		

			button3.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0){
				
					if(button3.getBackground().equals(Color.RED)) {
						button3.setBackground(Color.GREEN);
					}else {
						button3.setBackground(Color.RED);
					}
				}
			});
			
			painel3.add(label3, BorderLayout.NORTH);
			painel3.add(text3, BorderLayout.CENTER );
			painel3.add(button3, BorderLayout.SOUTH);
			
			paineltotal.add(painel1);
			paineltotal.add(painel2);
			paineltotal.add(painel3);
			frame.add(paineltotal);
	   }
	   
	   public static void main(String[] args) {
		   JanelaLogin window = new JanelaLogin();
		   window.open();
	   }
	   

	   }


