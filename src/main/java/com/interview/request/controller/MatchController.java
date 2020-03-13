package com.interview.request.controller;

import com.interview.request.domain.CommonResult;
import com.interview.request.unit.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestController
public class MatchController {

    @Autowired
    private MatchService matchService;

    @GetMapping("/anagrams/{string1}/{string2}")
    public CommonResult anagramsMatch(@PathVariable("string1") String str1, @PathVariable("string2") String str2) {

        //if the request string is invalid, HTTP STATUS 400 with bad request will be returned automatically
        boolean isAnagramsMatch = matchService.isAnagramsMatch(str1, str2);

        return new CommonResult(200, "OK", String.format("areAnagrams: %s", isAnagramsMatch));

    }

    @GetMapping("/anagrams/{string}")
    public CommonResult listAnagramsCandidate(@PathVariable("string") String string) {
        Map<String, Set<String>> map = new HashMap<>();
        Set<String> results = matchService.listAnagramsCandidate(string);
        map.put("anagrams: ", results);
        return new CommonResult(200, "OK", map);
    }

}
