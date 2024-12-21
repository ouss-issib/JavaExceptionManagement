public class CompteCourant extends CompteBancaire{
    private double decouvertAutorise;
    public CompteCourant(int numCompte, double solde, String nomTitulaire,double decouvertAutorise) {
        super(numCompte, solde, nomTitulaire);
        this.decouvertAutorise = decouvertAutorise;
    }

    public double getDecouvertAutorise() {
        return decouvertAutorise;
    }

    public void setDecouvertAutorise(double decouvertAutorise) {
        this.decouvertAutorise = decouvertAutorise;
    }


    @Override
    public void retirer(double montant) throws FondsInsuffisantsException {
        if(montant<=0){
            throw new IllegalArgumentException("Le montant à retirer doit être positif.");
        }
        if (solde - montant < -decouvertAutorise) {
            throw new FondsInsuffisantsException("Retrait refusé : dépassement du découvert autorisé.");
        }
        solde-=montant;
    }

    @Override
    public void afficherDetailsCompte() {
        System.out.println("💥 Compte Courant : \n \t ▶ Numéro de compte : " + numCompte + ", Solde : " + solde + " DH, Titulaire : " + nomTitulaire+", Découvert Autorisé : " + decouvertAutorise+" DH");
    }
}
