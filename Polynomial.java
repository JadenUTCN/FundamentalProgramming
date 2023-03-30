import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class Polynomial {

    public TreeMap<Integer,Monomial> monos;


    public int degree = -1;
    public int leadingCoef = -1;

    public Polynomial(){
        monos = new TreeMap<>();




    }
    public void ins(Monomial mono){
        //monos.put(mono.degree,mono);
        Monomial temp = monos.get(mono.degree);

        if (temp != null) {
//            if (mono.sign) {

                temp.coef += mono.coef;
            if (mono.degree >= this.degree){
                this.degree = mono.degree;


                if (temp.coef != 0) {
                    this.leadingCoef = temp.coef;
                }





            }


//            } else {
//                temp.coef -= mono.coef;
//            }
        }else{
                monos.put(mono.degree, mono);
            if (mono.degree >= this.degree){
                this.degree = mono.degree;
                if (mono.coef > this.leadingCoef) {
                    this.leadingCoef = mono.coef;

                }


            }

        }
    }
    public void recalculateDegree(){

    }

    public void printarray() {
        System.out.println("Printing array");
        for (Monomial mono : monos.values()) {
            System.out.println(mono);
        }
    }
    public Polynomial add(Polynomial poly2){
        Polynomial poly3 = new Polynomial();
        for (Monomial mono : this.monos.values()){
            poly3.ins(mono);
        }
        for (Monomial mono : poly2.monos.values()){
            poly3.ins(mono);
        }
        return poly3;
    }
    public Polynomial sub(Polynomial poly2){
        Polynomial poly3 = new Polynomial();
        for (Monomial mono : this.monos.values()) {
//            if (poly2.monos.get(mono.degree) != null){
            Monomial temp = new Monomial(mono.degree, mono.coef);
            poly3.ins(temp);

        }
            for (Monomial mono2 : poly2.monos.values()){
               Monomial monotemp = poly3.monos.get(mono2.degree);
               if (monotemp != null){
                   monotemp.coef -= mono2.coef;
                   if (monotemp.coef == 0) {
                       poly3.monos.remove(mono2.degree);
                       if (!poly3.monos.isEmpty()){
                           poly3.degree = poly3.monos.lastKey();
                       poly3.leadingCoef = poly3.monos.get(poly3.degree).coef;
                   }else{
                           poly3.degree = -1;
                       }
                   }




               }else{
                   Monomial newmono = new Monomial(mono2.degree,-mono2.coef);
                   poly3.ins(newmono);
               }
        }

        return poly3;
    }
    public Polynomial mul(Polynomial poly2){
        Polynomial poly3 = new Polynomial();
        for (Monomial mono : monos.values()){
            for (Monomial mono2 : poly2.monos.values()){
                int coef;
//                boolean sign = true;
                int degree;
                coef = mono.coef * mono2.coef;
//
                degree = mono.degree + mono2.degree;
                Monomial mulMono = new Monomial(degree,coef); //sign
                poly3.ins(mulMono);

            }
        }
    return poly3;
    }

    public Polynomial div(Polynomial divisor) {
        Polynomial quotient = new Polynomial();

        if (divisor.degree == 0) {
            if ((divisor.leadingCoef == 0)) {
                throw new RuntimeException("We can't divide by 0, Duh!");
            }
        }
        if (this.degree < divisor.degree){
            Monomial temp = new Monomial(0,0);
            Polynomial poly = new Polynomial();
            poly.ins(temp);
            return poly;
        }

        int coef = this.leadingCoef / divisor.leadingCoef;
        int degree = this.degree - divisor.degree;
        Monomial mono = new Monomial(degree, coef);
        Polynomial polo = new Polynomial();
        polo.ins(mono);
        quotient.ins(mono);

        return quotient.add(  (this.sub(divisor.mul(quotient)).div(divisor)) );
    }

/*
function n / d is
    require d ≠ 0
    q ← 0
    r ← n             // At each step n = d × q + r

    while r ≠ 0 and degree(r) ≥ degree(d) do
        t ← lead(r) / lead(d)       // Divide the leading terms
        q ← q + t
        r ← r − t × d

    return (q, r)
 */





//    public String getSign(int coef){
//        String sign = "+";
//        if (coef < 0){
//            sign = "";
//        }
//        return sign;
//    }

    public String toString(){
        String poly = "";
        int coef = 0;
        int degree = -1;

        Monomial temp;
        for (Monomial mono : monos.descendingMap().values()){
            coef = mono.coef;
            degree = mono.degree;
            if (coef > 0) {
                poly += "+";
            }
                coef = mono.coef;
                if (degree > 1) {
                        poly += Integer.toString(coef) + "x^" + Integer.toString(degree);
                    }else if (degree == 1){
                        poly += coef + "x";
                }else if (degree == 0){
                        poly += coef;
                }
            }


        return poly;
    }



}
