package com.example.appvoiceacting.Model;
import java.time.LocalDate;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class Actor {
    private  String name;
    private String Surname;
    private boolean sex;
    private String email;
    private LocalDate Birthday;
    private String Password;

    public Actor(String name,String Surname, boolean sexo, String Email,String Password, LocalDate birthday){
        this.name=name;
        this.Surname=Surname;
        this.sex=sexo;
        this.Password=Password;
        Birthday = birthday;
        this.email=email;
    }

    public Actor() {

    }

    public String getSurname() {
        return Surname;
    }

    public int setSurname(String surname) {



        int error=0;
        if(surname!=null&&surname.length()>0){
            Pattern pat = Pattern.compile("[A-Za-zÑñ ]+");
            Matcher mat = pat.matcher(surname);
            if(mat.matches()){
                this.Surname = surname;
            }else{
                error=1;
            }
        }
        return error;
    }

    public String getName() {
        return name;
    }

    public int setName(String name) {
        int error=0;
        if(name!=null&&name.length()>0){
            Pattern pat = Pattern.compile("[A-Za-zÑñ ]+");
            Matcher mat = pat.matcher(name);
            if(mat.matches()){
                this.name = name.toUpperCase();
            }else{
                error=1;
            }
        }
        return error;

    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public LocalDate getBirthday() {
        return Birthday;
    }

    public void setBirthday(LocalDate birthday) {
        Birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public boolean setEmail(String email) {

        boolean error=false;
        if(email!=null&&email.length()>0){
            Pattern pat = Pattern.compile("\"^(.+)@(.+)$\"");
            Matcher mat = pat.matcher(email);
            if(mat.matches()){
error = false;
            }else{
              error=true;
            }
        }
        return error;

    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
