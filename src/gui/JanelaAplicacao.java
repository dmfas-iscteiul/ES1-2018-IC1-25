package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneLayout;
import javax.swing.WindowConstants;

import twitterpack.Twitterapp;

	public class JanelaAplicacao {
	private JFrame frame;
	   
	   public JanelaAplicacao() {
		   frame = new JFrame("API");
		   
		   frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			
			frame.setLayout(new FlowLayout());
			
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
			
		

			JTextArea text1 = new JTextArea(" ");
			JScrollPane sp1 = new JScrollPane(text1);
			sp1.setLayout(new ScrollPaneLayout());
			sp1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			sp1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			sp1.setPreferredSize( new Dimension( 400, 400 ) );
			
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
			painel1.add(sp1, BorderLayout.CENTER);
			painel1.add(button1, BorderLayout.SOUTH);
			
			JLabel label2 = new JLabel("facebook");
			JTextArea text2 = new JTextArea(" ");
			JScrollPane sp2 = new JScrollPane(text2);
			sp2.setLayout(new ScrollPaneLayout());
			sp2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			sp2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			sp2.setPreferredSize( new Dimension( 400, 400 ) );
			
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
			painel2.add(sp2, BorderLayout.CENTER);
			painel2.add(button2, BorderLayout.SOUTH);
			
			
			JLabel label3 = new JLabel("twitter");
		
			JTextArea text3 = new JTextArea(" ");
			JScrollPane sp3 = new JScrollPane(text3);
			sp3.setLayout(new ScrollPaneLayout());
			sp3.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			sp3.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			sp3.setPreferredSize( new Dimension( 400, 400 ) );
			
			JButton button3 = new JButton("ACTIVAR/DESATIVAR");
			button3.setBackground(Color.RED);
			

			button3.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0){
				Twitterapp ta = new Twitterapp();
				StringBuilder xo = new StringBuilder();
				List<String> list = new ArrayList<>();
				list = ta.getList();
				for(String s: list) {
						xo.append(s);
						xo.append("\n");
				}
				String xox = xo.toString();
					if(button3.getBackground().equals(Color.RED)) {
						button3.setBackground(Color.GREEN);
						text3.setText(xox);

					}else {
						button3.setBackground(Color.RED);
					}
				}
			});
			
			painel3.add(label3, BorderLayout.NORTH);
			painel3.add(sp3, BorderLayout.CENTER );
			painel3.add(button3, BorderLayout.SOUTH);
			
			paineltotal.add(painel1);
			paineltotal.add(painel2);
			paineltotal.add(painel3);
			frame.add(paineltotal);
	   }
	   
	 
	   

	   }


