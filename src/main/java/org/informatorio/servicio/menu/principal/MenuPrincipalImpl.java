package org.informatorio.servicio.menu.principal;

import org.informatorio.entrada.InputConsoleService;
import org.informatorio.servicio.banco.BancoServicio;
import org.informatorio.servicio.cliente.ClienteServicio;
import org.informatorio.servicio.menu.cliente.MenuCliente;

public class MenuPrincipalImpl implements MenuPrincipal {
    private BancoServicio bancoServicio;
    private ClienteServicio clienteServicio;
    private MenuCliente menuCliente;

    public MenuPrincipalImpl(BancoServicio bancoServicio, ClienteServicio clienteServicio, MenuCliente menuCliente) {
        this.bancoServicio = bancoServicio;
        this.clienteServicio = clienteServicio;
        this.menuCliente = menuCliente;
    }

    @Override
    public void iniciar() {
        int opc;
        do {
            System.out.println("1. Registrar cliente");
            System.out.println("2. Seleccionar cliente");
            System.out.println("3. Exportar datos de cuentas a CSV");
            System.out.println("0. Salir");

            System.out.println("Ingrese una opción");
            opc = InputConsoleService.getScanner().nextInt();

            switch (opc){
                case 1:
                    clienteServicio.registrarCliente();
                    break;
                case 2:
                    menuCliente.seleccionarCliente();
                    break;
                case 3:
                    bancoServicio.exportarCuentasACsv();
                    break;
                case 0:
                    System.out.println("Saliendo del programa");
                    break;
                default:
                    System.out.println("Error! Por favor, seleccione una opción válida");
            }
        }while (opc != 0);
        InputConsoleService.closeScanner();
    }
}