package System.SerwisyTestowe;

import System.Model.Uzytkownik;
import System.Serwisy.ServerMockUp;
import System.Serwisy.WydarzenieService;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class WydarzenieServiceTest {
    WydarzenieService testWydarzenieServie;
    ServerMockUp server;
    final Date today = new Date();
    Uzytkownik testUser = new Uzytkownik("Imie", "Nazwisko", "Imie123@onet.pl", "imie123", 0);

    WydarzenieServiceTest() throws IOException {
        testWydarzenieServie = new WydarzenieService();
        server = new ServerMockUp();
    }

    @Test
    void CzyWydarzenieSieTworzy() throws IOException {
        assertTrue(testWydarzenieServie.utworzenie_wydarzenia("Lowienie lososi", today, testUser, 69));
    }
    @Test
    void CzyWyswietlaIstniejaceWydarzenie() throws IOException {
        assertTrue(testWydarzenieServie.wyswietlenie_wydarzenia(1));
    }
    @Test
    void CzyWyswietlaNieistniejaceWydarzenie() throws IOException {
        assertFalse(testWydarzenieServie.wyswietlenie_wydarzenia(2137));
    }
    @Test
    void CzyUsuwaIstniejaceWydarzenie() throws IOException {
        assertTrue(testWydarzenieServie.usuniecie_wydarzenia(1));
    }
    @Test
    void CzyUsuwaNieistniejaceWydarzenie() throws IOException {
        assertFalse(testWydarzenieServie.usuniecie_wydarzenia(2137));
    }
    @Test
    void CzyWydarzenieSieEdytuje() throws IOException {
        assertTrue(testWydarzenieServie.edycja_wydarzenia(1,"Sledzenie sledzi", today, testUser, 420));
    }

}
