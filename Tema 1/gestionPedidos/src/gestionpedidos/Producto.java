/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionpedidos;

/**
 * Clase que representa un producto en el sistema de gestión de pedidos.
 * Contiene información básica como nombre, categoría, precio y stock disponible.
 * 
 * @author javier
 * @version 1.0
 * @since 2024
 */
public class Producto {
    private String nombre;
    private String categoria;
    private double precio;
    private int stock;

    /**
     * Constructor por defecto que inicializa un producto sin parámetros.
     */
    public Producto() {
    }

    /**
     * Constructor que inicializa un producto con todos sus atributos.
     * 
     * @param nombre El nombre del producto
     * @param categoria La categoría a la que pertenece el producto
     * @param precio El precio unitario del producto
     * @param stock La cantidad disponible en inventario
     */
    public Producto(String nombre, String categoria, double precio, int stock) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
    }

    /**
     * Obtiene el nombre del producto.
     * 
     * @return El nombre del producto
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del producto.
     * 
     * @param nombre El nuevo nombre del producto
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la categoría del producto.
     * 
     * @return La categoría del producto
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Establece la categoría del producto.
     * 
     * @param categoria La nueva categoría del producto
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * Obtiene el precio del producto.
     * 
     * @return El precio del producto
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del producto.
     * 
     * @param precio El nuevo precio del producto
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Obtiene el stock disponible del producto.
     * 
     * @return La cantidad disponible en stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * Establece el stock disponible del producto.
     * 
     * @param stock La nueva cantidad de stock disponible
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Devuelve una representación en formato String del producto.
     * 
     * @return String que representa el producto con todos sus atributos
     */
    @Override
    public String toString() {
        return "Producto{" + "nombre=" + nombre + ", categoria=" + categoria + ", precio=" + precio + ", stock=" + stock + '}';
    }
}
