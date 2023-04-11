package vichmat.util;

import vichmat.methods.ChordMethod;
import vichmat.methods.NewtonMethod;
import vichmat.methods.SimpleIterationsMethod;

import java.util.Objects;
import java.util.Scanner;


public class IOManager{
    Scanner in;
    boolean equation = false;
    double eps;
    int a;
    int b;


    public IOManager(){
         in = new Scanner(System.in);
    }


    public void start(){
       chooseEquationOrSystem();
       if (equation){
           chooseEquation();
//           getInputSource();
           ChordMethod chordMethod = new ChordMethod(-2, -1, 4, 1);
           chordMethod.calculate();
           NewtonMethod newtonMethod = new NewtonMethod(-2, -1, 0.01);
           newtonMethod.calculate();
           SimpleIterationsMethod simpleIterationsMethod = new SimpleIterationsMethod(-2, -1, "1", 0.01);
           simpleIterationsMethod.calculate();
       }
       else{
           chooseSystem();
       }

    }

    public void chooseEquation(){
        Printer.printMessage("Please, choose equation: \n" +
                "(1) : x\u00b3 - x + 4 = 0 \n" +
                "(2) : 7x\u00b2 + 4x - 5 = 0 \n" +
                "(3) : cos(x) + tg(x) + x = 0");
        while (true) {
            String line = in.next();
            if (Objects.equals(line, "1")) {

                break;
            } else if (Objects.equals(line, "2")) {
                break;
            }
            else if (Objects.equals(line, "3")) {
                break;
            }
            else {
                Printer.printErrorMessage("Please write correct input");
            }
        }
    }

    public void chooseSystem(){
        Printer.printMessage("Please, choose system: \n" +
                "(1) : f\u2081(x\u2081, x\u2082) = 0,1x\u2081\u00b2 + x\u2081 + 0,2\u2082\u00b2 - 0,3 = 0 \n" +
                "      f\u2082(x\u2081, x\u2082) = 0,2x\u2081\u00b2 + x\u2082 + 0,1x\u2081x\u2082 - 0,7 = 0 \n");

    }

    public void chooseEquationOrSystem(){
        Printer.printMessage("Please, choose: equation(1) or system(2) ");
        while (true){
            String line = in.next();
            if (Objects.equals(line, "1")){
                equation = true;
                break;
            }
            else if (Objects.equals(line, "2")){
                Printer.printMessage("system");
                equation = false;
                break;
            }
            else {
                Printer.printErrorMessage("Please write correct input");
            }
        }
    }

    public void getInputSource(){
        Printer.printMessage("Please, choose input source: console(1) or file(2) ");
        while(true){
            String line = in.next();
            if (Objects.equals(line, "1")){
                readDataFromConsole();
                break;
            }
            else if (Objects.equals(line, "2")){
                Printer.printMessage("Please enter filename");
                String name = in.next();
                readDataFromFile(name);
                break;
            }
            else {
                Printer.printErrorMessage("Please write correct input");
            }
        }
    }

    public void readDataFromConsole(){
        Printer.printMessage("Please enter left bound");
         a = in.nextInt();
        Printer.printMessage("Please enter right bound");
         b = in.nextInt();
        Printer.printMessage("Please enter eps");
         eps = in.nextDouble();
    }
    public void readDataFromFile(String filename){

    }

    public boolean validate(){
        return true;
    }

}
