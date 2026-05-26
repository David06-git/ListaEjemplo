
import java.util.LinkedList;
import java.util.Scanner;

public class Metodos {
    Scanner sc = new Scanner(System.in);

    //VALIDACIONES

    public String validarLetras(String mensaje){
        System.out.println(mensaje);
        String dato = sc.nextLine();
        if (dato.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
            return dato;
        }

        System.out.println("ERROR. Solo letras.");
        return validarLetras(mensaje);
    }

    public double validarSalario(String mensaje) {
        System.out.print(mensaje);
        
        if (sc.hasNextDouble()) {
            double salario = sc.nextDouble();
            sc.nextLine(); 

            if (salario >= 0) {
                return salario; 
            } else {
                System.out.println("ERROR. El salario no puede ser negativo.");
            }
        } else {
            System.out.println("ERROR. Solo se permiten números.");
            sc.next(); 
            sc.nextLine(); 
        }

        return validarSalario(mensaje);
    } 
    
    public LinkedList<ObjEmpleado> IngresarRegistro (LinkedList<ObjEmpleado> lista){
        boolean continuar = true;
        int opt = 0;
        while (continuar) {
            ObjEmpleado o = new ObjEmpleado();
            o.setNombre(validarLetras("ingrese su nombre: "));
            o.setSalario(validarSalario("ingrese su salario: "));
            lista.add(o);
            System.out.println("desea seguir ingresando datos. 1)Si  2)No ");
            opt = sc.nextInt();
            sc.nextLine();
            if (opt == 2) {
                continuar = false;
            }
        } 
        return lista;
    }

    public String Aumentos(ObjEmpleado e){
        Scanner sc = new Scanner(System.in);
        double valorExtras = 0.0;
        System.out.println("El empleado " + e.getNombre() + " realizo horas extras? 1)Si  2)No");
        int opt = sc.nextInt();

        if (opt == 1) {
            boolean seguir = true;
            
            while (seguir) {
                System.out.println("--- SELECCIONE EL TIPO DE HORA EXTRA ---");
                System.out.println("1: Horas extras diurnas (Valor: 8.25)");
                System.out.println("2: Horas extras nocturnas (Valor: 0.35)");
                System.out.println("3: Horas extras diurnas festivas (Valor: 1.25)");
                System.out.println("4: Horas extras nocturnas festivas (Valor: 1.75)");
                System.out.println("5: Terminar el registrar");
                int tipo = sc.nextInt();
                
                if (tipo >=1 && tipo <=4) {
                    System.out.print("¿Cuántas horas de este tipo realizó?: ");
                    int cantidadHoras = sc.nextInt();

                    switch (tipo) {
                        case 1:
                            valorExtras += (cantidadHoras * 8.25);
                            break;
                        case 2:
                            valorExtras += (cantidadHoras * 0.35);
                            break;
                        case 3:
                            valorExtras += (cantidadHoras * 1.25);
                            break;
                        case 4:
                            valorExtras += (cantidadHoras * 1.75);
                            break;
                    }
                    System.out.println("¡Horas registradas y sumadas al acumulado!");
                } else if (tipo == 5) {
                    seguir = false;
                } else {
                    System.out.println("opcion invalida, intente de nuevo");
                }
            }
        }

        double salarioInicial = e.getSalario() + valorExtras;
        double porcentaje = 0.0;

        if (salarioInicial > 2500000 && salarioInicial < 3000000) {
            porcentaje = 0.09;
        } else if (salarioInicial >= 3000000 && salarioInicial < 4500000) {
            porcentaje = 0.085;
        } else if (salarioInicial >= 4500000 && salarioInicial < 5000000) {
            porcentaje = 0.06;
        } else if (salarioInicial > 5000000) {
            porcentaje = 0.04;
        }

        double aumento = salarioInicial * porcentaje;
        double salarioNeto = salarioInicial + aumento;

        String reporte = "Empleado: " + e.getNombre() + "\n" +
                         " -> Salario Base: $" + e.getSalario() + "\n" +
                         " -> Valor Total Horas Extras: $" + valorExtras + "\n" +
                         " -> Salario Neto Inicial: $" + salarioInicial + "\n" +
                         " -> Aumento Aplicado (" + (porcentaje * 100) + "%): $" + aumento + "\n" +
                         " -> SALARIO NETO: $" + salarioNeto + "\n" +
                         "-------------------------------------------";
        return reporte;
    }

    public void MostrarLista(LinkedList<ObjEmpleado> lista){
        if (lista.isEmpty()) {
            System.out.println("La lista está vacía. No hay registros para mostrar.");
            return;
        }

        System.out.println("-----------REPORTE GENERAL-----------");

        for (ObjEmpleado e: lista) {
            String resultado = Aumentos(e);
            System.out.println(resultado);
        }
    }
}
