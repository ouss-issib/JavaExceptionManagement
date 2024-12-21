public class Main {
    public static void main(String[] args) {
        System.out.println("**********************JAVA EXCEPTION MANAGEMENT**********************");

        System.out.println("1. Test si la valeur est positive : ");
        try {
            //Test de création  avec une valeur initiale positive
            EntierNaturel entierPositif = new EntierNaturel(10);
            System.out.println("- Valeur Initiale = " + entierPositif.getVal());

            //Test de la methode setVal avec une valeur initiale
            entierPositif.setVal(12);
            System.out.println("- Nouvelle Valeur = " + entierPositif.getVal());

            //Test de la methode decrementer
            entierPositif.decrementer();
            System.out.println("- Valeur après décrémentation = " + entierPositif.getVal());

        }catch (NombreNegatifException e){
            System.err.println("Exception capturée ==> "+ e.getMessage()+" , Valeur Erronée ==> "+e.getValeurErronee());
        }

        System.out.println("2. Test si la valeur est négative : ");
        try{
            EntierNaturel entierNegatif = new EntierNaturel(-10);
        }catch(NombreNegatifException e){
            System.err.println("Exception capturé à la création ==> "+e.getMessage()+" , Valeur Erronée ==> "+e.getValeurErronee());
        }


        try{
            EntierNaturel newEntierNegatif = new EntierNaturel(10);
            newEntierNegatif.setVal(-10);
        }catch(NombreNegatifException e){
            System.err.println("Exception capturé à la modification ==> "+e.getMessage()+" , Valeur Erronée ==> "+e.getValeurErronee());
        }

        try{
            EntierNaturel entierNull = new EntierNaturel(0);
            entierNull.decrementer();
        }catch(NombreNegatifException e){
            System.err.println("Exception capturé à la décrémentation ==> "+e.getMessage()+" , Valeur Erronée ==> "+e.getValeurErronee());
        }



    }
}