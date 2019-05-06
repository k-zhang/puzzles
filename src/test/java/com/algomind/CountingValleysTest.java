package com.algomind;

import org.junit.Assert;
import org.junit.Test;

public class CountingValleysTest {
    private CountingValleys countingValleys = new CountingValleys();

    @Test
    public void testOneValley() {
        String input = "UDDDUDUU";
        int result = countingValleys.countingValleys(input.length(), input);
        Assert.assertEquals(1, result);
    }

    @Test
    public void testTwoValley() {
        String input = "UDDDUDUUDDDUDUUU";
        int result = countingValleys.countingValleys(input.length(), input);
        Assert.assertEquals(2, result);
    }

    @Test
    public void testNoValley() {
        String input = "UUUUDDDD";
        int result = countingValleys.countingValleys(input.length(), input);
        Assert.assertEquals(0, result);
    }

    @Test
    public void testTwoStepValley() {
        String input = "DU";
        int result = countingValleys.countingValleys(input.length(), input);
        Assert.assertEquals(1, result);
    }
}