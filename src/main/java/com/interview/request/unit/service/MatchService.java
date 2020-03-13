package com.interview.request.unit.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
public class MatchService {

    public boolean isAnagramsMatch(String str1, String str2) {

        String s1 = str1.replaceAll("\\s", "");
        String s2 = str2.replaceAll("\\s","");

        if (s1.length() != s2.length()) {
            return false;
        }

        char[] array1 = s1.toLowerCase().toCharArray();
        char[] array2 = s2.toLowerCase().toCharArray();

        Arrays.sort(array1);
        Arrays.sort(array2);

        if(Arrays.equals(array1, array2)) {
            return true;
        }
        return false;
    }

    public Set<String> listAnagramsCandidate(String str) {
        String s = str.toLowerCase();
        Set<String> set = new HashSet<>();
        return assembleAnagrams("", s, set);



    }

    private Set<String> assembleAnagrams(String s1, String s2, Set<String> set) {
        if (s2.length() <= 1) {
            set.add(s1+s2);
        } else {
            for (int i = 0; i < s2.length(); i++) {
                String x = s2.substring(i, i + 1);
                String y = s2.substring(0, i);
                String z = s2.substring(i + 1);
                assembleAnagrams(s1 + x, y + z, set);
            }
        }
        return set;
    }
}
