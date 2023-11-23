package org.informatorio.servicio.menu.cuenta;

import org.informatorio.domain.Cliente;
import org.informatorio.domain.CuentaBancaria;

public interface MenuCuenta {
    void seleccionarCuenta(Cliente cliente);
    void menuCuenta(CuentaBancaria cuentaBancaria);
}
