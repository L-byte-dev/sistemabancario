package org.informatorio.domain;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private static Long contadorNumerosUnicos = 1L;
    private Long numeroUnico;
    private String nombre;
    private String direccion;
    private List<CuentaBancaria> cuentas = new ArrayList<>();

    public Cliente() {
    }

    public Cliente(String nombre, String direccion) {
        this.numeroUnico = contadorNumerosUnicos++;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public long getNumeroUnico() {
        return numeroUnico;
    }

    public void setNumeroUnico(Long numeroUnico) {
        this.numeroUnico = numeroUnico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<CuentaBancaria> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<CuentaBancaria> cuentas) {
        this.cuentas = cuentas;
    }
}
