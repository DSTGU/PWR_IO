package System;

import System.Model.*;
import System.Serwisy.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Aplikacja {

	public Uzytkownik zalogowanyUzytkownik; // Should be private. I m testing in main
	public UzytkownikService uzytkownikService;
	public WydarzenieService wydarzenieService;
	public SkargaService skargaService;
	public DziennikDzialanService dziennikDzialanService;
	public LoginService loginService;

	Aplikacja(){
		uzytkownikService = new UzytkownikService();
		wydarzenieService = new WydarzenieService();
		skargaService = new SkargaService();
		dziennikDzialanService = new DziennikDzialanService();
		loginService = new LoginService();
		zalogowanyUzytkownik = null;

		JFrame frame = new JFrame("Wendkarz");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(410,300);

		JPanel panel = new JPanel();

		JLabel imieLabel = new JLabel("Imie");
		JTextField imieTextfield = new JTextField(32);
		panel.add(imieLabel);
		panel.add(imieTextfield);

		JLabel nazwiskoLabel = new JLabel("Nazwisko");
		JTextField nazwiskoTextfield = new JTextField(32);
		panel.add(nazwiskoLabel);
		panel.add(nazwiskoTextfield);

		JLabel emailLabel = new JLabel("Email");
		JTextField emailTextfield = new JTextField(32);
		panel.add(emailLabel);
		panel.add(emailTextfield);

		JLabel hasloLabel = new JLabel("Haslo");
		JTextField hasloTextfield = new JTextField(32);
		panel.add(hasloLabel);
		panel.add(hasloTextfield);

		JButton button = new JButton("Utworz konto");
		panel.add(button);

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Uzytkownik uzytkownik = loginService.zarejestrujUzytkownika(imieTextfield.getText(), nazwiskoTextfield.getText(), emailTextfield.getText(), hasloTextfield.getText());
				if (uzytkownik != null) {
					zalogowanyUzytkownik = uzytkownik;
					System.out.println("Zarejestrowano uzytkownika");
				}
			}
		});

		frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.setVisible(true);
	}






}