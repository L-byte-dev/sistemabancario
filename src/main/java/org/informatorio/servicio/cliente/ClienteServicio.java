package org.informatorio.servicio.cliente;

import org.informatorio.domain.Banco;
import org.informatorio.domain.Cliente;
import org.informatorio.domain.CuentaBancaria;

public interface ClienteServicio {
    void agregarCuenta(Cliente cliente, CuentaBancaria cuentaBancaria);
    void eliminarCuenta(Cliente cliente);
    void consultarSaldoTotal(Cliente cliente);
    void mostrarClientes(Banco banco);
    Cliente seleccionarCliente();
    Cliente getClienteByNumeroUnico(Long numeroUnicoCliente);
}
