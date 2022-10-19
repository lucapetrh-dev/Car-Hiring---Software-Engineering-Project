package Boundary;

import java.awt.BorderLayout;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import Entity.Auto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Control.GestoreNoleggio;
import main.MainProva;

import javax.swing.JLayeredPane;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

public class UtenteBoundary extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLayeredPane layeredPane;
	private JPanel panelLogin;
	private JLabel labelNomeUtente;
	private JLabel labelPassword;
	private JTextField textField_1;
	private JPasswordField passwordField_1;
	public static String nomeUtente;
	private JButton btnRegistrazione;
	private JPanel panelRegistrazione;
	private JButton btnRegistrati;
	private JTextField textNuovoUtente;
	private JTextField textNuovaPassword;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel labelEsito;
	private JTextField textNuovoNome;
	private JTextField textNuovoCognome;
	private JTextField textNuovaMail;
	private JTextField textPatente;
	private JTextField textScadenza;
	private JTextField textAnnoPatente;
	private JTextField textNuovaData;
	private JPanel panelRicerca;
	private JLabel labelSegmento;
	private JButton btnRicerca_1;
	private JScrollPane scrollPane;
	private JButton LabelIndietro;
	private JTextField txtCapienza;
	private JTextField txtSegmento;
	private JTextField txtPotenza;
	private JTextField txtAlimentazione;
	private JTable table;
	private JButton btnRicerca_2;
	private JButton LabelIndietro_1;
	private JLabel lblInizio;
	private JLabel lblFine;
	private JComboBox  comboBox_Segmento;
	private JDateChooser dateFine;
	private JDateChooser dateFine_1;
	private JDateChooser dateInizio;
	private JLabel lblAvviso;
	/**
	 * Launch the application.
	 */
	
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
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UtenteBoundary frame = new UtenteBoundary();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void switchPanels (JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
	
	public UtenteBoundary() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 748, 564);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(10, 11, 718, 503);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		panelLogin = new JPanel();
		layeredPane.add(panelLogin, "name_2349456930687800");
		panelLogin.setLayout(null);
		
		labelNomeUtente = new JLabel("Nome Utente");
		labelNomeUtente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelNomeUtente.setBounds(143, 124, 106, 13);
		panelLogin.add(labelNomeUtente);
		
		labelPassword = new JLabel("Password");
		labelPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelPassword.setBounds(143, 171, 91, 13);
		panelLogin.add(labelPassword);
		
		textField_1 = new JTextField();
		textField_1.setBounds(284, 123, 106, 19);
		panelLogin.add(textField_1);
		textField_1.setColumns(10);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(284, 170, 106, 19);
		panelLogin.add(passwordField_1);
		
		
		
		final JCheckBox chckbxNewCheckBox = new JCheckBox("Mostra");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox.isSelected()) {
					 passwordField_1.setEchoChar((char)0);
				}
				else {
					 passwordField_1.setEchoChar(('*'));
				}
			}
		});
		chckbxNewCheckBox.setBounds(405, 169, 93, 21);
		panelLogin.add(chckbxNewCheckBox);
		
		final JLabel lblEsito = new JLabel("New label");
		lblEsito.setBounds(424, 234, 143, 13);
		panelLogin.add(lblEsito);
		lblEsito.setVisible(false);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(GestoreNoleggio.VerificaUtente(textField_1.getText(),passwordField_1.getText() )) {
					Boundary.UtenteRegistratoBoundary finestra=new Boundary.UtenteRegistratoBoundary();
					finestra.setVisible(true);
					setVisible(false);
					nomeUtente=textField_1.getText();
				}
				else {
					lblEsito.setText("Utente o Password errati");
					lblEsito.setVisible(true);
				}
			}
		});
		btnLogin.setBounds(283, 230, 85, 21);
		panelLogin.add(btnLogin);
		
		JLabel labelRicerca = new JLabel("Ricerca senza registrarti");
		labelRicerca.setBounds(165, 295, 185, 13);
		panelLogin.add(labelRicerca);
		
		JButton btnRicerca = new JButton("RICERCA");
		btnRicerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelRicerca);
			}
		});
		btnRicerca.setBounds(333, 291, 115, 21);
		panelLogin.add(btnRicerca);
		
		btnRegistrazione = new JButton("REGISTRATI");
		btnRegistrazione.setBounds(405, 122, 93, 21);
		panelLogin.add(btnRegistrazione);
		btnRegistrazione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				switchPanels(panelRegistrazione);
			}
		});
		
		panelRegistrazione = new JPanel();
		layeredPane.add(panelRegistrazione, "name_519969593351000");

		labelEsito = new JLabel("New label");
		labelEsito.setBounds(438, 306, 45, 13);
		labelEsito.setVisible(false);
		panelRegistrazione.setLayout(null);
		panelRegistrazione.add(labelEsito);
		
		btnRegistrati = new JButton("Registrati");
		btnRegistrati.setBounds(281, 302, 136, 21);
		btnRegistrati.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean flag=false;
				if(GestoreNoleggio.VerificaUtente(textNuovoUtente.getText(),textNuovaPassword.getText() )) {
					labelEsito.setText("Utente gia' registrato");
					labelEsito.setVisible(true);
				}
				else {
					String Nome = null;
	                if (!textNuovoNome.getText().trim().isEmpty()) 
	                	Nome = textNuovoNome.getText();
	                else {
	            		labelEsito.setVisible(true);
						labelEsito.setText("Non puoi avere parametri nulli");
						flag=true;
					}
	                String Cognome = null;
	                if (!textNuovoCognome.getText().trim().isEmpty()) 
	                	Cognome = textNuovoCognome.getText();
	                else {
	            		labelEsito.setVisible(true);
						labelEsito.setText("Non puoi avere parametri nulli");
						flag=true;
					}
	                String Data_nascita = null;
	                if (!textNuovaData.getText().trim().isEmpty()) 
	                	Data_nascita = textNuovaData.getText();
	                else {
	            		labelEsito.setVisible(true);
						labelEsito.setText("Non puoi avere parametri nulli");
						flag=true;
					}
	                String Email = null;
	                if (!textNuovaMail.getText().trim().isEmpty()) 
	                	Email = textNuovaMail.getText();
	                else {
	            		labelEsito.setVisible(true);
						labelEsito.setText("Non puoi avere parametri nulli");
						flag=true;
					}
	                String Num_patente = null;
	                if (!textPatente.getText().trim().isEmpty()) 
	                	Num_patente = textPatente.getText();
	                else {
	            		labelEsito.setVisible(true);
						labelEsito.setText("Non puoi avere parametri nulli");
						flag=true;
					}
	                int Anno_patente = 0;
	                if (!textAnnoPatente.getText().trim().isEmpty()) 
	                	Anno_patente = Integer.parseInt(textAnnoPatente.getText());
	                else {
	            		labelEsito.setVisible(true);
						labelEsito.setText("Non puoi avere parametri nulli");
						flag=true;
					}
	                int Scad_patente = 0;
	                if (!textScadenza.getText().trim().isEmpty()) 
	                	Scad_patente = Integer.parseInt(textScadenza.getText());
	                else {
	            		labelEsito.setVisible(true);
						labelEsito.setText("Non puoi avere parametri nulli");
						flag=true;
					}
					String Utente = null;
	                if (!textNuovoUtente.getText().trim().isEmpty()) 
	                	Utente = textNuovoUtente.getText();
	                else {
	            		labelEsito.setVisible(true);
						labelEsito.setText("Non puoi avere parametri nulli");
						flag=true;
					}

					String Password = null;
	                if (!textNuovaPassword.getText().trim().isEmpty()) 
	                	Password = textNuovaPassword.getText();
	                else {
	            		labelEsito.setVisible(true);
						labelEsito.setText("Non puoi avere parametri nulli");
						flag=true;
					}               
	        
	                if(flag==false) {
					GestoreNoleggio.RegistraUtente(Nome,Cognome,Data_nascita,Email,Num_patente,Anno_patente,Scad_patente,Utente,Password);
					labelEsito.setText("Registrazione effettuata");
	                }
	                
					
				}
			}
		});
		panelRegistrazione.add(btnRegistrati);
		
		textNuovoUtente = new JTextField();
		textNuovoUtente.setBounds(231, 133, 96, 19);
		panelRegistrazione.add(textNuovoUtente);
		textNuovoUtente.setColumns(10);
		
		textNuovaPassword = new JTextField();
		textNuovaPassword.setBounds(231, 167, 96, 19);
		panelRegistrazione.add(textNuovaPassword);
		textNuovaPassword.setColumns(10);
		
		lblNewLabel = new JLabel("Password");
		lblNewLabel.setBounds(155, 171, 85, 13);
		panelRegistrazione.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setBounds(155, 137, 85, 13);
		panelRegistrazione.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nome");
		lblNewLabel_2.setBounds(155, 207, 85, 14);
		panelRegistrazione.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Cognome");
		lblNewLabel_3.setBounds(155, 244, 85, 14);
		panelRegistrazione.add(lblNewLabel_3);
		
		textNuovoNome = new JTextField();
		textNuovoNome.setBounds(231, 204, 96, 20);
		panelRegistrazione.add(textNuovoNome);
		textNuovoNome.setColumns(10);
		
		textNuovoCognome = new JTextField();
		textNuovoCognome.setColumns(10);
		textNuovoCognome.setBounds(231, 239, 96, 20);
		panelRegistrazione.add(textNuovoCognome);
		
		JLabel lblNewLabel_4 = new JLabel("Data Nascita");
		lblNewLabel_4.setBounds(337, 136, 107, 14);
		panelRegistrazione.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Email");
		lblNewLabel_5.setBounds(337, 172, 80, 14);
		panelRegistrazione.add(lblNewLabel_5);
		
		textNuovaMail = new JTextField();
		textNuovaMail.setBounds(419, 167, 86, 20);
		panelRegistrazione.add(textNuovaMail);
		textNuovaMail.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Numero Patente");
		lblNewLabel_6.setBounds(337, 207, 96, 14);
		panelRegistrazione.add(lblNewLabel_6);
		
		textPatente = new JTextField();
		textPatente.setBounds(448, 204, 86, 20);
		panelRegistrazione.add(textPatente);
		textPatente.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Scadenza Patente");
		lblNewLabel_7.setBounds(337, 232, 107, 14);
		panelRegistrazione.add(lblNewLabel_7);
		
		textScadenza = new JTextField();
		textScadenza.setBounds(448, 229, 86, 20);
		panelRegistrazione.add(textScadenza);
		textScadenza.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Anno Patente");
		lblNewLabel_8.setBounds(337, 257, 96, 14);
		panelRegistrazione.add(lblNewLabel_8);
		
		textAnnoPatente = new JTextField();
		textAnnoPatente.setBounds(448, 254, 86, 20);
		panelRegistrazione.add(textAnnoPatente);
		textAnnoPatente.setColumns(10);
		
		textNuovaData = new JTextField();
		textNuovaData.setBounds(419, 133, 86, 20);
		panelRegistrazione.add(textNuovaData);
		textNuovaData.setColumns(10);
		
		LabelIndietro_1 = new JButton("Indietro");
		LabelIndietro_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.MainProva finestraIndietro = new main.MainProva();
				finestraIndietro.setVisible(true);
				setVisible(false);
			}
		});
		LabelIndietro_1.setFont(new Font("Lato", Font.PLAIN, 12));
		LabelIndietro_1.setBounds(602, 432, 89, 23);
		panelRegistrazione.add(LabelIndietro_1);
		
		panelRicerca = new JPanel();
		layeredPane.add(panelRicerca, "name_37555079289200");
		panelRicerca.setLayout(null);
		
		labelSegmento = new JLabel("Segmento");
		labelSegmento.setBounds(22, 71, 102, 13);
		panelRicerca.add(labelSegmento);
		
		btnRicerca_2 = new JButton("RICERCA");
		btnRicerca_2.setBounds(273, 118, 85, 21);
		btnRicerca_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblAvviso.setVisible(false);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0);
                boolean flag=true;
                String segmento = comboBox_Segmento.getSelectedItem().toString();
                
                if(dateInizio.getDate()==null) {flag=false; lblAvviso.setVisible(true);lblAvviso.setText("non puoi avere date nulle");}
                else if(dateFine_1.getDate()==null) {flag=false; lblAvviso.setVisible(true);lblAvviso.setText("non puoi avere date nulle");}
                else if(dateInizio.getDate().getTime()>dateFine_1.getDate().getTime()) {
                	flag=false;
                	lblAvviso.setText("date non corrette");
                	lblAvviso.setVisible(true);
				}
                else {
                	System.out.println(flag);
                	java.sql.Date sqlDateInizio = new java.sql.Date(dateInizio.getDate().getTime());
                	java.sql.Date sqlDateFinale = new java.sql.Date(dateFine_1.getDate().getTime());
                	addRowToJTable( sqlDateInizio,sqlDateFinale,segmento );}
            }
		});
		panelRicerca.add(btnRicerca_2);
		
		JPanel panelQuery = new JPanel();
		panelQuery.setBounds(10, 199, 698, 236);
		panelRicerca.add(panelQuery);
		panelQuery.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 175, 698, 236);
		panelRicerca.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Modello", "Prezzo", "Targa", "Capienza", "Potenza", "Alimentazione", "Segmento"
			}
		));
		scrollPane.setViewportView(table);
		
		LabelIndietro = new JButton("Indietro");
		LabelIndietro.setBounds(608, 452, 89, 23);
		LabelIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.MainProva finestraIndietro = new main.MainProva();
				finestraIndietro.setVisible(true);
				setVisible(false);
			}
		});
		LabelIndietro.setFont(new Font("Lato", Font.PLAIN, 12));
		panelRicerca.add(LabelIndietro);
		
		comboBox_Segmento = new JComboBox();
		comboBox_Segmento.setBounds(109, 67, 110, 21);
		panelRicerca.add(comboBox_Segmento);
		comboBox_Segmento.addItem("A");
		comboBox_Segmento.addItem("B");
		comboBox_Segmento.addItem("C");
		
		dateInizio = new JDateChooser();
		dateInizio.setBounds(369, 65, 70, 19);
		panelRicerca.add(dateInizio);
		
		dateFine_1 = new JDateChooser();
		dateFine_1.setBounds(558, 67, 70, 19);
		panelRicerca.add(dateFine_1);
		
		lblInizio = new JLabel("Data Inizio");
		lblInizio.setBounds(288, 71, 70, 13);
		panelRicerca.add(lblInizio);
		
		lblFine = new JLabel("Data Fine");
		lblFine.setBounds(484, 71, 45, 13);
		panelRicerca.add(lblFine);
		
		lblAvviso = new JLabel("inserisci bene le date");
		lblAvviso.setBounds(212, 458, 227, 13);
		lblAvviso.setVisible(false);
		panelRicerca.add(lblAvviso);
	
	}
}
