package com.example.search_lab.algorithm.text;

import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
public final class SimpleSubsequenceSearch implements TextSubsequenceSearch {

    @Override
    public Map<Character, Integer> search(String text, String sample) {
        Map<Character, Integer> out = new LinkedHashMap<>();
        if(text == null || text.isEmpty() || sample == null || sample.isEmpty()){
            return out;
        }
        int sampleIndex = 0;
        for(int textIndex = 0; textIndex < text.length(); textIndex++){
            if(sampleIndex == sample.length()){
                break;
            }
            char nextTextChar = text.charAt(textIndex);
            char nextSampleChar = sample.charAt(sampleIndex);
            if(nextTextChar == nextSampleChar){
                out.put(nextTextChar, textIndex);
                sampleIndex++;
            }
        }
        return out;
    }
}
