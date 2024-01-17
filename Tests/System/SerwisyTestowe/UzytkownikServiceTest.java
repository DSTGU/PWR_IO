package System.SerwisyTestowe;

import System.Model.Uzytkownik;
import System.Serwisy.ServerMockUp;
import System.Serwisy.UzytkownikService;
import System.Serwisy.WydarzenieService;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class UzytkownikServiceTest {
    UzytkownikService testUzytkownik;

    UzytkownikServiceTest() throws IOException {
        testUzytkownik = new UzytkownikService();
    }

    @Test
    void BrakUzytkownika() throws IOException {
        assertFalse(testUzytkownik.usuniecie_uzytkownika("Jan Papiez Drugi"));
    }

    @Test
    void UzytkownikPrawidlowoUsuniety() throws IOException{
        assertTrue(testUzytkownik.usuniecie_uzytkownika("Janusz"));
    }

}
