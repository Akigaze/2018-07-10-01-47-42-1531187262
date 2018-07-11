package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionOperator {
    private List<Integer> convertIntArrayToList(int[] array){
        List<Integer> list=new ArrayList<>();
        for (int i:array){
            list.add(i);
        }
        return list;
    }

    public List<Integer> getListByInterval(int left, int right) {
        int small=left<right?left:right;
        int big=left>right?left:right;

        List<Integer> result=new ArrayList<>();
        for (int i=small;i<=big;i++){
            result.add(i);
        }
        if (left==big){
            result.sort(Comparator.reverseOrder());
        }
        return result;
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        List<Integer> list=getListByInterval(left,right);
        return list.stream().filter(e -> e%2==0).collect(Collectors.toList());
    }

    public List<Integer> popEvenElments(int[] array) {
        List<Integer> list=convertIntArrayToList(array);
        return list.stream().filter(e -> e%2==0).collect(Collectors.toList());
    }

    public int popLastElment(int[] array) {
        return array[array.length-1];
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        List<Integer> firstList=convertIntArrayToList(firstArray);
        List<Integer> secondList=convertIntArrayToList(secondArray);
        firstList.retainAll(secondList);
        return firstList;
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        List<Integer> firstList=new ArrayList<>(Arrays.asList(firstArray));
        List<Integer> secondList=new ArrayList<>(Arrays.asList(secondArray));

        firstList.addAll(secondList);

        return firstList.stream().distinct().collect(Collectors.toList());
    }
}
