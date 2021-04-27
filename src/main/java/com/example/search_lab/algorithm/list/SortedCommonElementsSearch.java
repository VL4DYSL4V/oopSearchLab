package com.example.search_lab.algorithm.list;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public final class SortedCommonElementsSearch implements CommonElementsSearch{

    @Override
    public <T extends Comparable<T>> List<T> common(List<T> first, List<T> second) {
        List<T> out = new ArrayList<>();
        if(first == null || first.isEmpty() || second == null || second.isEmpty()){
            return out;
        }
        int firstIndex = 0;
        int secondIndex = 0;
        while(firstIndex < first.size() && secondIndex < second.size()){
            T elementFirst = first.get(firstIndex);
            T elementSecond = second.get(secondIndex);
            int comparingResult = elementFirst.compareTo(elementSecond);
            if(comparingResult == 0){
                out.add(elementFirst);
                firstIndex++;
                secondIndex++;
            }else if(comparingResult < 0){
                firstIndex++;
            }else{
                secondIndex++;
            }
        }
        return out;
    }

}
