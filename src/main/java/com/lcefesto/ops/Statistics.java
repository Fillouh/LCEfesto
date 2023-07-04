package com.lcefesto.ops;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Statistics {
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

    public static double entropy(List<Double> probabilities, int base){
        double entropy=0;
        for(Double p:probabilities){
            entropy+=p*(Math.log(p)/Math.log(base));
        }
        return Mathematics.negate(entropy);
    }

    public static double average(List<Double> elements){
        double average=0;
        for(Double el:elements){
            average+=el;
        }
        return average/elements.size();
    }

    public static double expectation(List<Double> elements,List<Double> probabilities){
        double exp=0;
        Iterator<Double> it= probabilities.iterator();
        for(Double el:elements){
            exp+=el*it.next();
        }
        return exp;
    }

    public static double variance(List<Double> elements,List<Double> probabilities){
        double e2=Math.pow(expectation(elements,probabilities),2);
        List<Double> esquared=new ArrayList<>();
        for(Double el:elements){
            esquared.add(Math.pow(el,2));
        }
        double e1=expectation(esquared,probabilities);
        return e1-e2;
    }

    public static double standardDeviation(List<Double> elements,List<Double> probabilities){
        return Math.sqrt(variance(elements,probabilities));
    }

    public static double covariance(List<Double> e1,List<Double> p1,List<Double> e2,List<Double> p2){
        double covariance=0;
        Iterator<Double> it1= p1.iterator();
        for (double xvalue : e1) {
            double xprob = it1.next();
            Iterator<Double> it2 = p2.iterator();
            for (double yvalue : e2) {
                double yprob = it2.next();
                covariance += (xvalue - expectation(e1, p1)) * (yvalue - expectation(e2, p2)) * xprob * yprob;
            }
        }
        return covariance;
    }

    public static double correlationCoefficient(List<Double> e1,List<Double> p1,List<Double> e2,List<Double> p2){
        double v1=variance(e1,p1);
        double v2=variance(e2,p2);
        return covariance(e1,p1,e2,p2)/(Math.sqrt(v1)*Math.sqrt(v2));

    }
}
