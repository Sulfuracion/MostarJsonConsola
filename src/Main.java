import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {
            //solicitar una peticion
            //https://rickandmortyapi.com/api/character/444
            URL url = new URL("https://rickandmortyapi.com/api/character/444");
            HttpURLConnection conn= (HttpURLConnection) url.openConnection();//crea objeto de conection
            conn.setRequestMethod("GET");//get es el metodo de petecion
            conn.connect();//se conecta


            //peticion correcta, si devuelve 200 es correcto
            int respondeCode= conn.getResponseCode();
            if (respondeCode!=200){
                throw new RuntimeException("Ocurrio un error " + respondeCode);
            }else{
                //lectura informacion
                StringBuilder informacionString = new StringBuilder();
                Scanner sc = new Scanner(url.openStream());//escanea el flujo de datos que llega desde la URL

                while (sc.hasNext()){//miestras el scaner tenga contenido sige
                    informacionString.append(sc.nextLine());
                }
                sc.close();
                //mostrar por consola
                System.out.println(informacionString);



            }





        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("no se conecta");
        }


    }
}