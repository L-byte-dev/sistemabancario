package org.informatorio.domain;

public class CuentaCorriente extends CuentaBancaria {
    private final Double LIMITE_SOBREGIRO = 500.0; // Ejemplo de limite de sobregiro

    public CuentaCorriente() {
    }

    public double getLIMITE_SOBREGIRO() {
        return LIMITE_SOBREGIRO;
    }
}
