package org.informatorio.servicio.cuenta.cuentabancaria;

import org.informatorio.domain.Cliente;
import org.informatorio.domain.CuentaBancaria;

public interface CuentaBancariaServicio {
    void depositar(CuentaBancaria cuenta, double monto);
    void retirar(CuentaBancaria cuentaBancaria, double monto);
    void mostrarCuentas(Cliente cliente);
    CuentaBancaria seleccionarCuenta(Cliente cliente);
    CuentaBancaria getCuentaByNumeroCuenta(Cliente cliente, Long numeroCuenta);
}
