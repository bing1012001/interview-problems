package com.interview.request.integrationTest.controller;

import com.interview.request.controller.MatchController;
import com.interview.request.domain.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class MatchControllerIntegrationTest {

    @Autowired
    private MatchController matchController;

    @Test
    public void listAnagramsCandidateTest() {
        CommonResult result = matchController.listAnagramsCandidate("test1");
        Assert.assertNotNull(result);
        Assert.assertEquals(Integer.valueOf(200), result.getCode());
        Assert.assertEquals("OK", result.getMsg());
        Assert.assertTrue( result.getResult() instanceof HashMap);
        Map<String, Set> map = (HashMap<String, Set>)result.getResult();
        Assert.assertEquals(1, map.size());
        map.entrySet().stream()
                        .filter( x -> x.getKey().equals("anagrams: "))
                        .flatMap(x -> x.getValue().stream())
                        .forEach( y -> {
                            Assert.assertTrue(matchController.anagramsMatch("test1", String.valueOf(y)).getResult().toString().equals("areAnagrams: true"));
                        });

    }

    @Test
    public void anagramsMatchTest() {
        CommonResult result = matchController.anagramsMatch("test1", "test2");
        Assert.assertEquals("areAnagrams: false", result.getResult().toString());
        result = matchController.anagramsMatch("test1", "test1");
        Assert.assertEquals("areAnagrams: true", result.getResult().toString());
    }
}
