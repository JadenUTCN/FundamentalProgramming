public class Monomial {
    public int degree;
    public int coef;

    public boolean sign;

    public Monomial(int deg, int coef){
        this.degree = deg;
        this.coef = coef;
//        this.sign = sign;
    }
    public String toString(){
        String mysign = "+";
        if (!sign){
            mysign = "-";
        }
//        String thisMono = "Sign "+mysign + " degree " + Integer.toString(degree) + " Coef " + Integer.toString(coef);
        String thisMono = "Sign "+" degree " + Integer.toString(degree) + " Coef " + Integer.toString(coef);
        return thisMono;
    }
    public void add(Monomial mono){
//        if (mono.sign) {//this is positive
            this.coef += mono.coef;
//        }else{
//            this.coef -= mono.coef;
//        }


    }







}
