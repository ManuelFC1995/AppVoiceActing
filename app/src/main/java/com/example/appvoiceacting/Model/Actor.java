package com.example.appvoiceacting.Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Actor extends RealmObject {
    @PrimaryKey
    private String id;
    private  String name;
    private String Surname;
    private String Tipo_voz;
    private String email;
    private Date Birthday;
    private String Password;
    private Boolean profesional;
private String image ="iVBORw0KGgoAAAANSUhEUgAAAIAAAACACAYAAADDPmHLAAAABHNCSVQICAgIfAhkiAAAAAlwSFlzAAADdgAAA3YBfdWCzAAAABl0RVh0U29mdHdhcmUAd3d3Lmlua3NjYXBlLm9yZ5vuPBoAAA4mSURBVHic7Z15tFZVFcB/G3DCKRUQcSJDEbRUNATFIXCpBaiVtSinBhemqcvKZc6ZZpm1wtTUxFzpck5XKg6hkYmzFDmgouIMIpOziAxv98e+D9578J1zz/3ud+/5Hve31lnvj3Peufues79zz7DP3qKqdFZEpDuwH7ATsGmSerf52w14B5jT4e90YKKqvleC2IUinU0BRGQzYHSSRgDrZKxqKfAwMAG4U1Vn5CNhXHQaBRCRQ4DTgC8D0oBHTAfGAVer6tIG1F8KTa8AIjIMuBAYWtAjXwLOUNVbC3peQ2laBRCRHYDfYEN9GUwBTlXVf5X0/FxoSgUQkZ8Dvwa6lC0LcDVwrKouLluQLDSVAojIWsB44IiyZenAQ8A3VHV+2YKE0jQKICKbArcDQzJW8QEwi/bLvSXYcrA19QF6ZKz/NWC0qj6X8f9LoSkUQER2Ae4Atgz4txbgP8DdSZqqKV5WRPoDXwNGAnsBawY88yNgjKreE/A/5aKqUSdgIPbr1ZTpE2x+0CuHZ68HnADMDXj+UmD/stst9TuWLYCnAzYGZgQ0/JVAnwbIsT5wXqJcaWR5D+hfdvulSdF+AkSkG3Af8JUUxZ8HDlXVFxos02bAdcDwFMVfBnbXyLeTY1hG1eJS0nX+RGBoozsfQFVnAwcAV6Qovi1wS6LI8VL2EFRjyD2OdEPtpUDXkmQ8Afvs+GS8uOz2bKpPQLLcm4FNwFycqarnFyBSTUTkYOA2oKujmGKfginFSBVGjJ+As/F3/jVldz6Aqt4BnOwpJthZRZRENQKISD9sQreGo9gjwHCNaOtVRMYDR3uKjVLVu4uQJ4TYFOBm4NuOIq8Dg1V1XjESpUNE1gDuB/ZxFJsG7KSqLcVIlY5oPgEishvwLU+x42LrfABVXQJ8D3CNSjsmZaIiGgXAZv4uQ45JqnpvUcKEoqqvA5d7iv24AFGCiOITICJdgNlArxpFFNhNVacWJ1U4ItIDeAXYwFFsc1V9uyCRvMQyAuxO7c4HuDH2zgdQOw7+nafYyCJkSUssCuCz6rmqECny4S/YiFWLUUUJkoZYPgHTgB1qZH8I9EgmWk2BiEwBdquRvRDYRFUXFShSTUofAURka2p3PsB9zdT5CRMced1xLxcLpXQFAPp58pvHuGIFd3nyfe9cGDEowKae/McKkSJHkgnrZ44ivncujBgUoLcnf3YhUuTPHEee750LIwYFcP0aFqnqB4VJki9zHXnVCNAG16/hncKkyB+XAlQjQBtcG0CuYTR2XArgeudCiUEBXOvhtQuTIn9cskexBwBxKEBTTJYy0BQjW+wK0FNEXOZWMVMpQEpcE70uQM+iBMkZlwJEM7mNQQF8v4atCpEiR0RkHdx3DKsRoA2+X8N+hUiRLyNwt201ArThWdymVFGdn6fEd7z930KkSEEsx8ETgf1rZLdgFz0XFChSXYjITGDzGtkzVTXklnNDiWEEAPfxaRfgq0UJUi8isiu1Ox/8J4WF0gwKAHBKYjfYDJzqya8UoCOq+gbwjKPIF4EjCxInMyIyGDjUUeRTICqnUlEoQMLfPfnnJcurmPmtJ/8+Vf20EElSEpMCXIJ5AqnFFsDPCpIlGBEZBezrKKKYk4moiEYBklm+7xf0CxEZUYQ8IYjINsBfPcVuUtVoln+tRLEMbCVx7vwy5q2rFu8BQ1T1pWKkciMiG2BmawMdxRYD26vqa8VIlZ5oRgAAVV0InOMpthEwQUQ+13iJ3CQHVTfj7nyAy2LsfIhsBIDljToN2N5T9GHgYFV9t/FSrUxyI3g8cJSn6AfAF2LdyIpqBABQ1WXAGMwjl4thwOMisl3jpWqPiGyCXQf3dX4LcESsnQ8RKgCAqj4NHI77ihWYI6bHRSSNM6lcEJEBwBOku9xxuqr6NrnKpWwnRR5HTKeTzlnUYsy1zLoNlKUrMBZ4P6VM15bdfqneq2wBUjT8DSkbXLE7BD8CuuUswyHACwFyPAasVXbbpUnRTQI7IiJrY9/bYQH/9hJwMXCX2jZzluf2wA6hjgH2DPjXV4A9VTUaow8X0SsA1O0m/lnssGkS5i18rnbw3iki67MikNRe2BXuIYTPkR4EvqkRT/o60hQK0IqInIJFCal38roEmIc5euxFPubnV2E+jJrqJnNTKQCAiIwGrsccOMfAMuBkVb2obEGy0HQKACAiOwLXAruULMpbwFhV/UfJcmQmyn0AH6o6DdgVOAyL1FE0CzAPods2c+dDk44AbRGRNbGl35k0/g7BQuAi4EJt3lvL7Wh6BWglmckfDRyMLRnzulGkwFRsJXGlmsv4TkOnUYC2iMhGWNyf0cCBwIaBVSzClo0TsL2EWflKGA9RKoCIbIgd+87UOsO0Jqd2fQkLHv2G5mS6ldg49ATmqR13R0WpCiAivbEIHAdgx789k7RWUmQhFqHzfFW9vxQhM5BYMP8Qc3+7I6ZoYO8zF9uD+B9wL+YC96My5ASKPwvANl7Oxb6rLaTfX78Tm3WXvn/ueb99sM5N+16LgQeA44F1Cpe34I7/Pekjb60qLQLOAtYou6NX8X6bANfU8W6th1knFakIRTRMN+BXdXZ8x/QsZhdYescn7/gdwmILplGEI5teAbDJ1oM5NkzbtAz4I7BeiR2/FRaVtBHvp8CfafCxciMbZw/s9K1RjdOa3gCOBboX2PG9sXnMRwW835PAlk2lAFhgxc8KaJy26V3gAmCLBnb8zth3vuh3mwVs1Yh3yn0ZKCI7AZNxB03oiGKBnp8C3k7SYOAHuKOIrIqlwK3AOFV9MvB/VyJZ0o3GJmf7ZqhiIRZDYD5236EPNjpuG1jPdMzQJF8r6Jx/IX2xzkur2VMwy9pVBnoGhmIm4ll/OU8Av8Q8dqT+RGDuXb4OjCN97OJVpXuArWs8ox/wU+xEMW19j5DzCiG3ESAJkfoEMChF8aeAs1TVe1U6Oew5DTMQDQnl3pEl2N7D66zYjJmHrVJ6YsvUnsCAJIWOPG2ZD5ykqtf7CibWTmOxw6w0DiSvVNVj6pCtPTn++tNa8F4CrJmh/h0wY8siv71Z0g1Azwzv1xvbEErzjBG59VtOnT8A26TxCf79Op/TBTgRux9Ydkd3TK8AI+t8v67AZSme9So5mcDnpQCPphB6XG5aawdFF2ATrLI7fja255/L7iT2SZpcVHvmIfDwFMI+mlcDdXj2ZlgE8Q9L6PiZmDuY3PcfsJXCHM/zW2MPla4AEzyCzqeBGxmJDN0xFzIPEHbAFJoWAbdg9wUaGrYeW7ks88hzRqkKgK1lXQ3eAhzYyIZahUzbYKuGieSzUzcH21c4Fti44Hc52yPb29Q5sta1DBSRS3GHQ71cVY/L/IA6SZamu2BHtHtg7tt6YCd3ba2EWrCJ5QJsxHoVeAiYrKrTi5S5Lckm1JOYAWwtjlDV6zI/I6sCJA4aZgLr1ijSAvRX1RkZZWsoiaXQxtgw+65GFtW7FREZA9zoKDJVVV0K4qQes/Cx1O58MFu6KDsfQFWXqOocVZ0fa+cn3IrtFtZikIjsnbXyTAqQDK3He4o15U2Z2FCzibzEU+ykrPVn+gSIyIGYPVstnlbVnbMKVdGe5HP7FrBejSKZ/Sln/QTs68mvfv05oqrvA1c7inTBbjUHk1UB9nHkvY970lKRjT958l19UpNgBRCRdakdGRts6eQKm1qRATW/iG86ihSjANh6upsj/8EsglSkwtW2O2XxnZhFAXyaNjlDnRXpcLVtF8Lc6Cz/p1BcCvARdimiojH4Rtfgz0CQAiTu2gc7ijys5uixogGo6su4o6k3VgEwcy+XWVY1/DceVxsPSkzMUhOqANt48h8KrK8iHFcbdyUwzmKoAnzek/9iYH0V4fja2NdH7QhVgL6OvI9VdX5gfRXhvObJ7xtSWZ4jgE+winx4EzvCrkVDR4BKAUpGzRGly2VNYxQgOQLewlGkUoDicLV135CKQkaALXF73qoUoDhcbd2wT4Av3m2lAMXhauteyXW6VIQoQHdPfrUCKA6f4Yevr5YTogC+qJ1RRcTs5Czy5KeOsBqiAD6X6pUCFIdPAVK7v69GgOakGgFWc6oRYDWnGgFWc0oZARZ78tcIqKuiPnzrfF9fLSdEAeZ68nsE1FVRH762Tr0nUylAcxKlAgTtQVfURV9HnmJOM1MRogDvePKHB9RVUR8u488FIYa5qRVALWyK65ryiLR1VWQniY3k8gfwWEh9oQYhEx1524uI68pYRT6MwX0zy9VHK5GnAgCcE1hfRQDJMe+ZnmINVYBJuO3RRtbjraLCy4m4zb5fDfXKEqQAalG3b/MU+5uI9A2pt8KPiIzAAme7GB9cb6iHEBHpDzyH2zzseWC4qs4JFahiZUTkS8C/MQ+ptZgN9NPA0HTBl0NV9UUscLOLgcBUEdkztP6K9ojIYdjM3tX5AOeFdj5k9xG0NXZDxXcPbQnwB8yvbTUaBCAiAzAP7IenKD4DGJiYjIc9pw4/gYcBaR0UfoaNGrcDj2gnCbycNyLSB9gb+C4winQxCz4Ghqnq05meWaen0HOxOH4htADPYDdcFiTpk8xCNDcbsMJz6XZYFJEQWoBDVHVCZgnq9GUrwE0U76m7SpZ+Urc/4hwcGq8JXBFBY6xOaTFwQi4OqfOoJFGEo4gjgENnTzOBoXn1Wz2+gtuhqtdgUb4yTUYqUjEBGKSqQQc+LnJTAABVbXURexDweJ51r8Yotvu6q6oepKo+u4wgcg8c2a5ykeHYp2E47pvFFSvzPPBP4ApVfaFRD2moArR7kMh2mM3AECw+Xg8sTl8P3G7nOzMfYOZb85K/szAfQJNU1WeAkwv/B3ys3CMb71vCAAAAAElFTkSuQmCC";
    public Actor(String name,String Surname, String voz, String Email,String Password, Date birthday){
        this.name=name;
        this.Surname=Surname;
        this.Tipo_voz=voz;
        this.Password=Password;
        Birthday = birthday;
        this.email=email;
    }

    public Actor() {


    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTipo_voz() {
        return Tipo_voz;
    }

    public void setTipo_voz(String tipo_voz) {
        Tipo_voz = tipo_voz;
    }

    public Date getBirthday() {
        return Birthday;
    }

    public  Boolean setBirthday(String birthday) {
        boolean result = false;
        SimpleDateFormat newDate = new SimpleDateFormat("dd/MM/yyyy");
        String RegEx = "^(?:(?:(?:0?[1-9]|1\\d|2[0-8])[/](?:0?[1-9]|1[0-2])|(?:29|30)[/](?:0?[13-9]|1[0-2])|31[/](?:0?[13578]|1[02]))[/](?:0{2,3}[1-9]|0{1,2}[1-9]\\d|0?[1-9]\\d{2}|[1-9]\\d{3})|29[/]0?2[/](?:\\d{1,2}(?:0[48]|[2468][048]|[13579][26])|(?:0?[48]|[13579][26]|[2468][048])00))$";

        if(birthday.matches(RegEx)){
            try {
                this.Birthday = newDate.parse(birthday);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            result = true;
        }

        return result;

    }

    public String getEmail() {
        return email;
    }

    public int setEmail(String email) {

        int error=0;
        if(email!=null&&email.length()>0){
            Pattern pat = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
            Matcher mat = pat.matcher(email);
            if(mat.matches()){
                this.email = email;
            }else{
                error=1;
            }
        }
        return error;
    }

    public String getPassword() {
        return Password;
    }

    public int setPassword(String password) {

        int error = 0;
        if (password != null && password.length() > 8) {
            this.Password=password;
        }
        else{
            error = 1;
        }
        return error;
    }

    public Boolean getProfesional() {
        return profesional;
    }

    public void setProfesional(Boolean profesional) {
        this.profesional = profesional;
    }
}
