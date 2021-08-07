/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaqProrrateo;

import PaqPrincipal.ClsPrincipal;
import PaqVenta.ClsVenta;
import java.util.Scanner;

/**
 *
 * @author Marjorie
 */
public class ClsProrrateo {
        public static void main(String[] args) {
            
    Double SeguroLocal = 0.0;
    Double FleteProductos = 0.0;
    Double ImpuestoAduanal = 0.0;
    Double Acarreo = 0.0;
    Double ComisionesBancarias = 0.0;
    Double FinalProrrateo = 0.0;
    
        ClsPrincipal Principal = new  ClsPrincipal();
        ClsVenta Ventas = new ClsVenta();
        Scanner Lector= new  Scanner(System.in);
        
        System.out.println("---------PRORRATEO DE FACTURAS---------");
        System.out.println("Ingrese la cantidad de productos:");
        
        
        int Cant = Lector.nextInt();
        Principal.CrearTabla(Cant);
        for (int i=0; i<Cant; i++) {
            Ventas.CargadeInformacion(i);
            Principal.AgregarTabla(Ventas);
        }
        
        // PREGUNTAS PARA CALCULAR OTRAS AFECTOS DEL AUMENTO DE PRECIO
        System.out.println("-------------------------------------------------");
        Principal.ImprimirTabla(); 
        System.out.println("1. ¿Cuánto se cancela de Seguro Local?");
        SeguroLocal = Lector.nextDouble();
        System.out.println("2. ¿Cuánto se cancela de Flete de los Productos?");
        FleteProductos = Lector.nextDouble();
        System.out.println("3. ¿Cuánto se cancela de Impuestos Aduanales?");
        ImpuestoAduanal = Lector.nextDouble();
        System.out.println("4. ¿Cuánto se cancela de Acarreo por los Productos?");
        Acarreo=Lector.nextDouble();
        System.out.println("5. ¿Cuánto se cancela de Comisiones Bancarias?");
        
       // SUMAS DE LOS INCREMENTOS DEL PRECIO
        ComisionesBancarias = Lector.nextDouble();
        Double SumaIncrementoPrecio = SeguroLocal+ImpuestoAduanal+ComisionesBancarias;
        Double SumaTransportes = FleteProductos+Acarreo;
        Double SumaTotal = Principal.CoeficienteGP(Cant,SumaIncrementoPrecio,SumaTransportes);
        Principal.CrearTablaImpresion(Cant);
        FinalProrrateo = Principal.TablaImpresion(Cant);

        // IMPRESIÓN DE TABLA DE LA INFORMACIÓN INGRESADA
        System.out.println("Gasto valor\n"
                + "Gasto peso\n"
                + "Costo unidad\n"
                + "Costo final\n");
        Principal.ImprimirT2();
        System.out.println("\nTotal "+ FinalProrrateo+"\n");
        System.out.println("Total Factura:   "+SumaTotal+"\n"
                + "Total gastos al Valor: "+SumaIncrementoPrecio+"\n"
                        + "Total gastos al Peso:  "+SumaTransportes+"\n"
                                + "\n"
                                + "TOTAL FINAL "+(SumaIncrementoPrecio+SumaTransportes+SumaTotal));     
    } 
}
