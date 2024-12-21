public class CompteEpargne extends CompteBancaire{
    private double tauxInteret;
    public CompteEpargne(int numCompte, double solde, String nomTitulaire,double  tauxInteret) {
        super(numCompte, solde, nomTitulaire);
        this.tauxInteret = tauxInteret;
    }

    public double getTauxInterets() {
        return tauxInteret;
    }

    public void setTauxInterets(double tauxInteret) {
        this.tauxInteret = tauxInteret;
    }

    public void appliquerInteret(){
        solde += solde*tauxInteret;
    }

    @Override
    public void afficherDetailsCompte() {
        System.out.println("💥 Compte Epargne : \n \t ▶ Numéro de compte : " + numCompte + ", Solde : " + solde + " DH , Titulaire : " + nomTitulaire+", tauxInteret : " + tauxInteret);
    }


}
