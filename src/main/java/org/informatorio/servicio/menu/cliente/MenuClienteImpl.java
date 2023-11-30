package org.informatorio.servicio.menu.cliente;

import org.informatorio.domain.Cliente;
import org.informatorio.entrada.InputConsoleService;
import org.informatorio.servicio.banco.BancoServicio;
import org.informatorio.servicio.cliente.ClienteServicio;
import org.informatorio.servicio.cuenta.cuentaahorro.CuentaAhorroServicio;
import org.informatorio.servicio.cuenta.cuentaahorro.CuentaAhorroServicioImpl;
import org.informatorio.servicio.cuenta.cuentabancaria.CuentaBancariaServicio;
import org.informatorio.servicio.cuenta.cuentabancaria.CuentaBancariaServicioImpl;
import org.informatorio.servicio.cuenta.cuentacorriente.CuentaCorrienteServicio;
import org.informatorio.servicio.cuenta.cuentacorriente.CuentaCorrienteServicioImpl;
import org.informatorio.servicio.menu.cuenta.MenuCuenta;
import org.informatorio.servicio.menu.cuenta.MenuCuentaImpl;

public class MenuClienteImpl implements MenuCliente {
    private ClienteServicio clienteServicio;
    private BancoServicio bancoServicio;

    public MenuClienteImpl(ClienteServicio clienteServicio, BancoServicio bancoServicio) {
        this.clienteServicio = clienteServicio;
        this.bancoServicio = bancoServicio;
    }


    public void seleccionarCliente() {
        Cliente cliente = clienteServicio.seleccionarCliente();
        if (cliente != null) {
            menuCliente(cliente);
        }
    }

    @Override
    public void menuCliente(Cliente cliente) {
        CuentaBancariaServicio cuentaBancariaServicio = new CuentaBancariaServicioImpl(clienteServicio);
        CuentaAhorroServicio cuentaAhorroServicio = new CuentaAhorroServicioImpl(clienteServicio);
        CuentaCorrienteServicio cuentaCorrienteServicio = new CuentaCorrienteServicioImpl(clienteServicio);
        MenuCuenta menuCuenta = new MenuCuentaImpl(cuentaBancariaServicio, cuentaAhorroServicio, cuentaCorrienteServicio);
        int opc;
        do {
            System.out.println("1. Abrir cuenta");
            System.out.println("2. Eliminar cuenta");
            System.out.println("3. Seleccionar cuenta");
            System.out.println("4. Ver saldo total");
            System.out.println("0. Volver al menú principal");

            System.out.println("Ingrese una opción");
            opc = InputConsoleService.getScanner().nextInt();

            switch (opc) {
                case 1:
                    cuentaBancariaServicio.abrirCuenta(cliente);
                    break;
                case 2:
                    clienteServicio.eliminarCuenta(cliente);
                    break;
                case 3:
                    menuCuenta.seleccionarCuenta(cliente);
                    break;
                case 0:
                    break;
                case 4:
                    clienteServicio.consultarSaldoTotal(cliente);
                    break;
                default:
                    System.out.println("Error! Por favor, seleccione una opción válida");
            }
        }while (opc != 0);
    }
}
