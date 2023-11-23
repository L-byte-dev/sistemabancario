package org.informatorio.servicio.banco;

import org.informatorio.domain.*;
import org.informatorio.entrada.InputConsoleService;
import org.informatorio.servicio.archivos.ArchivosServicio;
import org.informatorio.servicio.archivos.ArchivosServicioImpl;
import org.informatorio.servicio.cliente.ClienteServicio;

import java.util.ArrayList;

public class BancoServicioImpl implements BancoServicio {
    private final ClienteServicio clienteServicio;
    private final Banco banco;

    public BancoServicioImpl(ClienteServicio clienteServicio, Banco banco) {
        this.clienteServicio = clienteServicio;
        this.banco = banco;
        this.banco.setClientes(new ArrayList<>());
    }

    @Override
    public void registrarCliente() {
        System.out.println("Escriba su nombre: ");
        String nombre = InputConsoleService.getScanner().next();
        System.out.println("Escriba su dirección: ");
        String direccion = InputConsoleService.getScanner().next();
        Cliente cliente = new Cliente(nombre, direccion);
        banco.getClientes().add(cliente);
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
    public void exportarCuentasACsv() {
        ArchivosServicio archivosServicio = new ArchivosServicioImpl();
        archivosServicio.exportarCuentasACsv(banco.getClientes(), "cuentas.csv");
    }
}
