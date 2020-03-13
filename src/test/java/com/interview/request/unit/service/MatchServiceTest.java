package com.interview.request.unit.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@Slf4j
@RunWith(SpringRunner.class)
public class MatchServiceTest {

    private MatchService matchService;

    @Before
    public void setup() {
        matchService = Mockito.spy(MatchService.class);
    }


    @Test
    public void isAnagramsMatchTest() {

        boolean isSame = matchService.isAnagramsMatch("test1", "test2");
        Assert.assertFalse(isSame);
        isSame = matchService.isAnagramsMatch("test1", "te st1 ");
        Assert.assertTrue(isSame);
        isSame = matchService.isAnagramsMatch("test1", "test11");
        Assert.assertFalse(isSame);
        isSame = matchService.isAnagramsMatch("TEST1", "test1");
        Assert.assertTrue(isSame);
        isSame = matchService.isAnagramsMatch("", "test2");
        Assert.assertFalse(isSame);
        isSame = matchService.isAnagramsMatch("test1","test1");
        Assert.assertTrue(isSame);
        isSame = matchService.isAnagramsMatch("","");
        Assert.assertTrue(isSame);
        isSame = matchService.isAnagramsMatch(" ", " ");
        Assert.assertTrue(isSame);
        isSame = matchService.isAnagramsMatch("Test1", "1test");
        Assert.assertTrue(isSame);
        isSame = matchService.isAnagramsMatch("Test1", "te1st");
        Assert.assertTrue(isSame);
    }

    @Test
    public void testListAnagramsCandidate () {
        Set<String> set = matchService.listAnagramsCandidate("test1");
        Assert.assertNotNull(set);
        Assert.assertTrue(set.size() > 0);
        for(String str: set) {
            boolean isSame = matchService.isAnagramsMatch(str, "test1");
            Assert.assertTrue(isSame);
        }

    }


}
