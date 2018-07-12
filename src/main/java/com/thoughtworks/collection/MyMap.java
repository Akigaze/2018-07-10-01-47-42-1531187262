package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MyMap {

    List<Integer> array;
    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> letterList = Arrays.asList(letters);

    public MyMap(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getTriple() {
        return array.stream().map(e->e*3).collect(Collectors.toList());
    }

    public List<String> mapLetter() {
        return array.stream().map(e->letterList.get(e-1)).collect(Collectors.toList());
    }

    public List<String> mapLetters() {
        int len=letterList.size();
        return array.stream().map(e->{
            String result=null;
            e=e-1;
            if (e>=len){
                String lower=letterList.get(e%len);
                String upper=letterList.get((int)(e/len-1));
                result=upper+lower;
            }else {
                result=letterList.get(e);
            }
            return result;
        }).collect(Collectors.toList());
    }

    public List<Integer> sortFromBig() {
        return array.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    public List<Integer> sortFromSmall() {
        return array.stream().sorted().collect(Collectors.toList());

    }
}
