package System.Serwisy;

import System.Model.*;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginService {

	/**
	 * 
	 * @param imie
	 * @param nazwisko
	 * @param mail
	 */

	public Uzytkownik zarejestrujUzytkownika(String imie, String nazwisko, String mail, String haslo) {


		// NewUser(imie:string,nazwisko:string,email:string,haslo:string)
		if (true) { //Pytamy serwera czy mail jest nowy. Komunikacja z serwerem ogólnie, ale nie mamy serwera
			if (czyHasloPoprawnyFormat(haslo)) {
				//Tutaj wysłać informację
				Uzytkownik uzytkownik = new Uzytkownik(imie, nazwisko, mail, haslo, 0);
				return uzytkownik;
			}
		}
		return null;
	}

	private boolean czyHasloPoprawnyFormat(String haslo) {
		// ReGex to check if a string
		// contains uppercase, lowercase
		// special character & numeric value
		String regex = "^(?=.*[a-z])(?=."
				+ "*[A-Z])(?=.*\\d)"
				+ "(?=.*[-+_!@#$%^&*., ?]).+$";
		// Compile the ReGex
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(haslo);

		if (m.matches()) {
			if (haslo.length() > 8) {
				return true;
			}
			System.out.println("Haslo za krotkie");
		}
		else{
			System.out.println("Haslo musi zawierac duża literę, małą literą, znak specjalny i cyfrę");
		}
		return false;
	}

	public Uzytkownik zalogujUzytkownika(String email) throws Exception {

			BufferedReader reader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\Users.txt"));
			String imie="";
			String nazwisko="";
			String haslo="";
			while(reader.ready())
			{
				if (Objects.equals(reader.readLine(), email)) {
					haslo=reader.readLine();
					imie=reader.readLine();
					nazwisko=reader.readLine();
				}
			}
			if(!Objects.equals(imie, ""))
				return new Uzytkownik(imie,nazwisko,email,haslo,0);
			else {
				throw new Exception("Cos poszlo nie tak");
			}
	}

	public boolean isDataCorrect(String email, String password) throws IOException {

		//System.out.println(System.getProperty("user.dir")+"\\Users.txt");
		BufferedReader reader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\Users.txt"));

		while (reader.ready()) {
			if (Objects.equals(reader.readLine(), email)) {
				if (Objects.equals(reader.readLine(), password)) {
					reader.close();
					return true;
				}
			}

		}
		reader.close();
		return false;
	}
	public LoginService() {

	}

	/**
	 * 
	 * @param uzytkownik
	 */

	public LoginService(Uzytkownik uzytkownik) {
		// TODO - implement LoginService.LoginService
		throw new UnsupportedOperationException();
	}


}