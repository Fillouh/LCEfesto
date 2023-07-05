package com.lcefesto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class RandomVariable {
    List<Double> elements;
    List<Double> probabilities;

    public RandomVariable(List<Double> elements, List<Double> probabilities) {
        this.elements = elements;
        this.probabilities = probabilities;
    }

    public RandomVariable(){

    }

    public RandomVariable(double[] el,double[] pr){
        for(Double e: el){
            elements.add(e);
        }
        for(Double p:pr){
            probabilities.add(p);
        }
    }

    public List<Double> getElements() {
        return elements;
    }

    public void setElements(List<Double> elements) {
        this.elements = elements;
    }

    public List<Double> getProbabilities() {
        return probabilities;
    }

    public void setProbabilities(List<Double> probabilities) {
        this.probabilities = probabilities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RandomVariable that = (RandomVariable) o;
        return Objects.equals(elements, that.elements) && Objects.equals(probabilities, that.probabilities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(elements, probabilities);
    }

    @Override
    public String toString() {
        return "RandomVariable{" +
                "elements=" + elements +
                ", probabilities=" + probabilities +
                '}';
    }

    public static double expectation(RandomVariable x){
        double exp=0;
        Iterator<Double> it= x.probabilities.iterator();
        for(Double el:x.elements){
            exp+=el*it.next();
        }
        return exp;
    }

    public static double variance(RandomVariable x){
        double e2=Math.pow(expectation(x),2);
        List<Double> esquared=new ArrayList<>();
        for(Double el:x.elements){
            esquared.add(Math.pow(el,2));
        }
        x.setElements(esquared);
        double e1=expectation(x);
        return e1-e2;
    }

    public static double standardDeviation(RandomVariable x){
        return Math.sqrt(variance(x));
    }

    public static double covariance(RandomVariable x,RandomVariable y){
        double covariance=0;
        Iterator<Double> it1= x.probabilities.iterator();
        for (double xvalue : x.elements) {
            double xprob = it1.next();
            Iterator<Double> it2 = y.probabilities.iterator();
            for (double yvalue : y.elements) {
                double yprob = it2.next();
                covariance += (xvalue - expectation(x)) * (yvalue - expectation(y)) * xprob * yprob;
            }
        }
        return covariance;
    }

    public static double correlationCoefficient(RandomVariable x,RandomVariable y){
        return covariance(x,y)/(standardDeviation(x)*standardDeviation(y));
    }
}
