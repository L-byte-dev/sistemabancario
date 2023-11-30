package org.informatorio.servicio.cuenta.cuentabancaria;

import org.informatorio.domain.Cliente;
import org.informatorio.domain.CuentaBancaria;
import org.informatorio.servicio.cliente.ClienteServicio;

public interface CuentaBancariaServicio {
    void setClienteServicio(ClienteServicio clienteServicio);
    void abrirCuenta(Cliente cliente);
    void depositar(CuentaBancaria cuenta, double monto);
    void retirar(CuentaBancaria cuentaBancaria, double monto);
    void mostrarCuentas(Cliente cliente);
    CuentaBancaria seleccionarCuenta(Cliente cliente);
    CuentaBancaria getCuentaByNumeroCuenta(Cliente cliente, Long numeroCuenta);
}
