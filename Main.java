public class Main {
    public static void main(String[] args) {

        System.out.println("Création d'un personnage...");

        // Test de deux objets Personnages
        Personnage p1 = new Personnage("Guerrier", 100, 20);
        Personnage p2 = new Personnage("Paul",20,14);
        // Affichage de leurs états
        p1.afficherEtat();
        p2.afficherEtat();
    }
}
