package System.Tests_Fitnesse;

import fit.Fixture;

public class SetUp extends Fixture {
    static WydarzenieApplication wydarzenieApplication;

    public SetUp() {
        wydarzenieApplication = new WydarzenieApplication();
    }
}
