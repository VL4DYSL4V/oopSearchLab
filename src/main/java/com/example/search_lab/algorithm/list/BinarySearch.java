package com.example.search_lab.algorithm.list;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public final class BinarySearch implements SortedListSearch {

    @Override
    public int search(List<Integer> list, Integer key) {
        if(list == null || list.isEmpty() || key == null){
            return -1;
        }
        int low = 0;
        int high = list.size() - 1;
        int mid = (low + high) / 2;
        int index = -1;
        while (low <= high) {
            if (list.get(mid) < key) {
                low = mid + 1;
            } else if (list.get(mid).equals(key)) {
                index = mid;
                break;
            } else {
                high = mid - 1;
            }
            mid = (low + high) / 2;
        }
        return index;
    }

}
