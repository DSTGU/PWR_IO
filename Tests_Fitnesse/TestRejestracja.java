package System.Tests_Fitnesse;

import System.Model.Uzytkownik;
import fit.ColumnFixture;

import javax.xml.crypto.Data;
import java.io.IOException;

public class  TestRejestracja extends ColumnFixture {
    int number;
    String Imie;
    String Nazwisko;
    String Mail;
    String Haslo;
    String data;
    String result;

    Uzytkownik temp=null;
    Uzytkownik actuall;

    public boolean zarejestruj_uzytkownika() throws IOException {
        result=null;
        actuall=new Uzytkownik(Imie,Nazwisko,Mail,Haslo,0);
        temp=SetUp.loginService.zarejestrujUzytkownika(Imie,Nazwisko,Mail,Haslo);
        result="";
        data=SetUp.data.dataForRegistry[number];
        //data="Adam,Kowalski,email@email.com,HasloPoprawne12!";
        if(temp!=null) {
            result += temp.getImie();
            result += ',';
            result += temp.getNazwisko();
            result += ',';
            result += temp.getEmail();
            result += ',';
            result += temp.getHaslo();
        }
        return data.equals(result);
    }

}
