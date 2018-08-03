package guava;

import com.google.common.base.Joiner;
import org.junit.Assert;
import org.junit.Test;

public class StringUtilities {
    final String[] STRING_ARRAY = {"Harry", null, "Ron", "Hermione"};

    @Test
    public void testJoiner(){
        Joiner joiner = Joiner.on ( ";" ).skipNulls ();
        String retValue = joiner.join ( STRING_ARRAY );
        Assert.assertEquals ( "Harry;Ron;Hermione", retValue);
    }
}
