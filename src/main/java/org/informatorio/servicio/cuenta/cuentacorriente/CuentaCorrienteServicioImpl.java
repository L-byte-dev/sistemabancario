package org.informatorio.servicio.cuenta.cuentacorriente;

import org.informatorio.domain.CuentaCorriente;
import org.informatorio.servicio.cliente.ClienteServicio;
import org.informatorio.servicio.cuenta.cuentabancaria.CuentaBancariaServicioImpl;

public class CuentaCorrienteServicioImpl extends CuentaBancariaServicioImpl implements CuentaCorrienteServicio{
    public CuentaCorrienteServicioImpl(ClienteServicio clienteServicio) {
        super(clienteServicio);
    }

    @Override
    public void retirar(CuentaCorriente cuentaCorriente, double monto) {
        double saldoDisponible = cuentaCorriente.getSaldo() + cuentaCorriente.getLIMITE_SOBREGIRO();
        if (monto > 0) {
            if (monto > saldoDisponible) {
                System.out.println("Retiro no permitido. Fondos insuficientes y excede el límite de sobregiro.");
            } else {
                double nuevoSaldo = cuentaCorriente.getSaldo() - monto;
                cuentaCorriente.setSaldo(nuevoSaldo);
                if (nuevoSaldo < 0) {
                    System.out.println("Retiro exitoso con sobregiro.");
                } else {
                    System.out.println("Retiro exitoso.");
                }
            }
        } else {
            System.out.println(MENSAJE_CANTIDAD_MINIMA_TEMPLATE);
        }
    }
}
