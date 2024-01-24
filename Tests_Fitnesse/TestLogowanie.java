package System.Tests_Fitnesse;
import fit.ColumnFixture;

public class TestLogowanie extends ColumnFixture {
    String Mail;
    String Haslo;

    public boolean zaloguj_uzytkownika() throws Exception {
        return SetUp.Application.loginService.zalogujUzytkownika(Mail, Haslo) != null;
    }

}
