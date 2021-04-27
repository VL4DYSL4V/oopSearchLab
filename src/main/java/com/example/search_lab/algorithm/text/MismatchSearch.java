package com.example.search_lab.algorithm.text;

import java.util.List;

public interface MismatchSearch {

    List<Integer> getIndexesOfMatchingSubstrings(int mismatchAmount, String sample, String text);

}
