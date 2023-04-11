package vichmat.methods;

import vichmat.util.Printer;

public class ChordMethod {
    double a;
    double b;
    int n;
    int number;

    public ChordMethod(double a, double b, int n, int number) {
        this.a = a;
        this.b = b;
        this.n = n;
        this.number = number;
    }

    public double f(double x){
        return Math.pow(x, 3) - x + 4;
//        switch (number){
//            case 0:
//
//            case 1:
//                return 0;
//        }
//        return 0;
    }
    public void calculate(){
        double x = a - ((b-a)/(f(b) - f(a)))*f(a);
        double fa = f(a);
        double fb = f(b);
        double fx = f(x);

        for (int i = 1; i < n ; i++){
            if(fa * fx < 0){
                a = a;
                b = x;
            }
            else{
                a = x;
                b = b;
            }
            x = a - ((b-a)/(f(b) - f(a)))*f(a);
        }
        Printer.printSuccessMessage(String.valueOf(x));
    }


}
