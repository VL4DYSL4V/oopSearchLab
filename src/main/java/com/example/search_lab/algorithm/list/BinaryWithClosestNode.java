package com.example.search_lab.algorithm.list;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public final class BinaryWithClosestNode implements SortedListSearch {

    @Override
    public int search(List<Integer> list, Integer key) {
        if (list == null || list.isEmpty() || key == null) {
            return -1;
        }
        if (list.get(0) > key || list.get(list.size() - 1) < key) {
            return -1;
        }
        int half = list.size() / 2;
        int from = half;
        int to = half;
        int delta = 1;
        Integer value = list.get(from);
        if (value < key) {
            //expand right
            while (to < list.size() && list.get(to - 1) < key) {
                to = Math.min(half + delta, list.size());
                delta += delta;
            }
        } else if (Objects.equals(value, key)) {
            return from;
        } else {
            //expand left
            while (from > 0 && list.get(from) > key) {
                from = Math.max(half - delta, 0);
                delta += delta;
            }
        }
        return indexOfClosestLesserElement(list, key, from, to);
    }

    private int indexOfClosestLesserElement(List<Integer> list, Integer key, int from, int to) {
        int low = from;
        int high = to - 1;
        int mid = (low + high) / 2;
        int index = -1;
        while (low <= high) {
            Integer value = list.get(mid);
            if (value < key) {
                low = mid + 1;
                index = mid;
            } else if (Objects.equals(value, key)) {
                return mid;
            } else {
                high = mid - 1;
            }
            mid = (low + high) / 2;
        }
        return index;
    }
}
