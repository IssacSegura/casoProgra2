/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author issac
 */
public class habitaciones {

    private String numero;
    private String tipo;
    private double precio;
    private String estado;

    // Constructor
    public habitaciones(String numero, String tipo, double precio, String estado) {
        this.numero = numero;
        this.tipo = tipo;
        this.precio = precio;
        this.estado = estado;
    }

    // Metodos para obtener detalles
    public String obtenerDetalles() {
        return "Numero: " + numero + "\nTipo: " + tipo + "\nPrecio: " + precio + " colones\nEstado: " + estado;
    }

    // Metodos para modificar informacion
    public void modificar(String tipo, double precio, String estado) {
        this.tipo = tipo;
        this.precio = precio;
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public double getPrecio() {
        return precio;
    }
}
