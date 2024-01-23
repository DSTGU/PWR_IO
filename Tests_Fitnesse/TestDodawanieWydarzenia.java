package System.Tests_Fitnesse;

import fit.ColumnFixture;

import java.util.IllegalFormatCodePointException;


public class TestDodawanieWydarzenia extends ColumnFixture {
    String nazwa;

    public boolean dodaj_wydarzenie() {
        int events1 = liczbaWydarzen();
        SetUp.wydarzenieApplication.utworzenie_wydarzenia(nazwa);
        int events2 = liczbaWydarzen();
        return events1 != events2;
    }

    public int liczbaWydarzen(){
        return SetUp.wydarzenieApplication.server.getEventCount();
    }
}
