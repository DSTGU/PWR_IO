package System.Tests_Fitnesse;

import System.Serwisy.LoginService;
import System.Serwisy.UzytkownikService;
import fit.Fixture;
import System.Aplikacja;

public class SetUp extends Fixture {
    static Aplikacja Application;
    static WydarzenieApplication wydarzenieApplication;
    static LoginService loginService;
    static Data data=new Data();
    static int number;

    public SetUp() {
        Application = new Aplikacja();
        wydarzenieApplication = new WydarzenieApplication();
        loginService=new LoginService();
        data=new Data();
        data.setData();
    }
}
