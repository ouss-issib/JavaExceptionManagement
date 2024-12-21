public class EntierNaturel {
    private int val;
    public EntierNaturel(int val) throws NombreNegatifException{
        if(val<0)
            throw new NombreNegatifException("la valeur initiale de votre argument ne doit pas être négative",val);
        this.val = val;
    }

    public int getVal(){
        return this.val;
    }
    public void setVal(int val) throws NombreNegatifException{
        if(val<0)
            throw new NombreNegatifException("la valeur ne doit pas être négative!",val);
        this.val = val;
    }

    public void decrementer() throws NombreNegatifException{
        if((1-val)>0)
            throw new NombreNegatifException("La valeur ne doit pas étre décrémenté en dessous de zéro !",val-1);
        val--;
    }
}
