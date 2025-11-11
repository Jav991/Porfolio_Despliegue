/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionpedidos;

import java.util.ArrayList;

/**
 *
 * @author javier
 */
public class Pedido {
        private ArrayList<LineaPedido> arrayLineasPedido;
        private String cliente;
        private double total;

    public Pedido() {
    }

    public Pedido(ArrayList<LineaPedido> lineasPedido, String cliente, double total) {
        this.arrayLineasPedido = lineasPedido;
        this.cliente = cliente;
        this.total = total;
    }
    public Pedido(String cliente){
        this.cliente = cliente;
        this.arrayLineasPedido = null;
        this.total = 0;
    }

    public ArrayList<LineaPedido> getLineasPedido() {
        return arrayLineasPedido;
    }

    public void setLineasPedido(ArrayList<LineaPedido> lineasPedido) {
        this.arrayLineasPedido = lineasPedido;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Pedido{" + "lineasPedido=" + arrayLineasPedido + ", cliente=" + cliente + ", total=" + total + '}';
    }
    
    public void addlineaPedido(LineaPedido lp){
        if(this.arrayLineasPedido == null){
            this.arrayLineasPedido = new ArrayList();
        }
        this.arrayLineasPedido.add(lp);
    }
}
