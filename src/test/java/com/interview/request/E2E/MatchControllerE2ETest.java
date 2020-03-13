package com.interview.request.E2E;


import com.interview.request.domain.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class MatchControllerE2ETest {

    private RestTemplate restTemplate;

    @Before
    public void setUp() {
        restTemplate = new RestTemplate();
        Assert.assertNotNull(restTemplate);
    }

    @Test
    public void anagramsMatchTest() {
        CommonResult commonResult = restTemplate.getForObject("http://localhost:8080/anagrams/test1/test2", CommonResult.class);
        Assert.assertNotNull(commonResult);
        Assert.assertEquals(Integer.valueOf(200), commonResult.getCode());
        Assert.assertEquals("OK", commonResult.getMsg());
        Assert.assertEquals("areAnagrams: true", commonResult.getResult());
    }

    @Test
    public void listAnagramsCandidateTest() {
        CommonResult commonResult = restTemplate.getForObject("http://localhost:8080/anagrams/test1", CommonResult.class);
        Assert.assertNotNull(commonResult);
        Assert.assertEquals(Integer.valueOf(200), commonResult.getCode());
        Assert.assertEquals("OK", commonResult.getMsg());

    }

}
