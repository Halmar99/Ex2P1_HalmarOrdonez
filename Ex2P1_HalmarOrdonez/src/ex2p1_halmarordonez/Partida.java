package ex2p1_halmarordonez;

import java.util.ArrayList;

public class Partida {

    public static Personaje psj;

    public static void printparty(ArrayList<Personaje> party) {
        for (Personaje i : party) {
            System.out.println(i.nombre + ": Hp=" + i.hp + " Mp=" + i.mp + " Atk=" + i.attack + " Def=" + i.defense);
        }
    }

    public static void printmochila(ArrayList<Item> mochila) {
        for (Item i : mochila) {
            System.out.println(i.nombre + ": HP=" + i.hpPoints + ", MP=" + i.mpPoints);
        }
    }

    public static void printname(Personaje p1) {
        System.out.print(p1.nombre);
    }
}
