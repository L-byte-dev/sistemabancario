package org.informatorio.servicio.banco;

import org.informatorio.domain.Cliente;

public interface BancoServicio {
    void registrarCliente();
    void abrirCuenta(Cliente cliente);
    void exportarCuentasACsv();
}
