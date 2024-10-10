import API.Consulta;

import java.io.IOException;
import java.util.Scanner;

public class Funciones {

    public void menu() throws IOException, InterruptedException {
        Scanner seleccion = new Scanner(System.in);
        String monedaBase;
        String monedaConvertir;
        System.out.println("*******    Bienvenido/a al Conversor de monedas.  **********");
        System.out.println("""
                ************************************************************
                -------------------Menu de Conversiones.--------------------
                1). Dólar [USD] =>> Peso Chileno [CLP].
                2). Peso Chileno [CLP] =>> Dólar [USD].
                3). Dólar [USD] =>> Peso Argentino[ARS].
                4). Peso Argentino[ARS] =>>  Dólar [USD].
                5). Dólar [USD] =>> Peso Colombiano[COP].
                6). Peso Colombiano[COP] =>> Dólar [USD].
                7). Dólar [USD] =>> Peso Brasileño[BRL].
                8). Peso Brasileño[BRL] =>> Dólar [USD].
                9). Dólar [USD] =>> Peso Mexicano[MXN].
                10).Peso Mexicano[MXN] =>> Dólar [USD].
                11).Salir de la aplicación.
                ************************************************************
                """);
        System.out.println("Elija una opción válida:");
        int opcion;
        opcion = seleccion.nextInt();
        switch (opcion) {
            case 1 -> {
                monedaBase = "USD";
                monedaConvertir = "CLP";
                convertir(monedaBase, monedaConvertir);
            }
            case 2 -> {
                monedaBase = "CLP";
                monedaConvertir = "USD";
                convertir(monedaBase, monedaConvertir);
            }
            case 3 -> {
                monedaBase = "USD";
                monedaConvertir = "ARG";
                convertir(monedaBase, monedaConvertir);
            }
            case 4 -> {
                monedaBase = "ARG";
                monedaConvertir = "USD";
                convertir(monedaBase, monedaConvertir);
            }
            case 5 -> {
                monedaBase = "USD";
                monedaConvertir = "COP";
                convertir(monedaBase, monedaConvertir);
            }
            case 6 -> {
                monedaBase = "COP";
                monedaConvertir = "USD";
                convertir(monedaBase, monedaConvertir);
            }
            case 7 -> {
                monedaBase = "USD";
                monedaConvertir = "BRL";
                convertir(monedaBase, monedaConvertir);
            }
            case 8 -> {
                monedaBase = "BRL";
                monedaConvertir = "USD";
                convertir(monedaBase, monedaConvertir);
            }
            case 9 -> {
                monedaBase = "USD";
                monedaConvertir = "MXN";
                convertir(monedaBase, monedaConvertir);
            }
            case 10 -> {
                monedaBase = "MXN";
                monedaConvertir = "USD";
                convertir(monedaBase, monedaConvertir);
            }
            case 11 -> {
                System.out.println("Saliendo del programa.");
                return;
            }
            default -> {
                System.out.println("Opción inválida. Por favor, elija una opción válida.");
                break;
            }
        }
    }

    public void convertir (String monedaBase, String monedaConvertir) throws IOException, InterruptedException {
        Scanner seleccion = new Scanner(System.in);
        System.out.println("Estás convirtiendo " + monedaBase + " a " + monedaConvertir);
        double monto = 0;
        while (monto <= 0) {
            System.out.println("Ingrese el monto que deseas convertir:");
            monto = seleccion.nextDouble();
            if (monto <= 0) {
                System.out.println("Por favor, ingrese un monto mayor a 0.");
            }
        }
        Consulta consulta = new Consulta();
        double total = consulta.resultado(monto,monedaBase,monedaConvertir);
        imprimirValor(total);
    }
    public void imprimirValor(double total) throws IOException, InterruptedException {

        System.out.printf("El total es: %.2f\n", total);
        System.out.println();
        System.out.println("¿Desea volver al menú principal? [Y/N]");
        Scanner scanner = new Scanner(System.in);
        String seleccion = scanner.next();

        // Comparación correcta usando equalsIgnoreCase
        if (seleccion.equalsIgnoreCase("Y")) {
            menu();
        } else {
            System.out.println("Gracias por usar el conversor.");
        }
    }
}
