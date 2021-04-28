package com.example.search_lab.algorithm.text;

import com.example.search_lab.util.Pair;

import java.util.List;

public interface MismatchSearch {

    List<Pair<Integer>> getIndexesOfMatchingSubstrings(int mismatchAmount, String sample, String text);

}
