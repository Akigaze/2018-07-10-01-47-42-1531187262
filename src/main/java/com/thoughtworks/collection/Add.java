package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;
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
        List<Integer> evenList=arrayList.stream().filter(e -> e%2==0).sorted().collect(Collectors.toList());
        int len=evenList.size();
        if (len%2==0){
            return (evenList.get(len/2)+evenList.get(len/2-1))/2;
        }else {
            return evenList.get(len/2);
        }
    }

    public double getAverageOfEven(List<Integer> arrayList) {
        return arrayList.stream().filter(e -> e%2==0).reduce(0,(avg,current) -> avg+current/2);
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        if (specialElment%2==1) return false;
        return arrayList.contains(specialElment);
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        return arrayList.stream().filter(e -> e%2==0).distinct().collect(Collectors.toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List<Integer> oddList=arrayList.stream().filter(e -> e%2==1).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        List<Integer> evenList=arrayList.stream().filter(e -> e%2==0).sorted().collect(Collectors.toList());
        evenList.addAll(oddList);
        return evenList;
    }


}
