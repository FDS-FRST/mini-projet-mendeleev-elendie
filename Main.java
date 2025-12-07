
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Création d'un personnage...");

        // Test de trois objets Personnages
        Personnage p1 = new Personnage("Guerrier", 0, 120);
        Personnage p2 = new Personnage("Paul",5,14);
        Personnage p3 = new Personnage("Marie", 0, 12);
        // Affichage de leurs états
        p1.afficherEtat();
        p2.afficherEtat();
        p3.afficherEtat();

        //Creation du joueur
        System.out.print("Nom du joueur 1:");
        String nomJoueur = sc.nextLine();
        Joueur joueur = new Joueur(nomJoueur, new Personnage[]{p1, p2, p3});
        joueur.afficherEquipe();
        Personnage choisi = joueur.choisirPersonnageVivant();
        if (choisi != null) {
            System.out.println("Personnage choisi par le joueur :");
            choisi.afficherEtat();
        } else {
            System.out.println("Aucun personnage vivant à choisir.");
        }

        System.out.println("Le joueur a encore des personnages vivants ? " + joueur.aEncoreDesPersonnagesVivants());


    }
}
