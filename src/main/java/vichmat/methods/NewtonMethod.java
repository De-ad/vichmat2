package vichmat.methods;

import vichmat.util.Printer;

public class NewtonMethod {
    double a;
    double b;
    double eps;

    public NewtonMethod(double a, double b, double eps) {
        this.a = a;
        this.b = b;
        this.eps = eps;
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

    public double f_one(double x){
        return Math.pow(x, 2) * 3 - 1;
//        switch (number){
//            case 0:
//
//            case 1:
//                return 0;
//        }
//        return 0;
    }
    public double f_two(double x){
        return 6*x;
//        switch (number){
//            case 0:
//
//            case 1:
//                return 0;
//        }
//        return 0;
    }


    boolean checkConvergence(){
        boolean one = f(a) * f(b) < 0;
        boolean two = f_one(a) * f_one(b) > 0 && f_two(a) * f_two(b) > 0;
        boolean three = f_one(a) != 0 && f_one(b) != 0;
        return one && two && three;
    }

    public void calculate(){
        if (!checkConvergence()){
            Printer.printErrorMessage("Convergence condition is not met");
            return;
        }

        double x0;
        if (f(a)* f_two(a) > 0 ){
            x0 = a;
        }
        else{
            x0 = b;
        }
        double xminus = x0;
        double xi = xminus - (f(xminus))/f_one(xminus);
        while (xi - xminus > eps){
            xminus = xi;
            xi = xminus - (f(xminus))/f_one(xminus);
        }
        System.out.println(xi);
    }

}
