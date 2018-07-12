package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        return arrayList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()).get(0);
    }

    public double getMinimum() {
        return arrayList.stream().sorted().collect(Collectors.toList()).get(0);

    }

    public double getAverage() {
        return (double)arrayList.stream().reduce(0,(total,e)->total+e)/arrayList.size();
    }

    public double getOrderedMedian() {
        int len=arrayList.size();
        if (len%2==0){
            return (double)(arrayList.get(len/2)+arrayList.get(len/2-1))/2;
        }else {
            return (double)arrayList.get(len/2);
        }
    }

    public int getFirstEven() {
        return arrayList.stream().filter(e->e%2==0).findFirst().get();
    }

    public int getIndexOfFirstEven() {
        int first=getFirstEven();
        return arrayList.indexOf(first);
    }

    public boolean isEqual(List<Integer> arrayList) {
        if (arrayList.size()!=this.arrayList.size()){
            return false;
        }
        for (int i=0;i<arrayList.size();i++){
            if (arrayList.get(i)!=this.arrayList.get(i)){
                return false;
            }
        }
        return true;
    }

    public int getLastOdd() {
        return arrayList.stream().filter(e->e%2==1).reduce((p,n)->n).get();
    }

    public int getIndexOfLastOdd() {
        return arrayList.indexOf(getLastOdd());
    }

    public Double getMedianInLinkList(SingleLink singleLink) {
        int index = arrayList.size() / 2;

        if (arrayList.size() % 2 == 0) {
            return (Double.valueOf(singleLink.getNode(index).toString()) + Double.valueOf(singleLink.getNode(index+1).toString())) / 2.0;
        } else {
            return Double.valueOf(singleLink.getNode(index + 1).toString());
        }
    }

}
