package System.Tests_Fitnesse;
import System.Model.Uzytkownik;
import fit.ColumnFixture;

public class TestLogowanie extends ColumnFixture {
    String Mail;
    String Haslo;
    Uzytkownik uzytkownik;

    public boolean zaloguj_uzytkownika() throws Exception {
        uzytkownik = SetUp.Application.loginService.zalogujUzytkownika(Mail, Haslo);
        return uzytkownik != null;
    }

    public String zweryfikuj_imie(){
        if (uzytkownik == null){
            return "";
        }
        return uzytkownik.getImie();
    }

}
