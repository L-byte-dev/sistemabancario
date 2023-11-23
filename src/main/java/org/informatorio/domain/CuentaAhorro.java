package org.informatorio.domain;

public class CuentaAhorro extends CuentaBancaria {
    private final Double TASA_INTERES = 100.0; // Ejemplo de tasa de interés

    public CuentaAhorro() {
    }

    public Double getTASA_INTERES() {
        return TASA_INTERES;
    }
}
