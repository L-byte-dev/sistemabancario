# Sistema Bancario
Este código Java representa una aplicación de simulación de un sistema bancario básico tomando en cuenta lo investigado. Aquí hay una descripción detallada del código:

**Banco:**

Contiene un nombre y una lista de clientes.
Tiene métodos para obtener y establecer el nombre del banco, así como para obtener y establecer la lista de clientes.

**Cliente:**

Representa a un cliente del banco con un número único, nombre, dirección y una lista de cuentas bancarias.
Tiene métodos para obtener y establecer la información del cliente y sus cuentas.

**CuentaBancaria:**

Clase abstracta que sirve como base para las cuentas bancarias.
Contiene un número de cuenta, información del titular (cliente), y saldo.
Tiene métodos para obtener y establecer la información de la cuenta.

**CuentaAhorro:**

Extiende la clase abstracta CuentaBancaria y representa una cuenta de ahorros con una tasa de interés.

**CuentaCorriente:**

Extiende la clase abstracta CuentaBancaria y representa una cuenta corriente con un límite de sobregiro.

**InputConsoleService:**

Proporciona métodos estáticos para gestionar la entrada del usuario desde la consola mediante Scanner.

**ArchivosServicio y ArchivosServicioImpl:**

Define una interfaz y una implementación para exportar información de cuentas a un archivo CSV.

**BancoServicio y BancoServicioImpl:**

Define una interfaz y una implementación para servicios bancarios, como registrar clientes, abrir cuentas y exportar cuentas a CSV.

**ClienteServicio y ClienteServicioImpl:**

Define una interfaz y una implementación para servicios relacionados con clientes, como agregar o eliminar cuentas, consultar saldos y mostrar información del cliente.

**CuentaBancariaServicio y CuentaBancariaServicioImpl:**

Define una interfaz y una implementación para servicios relacionados con cuentas bancarias, como depositar, retirar y mostrar información de cuentas.

**CuentaAhorroServicio y CuentaAhorroServicioImpl:**

Define una interfaz y una implementación para servicios específicos de cuentas de ahorro, como calcular e agregar intereses.

**CuentaCorrienteServicio y CuentaCorrienteServicioImpl:**

Define una interfaz y una implementación para servicios específicos de cuentas corrientes, como realizar retiros considerando un límite de sobregiro.

**MenuCliente y MenuClienteImpl:**

Define una interfaz y una implementación para un menú interactivo relacionado con clientes, permitiendo abrir, eliminar cuentas, etc.

**MenuCuenta y MenuCuentaImpl:**

Define una interfaz y una implementación para un menú interactivo relacionado con cuentas bancarias, permitiendo depositar, retirar, etc.

**MenuPrincipal y MenuPrincipalImpl:**

Define una interfaz y una implementación para el menú principal de la aplicación, permitiendo registrar clientes, seleccionar clientes, exportar datos a CSV, etc.

**App:**

Punto de entrada principal para la aplicación. Se crea una instancia del banco y se configuran los servicios para luego iniciar el menú principal.

**Flujo de la Aplicación:**

La aplicación comienza en la clase App al crear instancias de las clases necesarias.
Se utiliza un menú principal (MenuPrincipal) para interactuar con el usuario y realizar operaciones como registrar clientes, seleccionar clientes y exportar datos a CSV.
La clase BancoServicioImpl implementa las operaciones del banco, como registrar clientes, abrir cuentas y exportar datos a CSV.
Los menús de cliente (MenuCliente) y cuenta (MenuCuenta) permiten realizar operaciones específicas para clientes y cuentas bancarias, respectivamente.
Se utilizan servicios específicos para manipular cuentas de ahorro, cuentas corrientes y otras operaciones relacionadas con clientes y cuentas bancarias.
La aplicación sigue un diseño modular y orientado a objetos, lo que facilita la expansión y mantenimiento del código.
