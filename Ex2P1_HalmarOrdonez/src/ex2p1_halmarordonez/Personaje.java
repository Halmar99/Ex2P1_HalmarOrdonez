package ex2p1_halmarordonez;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Personaje {

    static Random rng = new Random();
    static Scanner read = new Scanner(System.in);

    String nombre;
    int hp, mp, attack, defense;

    public Personaje(String nombre, int hp, int mp, int attack, int defense) {
        this.nombre = nombre;
        this.hp = hp;
        this.mp = mp;
        this.attack = attack;
        this.defense = defense;
    }

}

class Item {

    String nombre;
    int hpPoints, mpPoints;

    public Item(String nombre, int hpPoints, int mpPoints) {
        this.nombre = nombre;
        this.hpPoints = hpPoints;
        this.mpPoints = mpPoints;
    }
}

class Print {

    ArrayList<Personaje> party;
    ArrayList<Personaje> reservas;
    ArrayList<Item> mochila;

    public Print(ArrayList<Personaje> party, ArrayList<Personaje> reservas, ArrayList<Item> mochila) {
        this.party = party;
        this.reservas = reservas;
        this.mochila = mochila;
    }


    public void usarItem(Personaje party, Item i) {
        party.hp += i.hpPoints;
        party.mp += i.mpPoints;
        
        
    }

    public void cambiarPersonaje(Personaje partytogo, Personaje partytocont) {
        party.remove(partytogo);
        reservas.add(partytogo);
        party.add(partytocont);
        reservas.remove(partytocont);

    }

}
