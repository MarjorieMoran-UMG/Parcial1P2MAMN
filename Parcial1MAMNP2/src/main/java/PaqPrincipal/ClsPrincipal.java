/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaqPrincipal;

import PaqVenta.ClsVenta;
import java.text.DecimalFormat;

/**
 *
 * @author Marjorie
 */
public class ClsPrincipal {
    private String [][] Tabla;
    private final int Enc = 0;
    private final int Cantidad = 0;
    private final int Nombre = 1;
    private final int Precio = 2;
    private final int Peso = 3;
    private int Fila = 1;
    private final int MaxColum1 = 4;
       
    private String [][] Tabla2;
    private final int GastoValor = 3;
    private final int GastoPeso = 4;
    private final int CostoUnidad = 5;
    private final int CostoTotal = 6;
    private final int MaxColum2 = 7;

    double SumaPrecio = 0.0;
    double SumaPeso = 0.0;
    double CoeficienteGasto = 0.0;
    double CoeficientePeso = 0.0;
    double SumaTotal = 0.0;
    
    public  void CrearTabla(int nfilas){
        Tabla = new String[nfilas+1][MaxColum1];
        Tabla[Enc][Cantidad]="Cant";
        Tabla[Enc][Nombre]="Nombre";
        Tabla[Enc][Precio]="Precio";
        Tabla[Enc][Peso]="Peso";
    } 

    public void AgregarTabla(ClsVenta Productos){
        Tabla[Fila][Cantidad]=Productos.getCant()+"";
        Tabla[Fila][Nombre]=Productos.getNombre();
        Tabla[Fila][Precio]=Productos.getPrecioProducto()+"";
        Tabla[Fila][Peso]=Productos.getPesoProducto()+"";
        Fila++;           
    }
  
    public void ImprimirTabla(){
       for (int i=0; i<Tabla.length; i++) {
            System.out.print("|");
            for (int x=0; x<Tabla[i].length; x++) {
                System.out.print(Tabla[i][x]);
                if (x != Tabla[i].length - 1) {
                    System.out.print("\t");
                }
            }
            System.out.println("|");
        }
    
    }

    public Double CoeficienteGP(int nfilas, double gastos, double pesos){
        int fila = nfilas+1;
        for (int i=1; i<fila; i++) {
           SumaPrecio+=Double.valueOf(Tabla[i][Cantidad])*Double.valueOf(Tabla[i][Precio]);
           SumaPeso+=Double.valueOf(Tabla[i][Cantidad])*Double.valueOf(Tabla[i][Peso]);
        }
        CoeficienteGasto = gastos/SumaPrecio;
        CoeficientePeso = pesos/SumaPeso;
        return SumaPrecio;      
    }

    public  void CrearTablaImpresion(int NumeroFilas){
        Tabla2= new String[NumeroFilas+1][MaxColum2];
        Tabla2[Enc][Cantidad]="Cant";
        Tabla2[Enc][Nombre]="Nombre";
        Tabla2[Enc][Precio]="Precio";
        Tabla2[Enc][GastoValor]="GastoV";
        Tabla2[Enc][GastoPeso]="GastoP";
        Tabla2[Enc][CostoUnidad]="CostoU";
        Tabla2[Enc][CostoTotal]="CostoT";     
    } 

    public Double TablaImpresion(int NumeroFilas){
       int fila = NumeroFilas+1;
       DecimalFormat formato = new DecimalFormat("#.##");
        for (int i=1; i<fila; i++) {
           Tabla2[i][Cantidad]=Tabla[i][Cantidad];
           Tabla2[i][Nombre]=Tabla[i][Nombre];
           Tabla2[i][Precio]=Tabla[i][Precio]; 
           Tabla2[i][GastoValor]=(formato.format(Double.valueOf(Tabla[i][Precio])*CoeficienteGasto))+"";
           Tabla2[i][GastoPeso]=(formato.format(Double.valueOf(Tabla[i][Peso])*CoeficientePeso))+"";
           Tabla2[i][CostoUnidad]=(formato.format(Double.valueOf(Tabla[i][Precio])+Double.valueOf(Tabla2[i][GastoValor])+Double.valueOf(Tabla2[i][GastoPeso])))+"";
           Tabla2[i][CostoTotal]=(formato.format(Double.valueOf(Tabla2[i][Cantidad])*Double.valueOf(Tabla2[i][CostoUnidad])))+"";
           SumaTotal+=Double.valueOf(Tabla2[i][CostoTotal]);
        } 
        return SumaTotal;      
    }

    public void ImprimirT2(){
       for (int i=0; i<Tabla2.length; i++) {
            System.out.print("|");
            for (int x=0; x<Tabla2[i].length; x++) {
                System.out.print(Tabla2[i][x]);
                if (x != Tabla2[i].length - 1) {
                    System.out.print("\t");
                }
            }
            System.out.println("|");
        }  
    }
}
