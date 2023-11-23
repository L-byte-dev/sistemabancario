package org.informatorio.servicio.cliente;

import org.informatorio.domain.Banco;
import org.informatorio.domain.Cliente;
import org.informatorio.domain.CuentaBancaria;
import org.informatorio.entrada.InputConsoleService;
import org.informatorio.servicio.cuenta.cuentabancaria.CuentaBancariaServicio;

import java.util.List;
import java.util.Objects;

public class ClienteServicioImpl implements ClienteServicio {
    public static final String MENSAJE_REGISTRAR_CLIENTE_TEMPLATE =  "Debe registrar al menos un cliente";
    public static final String MENSAJE_CLIENTE_SIN_CUENTA_TEMPLATE =  "El cliente seleccionado no tiene ninguna cuenta bancaria";

    private Banco banco;
    private CuentaBancariaServicio cuentaBancariaServicio;

    public ClienteServicioImpl(Banco banco, CuentaBancariaServicio cuentaBancariaServicio) {
        this.banco = banco;
        this.cuentaBancariaServicio = cuentaBancariaServicio;
    }

    @Override
    public void agregarCuenta(Cliente cliente, CuentaBancaria cuentaBancaria) {
        cuentaBancaria.setTitular(cliente);
        cuentaBancaria.setSaldo(0.0);
        cliente.getCuentas().add(cuentaBancaria);
        System.out.println("Cuenta agregada exitosamente");
    }

    @Override
    public void eliminarCuenta(Cliente cliente) {
        CuentaBancaria cuentaEliminar = cuentaBancariaServicio.seleccionarCuenta(cliente);
        if (Objects.nonNull(cuentaEliminar)) {
            cliente.getCuentas().remove(cuentaEliminar);
            System.out.println("Cuenta eliminada exitosamente");
        }
    }

    @Override
    public void consultarSaldoTotal(Cliente cliente) {
        if (cliente.getCuentas().isEmpty()) {
            System.out.println(MENSAJE_CLIENTE_SIN_CUENTA_TEMPLATE);
        } else {
            double saldoTotal = 0;
            cuentaBancariaServicio.mostrarCuentas(cliente);
            for (CuentaBancaria cuenta : cliente.getCuentas()) {
                saldoTotal += cuenta.getSaldo();
            }
            System.out.println("Saldo total: " + saldoTotal);
        }
    }

    @Override
    public void mostrarClientes(Banco banco) {
        List<Cliente> clientes = banco.getClientes();
        for (Cliente cliente : clientes) {
            System.out.printf("Número único: %d, Nombre: %s, Dirección: %s%n", cliente.getNumeroUnico(), cliente.getNombre(), cliente.getDireccion());
        }
    }

    public Cliente seleccionarCliente() {
        if (banco.getClientes().isEmpty()) {
            System.out.println(MENSAJE_REGISTRAR_CLIENTE_TEMPLATE);
            return null;
        } else {
            mostrarClientes(banco);
            System.out.println("Ingrese el número único del cliente");

            Long numeroUnicoCliente = InputConsoleService.getScanner().nextLong();
            Cliente cliente = getClienteByNumeroUnico(numeroUnicoCliente);

            if (Objects.isNull(cliente)) {
                System.out.println("No existe el cliente con número único: " + numeroUnicoCliente);
                return null;
            } else {
                return cliente;
            }
        }
    }

    @Override
    public Cliente getClienteByNumeroUnico(Long numeroUnicoCliente) {
        List<Cliente> clientes = banco.getClientes();
        for (Cliente cliente : clientes) {
            if (Objects.equals(cliente.getNumeroUnico(), numeroUnicoCliente)) {
                return cliente;
            }
        }
        return null;
    }
}
