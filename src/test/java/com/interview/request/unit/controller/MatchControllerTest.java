package com.interview.request.unit.controller;

import com.interview.request.controller.MatchController;
import com.interview.request.domain.CommonResult;
import com.interview.request.unit.service.MatchService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@RunWith(SpringRunner.class)
public class MatchControllerTest {

    @Mock
    private MatchService matchService;

    @InjectMocks
    private MatchController matchController;


    @Before
    public void setup() {
        Assert.assertNotNull(matchController);
        Assert.assertNotNull(matchService);
    }

    @Test
    public void anagramsMatchTest() {
        String str1 = "test1";
        String str2 = "test2";

        Mockito.when(matchService.isAnagramsMatch(str1, str2)).thenReturn(true);

        CommonResult result = matchController.anagramsMatch(str1, str2);
        Assert.assertNotNull(result);
        Assert.assertEquals(Integer.valueOf(200), result.getCode());
        Assert.assertEquals("OK", result.getMsg());
        Assert.assertEquals("areAnagrams: true", result.getResult());
    }

    @Test
    public void listAnagramsCandidateTest() {
        String str = "test1";
        Set<String> results = new HashSet<>();
        results.add("candidate");

        Mockito.when(matchService.listAnagramsCandidate(str)).thenReturn(results);
        CommonResult result = matchController.listAnagramsCandidate(str);
        Assert.assertNotNull(result);
        Assert.assertEquals(Integer.valueOf(200), result.getCode());
        Assert.assertEquals("OK", result.getMsg());
        Assert.assertNotNull(result.getResult());

    }

}
