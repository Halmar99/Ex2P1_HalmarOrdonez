//Fila 1, Silla 7
package ex2p1_halmarordonez;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Ex2P1_HalmarOrdonez {

    static Scanner read = new Scanner(System.in);
    static Random rng = new Random();

    static Partida part = new Partida();
    static Personaje gp;
    static Print print;

    public static void main(String[] args) {
        Personaje sora = new Personaje("Sora", 300, 300, 75, 15);
        Personaje donald = new Personaje("Donald", 150, 450, 45, 10);
        Personaje goofy = new Personaje("Goofy", 450, 100, 150, 50);
        Personaje mickey = new Personaje("Mickey", 100, 500, 150, 35);
        Personaje roxas = new Personaje("Roxas", 300, 300, 15, 75);
        Personaje kairi = new Personaje("Kairi", 200, 200, 50, 15);

        Item pocion = new Item("Pocion", 50, 0);
        Item ether = new Item("Ether", 0, 50);
        Item elixir = new Item("Elixir", 100, 100);

        ArrayList<Personaje> mainparty = new ArrayList<>();
        mainparty.add(sora);
        mainparty.add(donald);
        mainparty.add(goofy);

        ArrayList<Personaje> reservas = new ArrayList<>();
        reservas.add(mickey);
        reservas.add(roxas);
        reservas.add(kairi);

        ArrayList<Item> mochila = new ArrayList<>();
        mochila.add(pocion);
        mochila.add(ether);
        mochila.add(elixir);

        Print equipo = new Print(mainparty, reservas, mochila);

        System.out.println("♡Kingdom Hearts♡");
        System.out.println("Re-Re:Coded");
        System.out.print("Ingresa cualquier tecla para continuar: ");
        read.nextLine();

        for (int i = 1; i <= 20 && !equipo.party.isEmpty(); i++) {
            System.out.println("-----Estas en el cuarto " + i + "-----\n");
            int cuarto = rng.nextInt(5) + 1;
            switch (cuarto) {
                case 1 -> {
                    int hl = rng.nextInt(3) + 1;
                    System.out.println("Te has encontrado a " + hl + " Heartless!!!");
                    //A falta de tiempo tuve que quitar el while para que continuara el programa
                    //while (hl > 0 && !equipo.party.isEmpty()) {
                    Partida.printparty(mainparty);
                    System.out.println("Elije un personaje");
                    int elec = read.nextInt();
                    Personaje p1 = mainparty.get(elec);

                    System.out.println("Menu:\n1.Attack\n2.Magic\n3.Items\n4.Party");
                    int elec2 = read.nextInt();
                    switch (elec2) {
                        case 1 -> {
                            Partida.printname(p1);
                            System.out.println(" ataco!");
                        }
                        case 2 -> {

                        }
                        case 3 -> {

                        }
                        case 4 -> {
                            System.out.println("Personajes en reserva:");
                            for (Personaje reserva : equipo.reservas) {
                                System.out.println(reserva.nombre);
                            }
                            System.out.print("Elige a quién cambiar: ");
                            int personajeACambiar = read.nextInt();
                            for (Personaje reserva : equipo.reservas) {
                                Personaje personajeAPasar = equipo.party.get(personajeACambiar);
                                equipo.cambiarPersonaje(personajeAPasar, reserva);
                                break;
                            }
                        }
                        default -> {
                            System.out.println("Opcion invalida");
                        }
                    }
                    //}
                }
                case 2 -> {
                    System.out.println("Te has encontrado un cofre que contiene una Pocion!!!");
                    mochila.add(pocion);
                }

                case 3 -> {
                    System.out.println("Te has encontrado un cofre que contiene una Ether!!!");
                    mochila.add(ether);
                }
                case 4 -> {
                    System.out.println("Te has encontrado un cofre que contiene un Elixir!!!");
                    mochila.add(elixir);
                }
                case 5 -> {
                    System.out.print("Te has encontrado a unos amigos que ocupan de tu ayuda y decides darles ");
                    int cantrem = rng.nextInt((tamlist(mochila) - 1) + 1) + 1;
                    System.out.println(cantrem + " items!!!");
                    for (int j = 0; j < cantrem; j++) {
                        int rem = rng.nextInt(tamlist(mochila));
                        mochila.remove(rem);
                    }
                    System.out.println("Quedan:");
                    Partida.printmochila(mochila);

                }
            }
            System.out.println("Ingrese algo para continuar: ");
            read.nextLine();
        }
        System.out.println("FELICIDADES!!!!!!!!!!\nHa completado el juego");
    }

    public static int tamlist(ArrayList<Item> mochila) {
        return mochila.size();
    }

}
