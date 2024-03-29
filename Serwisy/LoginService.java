package System.Serwisy;

import System.Model.*;

import java.io.*;
import java.util.List;
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
	private String path=System.getProperty("user.dir") + "\\Users.txt";
	ServerMockUp server=new ServerMockUp();
	public Uzytkownik zarejestrujUzytkownika(String imie, String nazwisko, String mail, String haslo) throws IOException {

		System.out.println("dupa");
		// NewUser(imie:string,nazwisko:string,email:string,haslo:string)
		if (!isMailUsed(mail)) { //Pytamy serwera czy mail jest nowy. Komunikacja z serwerem ogólnie, ale nie mamy serwera
			if (czyHasloPoprawnyFormat(haslo)) {
				Uzytkownik uzytkownik = new Uzytkownik(imie, nazwisko, mail, haslo, 0);
				server.addUsers(uzytkownik);
				System.out.println("dupa");
				return uzytkownik;
			}
		}
		return null;
	}
private boolean isMailUsed(String mail) throws IOException {

	for(int i=0;i<server.getUsers().size();i++) {
		if (Objects.equals(mail, server.getUsers().get(i).getEmail())) {

			return true;
		}
	}

	return false;
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

	public Uzytkownik zalogujUzytkownika(String email,String password) throws Exception {
		List<Uzytkownik> list = server.getUsers();
		for (Uzytkownik u : list){
			if (u.getEmail().equals(email)){
				if (u.getHaslo().equals(password)){
					return u;
				}
				return null;
			}

		}
		return null;
	}

	public boolean isDataCorrect(String email, String password) throws IOException {

		//System.out.println(System.getProperty("user.dir")+"\\Users.txt");
		BufferedReader reader = new BufferedReader(new FileReader(path));

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
	public void setTestPath(String newPath)
	{
		path=newPath;
	}

}