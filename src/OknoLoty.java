import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

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
		int columnNumber = 0;
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(Color.BLACK),"Znalezione Loty"));
		JTextArea textArea = new JTextArea(15,23);
		textArea.setEditable(false);
		panel.add(textArea);
		JButton allFlights = new JButton("Pobierz wszystkie loty");
		panel.add(allFlights);
		allFlights.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				Database database = new Database();
				ResultSet info = database.getFlights();
				String tmp = "SKAD | DOKAD | DATA | CENA | MIEJSCA BIZNES | MIEJSCA EKONOM\n";
				
				
				try {
					while( info.next()) {
						
						tmp = tmp + info.getString("SKAD")+" -- ";
						tmp = tmp + info.getString("DOKAD")+" ";
						tmp = tmp + info.getString("DATA")+" ";
						tmp = tmp + info.getString("CENA")+" ";
						tmp = tmp + info.getString("MIEJSCA_BIZNES")+" ";
						tmp = tmp + info.getString("MIEJSCA_EKONO")+" ";
						tmp = tmp + "\n-----------------------------------------------\n";	
						}
						
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				textArea.setText(tmp);
			
			
		}});
		
		
		
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
			
			aktualizujListeLotow(skad.getText(),dokad.getText());
			}
		});
		panel.add(przyciskSzukaj);
		
		
		return panel;
	}
	
	private void aktualizujListeLotow(String skad, String dokad) {
		
		
		
	}


	
}
