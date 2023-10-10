import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

class AsociacionMascotas {
    public static void main(String[] args) {
        Pila<Vacuna> pilaVacunas = new Pila<>();
        Cola<Mascota> colaMascotas = new Cola<>();
        List<Mascota> mascotas = new ArrayList<>();
        List<Vacuna> vacunas = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Menú:");
            System.out.println("1. Agregar una vacuna a la pila");
            System.out.println("2. Mostrar y retornar la vacuna con mayor precio de la pila");
            System.out.println("3. Agregar una mascota a la cola");
            System.out.println("4. Mostrar y pasar la cola de mascotas");
            System.out.println("5. Mostrar información y las vacunas aplicadas en la campaña");
            System.out.println("6. Mostrar cantidad de vacunas parvovirus colocadas en la campaña");
            System.out.println("7. Mostrar porcentaje de vacunas aplicadas de hepatitis");
            System.out.println("8. Mostrar cantidad de donación total");
            System.out.println("9. Salir");
            System.out.print("Elija una opción: ");

            String opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    agregarVacunaAPila(pilaVacunas, sc);
                    break;
                case "2":
                    mostrarYRetornarVacunaMayorPrecio(pilaVacunas);
                    break;
                case "3":
                    agregarMascotaACola(colaMascotas, mascotas, sc);
                    break;
                case "4":
                    mostrarYPasarCola(colaMascotas);
                    break;
                case "5":
                    mostrarInformacionMascotaYVacunas(mascotas, sc);
                    break;
                case "6":
                    contarVacunasParvovirus(mascotas);
                    break;
                case "7":
                    calcularPorcentajeVacunasHepatitis(vacunas);
                    break;
                case "8":
                    calcularDonacionTotal(vacunas);
                    break;
                case "9":
                    System.out.println("Saliendo del programa.");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }

    private static void agregarVacunaAPila(Pila<Vacuna> pila, Scanner sc) {
        System.out.print("Ingrese el código de la vacuna: ");
        String codigo = sc.nextLine();
        if (!Validaciones.esNumeroEntero(codigo)) {
            System.out.println("El código debe ser un número entero.");
            return;
        }
        int codigoVacuna = Integer.parseInt(codigo);

        System.out.print("Ingrese el precio sugerido: ");
        String precioSugeridoStr = sc.nextLine();
        if (!Validaciones.esNumeroDecimal(precioSugeridoStr)) {
            System.out.println("El precio sugerido debe ser un número decimal.");
            return;
        }
        double precioSugerido = Double.parseDouble(precioSugeridoStr);

        System.out.print("Ingrese la cantidad: ");
        String cantidadStr = sc.nextLine();
        if (!Validaciones.esNumeroEntero(cantidadStr)) {
            System.out.println("La cantidad debe ser un número entero.");
            return;
        }
        int cantidad = Integer.parseInt(cantidadStr);

        System.out.print("Ingrese el nombre de la vacuna: ");
        String nombreVacuna = sc.nextLine();

        Vacuna vacuna = new Vacuna(codigoVacuna, precioSugerido, cantidad, nombreVacuna);
        pila.apilar(vacuna);

        System.out.println("Vacuna agregada a la pila.");
    }

    private static void mostrarYRetornarVacunaMayorPrecio(Pila<Vacuna> pila) {
        try {
            Vacuna vacunaMayorPrecio = ManejoPila.obtenerVacunaMayorPrecio(pila);
            System.out.println("Vacuna con mayor precio:");
            System.out.println("Código: " + vacunaMayorPrecio.getCodigoVacuna());
            System.out.println("Precio: $" + vacunaMayorPrecio.getPrecioSugerido());
            System.out.println("Cantidad: " + vacunaMayorPrecio.getCantidad());
            System.out.println("Nombre: " + vacunaMayorPrecio.getNombreVacuna());
        } catch (EmptyStackException e) {
            System.out.println("La pila de vacunas está vacía.");
        }
    }

    private static void agregarMascotaACola(Cola<Mascota> cola, List<Mascota> mascotas, Scanner sc) {
        System.out.print("Ingrese el código de la mascota: ");
        String codigo = sc.nextLine();
        if (!Validaciones.esNumeroEntero(codigo)) {
            System.out.println("El código debe ser un número entero.");
            return;
        }
        int codigoMascota = Integer.parseInt(codigo);

        System.out.print("Ingrese el nombre de la mascota: ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese la edad de la mascota: ");
        String edadStr = sc.nextLine();
        if (!Validaciones.esNumeroEntero(edadStr)) {
            System.out.println("La edad debe ser un número entero.");
            return;
        }
        int edad = Integer.parseInt(edadStr);

        System.out.print("Ingrese la cédula del dueño de la mascota: ");
        String cedulaDuenio = sc.nextLine();

        Mascota mascota = new Mascota(codigoMascota, nombre, edad, cedulaDuenio);
        cola.encolar(mascota);
        mascotas.add(mascota); // Agregar la mascota a la lista de mascotas

        System.out.println("Mascota agregada a la cola.");
    }

    private static void mostrarYPasarCola(Cola<Mascota> cola) {
        try {
            ManejoCola.mostrarCola(cola);
            ManejoCola.pasarCola(cola);
            System.out.println("Cola de mascotas pasada a otra cola.");
        } catch (NoSuchElementException e) {
            System.out.println("La cola de mascotas está vacía.");
        }
    }

    private static void mostrarInformacionMascotaYVacunas(List<Mascota> mascotas, Scanner sc) {
        System.out.print("Ingrese el código de la mascota: ");
        String codigoMascotaStr = sc.nextLine();
        if (!Validaciones.esNumeroEntero(codigoMascotaStr)) {
            System.out.println("El código de la mascota debe ser un número entero.");
            return;
        }
        int codigoMascota = Integer.parseInt(codigoMascotaStr);

        Mascota mascotaSeleccionada = null;
        for (Mascota mascota : mascotas) {
            if (mascota.getCodigoMascota() == codigoMascota) {
                mascotaSeleccionada = mascota;
                break;
            }
        }

        if (mascotaSeleccionada == null) {
            System.out.println("Mascota no encontrada.");
        } else {
            System.out.println("Información de la mascota:");
            System.out.println("Nombre: " + mascotaSeleccionada.getNombre());
            System.out.println("Edad: " + mascotaSeleccionada.getEdad());
            System.out.println("Cédula del dueño: " + mascotaSeleccionada.getCedulaDuenio());

            // Mostrar las vacunas aplicadas a la mascota
            System.out.println("Vacunas aplicadas:");
            for (Vacuna vacuna : mascotaSeleccionada.getVacunasAplicadas()) {
                System.out.println("- " + vacuna.getNombreVacuna());
            }
        }
    }

    private static void contarVacunasParvovirus(List<Mascota> mascotas) {
        int totalVacunasParvovirus = 0;
        for (Mascota mascota : mascotas) {
            for (Vacuna vacuna : mascota.getVacunasAplicadas()) {
                if (vacuna.getNombreVacuna().equalsIgnoreCase("parvovirus")) {
                    totalVacunasParvovirus++;
                }
            }
        }
        System.out.println("Total de vacunas de Parvovirus aplicadas: " + totalVacunasParvovirus);
    }

    private static void calcularPorcentajeVacunasHepatitis(List<Vacuna> vacunas) {
        int totalVacunasHepatitis = 0;
        for (Vacuna vacuna : vacunas) {
            if (vacuna.getNombreVacuna().equalsIgnoreCase("hepatitis")) {
                totalVacunasHepatitis += vacuna.getCantidad();
            }
        }
        double porcentajeHepatitis = (double) totalVacunasHepatitis / vacunas.size() * 100.0;
        System.out.println("Porcentaje de vacunas de Hepatitis aplicadas: " + porcentajeHepatitis + "%");
    }

    private static void calcularDonacionTotal(List<Vacuna> vacunas) {
        double donacionTotal = 0;
        for (Vacuna vacuna : vacunas) {
            donacionTotal += vacuna.getPrecioSugerido() * vacuna.getCantidad();
        }
        System.out.println("Donación total: $" + donacionTotal);
    }
}