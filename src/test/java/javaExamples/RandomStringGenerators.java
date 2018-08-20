package javaExamples;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import java.util.Random;

public class RandomStringGenerators {

    @Test
    public void getRandomInteger(){
        Random r = new Random (  );
        for (int i = 0; i < 10; i++) {
            System.out.println ( r.nextInt ( 50 ) );
        }

    }

    @Test
    public void givenUsingApache_whenGeneratingRandomStringBounded_thenCorrect() {

        int length = 3;
        boolean useLetters = true;
        boolean useNumbers = false;
        for (int i = 0; i < 10; i++) {
            String generatedString = RandomStringUtils.random ( length, useLetters, useNumbers );

            System.out.println ( generatedString );
        }
    }
}
