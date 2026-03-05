import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Random;

public class GeneradorSalarios {
    public static void main(String[] args) {
        String[] rangos = {"asistente", "asociado", "titular"};
        Random random = new Random();

        try (PrintWriter out = new PrintWriter(new FileWriter("salarios.txt"))) {
            for (int i = 1; i <= 1000; i++) {
                String nombre = "Nombre" + i;
                String apellido = "Apellido" + i;
                
                String rango = rangos[random.nextInt(rangos.length)];
                
                double salario = 0;
                switch (rango) {
                    case "asistente":
                        salario = 50000 + (80000 - 50000) * random.nextDouble();
                        break;
                    case "asociado":
                        salario = 60000 + (110000 - 60000) * random.nextDouble();
                        break;
                    case "titular":
                        salario = 75000 + (130000 - 75000) * random.nextDouble();
                        break;
                }
                
                out.printf(Locale.US, "%s %s %s %.2f%n", nombre, apellido, rango, salario);
            }
            System.out.println("Archivo 'salarios.txt' generado exitosamente con 1,000 registros.");
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo: " + e.getMessage());
        }
    }
}