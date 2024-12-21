import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<CompteBancaire> compteBancaires = new ArrayList<>();

        System.out.println("*************Gestion des comptes bancaires*************");

        //Ajouter des comptes
        compteBancaires.add(new CompteCourant(1,5000,"Abdelouahed Bssabss",1000));
        compteBancaires.add(new CompteEpargne(2,10000,"Jamila uchiha",0.05));
        compteBancaires.add(new CompteEpargne(3,8000,"Anas jetsu",0.07));

        //Afficher Les comptes
        System.out.println("📛 Liste des comptes bancaires:");

        for(CompteBancaire compte : compteBancaires){
            compte.afficherDetailsCompte();
        }

        //Effectuer des opérations
        try{
            CompteBancaire compteAbdelouahed = compteBancaires.get(0);
            CompteBancaire compteJamila = compteBancaires.get(1);

            compteAbdelouahed.deposer(2000);
            compteJamila.retirer(100);

            CompteBancaire.transferer(compteAbdelouahed,compteJamila,1500);

            if(compteJamila instanceof CompteEpargne){
                ((CompteEpargne) compteJamila).appliquerInteret();
            }
            System.out.println("\t💨 Après ajout d'interet : ");
            compteJamila.afficherDetailsCompte();

        }catch(FondsInsuffisantsException | CompteInexistantException e){
            e.printStackTrace();
        }

        //supprimer un compte
        compteBancaires.remove(2);

        //Afficher les comptes restants
        System.out.println("📛 Liste des comptes bancaires restants :");
        for(CompteBancaire compte : compteBancaires){
            compte.afficherDetailsCompte();
        }

    }
}