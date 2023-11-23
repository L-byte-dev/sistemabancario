package org.informatorio.servicio.cuenta.cuentaahorro;

import org.informatorio.domain.CuentaAhorro;
import org.informatorio.servicio.cuenta.cuentabancaria.CuentaBancariaServicioImpl;

public class CuentaAhorroServicioImpl extends CuentaBancariaServicioImpl implements CuentaAhorroServicio {

    @Override
    public void calcularIntereses(CuentaAhorro cuentaAhorro) {
        double intereses = cuentaAhorro.getSaldo() * (cuentaAhorro.getTASA_INTERES() / 100.0);
        depositar(cuentaAhorro, intereses);
        System.out.println("Intereses agregados exitosamente.");
    }
}
