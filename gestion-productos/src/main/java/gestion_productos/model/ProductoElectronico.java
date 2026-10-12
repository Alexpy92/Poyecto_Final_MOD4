package gestion_productos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.DiscriminatorValue;

@Entity
@DiscriminatorValue("ProductoElectronico")
public class ProductoElectronico extends Producto {

    private String marca;
    private String modelo;
    
    public ProductoElectronico() {
        super();
    }

    public ProductoElectronico(String nombre, Double precio, Integer cantidad, String marca, String modelo) {
        super(nombre, precio, cantidad);
        this.marca = marca;
        this.modelo = modelo;
    }

    @Override 
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println(
            "Producto Electronico: " + getNombre() +
            "Marca: " + marca + 
            ", Modelo: " + modelo +
            ", Precio: " + getPrecio() +
            ", Cantidad: " + getCantidad()
        );
    }

    // Getters and Setters
        public String getMarca() {
            return marca;
        }
    
        public void setMarca(String marca) {
            this.marca = marca;
        }
    
        public String getModelo() {
            return modelo;
        }
    
        public void setModelo(String modelo) {
            this.modelo = modelo;
        }

}