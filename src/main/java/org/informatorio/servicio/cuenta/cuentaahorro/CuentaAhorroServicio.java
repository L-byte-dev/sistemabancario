package org.informatorio.servicio.cuenta.cuentaahorro;

import org.informatorio.domain.CuentaAhorro;
import org.informatorio.servicio.cuenta.cuentabancaria.CuentaBancariaServicio;

public interface CuentaAhorroServicio extends CuentaBancariaServicio {
    void calcularIntereses(CuentaAhorro cuentaAhorro);
}
