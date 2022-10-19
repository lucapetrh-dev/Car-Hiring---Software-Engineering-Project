package Boundary;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import Control.GestoreNoleggio;
import DB.DBAuto;
import main.MainProva;

import javax.swing.JLayeredPane;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;

public class OperatoreBoundary extends JFrame {

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
	private JPanel panelModificaNoleggio;
	private JPanel panelOperazioni;
	private JButton btnRegistra_1;
	private JButton btnModifica_1;
	private JPanel panelRegistra;
	private JTextField textTarga;
	private JTextField textCapienza;
	private JTextField textSegmento;
	private JTextField textModello;
	private JTextField textPrezzo;
	private JTextField textPotenza;
	private JTextField textAlimentazione;
	private JTable table;
	private JDateChooser dateChooser1;
	private JDateChooser dateChooser2;
	private JLabel targa;
	private JButton LabelIndietro_1;
	private JPanel panelModifica;
	private JLabel lblStato;
	private JLabel lblEsito1;
	private JButton btnModifica_2;
	private JTable table_RicercaModifica;
	private JLabel targaModifica;
	private JComboBox comboBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainProva frame = new MainProva();
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
	
	public void addRowToJTable()
    {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        Object [][] vect = GestoreNoleggio.RicercaTarga();
    	System.out.println(vect [0][0]);
    	System.out.println(vect [0][0]);

        Object rowData[] = new Object[3];
        for(int i = 0; i < DBAuto.dim; i++)
        {
            rowData[0] = vect[i][0];
            rowData[1] = vect[i][1];
            rowData[2] = vect[i][2];
            model.addRow(rowData);
        }
    }
	public void addRowtoTable()
    {
        DefaultTableModel model = (DefaultTableModel) table_RicercaModifica.getModel();
        Object [][] vect = GestoreNoleggio.RicercaPerModifica();
    	System.out.println(vect [0][0]);
    	System.out.println(vect [0][0]);

        Object rowData[] = new Object[3];
        for(int i = 0; i < DBAuto.dim; i++)
        {
            rowData[0] = vect[i][0];
            rowData[1] = vect[i][1];
            rowData[2] = vect[i][2];
            model.addRow(rowData);
        }
    }
 private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {                                     
        
        // get the model from the jtable
       DefaultTableModel model = (DefaultTableModel)table.getModel();

        // get the selected row index
       int selectedRowIndex = table.getSelectedRow();
       
        // set the selected row data into jtextfields
       
      
       targa.setText(model.getValueAt(selectedRowIndex, 0).toString());
        
	
 }
 private void jTable1MouseClicked2(java.awt.event.MouseEvent evt) {                                     
     
     // get the model from the jtable
    DefaultTableModel model = (DefaultTableModel)table_RicercaModifica.getModel();

     // get the selected row index
    int selectedRowIndex = table_RicercaModifica.getSelectedRow();
    
     // set the selected row data into jtextfields
    
    targaModifica.setVisible(false);
    targaModifica.setText(model.getValueAt(selectedRowIndex, 0).toString());
     
	
}

	public OperatoreBoundary() {
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
				if(GestoreNoleggio.VerificaOperatore(textField_1.getText(),passwordField_1.getText() )) {
					switchPanels(panelOperazioni);
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
		
		panelOperazioni = new JPanel();
		panelOperazioni.setLayout(null);
		layeredPane.add(panelOperazioni, "name_45603522076000");
		
		btnRegistra_1 = new JButton("REGISTRA VEICOLO");
		btnRegistra_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelRegistra);
			}
		});
		btnRegistra_1.setBounds(103, 195, 138, 49);
		panelOperazioni.add(btnRegistra_1);
		
		btnModifica_1 = new JButton("MODIFICA NOLEGGI");
		btnModifica_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelModificaNoleggio);
			}
		});
		btnModifica_1.setBounds(287, 195, 138, 49);
		panelOperazioni.add(btnModifica_1);
		
		btnModifica_2 = new JButton("MODIFICA VEICOLO");
		btnModifica_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelModifica);
			}
		});
		btnModifica_2.setBounds(468, 195, 138, 49);
		panelOperazioni.add(btnModifica_2);
		
		panelModificaNoleggio = new JPanel();
		panelModificaNoleggio.setLayout(null);
		layeredPane.add(panelModificaNoleggio, "name_37555079289200");
		
		panelModifica = new JPanel();
		layeredPane.add(panelModifica, "name_26956070058300");
		panelModifica.setLayout(null);
		
		lblStato = new JLabel("Stato Veicolo");
		lblStato.setBounds(105, 264, 85, 14);
		panelModifica.add(lblStato);
		
		JButton btnNewButton = new JButton("Modifica");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblEsito1.setVisible(false);
				if(targaModifica.getText().trim().isEmpty()) {
					lblEsito1.setVisible(true);
					lblEsito1.setText("seleziona prima un veicolo da modificare");
				}
				else {
					if(comboBox.getSelectedItem().toString()=="TRUE")
                		GestoreNoleggio.ModificaAuto(targaModifica.getText(),true);
					else	GestoreNoleggio.ModificaAuto(targaModifica.getText(),false);
				}
		}
	});
		btnNewButton.setBounds(236, 326, 89, 23);
		panelModifica.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Indietro");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.MainProva finestraIndietro = new main.MainProva();
				finestraIndietro.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(591, 435, 89, 23);
		panelModifica.add(btnNewButton_1);
		
		lblEsito1 = new JLabel("Seleziona prima un veicolo da modificare");
		lblEsito1.setVisible(false);
		lblEsito1.setBounds(355, 330, 230, 14);
		panelModifica.add(lblEsito1);

		comboBox = new JComboBox();
		comboBox.setBounds(214, 261, 134, 21);
		panelModifica.add(comboBox);
		comboBox.addItem("TRUE");
		comboBox.addItem("FALSE");
		
		JLabel lblNewLabel_3 = new JLabel("Verranno mostrati unicamente i veicoli non partecipanti ad un noleggio per modificarne lo stato");
		lblNewLabel_3.setBounds(10, 10, 679, 13);
		panelModifica.add(lblNewLabel_3);
		
		JButton btnNewButtonRicerca = new JButton("Aggiorna Ricerca");
		btnNewButtonRicerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table_RicercaModifica.getModel();
                model.setRowCount(0);
				addRowtoTable();
			}
		});
		btnNewButtonRicerca.setBounds(555, 49, 134, 21);
		panelModifica.add(btnNewButtonRicerca);
		
		JLabel lblNewLabel_4 = new JLabel("Selezionare il veicolo da modificare");
		lblNewLabel_4.setBounds(105, 227, 305, 13);
		panelModifica.add(lblNewLabel_4);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(27, 49, 500, 168);
		panelModifica.add(scrollPane_1);
		
		table_RicercaModifica = new JTable();
		table_RicercaModifica.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Targa", "Modello", "Stato"
			}
		));
		scrollPane_1.setViewportView(table_RicercaModifica);
		
		targaModifica = new JLabel("");
		targaModifica.setBounds(604, 88, 45, 13);
		panelModifica.add(targaModifica);
		
		panelRegistra = new JPanel();
		panelRegistra.setLayout(null);
		layeredPane.add(panelRegistra, "name_45623631926400");
		
		JLabel LabelModello = new JLabel("Modello");
		LabelModello.setFont(new Font("Lato", Font.BOLD, 12));
		LabelModello.setBounds(165, 122, 85, 22);
		panelRegistra.add(LabelModello);
		
		JLabel LabelTarga = new JLabel("Targa");
		LabelTarga.setFont(new Font("Lato", Font.BOLD, 12));
		LabelTarga.setBounds(165, 164, 85, 22);
		panelRegistra.add(LabelTarga);
		
		JLabel LabelPrezzo = new JLabel("Prezzo");
		LabelPrezzo.setFont(new Font("Lato", Font.BOLD, 12));
		LabelPrezzo.setBounds(369, 164, 85, 22);
		panelRegistra.add(LabelPrezzo);
		
		JLabel LabelNumPass = new JLabel("Capienza");
		LabelNumPass.setFont(new Font("Lato", Font.BOLD, 12));
		LabelNumPass.setBounds(164, 207, 85, 22);
		panelRegistra.add(LabelNumPass);
		
		JLabel LabelPotenza = new JLabel("Potenza");
		LabelPotenza.setFont(new Font("Lato", Font.BOLD, 12));
		LabelPotenza.setBounds(370, 208, 85, 22);
		panelRegistra.add(LabelPotenza);
		
		JLabel LabelSegmento = new JLabel("Segmento");
		LabelSegmento.setFont(new Font("Lato", Font.BOLD, 12));
		LabelSegmento.setBounds(164, 248, 85, 22);
		panelRegistra.add(LabelSegmento);
		
		JLabel LabelAlimentazione = new JLabel("Alimentaz.");
		LabelAlimentazione.setFont(new Font("Lato", Font.BOLD, 12));
		LabelAlimentazione.setBounds(369, 247, 85, 22);
		panelRegistra.add(LabelAlimentazione);
		
		textTarga = new JTextField();
		textTarga.setColumns(10);
		textTarga.setBounds(244, 166, 112, 20);
		panelRegistra.add(textTarga);
		
		textCapienza = new JTextField();
		textCapienza.setColumns(10);
		textCapienza.setBounds(244, 209, 112, 20);
		panelRegistra.add(textCapienza);
		
		textSegmento = new JTextField();
		textSegmento.setColumns(10);
		textSegmento.setBounds(244, 249, 112, 20);
		panelRegistra.add(textSegmento);
		
		textModello = new JTextField();
		textModello.setColumns(10);
		textModello.setBounds(244, 124, 302, 20);
		panelRegistra.add(textModello);
		
		textPrezzo = new JTextField();
		textPrezzo.setColumns(10);
		textPrezzo.setBounds(434, 166, 112, 20);
		panelRegistra.add(textPrezzo);
		
		textPotenza = new JTextField();
		textPotenza.setColumns(10);
		textPotenza.setBounds(434, 209, 112, 20);
		panelRegistra.add(textPotenza);
		
		textAlimentazione = new JTextField();
		textAlimentazione.setColumns(10);
		textAlimentazione.setBounds(434, 249, 112, 20);
		panelRegistra.add(textAlimentazione);

		final JLabel LabelEsito = new JLabel("Esito");
		LabelEsito.setFont(new Font("Lato Black", Font.PLAIN, 14));
		LabelEsito.setBounds(351, 304, 166, 14);
		LabelEsito.setVisible(false);
		panelRegistra.add(LabelEsito);
		
		JButton Registrazione = new JButton("Registrazione");
		Registrazione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean flag=true;
					int prezzo=0;
					if (!textPrezzo.getText().trim().isEmpty()) 
						prezzo=Integer.parseInt(textPrezzo.getText());
						else {
							LabelEsito.setVisible(true);
						LabelEsito.setText("Non puoi avere parametri non nulli");
						flag=false;
					}

					int capienza=0;
					if (!textCapienza.getText().trim().isEmpty()) 
	                    capienza=Integer.parseInt(textCapienza.getText());						
	                    else {
	                		LabelEsito.setVisible(true);
							LabelEsito.setText("Non puoi avere parametri non nulli");
							flag=false;
						}


	                int potenza = 0;
	                if (!textPotenza.getText().trim().isEmpty()) 
	                    potenza = Integer.parseInt(textPotenza.getText());
	                else {
	            		LabelEsito.setVisible(true);
							LabelEsito.setText("Non puoi avere parametri non nulli");
							flag=false;
						}


	                String alimentazione = null;
	                if (!textAlimentazione.getText().trim().isEmpty()) 
	                alimentazione = textAlimentazione.getText();
	                else {
	            		LabelEsito.setVisible(true);
						LabelEsito.setText("Non puoi avere parametri non nulli");
						flag=false;
					}

	                
	                String modello = null;
	                if (!textModello.getText().trim().isEmpty()) 
	                modello = textModello.getText();
	                else {
	            		LabelEsito.setVisible(true);
						LabelEsito.setText("Non puoi avere parametri non nulli");
						flag=false;
					}

	                
	                String segmento = null;
	                if (!textSegmento.getText().trim().isEmpty()) 
	                segmento = textSegmento.getText();
	                else {
	            		LabelEsito.setVisible(true);
						LabelEsito.setText("Non puoi avere parametri non nulli");
						flag=false;
					}

	                
	                String targa = null;
	                if (!textTarga.getText().trim().isEmpty()) 
	                targa = textTarga.getText();
	                else {
	            		LabelEsito.setVisible(true);
						LabelEsito.setText("Non puoi avere parametri non nulli");
						flag=false;
					}
	                
	                boolean StatoVeicolo = true;
	                if(flag==true)
	                	GestoreNoleggio.InserisciAuto(modello, prezzo, targa, capienza, potenza, alimentazione, segmento, StatoVeicolo);
			}
		});
		Registrazione.setFont(new Font("Lato Black", Font.PLAIN, 12));
		Registrazione.setBounds(217, 299, 113, 23);
		panelRegistra.add(Registrazione);
		
		JButton LabelIndietro = new JButton("Indietro");
		LabelIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelOperazioni);
			}
		});
		LabelIndietro.setFont(new Font("Lato", Font.PLAIN, 12));
		LabelIndietro.setBounds(590, 440, 89, 23);
		panelRegistra.add(LabelIndietro);
		
		JButton btnRicerca = new JButton("Ricerca");
		btnRicerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0);
				addRowToJTable();
			}
		});
		btnRicerca.setBounds(509, 147, 85, 21);
		panelModificaNoleggio.add(btnRicerca);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(121, 119, 338, 76);
		panelModificaNoleggio.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Targa", "Data Inizio", "Data Fine"
			}
		));
		scrollPane.setViewportView(table);
		
		table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
		table_RicercaModifica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked2(evt);
            }
        });
		
		dateChooser1 = new JDateChooser();
		dateChooser1.setBounds(121, 250, 106, 19);
		panelModificaNoleggio.add(dateChooser1);
		
		dateChooser2 = new JDateChooser();
		dateChooser2.setBounds(261, 250, 123, 19);
		panelModificaNoleggio.add(dateChooser2);
		
		final JLabel esito = new JLabel("");
		esito.setBounds(126, 354, 484, 13);
		esito.setVisible(false);
		panelModificaNoleggio.add(esito);

		targa = new JLabel("");
		targa.setBounds(549, 256, 45, 13);
		panelModificaNoleggio.add(targa);
		
		JButton btnModifica = new JButton("Modifica");
		btnModifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				esito.setVisible(false);
				if(dateChooser1.getDate()==null) { esito.setVisible(true);esito.setText("non puoi avere date nulle");}
				else if(dateChooser2.getDate()==null) { esito.setVisible(true);esito.setText("non puoi avere date nulle");}
				else if(dateChooser1.getDate().getTime()>dateChooser2.getDate().getTime()) {
					esito.setText("date non corrette");
					esito.setVisible(true);
				}
				else if(targa.getText().trim().isEmpty()) {
					esito.setVisible(true);
					esito.setText("seleziona prima un veicolo da modificare");
				}
				else {
				java.sql.Date sqlDateInizio = new java.sql.Date(dateChooser1.getDate().getTime());
				java.sql.Date sqlDateFinale = new java.sql.Date(dateChooser2.getDate().getTime());
				GestoreNoleggio.AggiornaVeicolo(targa.getText(),sqlDateInizio,sqlDateFinale);
				esito.setText("Veicolo aggiornato");
				esito.setVisible(true);
				}
			}
		});
		btnModifica.setBounds(121, 295, 85, 21);
		panelModificaNoleggio.add(btnModifica);

		JButton btnElimina = new JButton("Elimina");
		btnElimina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Targa = null;
				if(dateChooser1.getDate()==null) { esito.setVisible(true);esito.setText("non puoi avere date nulle");}
				else if(dateChooser2.getDate()==null) { esito.setVisible(true);esito.setText("non puoi avere date nulle");}
				else if(dateChooser1.getDate().getTime()>dateChooser2.getDate().getTime()) {
					esito.setText("date non corrette");
					esito.setVisible(true);
				}
				else if(targa.getText().trim().isEmpty()) {
					esito.setVisible(true);
					esito.setText("seleziona prima un veicolo da modificare");
				}
				else {
                	Targa = targa.getText();
				GestoreNoleggio.EliminaNoleggio(targa.getText());
				esito.setVisible(true);
				esito.setText("Noleggio eliminato");
				}

			}
		});
		btnElimina.setBounds(274, 295, 85, 21);
		panelModificaNoleggio.add(btnElimina);
		
		JLabel lblNewLabel_1 = new JLabel("Inizio");
		lblNewLabel_1.setBounds(121, 229, 45, 13);
		panelModificaNoleggio.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Fine");
		lblNewLabel_2.setBounds(261, 229, 45, 13);
		panelModificaNoleggio.add(lblNewLabel_2);
		
		
		JLabel lblNewLabel = new JLabel("Targa:");
		lblNewLabel.setBounds(463, 256, 131, 13);
		panelModificaNoleggio.add(lblNewLabel);
		
		LabelIndietro_1 = new JButton("Indietro");
		LabelIndietro_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelOperazioni);
				
			}
		});
		LabelIndietro_1.setFont(new Font("Lato", Font.PLAIN, 12));
		LabelIndietro_1.setBounds(604, 446, 89, 23);
		panelModificaNoleggio.add(LabelIndietro_1);
		
	}
}