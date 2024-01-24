package System.Tests_Fitnesse;

import fit.ColumnFixture;

import java.util.Date;


public class TestDodawanieWydarzenia extends ColumnFixture {
    String nazwa;

    public boolean dodaj_wydarzenie() {
        int events1 = liczbaWydarzen();
        SetUp.Application.wydarzenieService.utworzenie_wydarzenia(nazwa, new Date(), SetUp.Application.zalogowanyUzytkownik, 0.0f);
        int events2 = liczbaWydarzen();
        return events1 != events2;
    }

    public int liczbaWydarzen(){
        return SetUp.Application.wydarzenieService.server.getEventCount();
    }
}
