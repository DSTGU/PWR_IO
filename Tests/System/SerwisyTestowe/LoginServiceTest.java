package System.SerwisyTestowe;

import System.Model.Uzytkownik;
import System.Serwisy.LoginService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

class LoginServiceTest {
    LoginService testLoginService;
    LoginServiceTest() throws IOException {
        testLoginService=new LoginService();
        testLoginService.setTestPath(System.getProperty("user.dir") + "\\TestUsers.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter((System.getProperty("user.dir") + "\\TestUsers.txt")));
        writer.flush();
        writer.close();
    }




    @Test
    void CzyHasloNiepoprawne() throws IOException {
        assertNull(testLoginService.zarejestrujUzytkownika("Imie", "Nazwisko", "Email", "haslo"));
    }

    @Test
    void HasloNiepoprawneZDuzaLitera() throws IOException {
        assertNull(testLoginService.zarejestrujUzytkownika("Imie", "Nazwisko", "Email", "Niepoprawnehaslo"));
    }

    @Test
    void HasloNiepoprawneZCyfra() throws IOException {
        assertNull(testLoginService.zarejestrujUzytkownika("Imie", "Nazwisko", "Email", "niepoprawnehaslo1"));
    }
    @Test
    void HasloNiepoprawneZeZnakiemSpecjalnym() throws IOException {
        assertNull(testLoginService.zarejestrujUzytkownika("Imie", "Nazwisko", "Email", "niepoprawnehaslo!"));
    }
    @Test
    void HasloZaKrotkie() throws IOException {
        assertNull(testLoginService.zarejestrujUzytkownika("Imie", "Nazwisko", "Email", "Nph1!"));
    }
    @Test
    void HasloPoprawne() throws IOException {
        Uzytkownik testUser;
        testUser=testLoginService.zarejestrujUzytkownika("Imie", "Nazwisko", "Email", "Poprawnehaslo!11");
        assertEquals("Poprawnehaslo!11",testUser.getHaslo());
    }
    @Test
    void UzytkownikZarejestrowanyMaPoprawneDane()throws IOException{
        Uzytkownik testUser;
        testUser=testLoginService.zarejestrujUzytkownika("Imie", "Nazwisko", "Email", "Poprawnehaslo!11");
        assertEquals("Imie",testUser.getImie());
        assertEquals("Nazwisko",testUser.getNazwisko());
        assertEquals("Email", testUser.getEmail());
        assertEquals("Poprawnehaslo!11",testUser.getHaslo());
    }
    @Test
    void EmailIstnieje() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter((System.getProperty("user.dir") + "\\TestUsers.txt"),true));
        writer.write("Email");
        writer.close();
        Uzytkownik testUser=testLoginService.zarejestrujUzytkownika("Imie","Nazwisko","Email","Poprawnehaslo!11");
        assertNull(testUser);
    }
    @Test
    void EmailNieIstnieje()throws IOException{
        Uzytkownik testUser;
        testUser=testLoginService.zarejestrujUzytkownika("Imie", "Nazwisko", "Email", "Poprawnehaslo!11");
        assertEquals("Imie",testUser.getImie());
        assertEquals("Nazwisko",testUser.getNazwisko());
        assertEquals("Email", testUser.getEmail());
        assertEquals("Poprawnehaslo!11",testUser.getHaslo());
    }

    @Test
    void NiepoprawnyMail()throws Exception{
        BufferedWriter writer = new BufferedWriter(new FileWriter((System.getProperty("user.dir") + "\\TestUsers.txt"),true));
        writer.append("Email");
        writer.newLine();
        writer.append("Poprawnehaslo!11");
        writer.newLine();
        writer.append("Imie");
        writer.newLine();
        writer.append("Nazwisko");
        writer.newLine();
        Exception exception=assertThrows(Exception.class,
                () -> testLoginService.zalogujUzytkownika("NieMaTakiegoMaila", "Poprawnehaslo!11"),
                "Expected zalogujUzytkownitka() to throw, but it didn't"
        );
        assertTrue(exception.getMessage().contains("Niepoprawny email lub haslo"));
        }
    @Test
    void NiepoprawneHaslo()throws Exception{
        BufferedWriter writer = new BufferedWriter(new FileWriter((System.getProperty("user.dir") + "\\TestUsers.txt"),true));
        writer.append("Email");
        writer.newLine();
        writer.append("Poprawnehaslo!11");
        writer.newLine();
        writer.append("Imie");
        writer.newLine();
        writer.append("Nazwisko");
        writer.newLine();
        writer.close();
        Exception exception=assertThrows(Exception.class,
                () -> testLoginService.zalogujUzytkownika("Email", "NiepoprawneHaslo1!!"),
                "Expected zalogujUzytkownitka() to throw, but it didn't"
        );
        assertTrue(exception.getMessage().contains("Niepoprawny email lub haslo"));
    }
    @Test
    void PoprawneZalogowanie()throws Exception{
        BufferedWriter writer = new BufferedWriter(new FileWriter((System.getProperty("user.dir") + "\\TestUsers.txt"),true));
        writer.append("Email");
        writer.newLine();
        writer.append("Poprawnehaslo!11");
        writer.newLine();
        writer.append("Imie");
        writer.newLine();
        writer.append("Nazwisko");
        writer.newLine();
        writer.close();
        Uzytkownik testUser=testLoginService.zalogujUzytkownika("Email", "Poprawnehaslo!11");
        assertEquals("Imie",testUser.getImie());
        assertEquals("Nazwisko",testUser.getNazwisko());
        assertEquals("Email", testUser.getEmail());
        assertEquals("Poprawnehaslo!11",testUser.getHaslo());


    }
    @Test
    void PodczasLogowaniaPlikNieIstnieje()throws Exception{
        testLoginService.setTestPath("thisPathDoesNotExist");
        Exception exception=assertThrows(Exception.class,
                () -> testLoginService.zalogujUzytkownika("Email", "PoprawneHaslo1!!"),
                "Expected zalogujUzytkownitka() to throw, but it didn't"
        );
        assertTrue(exception.getMessage().contains("(The system cannot find the file specified)"));
    }
    @Test
    void PodczasRejestracjiPlikNieIsntieje(){
        testLoginService.setTestPath("thisPathDoesNotExist");
        Exception exception=assertThrows(Exception.class,
                () -> testLoginService.zarejestrujUzytkownika("Imie","Nazwisko","Email", "NiepoprawneHaslo1!!"),
                "Expected zalogujUzytkownitka() to throw, but it didn't"
        );
        assertTrue(exception.getMessage().contains("(The system cannot find the file specified)"));
    }
    @Test
    void RejestracjaILogowanieZarejestrowanegoUzytkownika() throws Exception {
        testLoginService.zarejestrujUzytkownika("Imie","Nazwisko","Email", "PoprawneHaslo1!!");
        Uzytkownik testUser=testLoginService.zalogujUzytkownika("Email","PoprawneHaslo1!!");
        assertEquals("Imie",testUser.getImie());
        assertEquals("Nazwisko",testUser.getNazwisko());
        assertEquals("Email", testUser.getEmail());
        assertEquals("PoprawneHaslo1!!",testUser.getHaslo());
    }

}