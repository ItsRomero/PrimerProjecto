import java.util.*;

class Entrenamiento {
    String fecha, tipo;
    double valor;

    Entrenamiento(String fecha, String tipo, double valor) {
        this.fecha = fecha;
        this.tipo = tipo;
        this.valor = valor;
    }

    public String toString() {
        return fecha + " | " + tipo + " | " + valor;
    }
}

class Atleta {
    String nombre, disciplina, departamento;
    int edad;
    List<Entrenamiento> entrenamientos = new ArrayList<>();

    Atleta(String n, int e, String d, String dep) {
        nombre = n; edad = e; disciplina = d; departamento = dep;
    }

    void agregarEntrenamiento(Entrenamiento ent) {
        entrenamientos.add(ent);
    }

    void mostrarHistorial() {
        if(entrenamientos.isEmpty()) {
            System.out.println("No hay entrenamientos registrados.");
        } else {
            entrenamientos.forEach(System.out::println);
        }
    }

    double getPromedio() {
        return entrenamientos.stream().mapToDouble(e -> e.valor).average().orElse(0);
    }

    double getMejorMarca() {
        return entrenamientos.stream().mapToDouble(e -> e.valor).min().orElse(0);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Atleta> atletas = new ArrayList<>();
        int opcion;

        do {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1. Registrar atleta");
            System.out.println("2. Registrar entrenamiento");
            System.out.println("3. Mostrar historial de un atleta");
            System.out.println("4. Mostrar estadísticas de un atleta");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt(); sc.nextLine();

            switch(opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Edad: ");
                    int edad = sc.nextInt(); sc.nextLine();
                    System.out.print("Disciplina: ");
                    String disciplina = sc.nextLine();
                    System.out.print("Departamento: ");
                    String depto = sc.nextLine();

                    atletas.add(new Atleta(nombre, edad, disciplina, depto));
                    System.out.println("Atleta registrado con éxito.");
                    break;

                case 2:
                    if(atletas.isEmpty()) {
                        System.out.println("No hay atletas registrados.");
                        break;
                    }
                    System.out.print("Nombre del atleta: ");
                    String nAtleta = sc.nextLine();
                    Atleta encontrado = buscarAtleta(atletas, nAtleta);

                    if(encontrado != null) {
                        System.out.print("Fecha (YYYY-MM-DD): ");
                        String fecha = sc.nextLine();
                        System.out.print("Tipo: ");
                        String tipo = sc.nextLine();
                        System.out.print("Valor (tiempo en seg. o peso en kg): ");
                        double valor = sc.nextDouble(); sc.nextLine();

                        encontrado.agregarEntrenamiento(new Entrenamiento(fecha, tipo, valor));
                        System.out.println("Entrenamiento registrado.");
                    } else {
                        System.out.println("Atleta no encontrado.");
                    }
                    break;

                case 3:
                    if(atletas.isEmpty()) {
                        System.out.println("No hay atletas registrados.");
                        break;
                    }
                    System.out.print("Nombre del atleta: ");
                    String buscarHist = sc.nextLine();
                    Atleta aHist = buscarAtleta(atletas, buscarHist);

                    if(aHist != null) {
                        System.out.println("\n===== HISTORIAL DE " + aHist.nombre + " =====");
                        aHist.mostrarHistorial();
                    } else {
                        System.out.println("Atleta no encontrado.");
                    }
                    break;

                case 4:
                    if(atletas.isEmpty()) {
                        System.out.println("No hay atletas registrados.");
                        break;
                    }
                    System.out.print("Nombre del atleta: ");
                    String buscarEst = sc.nextLine();
                    Atleta aEst = buscarAtleta(atletas, buscarEst);

                    if(aEst != null) {
                        System.out.println("\n===== ESTADÍSTICAS DE " + aEst.nombre + " =====");
                        System.out.println("Promedio: " + aEst.getPromedio());
                        System.out.println("Mejor marca: " + aEst.getMejorMarca());
                    } else {
                        System.out.println("Atleta no encontrado.");
                    }
                    break;

                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida, intenta de nuevo.");
            }

        } while(opcion != 5);

        sc.close();
    }
    private static Atleta buscarAtleta(List<Atleta> atletas, String nombre) {
        for (Atleta a : atletas) {
            if (a.nombre.equalsIgnoreCase(nombre)) {
                return a;
            }
        }
        return null;
    }
}
