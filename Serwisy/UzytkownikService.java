package System.Serwisy;

import System.Model.*;

public class UzytkownikService {

	private Uzytkownik uzytkownik;
	private ServerMockUp server;

	public UzytkownikService(){
		server = new ServerMockUp();
	}

	/**
	 * 
	 * @param typ
	 * @param dana
	 */
	public void edytowanie_uzytkownika(String typ, int dana) {
		// TODO - implement UzytkownikService.edytowanie_uzytkownika
		throw new UnsupportedOperationException();
	}

	public boolean usuniecie_uzytkownika(String imie){
		Uzytkownik user = server.getUser(imie);
		if (user != null) {
			return server.deleteUser(user);
		}
		return false;
	}

	public void wyswietlenie_uzytkownika() {
		// TODO - implement UzytkownikService.wyswietlenie_uzytkownika
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nazwa_konta
	 */
	public void wyszukanie_uzytkownika(String nazwa_konta) {
		// TODO - implement UzytkownikService.wyszukanie_uzytkownika
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nazwa_konta
	 */
	public boolean oplacenie_karty(String nazwa_konta) {
		// TODO - implement UzytkownikService.oplacenie_karty
		throw new UnsupportedOperationException();
	}

	public boolean wyciszenie_uzytkownika() {
		// TODO - implement UzytkownikService.wyciszenie_uzytkownika
		throw new UnsupportedOperationException();
	}

	public void wyswietlenie_platnosci() {
		// TODO - implement UzytkownikService.wyswietlenie_platnosci
		throw new UnsupportedOperationException();
	}

}