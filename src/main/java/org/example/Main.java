package org.example;


import java.io.*;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        //System.out.println("Hello world!");

//        int limiteInferior = 20;
//        int limiteSuperior = 70;
        int cantidadIteraciones = 10000000;

        List<Tupla> numerosAleatorios = new ArrayList<>();
        List<Integer> rango = new ArrayList<>();

        List<Tupla> numerosAleatoriosTotales = new ArrayList<>();

        for (int n = 0; n < 50; n++) {
            rango.add(n + 20);
        }

        for (int i = 0; i < cantidadIteraciones; i++) {
            float variable = new Random().nextFloat();
            int resultado = Math.round(variable * 50) + 20;
            //System.out.println(resultado);

            Tupla tupla = new Tupla();
            tupla.setValor(resultado);
            numerosAleatoriosTotales.add(tupla);
            if (numerosAleatorios.contains(tupla)) {

                Tupla miTupla = numerosAleatorios.stream().filter(t -> t.valor.equals(resultado)).findFirst().get();
                miTupla.incrementarContador();
            } else {

                numerosAleatorios.add(tupla);
                rango.remove(tupla.getValor());

            }

        }

        numerosAleatorios.sort(Comparator.comparing(Tupla::getValor)
                .thenComparing(Tupla::getValor));

        for (int j = 0; j < numerosAleatorios.size(); j++) {
            System.out.println("Salió " + numerosAleatorios.get(j).getValor() + " : " + numerosAleatorios.get(j).getContador()+" ");
        }

//        for (int j = 0; j < numerosAleatoriosTotales.size(); j++) {
//            System.out.print(numerosAleatoriosTotales.get(j).getValor() + " , ");
//        }

        System.out.println("\nNúmeros que no salieron: \n");

        for (int k = 0; k < rango.size(); k++) {
            System.out.println("El número " + rango.get(k) + " no salió.");
        }

        Tupla max = numerosAleatorios.stream()
                .max(Comparator.comparing(Tupla::getContador))
                .orElseThrow(NoSuchElementException::new);
        Tupla min = numerosAleatorios.stream()
                .min(Comparator.comparing(Tupla::getContador))
                .orElseThrow(NoSuchElementException::new);


        System.out.print("\nEl máximo de repeticiones es "+max.getContador() + " del valor: " + max.getValor()+"\n");
        System.out.print("El minimo de repeticiones es "+min.getContador() + " del valor: " + min.getValor());

//        try {
//            String currentPath = Paths.get("").toAbsolutePath().normalize().toString();
//            String downloadFolder = "/filesToDownload";
//            String downloadPath = currentPath + downloadFolder;
//            File newFolder = new File(downloadPath);
//            boolean dirCreated = newFolder.mkdir();
//
//            // get current time
//            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-M-dd_HH-mm-ss");
//            LocalDateTime now = LocalDateTime.now();
//            System.out.println(dtf.format(now));
//            String fileName = "Reporte_" + dtf.format(now) + ".csv";
//
//            // Whatever the file path is.
//            File statText = new File(downloadPath + "/" + fileName);
//            FileOutputStream is = new FileOutputStream(statText);
//            OutputStreamWriter osw = new OutputStreamWriter(is);
//            Writer w = new BufferedWriter(osw);

//            for (int i = 0; i < cantidadIteraciones; i++) {
//                w.write(numerosAleatoriosTotales.get(i).getValor());
//            }
//            w.close();
//            //return downloadPath + "/" + fileName;
//        } catch (IOException e) {
//            System.err.println("Problem writing to the file " + e);
//        }




    }


}