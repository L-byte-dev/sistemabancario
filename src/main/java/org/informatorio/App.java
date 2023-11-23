package org.informatorio;

import org.informatorio.domain.Banco;
import org.informatorio.entrada.InputConsoleService;
import org.informatorio.servicio.banco.BancoServicio;
import org.informatorio.servicio.banco.BancoServicioImpl;
import org.informatorio.servicio.cliente.ClienteServicio;
import org.informatorio.servicio.cliente.ClienteServicioImpl;
import org.informatorio.servicio.cuenta.cuentabancaria.CuentaBancariaServicio;
import org.informatorio.servicio.cuenta.cuentabancaria.CuentaBancariaServicioImpl;
import org.informatorio.servicio.menu.cliente.MenuCliente;
import org.informatorio.servicio.menu.cliente.MenuClienteImpl;
import org.informatorio.servicio.menu.principal.MenuPrincipal;
import org.informatorio.servicio.menu.principal.MenuPrincipalImpl;

public class App {

    public static void main( String[] args ) {
        InputConsoleService.createScanner();

        Banco banco = new Banco();
        CuentaBancariaServicio cuentaBancariaServicio = new CuentaBancariaServicioImpl();
        ClienteServicio clienteServicio = new ClienteServicioImpl(banco, cuentaBancariaServicio);
        BancoServicio bancoServicio = new BancoServicioImpl(clienteServicio, banco);
        MenuCliente menuCliente = new MenuClienteImpl(clienteServicio, bancoServicio);
        MenuPrincipal menuPrincipal = new MenuPrincipalImpl(bancoServicio, menuCliente);

        menuPrincipal.iniciar();

        InputConsoleService.closeScanner();
    }
}
