package models;

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

        for (int i =0; i<equipe.length;i++)
        {
            if(equipe[i].estVivant())
            {
                return equipe[i];
            }

        }
        return null;


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
        for (int i =0; i < equipe.length;i++)
        {
           equipe[i].afficherEtat();

        }
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
        if(num>equipe.length || num<=0){
            System.out.println("Mauvais choix");
        }
        return equipe[num-1];
    }


}
