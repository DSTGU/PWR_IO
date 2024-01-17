package System.Serwisy;

import System.Model.Uzytkownik;
import System.Model.Wydarzenie;
import System.Serwisy.UzytkownikService;

import java.util.*;

public class ServerMockUp {
    private List<Uzytkownik> users;
    private List<Wydarzenie> events;
    private int eventCount;
    public ServerMockUp(){
        users = new ArrayList<>();
        events = new ArrayList<>();
        users.add(new Uzytkownik("Janusz", "Sumowski", "janusz@o2.pl", "janusz123", 0));
        users.add(new Uzytkownik("Karol", "Wojtyla", "jp2@gmail.com", "karol123", 0));
        events.add(new Wydarzenie("Wedkowanie", new Date(), 420, users));
        events.add(new Wydarzenie("Polowanie na szczupaki", new Date(), 69, users));
        eventCount += 2;
    }
    public List<Uzytkownik> getUsers() {
        return users;
    }
    public List<Wydarzenie> getEvents() {
        return events;
    }
    public void addUsers(Uzytkownik user) {
        users.add(user);
    }
    public void addEvents(Wydarzenie event) {
        events.add(event);
        eventCount++;
    }
    public void editEvent(int eventId, Wydarzenie event){
        events.set(eventId, event);
    }

    public void deleteEvents(int eventId) {
        events.set(eventId, new Wydarzenie());
        eventCount--;
    }

    public int getEventCount() {
        return eventCount;
    }
}
