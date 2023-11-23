package org.informatorio.servicio.cuenta.cuentacorriente;

import org.informatorio.domain.CuentaCorriente;
import org.informatorio.servicio.cuenta.cuentabancaria.CuentaBancariaServicio;

public interface CuentaCorrienteServicio extends CuentaBancariaServicio {
    void retirar(CuentaCorriente cuentaCorriente, double monto);
}
