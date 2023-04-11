package vichmat.methods;

import vichmat.util.Printer;

public class SimpleIterationsMethod {
    double a;
    double b;
    double eps;
    String number;



    public SimpleIterationsMethod(double a, double b, String number, double eps) {
        this.a = a;
        this.b = b;
        this.eps = eps;
        this.number = number;
    }

//    get phi' and check if phi'(a) <1 and phi'(b) < 1
    public boolean checkConvergence(){
        return ((d_phi(a) < 1) && (d_phi(b) < 1));
    }


    public double phi(double x){
//        switch (number){
//            case "1":
                return Math.cbrt(x-4);
//            case 2:
//                return ;
//            case 3:
//                return ;
//        }
//        return 0;
    }

   public double d_phi(double x){
//       switch (number){
//           case "1":
               return ((double) 1/3 * 1/Math.cbrt(Math.pow((x-4),2)) );
//            case 2:
//                return ;
//            case 3:
//                return ;
//       }
//       return 0;
   }

    public void calculate(){
        if (!checkConvergence()){
            Printer.printErrorMessage("Convergence condition is not met");
            return;
        }
        double xi = a;
        double xiplus = phi(a);
        while (Math.abs(xiplus - xi) > eps){
            xi = xiplus;
            xiplus = phi(xi);
        }
        System.out.println(xiplus);
    }
}
