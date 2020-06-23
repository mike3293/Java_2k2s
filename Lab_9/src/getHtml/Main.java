package getHtml;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    public static void main(String[] args) {
        ReadHTML("https://www.tut.by/news");
    }

    public static void ReadHTML(String URL){
        java.net.URL tut = null;
        try {
            tut = new URL(URL);
            if(tut == null){
                throw new RuntimeException();
            }
        }
        catch (MalformedURLException ex){
            System.out.println(ex.getMessage());
        }
        try (BufferedReader d= new BufferedReader(new InputStreamReader((tut.openStream())))) {
            String line ="";
            while((line = d.readLine())!=null){
                System.out.println(line);
            }
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
