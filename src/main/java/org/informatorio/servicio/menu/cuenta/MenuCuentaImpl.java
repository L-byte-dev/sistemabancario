package org.informatorio.servicio.menu.cuenta;

import org.informatorio.domain.Cliente;
import org.informatorio.domain.CuentaAhorro;
import org.informatorio.domain.CuentaBancaria;
import org.informatorio.domain.CuentaCorriente;
import org.informatorio.entrada.InputConsoleService;
import org.informatorio.servicio.cuenta.cuentaahorro.CuentaAhorroServicio;
import org.informatorio.servicio.cuenta.cuentabancaria.CuentaBancariaServicio;
import org.informatorio.servicio.cuenta.cuentacorriente.CuentaCorrienteServicio;

import java.util.Objects;

public class MenuCuentaImpl implements MenuCuenta {
    private CuentaBancariaServicio cuentaBancariaServicio;
    private CuentaAhorroServicio cuentaAhorroServicio;
    private CuentaCorrienteServicio cuentaCorrienteServicio;

    public MenuCuentaImpl(CuentaBancariaServicio cuentaBancariaServicio, CuentaAhorroServicio cuentaAhorroServicio, CuentaCorrienteServicio cuentaCorrienteServicio) {
        this.cuentaBancariaServicio = cuentaBancariaServicio;
        this.cuentaAhorroServicio = cuentaAhorroServicio;
        this.cuentaCorrienteServicio = cuentaCorrienteServicio;
    }

    @Override
    public void seleccionarCuenta(Cliente cliente) {
        CuentaBancaria cuentaBancaria = cuentaBancariaServicio.seleccionarCuenta(cliente);
        if (Objects.nonNull(cuentaBancaria)) {
            menuCuenta(cuentaBancaria);
        }
    }

    @Override
    public void menuCuenta(CuentaBancaria cuentaBancaria) {
        int opc;
        do {
            System.out.println("1. Depositar");
            System.out.println("2. Retirar");
            System.out.println("3. Mostrar saldo");
            if (cuentaBancaria instanceof CuentaAhorro) {
                System.out.println("4. Calcular y agregar intereses");
            }
            System.out.println("0. Volver al menú del cliente");

            System.out.println("Ingrese una opción");
            opc = InputConsoleService.getScanner().nextInt();

            switch (opc) {
                case 1:
                    System.out.println("Ingrese el monto a depositar:");
                    double montoDeposito = InputConsoleService.getScanner().nextDouble();
                    cuentaBancariaServicio.depositar(cuentaBancaria, montoDeposito);
                    break;
                case 2:
                    System.out.println("Ingrese el monto a retirar:");
                    double montoRetiro = InputConsoleService.getScanner().nextDouble();
                    if (cuentaBancaria instanceof CuentaCorriente) {
                        cuentaCorrienteServicio.retirar((CuentaCorriente) cuentaBancaria, montoRetiro);
                    } else {
                        cuentaBancariaServicio.retirar(cuentaBancaria, montoRetiro);
                    }
                    break;
                case 3:
                    System.out.println("Saldo: " + cuentaBancaria.getSaldo());
                    break;
                case 4:
                    if (cuentaBancaria instanceof CuentaAhorro) {
                        cuentaAhorroServicio.calcularIntereses((CuentaAhorro) cuentaBancaria);
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Error! Por favor, seleccione una opción válida");
            }
        }while (opc != 0);
    }
}
