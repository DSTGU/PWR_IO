package System.Serwisy;

import System.Model.*;

import java.io.IOException;
import java.util.Date;
import java.util.*;

public class WydarzenieService {

	private Wydarzenie wydarzenie;


	public ServerMockUp server = new ServerMockUp();

	public boolean utworzenie_wydarzenia(String nazwa, Date data, Uzytkownik organizator, float wpisowe) {
		int events = server.getEventCount();
		List<Uzytkownik> organizators= new ArrayList<Uzytkownik>();
		organizators.add(organizator);
		var newWydarzenie = new Wydarzenie(nazwa, data, wpisowe, organizators);
		server.addEvents(newWydarzenie);
		if(events < server.getEventCount()) return true;
		else return false;
	}

	public boolean wyswietlenie_wydarzenia(int eventId) throws IOException {
		if(server.getEventCount() <= eventId) return false;
		var wydarzenie = server.getEvents().get(eventId);
		System.out.println("Wydarzenie: " + wydarzenie.getNazwa());
		return true;
	}

	public boolean edycja_wydarzenia(int eventId, String nazwa, Date data, Uzytkownik organizator, float wpisowe) {
		if(server.getEventCount() <= eventId) return false;
		List<Uzytkownik> organizators= new ArrayList<>();
		organizators.add(organizator);

		var newWydarzenie = new Wydarzenie(nazwa, data, wpisowe, organizators);
		server.editEvent(eventId, newWydarzenie);

		if(!server.getEvents().get(eventId).getNazwa().equals(nazwa)) return false;
		else return true;
	}

	public boolean usuniecie_wydarzenia(int eventId) {
		if(server.getEventCount() <= eventId) return false;
		int events = server.getEventCount();
		server.deleteEvents(eventId);
		if(events > server.getEventCount()) return true;
		else return false;
	}

	public void przegladanie_wydarzen() {
		// TODO - implement WydarzenieService.przegladanie_wydarzen
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param uzytkownik
	 */
	public boolean zapis_na_wydarzenie(Uzytkownik uzytkownik) {
		// TODO - implement WydarzenieService.zapis_na_wydarzenie
		throw new UnsupportedOperationException();
	}

}