/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.entrega1ventas;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author jcanoto
 */
public class GenerateInfoFiles {
    public static void main(String[] args) {
     try {
            // Generar los archivos planos pseudoaleatorios necesarios
            generateSalesMenFiles(5); // Generar 5 archivos de ventas de vendedores
            generateProductsFile(5); // Generar información de 5 productos
            generateSalesManInfoFile(12); // Generar información de 12 vendedores
            System.out.println("Proceso completado con éxito.");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        }
    }
    
     public static void generateSalesMenFiles(int numFiles) throws IOException {
        for (int i = 1; i <= numFiles; i++) {
            String fileName = "Vendedores_" + i + ".txt";
            generateSalesMenFile(fileName);
        }
    }

    public static void generateSalesMenFile(String fileName) throws IOException {
        try (FileWriter writer = new FileWriter(fileName)) {
            Random random = new Random();
            // Escribir ventas pseudoaleatorias en el archivo
            writer.write("TipoDocumentoVendedor;NúmeroDocumentoVendedor\n");
            for (int j = 1; j <= random.nextInt(10); j++) {
                // Generar datos pseudoaleatorios
                String tipoDocumento = "TipoDocumento" + j;
                int numeroDocumento = random.nextInt(1000);
                writer.write(tipoDocumento + ";" + numeroDocumento + "\n");
            }
        }
    }

    public static void generateProductsFile(int numProducts) throws IOException {
        String fileName = "productos.txt";
        try (FileWriter writer = new FileWriter(fileName)) {
            Random random = new Random();
            // Escribir información pseudoaleatoria de productos en el archivo
            for (int i = 1; i <= numProducts; i++) {
                writer.write("IDProducto" + i + ";NombreProducto" + i + ";" + (random.nextDouble() * 100) + "\n");
            }
        }
    }

    public static void generateSalesManInfoFile(int numSalesmenCount) throws IOException {
        String fileName = "Vendedor.txt";
        try (FileWriter writer = new FileWriter(fileName)) {
            Random random = new Random();
            // Escribir información pseudoaleatoria de vendedores en el archivo
            for (int i = 1; i <= numSalesmenCount; i++) {
                writer.write("TipoDocumento" + i + ";" + random.nextInt(1000) + ";NombresVendedor" + i + ";ApellidosVendedor" + i + "\n");
            }
        }
    }
    
}
