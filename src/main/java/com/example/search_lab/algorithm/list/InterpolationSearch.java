package com.example.search_lab.algorithm.list;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public final class InterpolationSearch implements SortedListSearch {

    @Override
    public int search(List<Integer> list, Integer key) {
        if(list == null || list.isEmpty() || key == null){
            return -1;
        }
        int startIndex = 0;
        int lastIndex = (list.size() - 1);

        while ((startIndex <= lastIndex) && (key >= list.get(startIndex)) && (key <= list.get(lastIndex))) {
            // используем формулу интерполяции для поиска возможной лучшей позиции для существующего элемента
            int pos = startIndex + (((lastIndex - startIndex) /
                    (list.get(lastIndex) - list.get(startIndex))) *
                    (key - list.get(startIndex)));

            if (list.get(pos).equals(key)) {
                return pos;
            }
            if (list.get(pos) < key) {
                startIndex = pos + 1;
            } else {
                lastIndex = pos - 1;
            }
        }
        return -1;
    }

    //Интерполяционный поиск используется для поиска элементов в отсортированном массиве.
    // Он полезен для равномерно распределенных в структуре данных.
    //
    //При равномерно распределенных данных местонахождение элемента определяется точнее.
    // Тут и вскрывается отличие алгоритма от бинарного поиска, где мы пытаемся найти
    // элемент в середине массива.
    //
    //Для поиска элементов в массиве алгоритм использует формулы интерполяции. Эффективнее
    // применять эти формула для больших массивов. В противном случае алгоритм работает
    // как линейный поиск.
}
