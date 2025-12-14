import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Bienvenue dans le jeu de combat !");



        //  Création des joueurs


        System.out.print("\nNom du joueur 1 : ");
        String nomJoueur1 = input.nextLine();

        System.out.print("Nom du joueur 2 : ");
        String nomJoueur2 = input.nextLine();



        //  Création des personnages du Joueur 1


        System.out.println("\n " + nomJoueur1 +" cree ton equipe :");

        System.out.print("Nom du personnage 1 : ");
        String nom1 = input.nextLine();

        System.out.print("Nom du personnage 2 : ");
        String nom2 = input.nextLine();

        System.out.print("Nom du personnage 3 : ");
        String nom3 = input.nextLine();



        //  Création des personnages du Joueur 2


        System.out.println("\n " + nomJoueur2 +" cree ton equipe :");

        System.out.print("Nom du personnage 1 : ");
        String nom4 = input.nextLine();

        System.out.print("Nom du personnage 2 : ");
        String nom5 = input.nextLine();

        System.out.print("Nom du personnage 3 : ");
        String nom6 = input.nextLine();


        // =======================
        // Création des objets Personnage
        // =======================

        Personnage p1 = new Personnage(nom1, 100, 20);
        Personnage p2 = new Personnage(nom2, 100, 20);
        Personnage p3 = new Personnage(nom3, 100, 20);

        Personnage p4 = new Personnage(nom4, 100, 20);
        Personnage p5 = new Personnage(nom5, 100, 20);
        Personnage p6 = new Personnage(nom6, 100, 20);



        Joueur joueur1 = new Joueur(nomJoueur1, new Personnage[]{p1, p2, p3});
        Joueur joueur2 = new Joueur(nomJoueur2, new Personnage[]{p4, p5, p6});



        System.out.println("\n--- Équipe de " + joueur1.getNom() + " ---");
        joueur1.afficherEquipe();

        System.out.println("\n--- Équipe de " + joueur2.getNom() + " ---");
        joueur2.afficherEquipe();




//        System.out.println("\n" + joueur1.getNom() + ", choisissez un personnage vivant :");
//        Personnage choisi1 = joueur1.choisirPersonnageVivant();
//        if (choisi1 != null) {
//            System.out.println("Personnage choisi :");
//            choisi1.afficherEtat();
//        }
//
//        System.out.println("\n" + joueur2.getNom() + ", choisissez un personnage vivant :");
//        Personnage choisi2 = joueur2.choisirPersonnageVivant();
//        if (choisi2 != null) {
//            System.out.println("Personnage choisi :");
//            choisi2.afficherEtat();
//        }
//
//
//        System.out.println("\n" + joueur1.getNom() + " a encore des personnages vivants ? "
//                + joueur1.aEncoreDesPersonnagesVivants());
//
//        System.out.println(joueur2.getNom() + " a encore des personnages vivants ? "
//                + joueur2.aEncoreDesPersonnagesVivants());


        int numeroTour=1;
        //Boucle de combat
        while (joueur1.aEncoreDesPersonnagesVivants()  && joueur2.aEncoreDesPersonnagesVivants())
        {
            System.out.println("\n--- Tour " + numeroTour + " ---");
            joueur1.affichageDesPersonnages();

            //Le choix de l`attaquant
            System.out.println("Choisissez votre attaquant entre les numeros 1 a 3");
            int numeroDuPersonnageAttaquant = input.nextInt();
            Personnage attaquant = joueur1.obtenirPersonnage(numeroDuPersonnageAttaquant);

            //Verifiez si l`attaquant est en vie
            if(!attaquant.estVivant())
            {
                System.out.println("Votre attaquant(e) n`est plus en vie");
                continue;
            }else
            {
                System.out.println(joueur1.getNom()+ " choisit son attaquant :" + attaquant.getNom());
            }



            //Joueur 1 choisit la cible
            System.out.print("Choisissez une cible chez " + joueur2.getNom() + " (1-3) : ");
            joueur2.afficherEquipe();
            int numCible = input.nextInt();
            Personnage cible = joueur2.obtenirPersonnage(numCible);

            if(!cible.estVivant()){
                System.out.println(cible.getNom() + " est deja mort(e)");
            continue;
            }

            // Attaque
            System.out.println(attaquant.getNom() + " attaque " + cible.getNom());
            attaquant.attaquer(cible);
            System.out.println(cible.getNom() + " perd " + attaquant.getAttaque() + " points de vie ");

            //Affichage de l`etat
            System.out.println("\nÉtat de l'équipe de " + joueur2.getNom() + " :");
            joueur2.afficherEquipe();


            //Verifier si le joueur 2 a perdu

            if(!joueur2.aEncoreDesPersonnagesVivants())
            {
                System.out.println("Victoire de " + joueur1.getNom()+" !" +
                        "Tous les personnages de " + joueur2.getNom()
                        +" sont elimines." );
                break;
            }
                        //Tour du jouer 2
            System.out.println("\n"+joueur2.getNom()+ "  joue !  ");
            joueur2.afficherEquipe();
            System.out.println("Choisissez votre attaquant entre les numeros 1 a 3");
            int numeroAttaquant2 = input.nextInt();
            Personnage attaquant2= joueur2.obtenirPersonnage(numeroAttaquant2);
            if(!attaquant2.estVivant()){
            System.out.println(attaquant2.getNom() + " est deja mort(e)");
            continue;
              }
            else{
              System.out.println("Choississez une cible chez " + joueur1.getNom() + " (1-3) : ");
                joueur1.afficherEquipe();
                int numCible2 = input.nextInt();
                Personnage cible2 = joueur1.obtenirPersonnage(numCible2);
                if(!cible2.estVivant()){
                    System.out.println(cible2.getNom() + " est deja mort(e)");
                    continue;
                }
                else{
                    System.out.println(attaquant2.getNom() + " attaque " + cible2.getNom());
                    attaquant2.attaquer(cible2);
                    System.out.println(cible2.getNom() + " perd " + attaquant2.getAttaque() + " points de vie ");
                }

            }

        // Vérifier si joueur 1 a perdu
            if (!joueur1.aEncoreDesPersonnagesVivants()) {
                System.out.println("\nVictoire de " + joueur2.getNom() + " !");
                System.out.println("Tous les personnages de " + joueur1.getNom() + " sont éliminés.");
                break;
            }

    numeroTour++;

//
        }



        
    }
}
