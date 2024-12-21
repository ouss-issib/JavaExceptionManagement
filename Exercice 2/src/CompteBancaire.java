 abstract  class CompteBancaire {
    protected int numCompte;
    protected double solde;
    protected String nomTitulaire;

    public CompteBancaire(int numCompte,double solde,String nomTitulaire){
        this.numCompte = numCompte;
        if(solde<0)
            throw new IllegalArgumentException("Le solde initiale ne peut pas être négatif.");
        this.solde = solde;
        this.nomTitulaire = nomTitulaire;
    }

    public int getNumCompte() {
        return numCompte;
    }

    public void setNumCompte(int numCompte) {
        this.numCompte = numCompte;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public String getNomTitulaire() {
        return nomTitulaire;
    }

    public void setNomTitulaire(String nomTitulaire) {
        this.nomTitulaire = nomTitulaire;
    }

    //Methode du dépôt d'argent
    public void deposer(double montant){
        if(montant<=0)
            throw new IllegalArgumentException("Le montant à déposer doit être positif.");
        solde+=montant;
    }

    //Méthode du retrait d'argent
    public void retirer(double montant) throws FondsInsuffisantsException{
        if(montant<=0){
            throw new IllegalArgumentException("Le montant à retirer doit être positif.");
        }
        if(solde<montant) {
            throw new FondsInsuffisantsException("Fonds insuffisants pour effectuer le retrait.");
        }
        solde-=montant;
    }
    //Affichage du solde de compte
    public void afficherSolde(){
        System.out.println("Solde de compte : "+this.solde+" DH");
    }

    public static void transferer(CompteBancaire source,CompteBancaire destination,double mt) throws FondsInsuffisantsException,CompteInexistantException{
        if(destination == null ) {
            throw new CompteInexistantException("Le Compte de destination n'existe pas !!");
        }
        source.retirer(mt);
        destination.deposer(mt);
    }

     public abstract void afficherDetailsCompte();

}
