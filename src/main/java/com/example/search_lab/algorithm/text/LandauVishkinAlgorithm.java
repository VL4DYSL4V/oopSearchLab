package com.example.search_lab.algorithm.text;

import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public final class LandauVishkinAlgorithm implements MismatchSearch {

    @Override
    public List<Integer> getIndexesOfMatchingSubstrings(int mismatchAmount, String sample, String text) {
        int[][] d = new int[sample.length() + 1][text.length() + 1];
        for (int i = 1; i <= sample.length(); i++) {
            d[i][0] = i;
        }
        for (int j = 1; j <= text.length(); j++) {
            d[0][j] = 0;
        }
        List<Integer> out = new LinkedList<>();
        for (int j = 1; j <= text.length(); j++) {
            for (int i = 1; i < sample.length() + 1; i++) {
                int firstMin = Math.min(d[i - 1][j] + 1, d[i][j - 1] + 1);
                int substitutionCost = (sample.charAt(i - 1) == text.charAt(j - 1)) ? 0 : 1;
                d[i][j] = Math.min(firstMin, d[i - 1][j - 1] + substitutionCost);
                if (i == sample.length() && d[i][j] == mismatchAmount) {
                    out.add(j);
                }
            }
        }
        return out;
    }
}
