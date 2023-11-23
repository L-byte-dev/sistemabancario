package org.informatorio.servicio.archivos;

import org.informatorio.domain.Cliente;
import org.informatorio.domain.CuentaAhorro;
import org.informatorio.domain.CuentaBancaria;

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class ArchivosServicioImpl implements ArchivosServicio {
    private final String UBICACION_ARCHIVO = "/src/main/java/org/informatorio/recursos/";

    @Override
    public void exportarCuentasACsv(List<Cliente> clientes, String nombreArchivo) {
        if (clientes.isEmpty() || clientes.stream().allMatch(cliente -> cliente.getCuentas().isEmpty())) {
            System.out.println("No hay clientes con cuentas para exportar.");
        } else {
            String ruta = System.getProperty("user.dir").concat(UBICACION_ARCHIVO).concat(nombreArchivo);

            clientes.sort(Comparator.comparingLong(Cliente::getNumeroUnico));

            try (CSVWriter writer = new CSVWriter(new FileWriter(ruta))) {
                String[] encabezados = {"Numero Unico", "Titular", "Saldo", "Tipo de Cuenta"};
                writer.writeNext(encabezados);

                for (Cliente cliente : clientes) {
                    cliente.getCuentas().sort(Comparator.comparingDouble(CuentaBancaria::getSaldo));

                    for (CuentaBancaria cuenta : cliente.getCuentas()) {
                        String tipoCuenta = (cuenta instanceof CuentaAhorro) ? "Ahorro" : "Corriente";
                        String[] datos = {
                                String.valueOf(cliente.getNumeroUnico()),
                                cliente.getNombre(),
                                String.valueOf(cuenta.getSaldo()),
                                tipoCuenta
                        };
                        writer.writeNext(datos);
                    }
                }
                System.out.println("Exportacion a CSV exitosa");
            } catch (IOException e) {
                System.out.println("Error al exportar a CSV: " + e.getMessage());
            }
        }
    }
}
