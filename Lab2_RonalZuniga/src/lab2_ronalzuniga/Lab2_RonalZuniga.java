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
            System.out.println("8. Listar casos pendientes");
            System.out.println("9. Listar casos resueltos");
            System.out.println("10. Salir");
            System.out.println("");
            System.out.print("Ingrese la opcion que desea realizar: ");
            op = sc.nextInt();
            while (op <= 0 || op > 10) {
                System.out.println("Opcion no válida, intente de nuevo");
                System.out.print("Ingrese la opcion que desea realizar: ");
                op = sc.nextInt();
            }

            if (op == 1) {
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
                System.out.print("Ingrese el nivel del detective: ");
                nivel = sc.nextInt();
                det.add(new Detective(nombre, edad, nacionalidad, laborales, nivel));
                System.out.println("Detective agregado con éxito");
                System.out.println("");
            }//fin opcion 1

            if (op == 2) {
                System.out.println("");
                imprimirD(det);
                System.out.print("Ingrese la posicion del detective a eliminar: ");
                int p = sc.nextInt();
                if (p < 0 || p >= det.size()) {
                    System.out.println("Posición inválida, no se ha eliminado ningún detective");
                } else {
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
                        det.remove(p);
                        System.out.println("Se ha eliminado el detective y se han reasignado sus casos");
                        System.out.println("");
                    }//fin opcion 2

                    if (op == 3) {

                    }
                }
            }//fin while opcion

        }//fin del main

    

    public static void imprimirD(ArrayList<Detective> d) {//imprime los detectives
        for (int i = 0; i < d.size(); i++) {
            System.out.println(i + "- " + d.get(i));
        }
    }

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
    }

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
    }

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
    }

}//fin de la clase
