
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Metodos m = new Metodos();
        LinkedList<ObjEmpleado> lista = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        boolean continuar = true;
        int opt = 0;
        while (continuar) {
            System.out.println("escoja la opcion que requiere");
            System.out.println("1: Ingresar Registro");
            System.out.println("2: Mostrar Registros");
            System.out.println("3: Salir");
            opt = sc.nextInt();
            sc.nextLine();
            switch (opt) {
                case 1:
                    lista = m.IngresarRegistro(lista);
                    break;

                case 2:
                    m.MostrarLista(lista);
                    break;

                case 3:
                    continuar = false;
                    break;

                default:
                System.out.println("Opción incorrecta, intente de nuevo.");
                break;            }
        }
    }
}
