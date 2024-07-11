import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Consulta consulta = new Consulta();
        Scanner lectura = new Scanner(System.in);
        int opcion = 0;
        boolean continuar = true;


        String menu = """
                \n
                ********************************************************
                *** Conversor de monedas ***
                Indique, mediante el teclado, que conversión desea realizar
                1) ARS - Peso argentino --> USD - Dólar estadounidense
                2) ARS - Peso argentino --> BOB - Boliviano boliviano
                3) ARS - Peso argentino --> BRL - Real brasileño
                4) BRL - Real brasileño --> ARS - Peso argentino
                5) USD - Dólar estadounidense --> ARS - Peso argentino
                6) BOB - Boliviano boliviano --> ARS - Peso argentino
                7) Salir
                ********************************************************
                """;


        while (continuar) {
                System.out.println(menu);

            try{
                opcion = lectura.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("Equivale a: " + consulta.consultaDeCambio("ARS", "USD") + " USD");
                        break;
                    case 2:
                        System.out.println("Equivale a: " + consulta.consultaDeCambio("ARS", "BOB") + " BOB");
                        break;
                    case 3:
                        System.out.println("Equivale a: " + consulta.consultaDeCambio("ARS", "BRL") + " BRL");
                        break;
                    case 4:
                        System.out.println("Equivale a: " + consulta.consultaDeCambio("BRL", "ARS") + " ARS");
                        break;
                    case 5:
                        System.out.println("Equivale a: " + consulta.consultaDeCambio("USD", "ARS") + " ARS");
                        break;
                    case 6:
                        System.out.println("Equivale a: " + consulta.consultaDeCambio("BOB", "ARS") + " ARS");
                        break;
                    case 7:
                        continuar = false;
                        System.out.println("Gracis por usar el conversor :)");
                        break;
                    default:
                        System.out.println("Por favor ingrese una opción válida");
                }
            } catch (InputMismatchException e){
                System.out.println("entrada no válida. Por favor ingrese un número.");
                lectura.next();
            }

        }
    }
}
