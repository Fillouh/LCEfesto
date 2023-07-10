package com.lcefesto.ops;

public class Statistics {
    //COMBINATORICS
    public static double factorial(double n){
        if(n<0){
            throw new IllegalArgumentException("The parameter n must be a positive!");
        }
        if(n==0){
            return 1;
        }
        double number=n;
        for(double i=1;i<n;++i){
            number*=i;
        }
        return number;
    }

    public static double semiFactorial(double n){
        if(n<0){
            throw new IllegalArgumentException("The parameter n must be a positive integer!");
        }
        if(n==0||n==1){
            return 1;
        }
        double ris = 1;
        for (double i = n; i > 1; i-=2) {
            ris *= i;
        }
        return ris;
    }

    public static double arrangementsWithRepetition(double n,double k){
        return Math.pow(n,k);
    }

    public static double arrangementsWithoutRepetition(double n, double k){
        return factorial(n)/factorial(n-k);
    }

    public static double binomialCoefficient(double n,double k){
        return factorial(n)/(factorial(k)*factorial(n-k));
    }

    public static double symmetricBinomialCoefficient(double n,double h, double k){
        return factorial(n)/(factorial(h)*factorial(k));
    }
}
