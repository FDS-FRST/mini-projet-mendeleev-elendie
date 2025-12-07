public class Joueur {

    //Attributs
    private String nom;
    private Personnage[] equipe;

    public Joueur(String nom, Personnage[] equipe) {
            this.nom = nom;
            this.equipe = equipe;
    }

    // Méthodes
    public Personnage choisirPersonnageVivant() {
        if (equipe[0].estVivant()) {
            return equipe[0];
        } else if (equipe[1].estVivant()) {
            return equipe[1];
        } else if (equipe[2].estVivant()) {
            return equipe[2];
        } else {
            return null; // aucun personnage vivant
        }
    }

    public boolean aEncoreDesPersonnagesVivants() {
        int vivant= 0;

        vivant+= equipe[0].estVivant() ? 1 : 0;
        vivant += equipe[1].estVivant() ? 1 : 0;
        vivant += equipe[2].estVivant() ? 1 : 0;

        // Si au moins un est vivant, vivants > 0
        return vivant > 0;
    }


    public void afficherEquipe() {
        System.out.println("Équipe de " + nom + " :");
        equipe[0].afficherEtat();
        equipe[1].afficherEtat();
        equipe[2].afficherEtat();
    }
}
