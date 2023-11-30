package org.informatorio.servicio.banco;

import org.informatorio.domain.*;
import org.informatorio.servicio.archivos.ArchivosServicio;
import org.informatorio.servicio.archivos.ArchivosServicioImpl;

import java.util.ArrayList;

public class BancoServicioImpl implements BancoServicio {
    private final Banco banco;

    public BancoServicioImpl(Banco banco) {
        this.banco = banco;
        this.banco.setClientes(new ArrayList<>());
    }

    @Override
    public void exportarCuentasACsv() {
        ArchivosServicio archivosServicio = new ArchivosServicioImpl();
        archivosServicio.exportarCuentasACsv(banco.getClientes(), "cuentas.csv");
    }
}
