import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class OknoLoty extends JFrame {

	public OknoLoty() {
		
		JPanel panelWyszukiwania = stworzPanelWyszukiwania();
		add(panelWyszukiwania,BorderLayout.NORTH);
		
		JPanel panelWynikowWyszukiwania = stworzPanelWynikowWyszukiwania();
		add(panelWynikowWyszukiwania, BorderLayout.CENTER);
		
		JPanel panelEdycji = stworzPanelEdycji();
		add(panelEdycji, BorderLayout.EAST);
		
		pack();
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
	
}

	private JPanel stworzPanelWynikowWyszukiwania() {
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(Color.BLACK),"Znalezione Loty"));
		JTextArea textArea = new JTextArea(15,23);
		textArea.setEditable(false);
		panel.add(textArea, BorderLayout.EAST);
		
		
		
		return panel;
	}

	private JPanel stworzPanelEdycji() {
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(Color.BLACK),"Edycja Lotu"));
		
		panel.setLayout(new GridLayout(6,2,5,5));
		
		panel.add(new JLabel("ID"));
		panel.add(new JTextField(20));
		
		panel.add(new JLabel("Sk퉐"));
		panel.add(new JTextField(20));
		
		panel.add(new JLabel("Dok퉐"));
		panel.add(new JTextField(20));
		
		panel.add(new JLabel("Data wylotu"));
		panel.add(new JTextField(20));
		
		panel.add(new JLabel("Cena"));
		panel.add(new JTextField(20));
		
		panel.add(new JLabel(""));
		panel.add(new JButton("Zapisz"));
		
		
		return panel;
	}

	private JPanel stworzPanelWyszukiwania() {
		JPanel panel = new JPanel();
		panel.add(new JLabel("Sk퉐"));
		JTextField skad = new JTextField(25);
		panel.add(skad);
		JTextField dokad = new JTextField(25);
		panel.add(new JLabel("Dok퉐"));
		panel.add(dokad);
		JButton przyciskSzukaj = new JButton("Szukaj");
		przyciskSzukaj.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(panel,"Wpisano sk퉐: "+skad.getText()+" Do: "+dokad.getText());
			}
		});
		panel.add(przyciskSzukaj);
		
		
		return panel;
	}


	
}
