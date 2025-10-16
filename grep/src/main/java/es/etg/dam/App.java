package es.etg.dam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class App {

    public static final String TEXTO = """
                Me gusta PSP y java
                SP se programa en java
                es un módulo de DAM
                y se programa de forma concurrente en PSP
                PSP es programación.
            """;

    public static final String COMANDO = "grep PSP";
    public static final String RESULTADO = "Lineas de PSP";

    public static void main(String[] args) throws Exception {
        Process p = Runtime.getRuntime().exec(COMANDO);
        OutputStream out = p.getOutputStream();

        PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
        pw.println(TEXTO);
        pw.close();

        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
        System.out.println(RESULTADO);

        String linea;
        while ((linea = br.readLine()) != null) {
            System.out.println(linea);
        }
        br.close();

    }
}
