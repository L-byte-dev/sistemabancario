package org.informatorio.servicio.cuenta.cuentabancaria;

import org.informatorio.domain.*;
import org.informatorio.entrada.InputConsoleService;
import org.informatorio.servicio.cliente.ClienteServicio;
import org.informatorio.servicio.cliente.ClienteServicioImpl;

import java.util.List;
import java.util.Objects;

public class CuentaBancariaServicioImpl implements CuentaBancariaServicio {
    public static final String MENSAJE_CANTIDAD_MINIMA_TEMPLATE =  "El monto ingresado debe ser mayor que 0";

    private ClienteServicio clienteServicio;

    public CuentaBancariaServicioImpl() {
    }

    public CuentaBancariaServicioImpl(ClienteServicio clienteServicio) {
        this.clienteServicio = clienteServicio;
    }

    public void setClienteServicio(ClienteServicio clienteServicio) {
        this.clienteServicio = clienteServicio;
    }

    @Override
    public void abrirCuenta(Cliente cliente) {
        System.out.println("Seleccione el tipo de cuenta que desea abrir: ");
        System.out.println("1. Cuenta de ahorro");
        System.out.println("2. Cuenta corriente");
        int opc = InputConsoleService.getScanner().nextInt();
        switch (opc){
            case 1:
                CuentaBancaria cuentaAhorro = new CuentaAhorro();
                clienteServicio.agregarCuenta(cliente, cuentaAhorro);
                break;
            case 2:
                CuentaBancaria cuentaCorriente = new CuentaCorriente();
                clienteServicio.agregarCuenta(cliente, cuentaCorriente);
                break;
            default:
                System.out.println("Error! Opcion invalida");
        }
    }

    @Override
    public void depositar(CuentaBancaria cuentaBancaria, double monto) {
        if (monto > 0) {
            double nuevoSaldo = cuentaBancaria.getSaldo() + monto;
            cuentaBancaria.setSaldo(nuevoSaldo);
            System.out.println("Depósito exitoso.");
        } else {
            System.out.println(MENSAJE_CANTIDAD_MINIMA_TEMPLATE);
        }
    }

    @Override
    public void retirar(CuentaBancaria cuentaBancaria, double monto) {
        if (monto > 0) {
            if (monto > cuentaBancaria.getSaldo()) {
                System.out.println("La cuenta no tiene tanto dinero para retirar");
            } else {
                double nuevoSaldo = cuentaBancaria.getSaldo() - monto;
                cuentaBancaria.setSaldo(nuevoSaldo);
                System.out.println("Retiro exitoso.");
            }
        } else {
            System.out.println(MENSAJE_CANTIDAD_MINIMA_TEMPLATE);
        }
    }

    @Override
    public void mostrarCuentas(Cliente cliente) {
        List<CuentaBancaria> cuentas = cliente.getCuentas();
        for (CuentaBancaria cuenta : cuentas) {
            String tipoCuenta = (cuenta instanceof CuentaAhorro) ? "Ahorro" : "Corriente";
            System.out.printf("Número cuenta: %d, Saldo: %f, Tipo: %s%n", cuenta.getNumeroCuenta(), cuenta.getSaldo(), tipoCuenta);
        }
    }

    @Override
    public CuentaBancaria seleccionarCuenta(Cliente cliente) {
        if (cliente.getCuentas().isEmpty()) {
            System.out.println(ClienteServicioImpl.MENSAJE_CLIENTE_SIN_CUENTA_TEMPLATE);
            return null;
        } else {
            System.out.println("Ingrese el número de cuenta");
            mostrarCuentas(cliente);

            Long numeroCuenta = InputConsoleService.getScanner().nextLong();
            CuentaBancaria cuenta = getCuentaByNumeroCuenta(cliente, numeroCuenta);

            if (Objects.isNull(cuenta)) {
                System.out.println("No existe la cuenta con número único: " + numeroCuenta);
                return null;
            } else {
                return cuenta;
            }
        }
    }

    @Override
    public CuentaBancaria getCuentaByNumeroCuenta (Cliente cliente, Long numeroCuenta) {
        List<CuentaBancaria> cuentas = cliente.getCuentas();
        for (CuentaBancaria cuenta : cuentas) {
            if (Objects.equals(cuenta.getNumeroCuenta(), numeroCuenta)) {
                return cuenta;
            }
        }
        return null;
    }
}