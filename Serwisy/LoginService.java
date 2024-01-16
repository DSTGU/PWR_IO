package System.Serwisy;

import System.Model.*;

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

	public void zalogujUzytkownika() {
		// TODO - implement LoginService.ZalogujUzytkownika
		throw new UnsupportedOperationException();
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