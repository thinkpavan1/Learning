package mockito.mockito.doc;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class DocumentationExamples {
    @Test
    public void testJavaList(){
        List mockList = mock(ArrayList.class);
        mockList.add("One");
        mockList.add("Two");

        verify(mockList).add("One");
        verify(mockList).add("Two");
    }

}
