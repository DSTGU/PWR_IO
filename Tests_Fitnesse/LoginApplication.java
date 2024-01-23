package System.Tests_Fitnesse;


import System.Model.*;

import java.io.*;
import java.util.IllegalFormatCodePointException;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginApplication {

    /**
     *
     * @param imie
     * @param nazwisko
     * @param mail
     */
    private String path=System.getProperty("user.dir") + "\\Users.txt";

    public Uzytkownik zarejestrujUzytkownika(String imie, String nazwisko, String mail, String haslo) throws IOException {


        // NewUser(imie:string,nazwisko:string,email:string,haslo:string)
        if (!isMailUsed(mail)) { //Pytamy serwera czy mail jest nowy. Komunikacja z serwerem ogólnie, ale nie mamy serwera
            if (czyHasloPoprawnyFormat(haslo)) {
                Uzytkownik uzytkownik = new Uzytkownik(imie, nazwisko, mail, haslo, 0);
                BufferedWriter writer = new BufferedWriter(new FileWriter(path, true));
                writer.append(uzytkownik.getEmail());//Tutaj wysłać informację
                writer.newLine();
                writer.append(uzytkownik.getHaslo());//hihi a bit of mischief
                writer.newLine();
                writer.append(uzytkownik.getImie());
                writer.newLine();
                writer.append(uzytkownik.getNazwisko());
                writer.newLine();
                writer.close();
                return uzytkownik;
            }
        }
        return null;
    }
    private boolean isMailUsed(String mail) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        while(reader.ready())
        {
            if(Objects.equals(reader.readLine(), mail)) {
                reader.close();
                return true;
            }
        }
        return false;
    }
    private boolean czyHasloPoprawnyFormat(String haslo) {
        // ReGex to check if a string
        // contains uppercase, lowercase
        // special character & numeric value
        String regex = "^(?=.*[a-z])(?=."
                + "*[A-Z])(?=.*\\d)"
                + "(?=.*[-+_!@#$%^&*., ?]).+$";
        // Compile the ReGex
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(haslo);

        if (m.matches()) {
            if (haslo.length() > 8) {
                return true;
            }
            System.out.println("Haslo za krotkie");
        }
        else{
            System.out.println("Haslo musi zawierac duża literę, małą literą, znak specjalny i cyfrę");
        }
        return false;
    }

    public Uzytkownik zalogujUzytkownika(String email,String password) throws Exception {

        BufferedReader reader = new BufferedReader(new FileReader(path));
        String imie="";
        String nazwisko="";
        if(isDataCorrect(email,password)) {
            while (reader.ready()) {
                if (Objects.equals(reader.readLine(), email)) {
                    reader.readLine();
                    imie = reader.readLine();
                    nazwisko = reader.readLine();
                }
            }
            if (!Objects.equals(imie, ""))
                return new Uzytkownik(imie, nazwisko, email, password, 0);
            else {
                throw new Exception("Cos poszlo nie tak");
            }
        }
        throw new Exception("Niepoprawny email lub haslo");
    }

    public boolean isDataCorrect(String email, String password) throws IOException {

        //System.out.println(System.getProperty("user.dir")+"\\Users.txt");
        BufferedReader reader = new BufferedReader(new FileReader(path));

        while (reader.ready()) {
            if (Objects.equals(reader.readLine(), email)) {
                if (Objects.equals(reader.readLine(), password)) {
                    reader.close();
                    return true;
                }
            }

        }
        reader.close();
        return false;
    }
    public LoginApplication() {

    }

    /**
     *
     * @param uzytkownik
     */

    public LoginApplication(Uzytkownik uzytkownik) {
        // TODO - implement LoginService.LoginService
        throw new UnsupportedOperationException();
    }
    public void setTestPath(String newPath)
    {
        path=newPath;
    }

}
