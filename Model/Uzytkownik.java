package System.Model;

import java.util.Date;

public class Uzytkownik {

	private String nazwa_konta;
	private String imie;
	private String nazwisko;
	private String email;
	private String haslo;
	private int poziom_uprawnien;
	private Date data_waznosci_karty;

	public Uzytkownik() {
	}

	public String getNazwa_konta() {
		return nazwa_konta;
	}

	public void setNazwa_konta(String nazwa_konta) {
		this.nazwa_konta = nazwa_konta;
	}
	public String getImie()
	{
		return imie;
	}
	public  String getNazwisko()
	{
		return nazwisko;
	}
	public String getEmail()
	{
		return email;
	}
	public String getHaslo()//YEAH ALE JEST BEZPIECZNIEEEEE
	{
		return haslo;
	}
	/**
	 * 
	 * @param imie
	 * @param nazwisko
	 * @param email
	 * @param haslo
	 * @param poziom_uprawnien
	 */

	public Uzytkownik(String imie, String nazwisko, String email, String haslo, int poziom_uprawnien) {
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.email = email;
		this.haslo = haslo;
		this.poziom_uprawnien = poziom_uprawnien;
	}

}