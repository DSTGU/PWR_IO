package System;

import System.Model.*;
import System.Serwisy.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Objects;
import java.util.stream.StreamSupport;

public class Aplikacja {

	public Uzytkownik zalogowanyUzytkownik; // Should be private. I m testing in main
	public UzytkownikService uzytkownikService;
	public WydarzenieService wydarzenieService;
	public SkargaService skargaService;
	public DziennikDzialanService dziennikDzialanService;
	public LoginService loginService;
	private JFrame frame;
	private JFrame login_screen;

	Aplikacja() {
		uzytkownikService = new UzytkownikService();
		wydarzenieService = new WydarzenieService();
		skargaService = new SkargaService();
		dziennikDzialanService = new DziennikDzialanService();
		loginService = new LoginService();
		zalogowanyUzytkownik = null;

		frame = new JFrame("Wendkarz");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(410, 300);

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
		JButton login = new JButton("Zaloguj");
		panel.add(login);
		login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				set_login_screen();
			}
		});
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Uzytkownik uzytkownik = loginService.zarejestrujUzytkownika(imieTextfield.getText(), nazwiskoTextfield.getText(), emailTextfield.getText(), hasloTextfield.getText());
				if (uzytkownik != null) {
					//zalogowanyUzytkownik = uzytkownik;
					try {
						BufferedWriter writer = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "\\Users.txt", true));
						writer.append(uzytkownik.getEmail());
						writer.newLine();
						writer.append(uzytkownik.getHaslo());//hihi a bit of mischief
						writer.newLine();
						writer.append(uzytkownik.getImie());
						writer.newLine();
						writer.append(uzytkownik.getNazwisko());
						writer.newLine();
						writer.close();
					} catch (IOException ex) {
						JOptionPane.showMessageDialog(frame, "smh nie masz pliku Users.txt ;-;");
					}
					JOptionPane.showMessageDialog(frame, "Zarejestrowano uzytkownika");
				}
			}
		});

		frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.setVisible(true);
	}

	void set_login_screen() {
		frame.setVisible(false);
		//frame.dispose();
		login_screen = new JFrame("Login");
		login_screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login_screen.setSize(410, 300);
		//login_screen.setVisible(true);
		JPanel loginPanel = new JPanel();
		JLabel emailLabel = new JLabel("Email");
		JTextField emailTextField = new JTextField(32);
		loginPanel.add(emailLabel);
		loginPanel.add(emailTextField);
		JLabel passwordLabel = new JLabel("Haslo");
		JTextField passwordTextField = new JTextField(32);
		loginPanel.add(passwordLabel);
		loginPanel.add(passwordTextField);
		JButton back = new JButton("Powrot");
		JButton login = new JButton("Zaloguj");
		loginPanel.add(login);
		loginPanel.add(back);
		login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (loginService.isDataCorrect(emailTextField.getText(), passwordTextField.getText())) {

							zalogowanyUzytkownik = loginService.zalogujUzytkownika(emailTextField.getText());



					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(login_screen,ex.getMessage());

				}
			}

		});
		login_screen.getContentPane().add(BorderLayout.CENTER, loginPanel);
		login_screen.setVisible(true);
	}










}