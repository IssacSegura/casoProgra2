
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author issac
 */
public class gestionReserva {

    private habitaciones[] habitaciones;
    private int totalHabitaciones;
    private int pisos;
    private int habitacionesPorPiso;

    //constructor
    public gestionReserva(int pisos, int habitacionesPorPiso) {
        this.pisos = pisos;
        this.habitacionesPorPiso = habitacionesPorPiso;
        habitaciones = new habitaciones[pisos * habitacionesPorPiso];
        totalHabitaciones = 0;
        precargarHabitaciones(); // Cargar habitaciones de ejemplo
    }

    // Metodo para precargar las habitaciones con datos iniciales
    private void precargarHabitaciones() {
        // Datos precargados
        habitaciones[0] = new habitaciones("101", "Simple", 30000, "Libre");
        habitaciones[1] = new habitaciones("102", "Doble", 40000, "ocupada");
        habitaciones[2] = new habitaciones("103", "Simple", 30000, "sucia");
        habitaciones[3] = new habitaciones("201", "doble", 40000, "libre");
        habitaciones[4] = new habitaciones("20", "simple", 30000, "ocupada");
        habitaciones[5] = new habitaciones("203", "Doble", 40000, "libre");
        habitaciones[6] = new habitaciones("301", "simple", 30000, "sucia");
        habitaciones[7] = new habitaciones("302", "doble", 40000, "Libre");
        habitaciones[8] = new habitaciones("303", "Simple", 30000, "Ocupada");
        habitaciones[9] = new habitaciones("304", "Doble", 40000, "libre");

        totalHabitaciones = 10; // Total de habitaciones precargadas
    }

    // Registrar una nueva habitacion
    public void registrarHabitacion() {
        if (totalHabitaciones < habitaciones.length) {
            String numero = JOptionPane.showInputDialog("Ingrese el numero de la habitacion:");
            String tipo = JOptionPane.showInputDialog("Ingrese el tipo de habitacion (Simple/Doble):");
            double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio de la habitacion en colones:"));
            String estado = JOptionPane.showInputDialog("Ingrese el estado de la habitacion (Libre/Ocupada/Sucia):");

            habitaciones[totalHabitaciones] = new habitaciones(numero, tipo, precio, estado);
            totalHabitaciones++;
            JOptionPane.showMessageDialog(null, "Habitacion registrada con exito.");
        } else {
            JOptionPane.showMessageDialog(null, "No se pueden registrar mas habitaciones.");
        }
    }

    // Listar todas las habitaciones
    public void listarHabitaciones() {
        String lista = "Habitaciones registradas:\n";
        for (int i = 0; i < totalHabitaciones; i++) {
            lista += habitaciones[i].obtenerDetalles() + "\n\n";
        }
        JOptionPane.showMessageDialog(null, lista);
    }

    //modificar una habitacion
    public void modificarHabitacion() {
        String numeroBuscado = JOptionPane.showInputDialog("Ingrese el numero de la habitacion a modificar:");
        for (int i = 0; i < totalHabitaciones; i++) {
            if (habitaciones[i].obtenerDetalles().contains("Numero: " + numeroBuscado)) {
                String nuevoTipo = JOptionPane.showInputDialog("Ingrese el nuevo tipo de habitacion:");
                double nuevoPrecio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el nuevo precio en colones:"));
                String nuevoEstado = JOptionPane.showInputDialog("Ingrese el nuevo estado (Libre/Ocupada/Sucia):");

                habitaciones[i].modificar(nuevoTipo, nuevoPrecio, nuevoEstado);
                JOptionPane.showMessageDialog(null, "Habitacion modificada con exito.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Habitacion no encontrada.");
    }

    //generar factura del hotel
    public void generarFacturaHotel() {
        int totalHabitaciones = pisos * habitacionesPorPiso;
        int libres = 0;
        int ocupadas = 0;
        int sucias = 0;

        for (int i = 0; i < totalHabitaciones; i++) {
            String estado = habitaciones[i].getEstado();

            // Comparacion simple por nombre de estado
            if (estado == "libre") {
                libres++;
            } else if (estado == "ocupada") {
                ocupadas++;
            } else if (estado == "Sucia") {
                sucias++;
            }
        }

        String factura = "Factura del Hotel:\n"
                + "Habitaciones Libres: " + libres + "\n"
                + "Habitaciones Ocupadas: " + ocupadas + "\n"
                + "Habitaciones Sucias: " + sucias;

        JOptionPane.showMessageDialog(null, factura);
    }
}
