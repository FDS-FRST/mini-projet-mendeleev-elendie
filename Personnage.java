public class Personnage {
    private String nom;
    private int vie;
    private int attaque;

    public Personnage(String nom,int vie,int attaque)
    {
        this.nom = nom;
        this.vie = vie;
        this.attaque = attaque;
    }

    public boolean estVivant()
    {
        return vie > 0;

    }

    public void afficherEtat()
    {
        System.out.println("Nom:" + this.nom + "  Vie restante: " + this.vie );
    }

    public void attaquer(Personnage cible)
    {
        cible.vie -= this.attaque;
        if(cible.vie < 0)
        {
            cible.vie = 0;
        }


    }

}
