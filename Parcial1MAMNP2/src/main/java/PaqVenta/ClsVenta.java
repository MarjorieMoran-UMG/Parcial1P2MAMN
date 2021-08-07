/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaqVenta;

import java.util.Scanner;

/**
 *
 * @author Marjorie
 */
public class ClsVenta {
    private int CantidadProducto;
    private String Producto;
    private Double Precio;
    private Double PesoProducto;
    
    public int getCant() {
        return CantidadProducto;
    }

    public void setCant(int Cantidad) {
        this.CantidadProducto = Cantidad;
    }

    public String getNombre() {
        return Producto;
    }

    public void setNombre(String Nombre) {
        this.Producto = Nombre;
    }

    public Double getPrecioProducto() {
        return Precio;
    }

    public void setPrecioProducto(Double Precio) {
        this.Precio = Precio;
    }

    public Double getPesoProducto() {
        return PesoProducto;
    }

    public void setPesoProducto(Double Peso) {
        this.PesoProducto = Peso;
    }
    
    
    
    // INGRESO DE LA INFORMACIÓN 
    public void CargadeInformacion(int n){
       Scanner Lector = new  Scanner(System.in);
        System.out.println("\n");
        System.out.println("Ingrese los productos"+(n+1)+":");
        System.out.println("\n");

       System.out.println("Ingrese la cantidad de productos"+(n+1)+":");
        setCant(Lector.nextInt());
        System.out.println("\n");
         
        System.out.println("Ingrese el nombre del producto"+(n+1)+":");
        setNombre(Lector.nextLine());
        setNombre(Lector.nextLine());
        System.out.println("\n");
        
       System.out.println("Ingrese el precio unitario del producto"+(n+1)+":");
        setPrecioProducto((Double) Lector.nextDouble());
        System.out.println("\n");
        
       System.out.println("Ingrese el peso del producto"+(n+1)+":");
        setPesoProducto((Double) Lector.nextDouble());
        System.out.println("\n");
    }
}
