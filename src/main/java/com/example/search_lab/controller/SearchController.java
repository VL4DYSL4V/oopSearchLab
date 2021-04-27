package com.example.search_lab.controller;

import com.example.search_lab.algorithm.list.CommonElementsSearch;
import com.example.search_lab.algorithm.list.SequenceSearch;
import com.example.search_lab.algorithm.list.SortedListSearch;
import com.example.search_lab.algorithm.text.*;
import com.example.search_lab.entity.ListCommonEntity;
import com.example.search_lab.entity.ListSearchEntity;
import com.example.search_lab.entity.StringSearchEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public final class SearchController {

    private final ApplicationContext applicationContext;

    public SearchController(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @GetMapping("/binary-search")
    @ResponseBody
    public int findBinary(@RequestBody ListSearchEntity listSearchEntity) {
        SortedListSearch sortedListSearch = applicationContext.getBean("binarySearch", SortedListSearch.class);
        return sortedListSearch.search(listSearchEntity.getData(), listSearchEntity.getElement());
    }

    @GetMapping("/subsequence")
    @ResponseBody
    public Map<Character, Integer> findSubsequence(@RequestBody StringSearchEntity stringSearchEntity){
        TextSubsequenceSearch textSubsequenceSearch =
                applicationContext.getBean("simpleSubsequenceSearch", TextSubsequenceSearch.class);
        return textSubsequenceSearch.search(stringSearchEntity.getText(), stringSearchEntity.getSample());
    }
    @GetMapping("/common")
    @ResponseBody
    public List<Integer> findCommon(@RequestBody ListCommonEntity listCommonEntity){
        CommonElementsSearch commonElementsSearch =
                applicationContext.getBean("sortedCommonElementsSearch", CommonElementsSearch.class);
        return commonElementsSearch.common(listCommonEntity.getFirst(), listCommonEntity.getSecond());
    }

    @GetMapping("/interpolation-search")
    @ResponseBody
    public int interpolationSearch(@RequestBody ListSearchEntity listSearchEntity){
        SortedListSearch sortedListSearch = applicationContext.getBean("interpolationSearch", SortedListSearch.class);
        return sortedListSearch.search(listSearchEntity.getData(), listSearchEntity.getElement());
    }

    @GetMapping("/binary-with-closest-node")
    @ResponseBody
    public int binaryWithClosestNode(@RequestBody ListSearchEntity listSearchEntity){
        SortedListSearch sortedListSearch = applicationContext.getBean("binaryWithClosestNode", SortedListSearch.class);
        return sortedListSearch.search(listSearchEntity.getData(), listSearchEntity.getElement());
    }

    @GetMapping("/precise-search")
    @ResponseBody
    public List<Integer> preciseSearch(@RequestBody StringSearchEntity stringSearchEntity){
        PreciseSubstringSearch preciseSubstringSearch =
                applicationContext.getBean("knutMorrisPrattSearch", PreciseSubstringSearch.class);
        return preciseSubstringSearch.search(stringSearchEntity.getText(), stringSearchEntity.getSample());
    }

    @GetMapping("/wagner-fisher")
    @ResponseBody
    public int levenshteinDistance(@RequestBody StringSearchEntity stringSearchEntity){
        LevenshteinDistanceSearch levenshteinDistanceSearch =
                applicationContext.getBean("wagnerFischerDistanceSearch", LevenshteinDistanceSearch.class);
        return levenshteinDistanceSearch.getDistance(stringSearchEntity.getText(), stringSearchEntity.getSample());
    }

    @GetMapping("/lis")
    @ResponseBody
    public int lis(@RequestBody ListSearchEntity listSearchEntity){
        SequenceSearch sequenceSearch =
                applicationContext.getBean("longestIncreasingSequence", SequenceSearch.class);
        return sequenceSearch.getSequenceLength(listSearchEntity.getData());
    }

    @GetMapping("/landau-vishkin")
    @ResponseBody
    public List<Integer> getIndexesOfMatchingSubstrings(
            @RequestBody StringSearchEntity stringSearchEntity,
            @RequestParam(value = "mismatchAmount", required = true) int mismatchAmount){
        MismatchSearch landauVishkinAlgorithm =
                applicationContext.getBean("landauVishkinAlgorithm", MismatchSearch.class);
        return landauVishkinAlgorithm
                .getIndexesOfMatchingSubstrings(mismatchAmount, stringSearchEntity.getSample(), stringSearchEntity.getText());
    }

    @GetMapping("/largest-repeated-substring")
    @ResponseBody
    public String findLargestSubstring(@RequestBody StringSearchEntity stringSearchEntity){
        LargestSubstringSearch largestSubstringSearch =
                applicationContext.getBean("naiveLargestSubstringSearch", LargestSubstringSearch.class);
        return largestSubstringSearch.getLargestSubsequence(stringSearchEntity.getText());
    }

    // TODO: 23.04.2021 algorithms 5?

    
}
