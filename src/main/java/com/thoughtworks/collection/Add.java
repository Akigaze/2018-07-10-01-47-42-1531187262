package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        int sumOfEvens=0;
        int big=rightBorder>leftBorder?rightBorder:leftBorder;
        int small=rightBorder<leftBorder?rightBorder:leftBorder;
        int temp=small%2==0?small:small+1;
        while (temp<=big){
            sumOfEvens+=temp;
            temp+=2;
        }
        return sumOfEvens;
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        int sumOfAll=(rightBorder+leftBorder)*(Math.abs(leftBorder-rightBorder)+1)/2;
        int sumOfOld=sumOfAll-getSumOfEvens(leftBorder,rightBorder);
        return sumOfOld;
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        return arrayList.parallelStream().map(a -> a*3+2).reduce(0,(sum,current)->  sum+current );
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().map(e -> e%2==0?e:e*3+2).collect(Collectors.toList());
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        return arrayList.stream().reduce(0,(sumOfOlds,current) -> current%2==1?sumOfOlds+current*3+5:sumOfOlds );
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        List<Integer> result=new ArrayList<>();
        for (int i=0;i<arrayList.size()-1;i++){
            result.add(3*(arrayList.get(i)+arrayList.get(i+1)));
        }
        return result;
    }

    public double getMedianOfEven(List<Integer> arrayList) {
        throw new NotImplementedException();
    }

    public double getAverageOfEven(List<Integer> arrayList) {
        throw new NotImplementedException();
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        throw new NotImplementedException();
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        throw new NotImplementedException();
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        throw new NotImplementedException();
    }


}
