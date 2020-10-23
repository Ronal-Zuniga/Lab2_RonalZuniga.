package lab2_ronalzuniga;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Lab2_RonalZuniga {

    public static void main(String[] args) {
        ArrayList<Detective> det = new ArrayList();
        ArrayList<Casos> casos = new ArrayList();
        Scanner sc = new Scanner(System.in);
        int op = 0;
        while (op != 10) {
            System.out.println("");
            System.out.println("----MENU----");
            System.out.println("1. Agregar detectives");
            System.out.println("2. Eliminar detectives");
            System.out.println("3. Modificar detectives");
            System.out.println("4. Listar detectives");
            System.out.println("5. Registar casos");
            System.out.println("6. Modificar casos");
            System.out.println("7. Listar casos");
            System.out.println("8. Listar casos resueltos");
            System.out.println("9. Listar casos pendientes");
            System.out.println("10. Salir");
            System.out.println("");
            System.out.print("Ingrese la opcion que desea realizar: ");
            op = sc.nextInt();
            while (op <= 0 || op > 10) {
                System.out.println("Opcion no válida, intente de nuevo");
                System.out.print("Ingrese la opcion que desea realizar: ");
                op = sc.nextInt();
            }

            if (op == 1) {//opcion agregar detectives
                String nombre, nacionalidad;
                int edad, laborales, nivel;
                System.out.println("");
                System.out.println("AGREGAR DETECTIVE");
                System.out.print("Ingrese el nombre del detective: ");
                nombre = sc.next();
                System.out.print("Ingrese la edad del detective: ");
                edad = sc.nextInt();
                System.out.print("Ingrese la nacionalidad del detective: ");
                nacionalidad = sc.next();
                System.out.print("Ingrese los años que ha laborado el detective: ");
                laborales = sc.nextInt();
                while (laborales < 0) {
                    System.out.println("Ingrese años laborales mayores o iguales a 0");
                    System.out.print("Ingrese los años que ha laborado el detective: ");
                    laborales = sc.nextInt();
                }
                System.out.print("Ingrese el nivel del detective: ");
                nivel = sc.nextInt();
                while (nivel <= 0 || nivel > 10) {
                    System.out.println("Nivel fuera de rango, intente de nuevo ingresando un numero entre (1-10)");
                    System.out.print("Ingrese el nivel del detective: ");
                    nivel = sc.nextInt();
                }
                det.add(new Detective(nombre, edad, nacionalidad, laborales, nivel));
                System.out.println("Detective agregado con éxito");
                System.out.println("");
            }//fin opcion 1

            if (op == 2) {//opcion eliminar detectives
                System.out.println("");
                System.out.println("ELIMINAR DETECTIVE");
                imprimirD(det);
                System.out.print("Ingrese la posicion del detective a eliminar: ");
                int p = sc.nextInt();
                if (p < 0 || p >= det.size()) {
                    System.out.println("Posición inválida, no se ha eliminado ningún detective");
                } else {
                    if (det.size() == 1) {//si solo hay un detective se eliminan los casos
                        String d = det.get(p).getNombre();
                        for (int i = 0; i < casos.size(); i++) {
                            if (casos.get(i).getDetective().equals(d)) {
                                casos.remove(i);
                            }//fin if externo
                        }//fin del for
                        det.remove(p);
                    } else {//si hay mas de un detective reasigna los casos
                        String d = det.get(p).getNombre();
                        String mayor = Dmayornivel(det);
                        String segundo = Dsegundonivel(det);
                        String ultimo = Dbajonivel(det);
                        for (int i = 0; i < casos.size(); i++) {
                            if (casos.get(i).getDetective().equals(d)) {
                                if (casos.get(i).getTipo().equals("Homicidio")) {
                                    casos.get(i).setDetective(mayor);
                                }
                                if (casos.get(i).getTipo().equals("Secuestro")) {
                                    casos.get(i).setDetective(segundo);
                                }
                                if (casos.get(i).getTipo().equals("Robo")) {
                                    casos.get(i).setDetective(ultimo);
                                }
                            }//fin if externo
                        }//fin del for
                        det.remove(p);//elimina el detective
                        System.out.println("Se ha eliminado el detective y se han reasignado sus casos");
                        System.out.println("");
                    }//fin else
                }//fin decision anidada
            }//fin opcion2

            if (op == 3) {//opcion modificar detectives 
                System.out.println("");
                int o = 0;
                while (o != 6) {
                    System.out.println("----MODIFICAR DETECTIVES----");
                    System.out.println("1. Modificar Nombre");
                    System.out.println("2. Modificar Edad");
                    System.out.println("3, Modificar Nacionalidad");
                    System.out.println("4. Modificar años laborales");
                    System.out.println("5. Modificar nivel");
                    System.out.println("6. Regresar al menu principal");
                    System.out.print("¿Qué desea modificar?: ");
                    o = sc.nextInt();
                    while (o < 0 || o > 6) {
                        System.out.println("Opcion inválida, intente de nuevo");
                        System.out.print("¿Qué desea modificar?: ");
                        o = sc.nextInt();
                    }
                    if (o != 6) {
                        System.out.println("");
                        imprimirD(det);
                        System.out.print("Ingrese la posicion del detective a modificar: ");
                        int p = sc.nextInt();
                        if (p < 0 || p >= det.size()) {
                            System.out.println("Posicion fuera de rango");
                            o = 6;
                        } else {
                            switch (o) {
                                case 1:
                                    System.out.println("");
                                    String nombre;
                                    System.out.print("Ingrese el nombre del detective: ");
                                    nombre = sc.next();
                                    det.get(p).setNombre(nombre);
                                    System.out.println("Nombre modificado con éxito");
                                    System.out.println("");
                                    break;

                                case 2:
                                    System.out.println("");
                                    int edad;
                                    System.out.print("Ingrese la edad del detective: ");
                                    edad = sc.nextInt();
                                    det.get(p).setEdad(edad);
                                    System.out.println("Edad modificada con éxito");
                                    System.out.println("");
                                    break;

                                case 3:
                                    System.out.println("");
                                    String nacionalidad;
                                    System.out.print("Ingrese la nacionalidad del detective: ");
                                    nacionalidad = sc.next();
                                    det.get(p).setNacionalidad(nacionalidad);
                                    System.out.println("Nacionalidad modificada con éxito");
                                    System.out.println("");
                                    break;

                                case 4:
                                    System.out.println("");
                                    int laborales;
                                    System.out.print("Ingrese los años que ha laborado el detective: ");
                                    laborales = sc.nextInt();
                                    while (laborales < 0) {
                                        System.out.println("Ingrese años laborales mayores o iguales a 0");
                                        System.out.print("Ingrese los años que ha laborado el detective: ");
                                        laborales = sc.nextInt();
                                    }
                                    det.get(p).setLaborales(laborales);
                                    System.out.println("Años laborales modificados con éxito");
                                    System.out.println("");
                                    break;

                                case 5:
                                    System.out.println("");
                                    int nivel;
                                    System.out.print("Ingrese el nivel del detective: ");
                                    nivel = sc.nextInt();
                                    while (nivel <= 0 || nivel > 10) {
                                        System.out.println("Nivel fuera de rango, intente de nuevo ingresando un numero entre (1-10)");
                                        System.out.print("Ingrese el nivel del detective: ");
                                        nivel = sc.nextInt();
                                    }
                                    det.get(p).setNivel(nivel);
                                    System.out.println("Nivel modificado con éxito");
                                    System.out.println("");
                                    break;
                            }//fin del switch
                        }//fin decision anidada
                    }//fin decision

                }//fin while
            }//fin opcion3

            if (op == 4) {//opcion listar detectives
                System.out.println("");
                System.out.println("LISTADO DE DETECTIVES");
                System.out.println("");
                imprimirD(det);
                System.out.println("");
            }//fin opcion 4

            if (op == 5) {//opcion agregar casos
                System.out.println("");
                System.out.println("REGISTRAR CASOS");
                String lugar, descripcion, tipo = "", detective, estado = "";
                int t, e, p;
                System.out.print("Ingrese el lugar del caso: ");
                lugar = sc.next();
                System.out.print("Ingrese la descripción del caso: ");
                descripcion = sc.next();
                System.out.println("1. Homicidio\n"
                        + "2. Robo\n"
                        + "3. Secuestro");
                System.out.print("Seleccione el tipo de caso: ");
                t = sc.nextInt();
                while (t <= 0 || t > 3) {
                    System.out.println("Tipo inválido, intente de nuevo");
                    System.out.println("1. Homicidio\n"
                            + "2. Robo\n"
                            + "3. Secuestro");
                    System.out.print("Seleccione el tipo de caso: ");
                    t = sc.nextInt();
                }//fin while validacion de tipo
                switch (t) {
                    case 1:
                        tipo = "Homicidio";
                        break;

                    case 2:
                        tipo = "Robo";
                        break;

                    case 3:
                        tipo = "Secuestro";
                        break;
                }//fin switch
                imprimirD(det);
                System.out.print("Ingrese la posicion del detective a cargo del caso: ");
                p = sc.nextInt();
                while (p < 0 || p >= det.size()) {
                    System.out.println("Posicion del detective fuera de rango, intente de nuevo");
                    System.out.print("Ingrese la posicion del detective a cargo del caso: ");
                    p = sc.nextInt();
                }//fin while validacion de detective
                detective = det.get(p).getNombre();
                System.out.println("1. Pendiente\n"
                        + "2. Resuelto");
                System.out.print("Seleccione el estado del caso: ");
                e = sc.nextInt();
                while (e <= 0 || e > 2) {
                    System.out.println("Tipo inválido, intente de nuevo");
                    System.out.println("1. Pendiente\n"
                            + "2. Resuelto");
                    System.out.print("Seleccione el estado del caso: ");;
                    e = sc.nextInt();
                }//fin while validacion de estado
                switch (e) {
                    case 1:
                        estado = "Pendiente";
                        break;

                    case 2:
                        estado = "Resuelto";
                        break;
                }//fin switch
                casos.add(new Casos(lugar, descripcion, tipo, detective, estado));
                System.out.println("Caso registrado correctamente");
                System.out.println("");
            }//fin opcion 5

            if (op == 6) {//opcion modificar casos
                System.out.println("");
                int o = 0;
                while (o != 6) {
                    System.out.println("----MODIFICAR CASOS----");
                    System.out.println("1. Modificar Lugar");
                    System.out.println("2. Modificar Descripcion");
                    System.out.println("3, Modificar Tipo");
                    System.out.println("4. Modificar Detective");
                    System.out.println("5. Modificar Estado");
                    System.out.println("6. Regresar al menu principal");
                    System.out.print("¿Qué desea modificar?: ");
                    o = sc.nextInt();
                    while (o < 0 || o > 6) {
                        System.out.println("Opcion inválida, intente de nuevo");
                        System.out.print("¿Qué desea modificar?: ");
                        o = sc.nextInt();
                    }
                    System.out.println("");
                    if (o != 6) {
                        imprimirC(casos);
                        System.out.print("Ingrese la posicion del caso a modificar: ");
                        int p = sc.nextInt();
                        if (p < 0 || p >= casos.size()) {
                            System.out.println("Posicion fuera de rango");
                            o = 6;

                        } else {
                            switch (o) {
                                case 1:
                                    System.out.println("");
                                    String lugar;
                                    System.out.print("Ingrese el lugar del caso: ");
                                    lugar = sc.next();
                                    casos.get(p).setLugar(lugar);
                                    System.out.println("Lugar modificado con éxito");
                                    System.out.println("");
                                    break;

                                case 2:
                                    System.out.println("");
                                    String descripcion;
                                    System.out.print("Ingrese la descripción del caso: ");
                                    descripcion = sc.next();
                                    casos.get(p).setDescripcion(descripcion);
                                    System.out.println("Descripcion modificada con éxito");
                                    System.out.println("");
                                    break;

                                case 3:
                                    System.out.println("");
                                    int t;
                                    String tipo = "";
                                    System.out.println("1. Homicidio\n"
                                            + "2. Robo\n"
                                            + "3. Secuestro");
                                    System.out.print("Seleccione el tipo de caso: ");
                                    t = sc.nextInt();
                                    while (t <= 0 || t > 3) {
                                        System.out.println("Tipo inválido, intente de nuevo");
                                        System.out.println("1. Homicidio\n"
                                                + "2. Robo\n"
                                                + "3. Secuestro");
                                        System.out.print("Seleccione el tipo de caso: ");
                                        t = sc.nextInt();
                                    }//fin while validacion de tipo
                                    switch (t) {
                                        case 1:
                                            tipo = "Homicidio";
                                            break;

                                        case 2:
                                            tipo = "Robo";
                                            break;

                                        case 3:
                                            tipo = "Secuestro";
                                            break;
                                    }//fin switch
                                    casos.get(p).setTipo(tipo);
                                    System.out.println("Tipo modificado con éxito");
                                    System.out.println("");
                                    break;

                                case 4:
                                    int pos;
                                    String detective;
                                    System.out.println("");
                                    imprimirD(det);
                                    System.out.print("Ingrese la posicion del detective a cargo del caso: ");
                                    pos = sc.nextInt();
                                    while (pos < 0 || pos >= det.size()) {
                                        System.out.println("Posicion del detective fuera de rango, intente de nuevo");
                                        System.out.print("Ingrese la posicion del detective a cargo del caso: ");
                                        pos = sc.nextInt();
                                    }//fin while validacion de detective
                                    detective = det.get(pos).getNombre();
                                    casos.get(p).setDetective(detective);
                                    System.out.println("Detective modificado con éxito");
                                    System.out.println("");
                                    break;

                                case 5:
                                    System.out.println("");
                                    int e;
                                    String estado = "";
                                    System.out.println("1. Pendiente\n"
                                            + "2. Resuelto");
                                    System.out.print("Seleccione el estado del caso: ");
                                    e = sc.nextInt();
                                    while (e <= 0 || e > 2) {
                                        System.out.println("Tipo inválido, intente de nuevo");
                                        System.out.println("1. Pendiente\n"
                                                + "2. Resuelto");
                                        System.out.print("Seleccione el estado del caso: ");;
                                        e = sc.nextInt();
                                    }//fin while validacion de estado
                                    switch (e) {
                                        case 1:
                                            estado = "Pendiente";
                                            break;

                                        case 2:
                                            estado = "Resuelto";
                                            break;
                                    }//fin switch
                                    casos.get(p).setEstado(estado);
                                    System.out.println("Estado modificado con éxito");
                                    System.out.println("");
                                    break;
                            }//fin del switch
                        }//fin decision anidada
                    }//fin decision
                }//fin while
            }//fin opcion 6

            if (op == 7) {//opcion listar todos los casos
                System.out.println("");
                System.out.println("LISTADO DE CASOS");
                System.out.println("");
                imprimirC(casos);
                System.out.println("");
            }//fin opcion 7

            if (op == 8) {//opcion listar casos resueltos
                System.out.println("");
                System.out.println("LISTADO DE CASOS RESUELTOS");
                System.out.println("");
                imprimirCR(casos);
                System.out.println("");
            }//fin opcion 8

            if (op == 9) {//opcion listar casos pendientes
                System.out.println("");
                System.out.println("LISTADO DE CASOS PENDIENTES");
                System.out.println("");
                imprimirCP(casos);
                System.out.println("");
            }//fin opcion 9

        }//fin while opcion

    }//fin del main

    public static void imprimirD(ArrayList<Detective> d) {//imprime los detectives
        for (int i = 0; i < d.size(); i++) {
            System.out.println(i + "- " + d.get(i));
        }
    }//fin metodo imprimir detectives

    public static String Dmayornivel(ArrayList<Detective> d) {//metodo para sacar el detective de mayor nivel
        String mayor = "";
        int m = 0;
        for (int i = 0; i < d.size(); i++) {
            if (d.get(i).getNivel() > m) {
                m = d.get(i).getNivel();
                mayor = d.get(i).getNombre();
            }
        }
        return mayor;
    }//fin metodo detective de mayor nivel

    public static String Dsegundonivel(ArrayList<Detective> d) {//metodo para sacar el detective de segundo mayor nivel
        Integer[] a = null;
        String segundo = "";
        int aux = 0;
        for (int i = 0; i < d.size(); i++) {
            a[aux] = d.get(i).getNivel();
            aux++;
        }
        Arrays.sort(a, Collections.reverseOrder());
        int x = a[1];
        for (int i = 0; i < d.size(); i++) {
            if (d.get(i).getNivel() == x) {
                segundo = d.get(i).getNombre();
            }
        }
        return segundo;
    }//fin metodo detective de segundo mayor nivel

    public static String Dbajonivel(ArrayList<Detective> d) {//metodo para sacar el detective de menor nivel
        int[] a = null;
        String ultimo = "";
        int aux = 0;
        for (int i = 0; i < d.size(); i++) {
            a[aux] = d.get(i).getNivel();
            aux++;
        }
        Arrays.sort(a);
        int x = a[0];
        for (int i = 0; i < d.size(); i++) {
            if (d.get(i).getNivel() == x) {
                ultimo = d.get(i).getNombre();
            }
        }
        return ultimo;
    }//fin metodo detective de menor nivel

    public static void imprimirC(ArrayList<Casos> c) {//imprime los casos en orden
        int aux = 0;
        for (int i = 0; i < c.size(); i++) {
            if (c.get(i).getTipo().equals("Homicidio")) {
                System.out.println(aux + "- " + c.get(i));
                aux++;
            }
        }
        for (int i = 0; i < c.size(); i++) {
            if (c.get(i).getTipo().equals("Secuestro")) {
                System.out.println(aux + "- " + c.get(i));
                aux++;
            }
        }
        for (int i = 0; i < c.size(); i++) {
            if (c.get(i).getTipo().equals("Robo")) {
                System.out.println(aux + "- " + c.get(i));
                aux++;
            }
        }
    }//fin del metodo imprimir todos los casos

    public static void imprimirCR(ArrayList<Casos> c) {//imprime los casos resueltos en orden
        int aux = 0;
        for (int i = 0; i < c.size(); i++) {
            if (c.get(i).getEstado().equals("Resuelto")) {
                if (c.get(i).getTipo().equals("Homicidio")) {
                    System.out.println(aux + "- " + c.get(i));
                    aux++;
                }
            }
        }
        for (int i = 0; i < c.size(); i++) {
            if (c.get(i).getEstado().equals("Resuelto")) {
                if (c.get(i).getTipo().equals("Secuestro")) {
                    System.out.println(aux + "- " + c.get(i));
                    aux++;
                }
            }
        }
        for (int i = 0; i < c.size(); i++) {
            if (c.get(i).getEstado().equals("Resuelto")) {
                if (c.get(i).getTipo().equals("Robo")) {
                    System.out.println(aux + "- " + c.get(i));
                    aux++;
                }
            }
        }
    }//fin del metodo imprimir todos los casos resueltos

    public static void imprimirCP(ArrayList<Casos> c) {//imprime los casos pendientes en orden
        int aux = 0;
        for (int i = 0; i < c.size(); i++) {
            if (c.get(i).getEstado().equals("Pendiente")) {
                if (c.get(i).getTipo().equals("Homicidio")) {
                    System.out.println(aux + "- " + c.get(i));
                    aux++;
                }
            }
        }
        for (int i = 0; i < c.size(); i++) {
            if (c.get(i).getEstado().equals("Pendiente")) {
                if (c.get(i).getTipo().equals("Secuestro")) {
                    System.out.println(aux + "- " + c.get(i));
                    aux++;
                }
            }
        }
        for (int i = 0; i < c.size(); i++) {
            if (c.get(i).getEstado().equals("Pendiente")) {
                if (c.get(i).getTipo().equals("Robo")) {
                    System.out.println(aux + "- " + c.get(i));
                    aux++;
                }
            }
        }
    }//fin del metodo imprimir todos los casos pendientes

}//fin de la clase
