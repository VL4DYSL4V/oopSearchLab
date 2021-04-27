package com.example.search_lab.algorithm.list;

import java.util.List;

public interface CommonElementsSearch {

    <T extends Comparable<T>> List<T> common(List<T> first, List<T> second);

}
