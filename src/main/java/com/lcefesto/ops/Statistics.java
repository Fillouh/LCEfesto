package com.lcefesto.ops;

public class Statistics {
    //COMBINATORICS
    public static double factorial(double number){
        if(number<0){
            throw new IllegalArgumentException("The parameter n must be a positive!");
        }
        if(number==0){
            return 1;
        }
        double num=number;
        for(double i=1;i<number;++i){
            number*=i;
        }
        return number;
    }

    public static double semiFactorial(double number){
        if(number<0){
            throw new IllegalArgumentException("The parameter n must be a positive integer!");
        }
        if(number==0||number==1){
            return 1;
        }
        double ris = 1;
        for (double i = number; i > 1; i-=2) {
            ris *= i;
        }
        return ris;
    }

    public static double arrangementsWithRepetition(double nElements,double kPositions){
        return Math.pow(nElements,kPositions);
    }

    public static double arrangementsWithoutRepetition(double nElements, double kPositions){
        return factorial(nElements)/factorial(nElements-kPositions);
    }

    public static double binomialCoefficient(double n,double k){
        return factorial(n)/(factorial(k)*factorial(n-k));
    }

    public static double symmetricBinomialCoefficient(double n,double h, double k){
        return factorial(n)/(factorial(h)*factorial(k));
    }
}
