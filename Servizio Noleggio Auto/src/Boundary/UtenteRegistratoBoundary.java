package Boundary;

import java.awt.BorderLayout;
import java.sql.*;
import java.sql.Date;
import java.util.*;
import main.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

import Control.GestoreNoleggio;
import Entity.Auto;

import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class UtenteRegistratoBoundary extends JFrame {

	private JPanel Pannello;
	private JTable table;
	private JComboBox comboBox_Segmento;
	private JLabel lblAvviso;
	private JTable table_Accessori;
	private Object [] vect;
	private JComboBox comboBoxServizioAssiccurativo;
	private JCheckBox checkBoxGuidatore;
	private JLabel lblSelezioneTarga;
	private JTextField UserTxt;
	private JTextField PasswordTxt;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UtenteRegistratoBoundary frame = new UtenteRegistratoBoundary();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
public void addRowToJTable(Date Inizio, Date Fine, String segm)
    {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        ArrayList<Auto> list = GestoreNoleggio.RicercaAutoPerDate(Inizio,Fine,segm);
        Object rowData[] = new Object[7];
        for(int i = 0; i < list.size(); i++)
        {
            rowData[0] = list.get(i).getModello();
            rowData[1] = list.get(i).getPrezzo();
            rowData[2] = list.get(i).getTarga();
            rowData[3] = list.get(i).getCapienza();
            rowData[4] = list.get(i).getPotenza();
            rowData[5] = list.get(i).getAlimentazione();
            rowData[6] = list.get(i).getSegmento();
            model.addRow(rowData);
        }
    }
public void addRowtoJAccessori(String accessorio) {
	 DefaultTableModel model = (DefaultTableModel) table_Accessori.getModel();
       Object rowData[] = new Object[1];
       rowData[0] = accessorio;
       model.addRow(rowData);
       
}
	
private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {                                     
	        
	        // get the model from the jtable
	       DefaultTableModel model = (DefaultTableModel)table.getModel();

	        // get the selected row index
	       int selectedRowIndex = table.getSelectedRow();
	       
	        
	    }   
	/**
	 * Create the frame.
	 */
	public UtenteRegistratoBoundary() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 650);
		Pannello = new JPanel();
		Pannello.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Pannello);
		Pannello.setLayout(null);
		
		JLabel LabelDataInizio = new JLabel("Data Inizio");
		LabelDataInizio.setFont(new Font("Lato", Font.BOLD, 14));
		LabelDataInizio.setBounds(58, 18, 100, 33);
		Pannello.add(LabelDataInizio);
		
		JLabel LabelAccessori = new JLabel("Accessori");
		LabelAccessori.setFont(new Font("Lato", Font.BOLD, 14));
		LabelAccessori.setBounds(58, 87, 93, 26);
		Pannello.add(LabelAccessori);
		
		final JLabel LabelPrezzoTotale = new JLabel("Prezzo Totale");
		LabelPrezzoTotale.setFont(new Font("Lato", Font.BOLD, 15));
		LabelPrezzoTotale.setBounds(58, 568, 748, 20);
		LabelPrezzoTotale.setVisible(false);
		Pannello.add(LabelPrezzoTotale);
		
		JButton LabelIndietro = new JButton("INDIETRO");
		LabelIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.MainProva finestraIndietro = new main.MainProva();
				finestraIndietro.setVisible(true);
				setVisible(false);
			}
		});
		LabelIndietro.setFont(new Font("Lato", Font.PLAIN, 12));
		LabelIndietro.setBounds(509, 522, 111, 23);
		Pannello.add(LabelIndietro);
		
		final JDateChooser dateInizio = new JDateChooser();
		dateInizio.setBounds(218, 25, 169, 20);
		Pannello.add(dateInizio);
		
		final JDateChooser dateFinale = new JDateChooser();
		dateFinale.setBounds(218, 58, 169, 20);
		Pannello.add(dateFinale);
		
		JLabel LabelDataFine = new JLabel("Data Fine");
		LabelDataFine.setFont(new Font("Lato", Font.BOLD, 14));
		LabelDataFine.setBounds(58, 62, 79, 14);
		Pannello.add(LabelDataFine);
		
		JPanel panel = new JPanel();
		panel.setBounds(46, 191, 748, 174);
		Pannello.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 10, 736, 157);
		panel.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane.setColumnHeaderView(scrollPane_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Modello", "Prezzo", "Targa", "Capienza", "Potenza", "Alimentazione", "Segmento"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel labelSegmento = new JLabel("Segmento");
		labelSegmento.setBounds(435, 30, 79, 13);
		Pannello.add(labelSegmento);
		
		JButton btnRicerca = new JButton("RICERCA");
		btnRicerca.setFont(new Font("Lato", Font.PLAIN, 12));
		btnRicerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblAvviso.setVisible(false);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0);
                boolean flag=true;
                String segmento = comboBox_Segmento.getSelectedItem().toString();
                
                if(dateInizio.getDate()==null) {flag=false; lblAvviso.setVisible(true);lblAvviso.setText("non puoi avere date nulle");}
                else if(dateFinale.getDate()==null) {flag=false; lblAvviso.setVisible(true);lblAvviso.setText("non puoi avere date nulle");}
                else if(dateInizio.getDate().getTime()>dateFinale.getDate().getTime()) {
                	flag=false;
                	lblAvviso.setText("date non corrette");
                	lblAvviso.setVisible(true);
				}
                else {
                	System.out.println(flag);
                	java.sql.Date sqlDateInizio = new java.sql.Date(dateInizio.getDate().getTime());
                	java.sql.Date sqlDateFinale = new java.sql.Date(dateFinale.getDate().getTime());
                	addRowToJTable( sqlDateInizio,sqlDateFinale,segmento );}
            }
			
		});

		table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
		btnRicerca.setBounds(546, 131, 120, 23);
		Pannello.add(btnRicerca);
		final JComboBox comboBox = new JComboBox();
		JButton ButtonNoleggia = new JButton("NOLEGGIA");
		ButtonNoleggia.setFont(new Font("Lato", Font.PLAIN, 12));
		ButtonNoleggia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LabelPrezzoTotale.setVisible(false);
				  DefaultTableModel model = (DefaultTableModel)table.getModel();
				  lblSelezioneTarga.setVisible(false);
			    	
			        // get the selected row index
			    int selectedRowIndex = table.getSelectedRow();
			    if (selectedRowIndex ==-1) {
			    	lblSelezioneTarga.setVisible(true);
			    	lblSelezioneTarga.setText("Seleziona prima una targa");
			    }
			    else {
				String user= UtenteBoundary.nomeUtente;
				String targa= model.getValueAt(selectedRowIndex, 2).toString();
				String prezzoTotaleStringa = model.getValueAt(selectedRowIndex, 1).toString();
				float prezzoTotale = Float.parseFloat(prezzoTotaleStringa);
				java.sql.Date sqlDateInizio = new java.sql.Date(dateInizio.getDate().getTime());
				java.sql.Date sqlDateFinale = new java.sql.Date(dateFinale.getDate().getTime());
				vect=new Object[table_Accessori.getModel().getRowCount()];
				for(int i=0;i<table_Accessori.getRowCount();i++) {
					vect[i]=table_Accessori.getModel().getValueAt(i,0);
				}
				String autista="NULL";
				boolean flag=true;
				if(checkBoxGuidatore.isSelected()) {
					flag=false;
					autista=UserTxt.getText();
					if(GestoreNoleggio.VerificaUtente(UserTxt.getText(),PasswordTxt.getText())) {
						if(autista.equals(user)) {
							LabelPrezzoTotale.setText("non puoi avere questo autista perche' e' uguale all utente");
							LabelPrezzoTotale.setVisible(true);}
						else{
						System.out.println(user+UserTxt.getText());
						String esito=GestoreNoleggio.Noleggia(user,targa,sqlDateInizio,sqlDateFinale, prezzoTotale,vect,table_Accessori.getRowCount(),comboBoxServizioAssiccurativo.getSelectedItem().toString(),autista);
						LabelPrezzoTotale.setText(esito);
						LabelPrezzoTotale.setVisible(true);
						}
					}
					else {
						LabelPrezzoTotale.setText("Utente errato");
						LabelPrezzoTotale.setVisible(true);
					}
				}
				else autista="NULL";
				if(flag==true) {
				String esito=GestoreNoleggio.Noleggia(user,targa,sqlDateInizio,sqlDateFinale, prezzoTotale,vect,table_Accessori.getRowCount(),comboBoxServizioAssiccurativo.getSelectedItem().toString(),autista);
				LabelPrezzoTotale.setText(esito);
				LabelPrezzoTotale.setVisible(true);}
			}}
		});
		ButtonNoleggia.setBounds(295, 522, 120, 23);
		Pannello.add(ButtonNoleggia);
		
		
		
		
		checkBoxGuidatore = new JCheckBox("AutistaSupplementare");
		checkBoxGuidatore.setBounds(58, 133, 147, 21);
		Pannello.add(checkBoxGuidatore);
		
		comboBox_Segmento = new JComboBox();
		comboBox_Segmento.setBounds(566, 26, 169, 21);
		Pannello.add(comboBox_Segmento);
		comboBox_Segmento.addItem("A");
		comboBox_Segmento.addItem("B");
		comboBox_Segmento.addItem("C");
		
		comboBoxServizioAssiccurativo = new JComboBox();
		comboBoxServizioAssiccurativo.setBounds(566, 74, 169, 21);
		Pannello.add(comboBoxServizioAssiccurativo);
		comboBoxServizioAssiccurativo.addItem("Assicurazione KASKO");
		comboBoxServizioAssiccurativo.addItem("Assicurazione Furto e Incendio");
		comboBoxServizioAssiccurativo.addItem("Assicurazione Eventi naturali");
		
		JLabel lblAssicurazioni = new JLabel("Servizio Assicurativo");
		lblAssicurazioni.setBounds(435, 78, 121, 13);
		Pannello.add(lblAssicurazioni);
		
		lblAvviso = new JLabel("New label");
		lblAvviso.setBounds(435, 105, 193, 13);
		lblAvviso.setVisible(false);
		Pannello.add(lblAvviso);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(236, 375, 417, 126);
		Pannello.add(scrollPane_2);
		
		table_Accessori = new JTable();
		table_Accessori.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Accessori"
			}
		));
		scrollPane_2.setViewportView(table_Accessori);
		comboBox.setBounds(218, 92, 169, 21);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					addRowtoJAccessori(comboBox.getSelectedItem().toString());
				}
			}
		});
		Pannello.add(comboBox);
		comboBox.addItem("-");
		comboBox.addItem("Aria Condizionata");
		comboBox.addItem("Seggiolino");
		comboBox.addItem("Cerchi in lega");
		comboBox.addItem("Assistenza stradale");
		comboBox.addItem("Catene per la neve");
		comboBox.addItem("Tetto rimovibile");
		comboBox.addItem("Vetri oscurati");
		JButton btnSvuota = new JButton("SVUOTA");
		btnSvuota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table_Accessori.getModel();
                model.setRowCount(0);
			}
		});
		btnSvuota.setBounds(58, 419, 85, 21);
		Pannello.add(btnSvuota);
		
		lblSelezioneTarga = new JLabel("New label");
		lblSelezioneTarga.setBounds(679, 382, 147, 13);
		Pannello.add(lblSelezioneTarga);
		
		UserTxt = new JTextField();
		UserTxt.setBounds(295, 134, 96, 19);
		Pannello.add(UserTxt);
		UserTxt.setColumns(10);
		
		PasswordTxt = new JTextField();
		PasswordTxt.setBounds(295, 160, 96, 19);
		Pannello.add(PasswordTxt);
		PasswordTxt.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("User");
		lblNewLabel.setBounds(229, 137, 45, 13);
		Pannello.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(218, 163, 45, 13);
		Pannello.add(lblNewLabel_1);
		lblSelezioneTarga.setVisible(false);
	}	
}