package System.Tests_Fitnesse;

import System.Serwisy.LoginService;
import System.Serwisy.UzytkownikService;
import fit.Fixture;
import System.Aplikacja;

public class SetUp extends Fixture {
    static Aplikacja Application;
    static Data data=new Data();

    public SetUp() {
        Application = new Aplikacja();
        data=new Data();
        data.setData();
    }
}
