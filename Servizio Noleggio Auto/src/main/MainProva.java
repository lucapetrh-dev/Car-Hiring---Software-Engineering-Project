package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Control.GestoreNoleggio;

import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.Date;
import java.util.*;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

public class MainProva extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	public static String nomeUtente;
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
	public MainProva() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 557, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel Testo = new JLabel("AUTENTICAZIONE");
		Testo.setFont(new Font("Lato Black", Font.PLAIN, 28));
		Testo.setBounds(140, 28, 320, 68);
		contentPane.add(Testo);
		
		JButton Utente = new JButton("Utente");
		Utente.setFont(new Font("Lato", Font.PLAIN, 18));
		Utente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Boundary.UtenteBoundary finestra= new Boundary.UtenteBoundary();
				finestra.setVisible(true);
				setVisible(false);
			}
		});
		Utente.setBounds(111, 131, 125, 44);
		contentPane.add(Utente);
		
		JButton Operatore = new JButton("Operatore");
		Operatore.setFont(new Font("Lato", Font.PLAIN, 18));
		Operatore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Boundary.OperatoreBoundary finestra= new Boundary.OperatoreBoundary();
				finestra.setVisible(true);
				setVisible(false);
			}
		});
		Operatore.setBounds(298, 131, 125, 44);
		contentPane.add(Operatore);
	
	
	}
}
