package org.informatorio.servicio.archivos;

import org.informatorio.domain.Cliente;

import java.util.List;

public interface ArchivosServicio {
    void exportarCuentasACsv(List<Cliente> clientes, String nombreArchivo);
}
