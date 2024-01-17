package System.Model;

import java.util.*;

public class Wydarzenie {

	private String nazwa;
	private String adres;
	private Date data_wydarzenia;
	private float wpisowe;
	private List<Uzytkownik> organizatorzy;
	private Collection<List<Uzytkownik>> uczestnicy;

	public Wydarzenie() {
	}

	/**
	 * 
	 * @param nazwa
	 *
	 * @param data_wydarzenia
	 * @param wpisowe
	 * @param organizatorzy
	 */
	public Wydarzenie(String nazwa, Date data_wydarzenia, float wpisowe, List<Uzytkownik> organizatorzy) {
		this.nazwa = nazwa;
		this.data_wydarzenia = data_wydarzenia;
		this.wpisowe = wpisowe;
		this.organizatorzy = organizatorzy;
	}

	public String getNazwa() {
		return nazwa;
	}

	public Date getData_wydarzenia() {
		return data_wydarzenia;
	}

	public float getWpisowe() {
		return wpisowe;
	}

	public List<Uzytkownik> getOrganizatorzy() {
		return organizatorzy;
	}
}