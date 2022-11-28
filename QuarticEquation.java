public class QuarticEquation {
    int power4, power3, power2, power1, power0;
    // (Ax^2 + Bx + C)(Ax^2 + Bx + D) + F = ax^4 + bx^3 + cx^2 + dx + e

    // a = A*A
    // b = 2*A*B
    // c = B*B + A*C + A*D
    // d = B*C + B*D
    // e = C*D + F

    QuarticEquation(int a, int b, int c, int d, int f){
        this.power4 = a*a;
        this.power3 = 2*a*b;
        this.power2 = b*b + a*c + a*d;
        this.power1 = b*c + b*d;
        this.power0 = c*d + f;
    }

    String getEquation(){
        return power4 + "(x^4) + " + power3 + "(x^3) + " + power2 + "(x^2) + " +  power1 + "(x^1) + " + power0;
    }

    double[] getCoefficients(){
        return new double[]{power0,power1,power2,power3,power4};
    }
}
