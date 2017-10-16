/**
 * @author marconte
 */

package com.mycompany.pokemon;

import java.util.Scanner;
import java.util.Random;
//import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
/*  
______________________________________________     
  Mes données
______________________________________________
*/
    @SuppressWarnings("resource")
	Scanner scan = new Scanner(System.in);
    Random generateNbr = new Random();
    int random;
    int idPokemon;
    Pokemon myPokemon;
    String myPokemonName;
    int myPokemonPV;
    Pokemon advPokemon;
    String advPokemonName;
    int advPokemonPv;

    // Je crée et configure des attaques
    Attack charge = new Attack("Charge", 5);
    Attack eclair = new Attack("Éclair", 10);
    Attack flameche = new Attack("Flammèche", 10);
    Attack pistoletaeau = new Attack("Pistolet à eau", 10);
    Attack tranchherbe = new Attack("Tranch'herbe", 10);
    // Je crée et remplis des tableaux d'attaques pour chaque pokemon
    Attack[] attacksPikachu = { charge, eclair };
    Attack[] attacksCarapuce = { charge, pistoletaeau };
    Attack[] attacksSalameche = { charge, flameche };
    Attack[] attacksBulbizarre = { charge, tranchherbe };
    // Je crée et configure des pokemons
    Pokemon pikachu = new Pokemon("Pikachu", 150, 5, "Electrique", attacksPikachu);
    Pokemon carapuce = new Pokemon("Carapuce", 150, 5, "Eau", attacksCarapuce);
    Pokemon salameche = new Pokemon("Salamèche", 150, 5, "Feu", attacksSalameche);
    Pokemon bulbizarre = new Pokemon("Bulbizarre", 150, 5, "Plante", attacksBulbizarre);
    // Je crée et remplis de pokemons
    Pokemon[] pokedex = { pikachu, carapuce, salameche, bulbizarre };

    /*  
    ______________________________________________     
    Je lance mon programme
    ______________________________________________
    */
    // STEP 1
    System.out.println("Hello there! Welcome to the world of POKEMON! My name is OAK!\n"
        + "People call me the POKEMON PROF!\n" + "First, what is your name?");
    // L'utilisateur entre son nom
    User myUser = new User(scan.next());

    // STEP 2
    do {
      System.out.println("Right! So your name is " + myUser.getName() + " !\n");
      System.out.println("Now, " + myUser.getName() + ",which POKEMON do you want?\n");
      // J'affiche mon pokedex
      System.out.println("-----------------------------");
      System.out.println("Name    " + "\t" + "Level" + "\t" + "PV");
      System.out.println("-----------------------------");
      for (int i = 0; i < pokedex.length; i++) {
        System.out.println("_____________________________");
        System.out
            .println((i + 1) + ". " + pokedex[i].getName() + " \t" + pokedex[i].level + "\t" + pokedex[i].getPv());
        System.out.println("-----------------------------");
        // J'affiche les attaques de chaque pokemon
        for (int j = 0; j < 2; j++) {
          System.out.println(pokedex[i].attacks[j].name + " " + pokedex[i].attacks[j].pv);
        }
      }
      // L'utilisateur choisis un pokemon
      idPokemon = (scan.nextInt() - 1);

      myPokemonName = pokedex[idPokemon].getName();
      myPokemonPV = pokedex[idPokemon].getPv();
      myPokemon = pokedex[idPokemon];
      // Confirmation
      System.out.println("So! You want the " + myPokemonName + " ?");
    } while (scan.next().equals("n"));

    // STEP 3
    // Je crée un adversaire random parmis les pokemons du pokedex en excluant celui que j'ai choisis
    do {
      random = generateNbr.nextInt(pokedex.length);
    } while (random == idPokemon);

    advPokemonName = pokedex[random].getName();
    advPokemonPv = pokedex[random].getPv();
    advPokemon = pokedex[random];

    System.out.println("Great ! Are you ready for your first battle ?");
    System.out.println(advPokemonName + " wants to fight !");
    // J'affiche le nom et les pv des pokemon au combat
  do {  System.out.println("\t\t" + advPokemonName + " " + advPokemonPv);
    System.out.println("_____________________________");
    System.out.println(myPokemonName + " " + myPokemonPV);
    System.out.println("-----------------------------");
    for (int j = 0; j < 2; j++) {
      System.out.println((j + 1) + ". " + myPokemon.attacks[j].name + " " + myPokemon.attacks[j].pv);
    }
    // J'attaque
    System.out.println("Wich attack do you choose ?");
    int attackId = (scan.nextInt() - 1);
    System.out.println(myPokemonName + " throws " + myPokemon.attacks[attackId].name + " !");
    advPokemonPv = myPokemon.attacks[attackId].toAttack(advPokemonPv);
    // Pokemon adversaire attaque
    random = generateNbr.nextInt(advPokemon.attacks.length);
    System.out.println(advPokemonName + " throws " + advPokemon.attacks[random].name + " !");
    myPokemonPV = advPokemon.attacks[random].toAttack(myPokemonPV);

  } while(advPokemonPv > 0 && myPokemonPV > 0);
  // Resultats du combat
  System.out.println("\t\t" + advPokemonName + " " + advPokemonPv);
  System.out.println("_____________________________");
  System.out.println(myPokemonName + " " + myPokemonPV);
  if(advPokemonPv == 0){
    System.out.println("You won !");
  } else if (myPokemonPV == 0) {
    System.out.println("You loose ...");
  }
  }
}
