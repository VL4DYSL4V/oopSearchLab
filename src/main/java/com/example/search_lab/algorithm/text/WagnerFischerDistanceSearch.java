package com.example.search_lab.algorithm.text;

import org.springframework.stereotype.Component;

@Component
public final class WagnerFischerDistanceSearch implements LevenshteinDistanceSearch {

    @Override
    public int getDistance(String first, String second) {
        // for all i and j, d[i,j] will hold the Levenshtein distance between
        // the first i characters of s and the first j characters of t
        // note that d has (m+1)*(n+1) values
        int[][] d = new int[first.length() + 1][second.length() + 1];
        // source prefixes can be transformed into empty string by dropping all characters
        for (int i = 1; i <= first.length(); i++) {
            d[i][0] = i;
        }
        // target prefixes can be reached from empty source prefix  by inserting every character
        for (int j = 1; j <= second.length(); j++) {
            d[0][j] = j;
        }
        for (int j = 1; j <= second.length(); j++) {
            for (int i = 1; i <= first.length(); i++) {
                int substitutionCost = (first.charAt(i - 1) == second.charAt(j - 1)) ? 0 : 1;
                int firstMin = Math.min(
                        d[i - 1][j] + 1,   // deletion
                        d[i][j - 1] + 1);  // insertion
                d[i][j] = Math.min(firstMin, d[i - 1][j - 1] +
                        substitutionCost); // substitution
            }
        }
        return d[first.length()][second.length()];
    }
}
