import java.util.Scanner;

public class Joueur {

    //Attributs
    private String nom;
    private Personnage[] equipe;

    public Joueur(String nom, Personnage[] equipe) {
            this.nom = nom;
            this.equipe = equipe;
    }

    // Méthodes
    // Est-ce qu`on ne pourrait pas utiliser une boucle ?
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

    public String getNom() {
        return this.nom;
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


    public void affichageDesPersonnages()
    {
        System.out.println(this.nom +" voici la liste de vos personnages vivants :"  );
        for (int i =0;i<equipe.length;i++)
        {
            if(equipe[i].estVivant())
            {
                System.out.println((i+1)+" - "+ equipe[i].getNom()); //Afficher uniquement les noms des personnages vivants

            }

        }

    }



    //Cette methode permet d`obtenir un personnage dans l`equipe du joueur en utilisant
    // le numero entre par le joueur

    public Personnage obtenirPersonnage(int num)
    {
        if(num>equipe.length){
            System.out.println("Mauvais choix");
        }
        return equipe[num-1];
    }



}
