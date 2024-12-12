
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author issac
 */
public class CasoEstudio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        gestionReserva hotel = new gestionReserva(3, 5);

        while (true) {

            //menu de opcones 
            String menu = """
                menu de Gestion del Hotel:
                1. Registrar Habitacion
                2. Listar Habitaciones
                3. modificar Habitacion
                4. generacion Factura
                """;
            int opcion = Integer.parseInt(JOptionPane.showInputDialog(menu + "\nseleccione una opcion:"));

            if (opcion == 1) {
                hotel.registrarHabitacion();
            } else if (opcion == 2) {
                hotel.listarHabitaciones();
            } else if (opcion == 3) {
                hotel.modificarHabitacion();
            } else if (opcion == 4) {
                hotel.generarFacturaHotel();
            } else {
                JOptionPane.showMessageDialog(null, " no valido.");
            }
        }
    }
}
