package org.informatorio.domain;

public abstract class CuentaBancaria {
    protected static long contadorNumerosCuenta = 1L;
    protected Long numeroCuenta;
    protected Cliente titular;
    protected Double saldo;

    public CuentaBancaria() {
        this.numeroCuenta = contadorNumerosCuenta++;
    }

    public CuentaBancaria(Cliente titular, Double saldo) {
        this.numeroCuenta = contadorNumerosCuenta++;
        this.titular = titular;
        this.saldo = saldo;
    }

    public Long getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(Long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
}
