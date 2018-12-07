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

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListModel;
import javax.swing.ScrollPaneLayout;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import mailpack.ReadEmail;
import twitterpack.Twitterapp;
import utlity.Lista;

/**
 * 
 * 
 * @author elmo & dinis
 *
 */
public class JanelaAplicacao {
	private JList<String> lista;
	private DefaultListModel<String> model = new DefaultListModel<>();
	List<Lista> lx = new ArrayList<>();

	/**
	 * window of the GUI
	 */
	private JFrame frame;

	public JanelaAplicacao() {

		/**
		 * Constructor of class JanelaAplicacao
		 */
		frame = new JFrame("API");

		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		frame.setLayout(new FlowLayout());

		addFrameContent();

		frame.pack();
	}

	/**
	 * this method defines if the gui gonna be visible or not
	 */
	public void open() {
		frame.setVisible(true);
	}

	/**
	 * this method contains all the components of the frame
	 */
	private void addFrameContent() {
		frame.setLayout(new BorderLayout());
		JPanel paineltotal = new JPanel();
		paineltotal.setLayout(new GridLayout(1, 2));

		JPanel painel1 = new JPanel();
		painel1.setLayout(new BorderLayout());
		JPanel painel2 = new JPanel();
		painel2.setLayout(new BorderLayout());

		JLabel label1 = new JLabel("twitter + mail");
		lista = new JList<String>(model);
		JScrollPane sp1 = new JScrollPane(lista);
		sp1.setLayout(new ScrollPaneLayout());
		sp1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		sp1.setPreferredSize(new Dimension(400, 400));

		JButton button1 = new JButton("ACTIVAR/DESATIVAR");
		button1.setBackground(Color.RED);

		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Twitterapp ta = new Twitterapp();
				ReadEmail re = new ReadEmail();
				String host = "imap.gmail.com";
				String username = "es1.2018.ic1.25@gmail.com";
				String password = "ES1_g25_det";
				re.fetch(host, username, password);
				lx.addAll(ta.getLx());
				lx.addAll(re.getLx());
				for (int x = 0; x < lx.size(); x++) {
					model.addElement(new String(lx.get(x).getHead()));
				}

			}
		});

		painel1.add(label1, BorderLayout.NORTH);
		painel1.add(sp1, BorderLayout.CENTER);
		painel1.add(button1, BorderLayout.SOUTH);

		JLabel label2 = new JLabel("Conteudo");

		JTextArea text2 = new JTextArea(" ");
		JScrollPane sp2 = new JScrollPane(text2);
		sp2.setLayout(new ScrollPaneLayout());
		sp2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		sp2.setPreferredSize(new Dimension(400, 400));

		lista.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				text2.setText(lx.get(lista.getSelectedIndex()).getCont());
			}
		});

		painel2.add(label2, BorderLayout.NORTH);
		painel2.add(sp2, BorderLayout.CENTER);

		paineltotal.add(painel1);
		paineltotal.add(painel2);
		frame.add(paineltotal);
	}

}
