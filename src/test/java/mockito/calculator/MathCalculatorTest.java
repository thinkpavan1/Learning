package mockito.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.when;


public class MathCalculatorTest {

    @InjectMocks
    public MathCalculator mathApplication = new MathCalculator();
    @Mock
    CalculatorService calcService;

    @Test
    public void testAdd(){
        when(calcService.add(10.0,20.0)).thenReturn(30.00);
        Assert.assertEquals(mathApplication.add(10.0, 20.0),30.0,0);
    }
}