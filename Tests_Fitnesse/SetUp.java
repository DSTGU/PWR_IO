package System.Tests_Fitnesse;

import fit.Fixture;
import System.Aplikacja;

public class SetUp extends Fixture {
    static Aplikacja Application;

    public SetUp() {
        Application = new Aplikacja();
    }
}
