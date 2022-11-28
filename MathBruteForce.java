import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;
import org.apache.commons.math3.analysis.solvers.LaguerreSolver;
import org.apache.commons.math3.complex.Complex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MathBruteForce {
    public static void main(String[] args) {
        // (Ax^2 + Bx + C)(Ax^2 + Bx + D) + F = ax^4 + bx^3 + cx^2 + dx + e

        // a = A*A
        // b = 2*A*B
        // c = B*B + A*C + A*D
        // d = B*C + B*D
        // e = C*D + F

        ArrayList<PolynomialFunction> ansList = new ArrayList<>();
        ArrayList<Object[]> rootsList = new ArrayList<>();

        Random randomGenerator = new Random();
        int count = 0;
        for(int i=0; i<10000; i++) {
            int a = randomGenerator.nextInt(1,10);
            int b = randomGenerator.nextInt(1,10);
            int c = randomGenerator.nextInt(1,10);
            int d = randomGenerator.nextInt(1,10);
            int f = randomGenerator.nextInt(1,10);

            QuarticEquation q1 = new QuarticEquation(a,b,c,d,f);
            PolynomialFunction p1 = new PolynomialFunction(q1.getCoefficients());

            LaguerreSolver l = new LaguerreSolver();
            Complex[] array = l.solveAllComplex(p1.getCoefficients(), -1000000.0);

            ArrayList<Double> list = new ArrayList<>();
            for (Complex n : array) {
                /*if (n.equals(new Complex(n.getReal(), 0)) && Math.round(n.getReal()*10)/10 != 0) {
                    int roundedVal = (int) (Math.round(n.getReal()*10)/10);
                    list.add((double) Math.round(n.getReal()*10)/10);
                    System.out.println((roundedVal*2)%10);
                }*/
                if (n.equals(new Complex(n.getReal(), 0)) && Math.round(n.getReal()*10)/10 != 0) {
                    list.add((double) Math.round(n.getReal()*100000)/100000);
                }
            }
            if(list.size() == 4){
                System.out.print("#"+ count + "\t\t\tFunction = " + p1);
                System.out.println("\t\t\tRoots = " + Arrays.toString(list.toArray()));
                rootsList.add(list.toArray());
                ansList.add(p1);
                count++;
            }
        }


        System.out.println("\n\nWhich polynomial to display in detail?");
        int a = new Scanner(System.in).nextInt();
        System.out.println("Function = " + ansList.get(a).toString());
        System.out.println("Roots = " + Arrays.toString(rootsList.get(a))+"\n");
        printSpecialForm(ansList.get(a).getCoefficients());
    }
    static void printSpecialForm(double[] coeff){
        //example solution:
        //4x^4 + 28x^3 + 71x^2 + 77x + 30
        //  4      3       2      1     0
        //  a      b       c      d     e


        double A = Math.sqrt(coeff[4]);
        double B = coeff[3] / (2*A);
        double CpD = (coeff[2] - B*B)/A;

        for (int i = 0; i < CpD / 2; i++) {
            double C = i;
            double D = CpD - i;
            double F = (coeff[0] - C*D);

            PolynomialFunction p1 = new PolynomialFunction(new double[]{C,B,A});
            PolynomialFunction p2 = new PolynomialFunction(new double[]{D,B,A});
            System.out.println("(" + p1 + ")(" + p2 + ") + "+F);
        }

    }
}
