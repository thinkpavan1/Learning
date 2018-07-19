package mockito.mockito.doc;


import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

public class VerifyBehaviorTest {
    private List mockedList = mock(List.class);

    @Test
    public void testVerify(){
        mockedList.add("One");
        mockedList.clear();

        verify(mockedList).add("One");
        verify(mockedList).clear();
    }

    @Test
    public void testStubbing(){

        when( mockedList.get(0) ).thenReturn("First");
        when( mockedList.get(1) ).thenReturn("Second");

        assertEquals("First", mockedList.get(0));
        assertEquals("Second", mockedList.get(1));
        assertEquals(null, mockedList.get(999));
    }

    @Test
    public void testArgumentMatcher(){
        when(mockedList.get(anyInt())).thenReturn("Any element");
        assertEquals("Any element", mockedList.get(999));
//        when(mockedList.contains(argThat(new isValid()))).thenReturn("element");
    }

    @Test
    public void testVerifyWithTime(){
        mockedList = mock(LinkedList.class);
        mockedList.add("one");

        mockedList.add("two");
        mockedList.add("two");

        mockedList.add("three");
        mockedList.add("three");
        mockedList.add("three");

        verify(mockedList).add("one");

        verify(mockedList, times(1)).add("one");
        verify(mockedList, times(2)).add("two");
        verify(mockedList, times(3)).add("three");

        verify(mockedList, never()).add("never happened");
        verify(mockedList, atLeast(1)).add("two");
        verify(mockedList, atMost(5)).add("three");
    }

    @Test
    public void testVoidMethods(){
        LinkedList mockedLinkedList = mock(LinkedList.class);
        doThrow(new RuntimeException()).when(mockedList).clear();

        mockedLinkedList.clear();
    }

    @Test
    public void testInOrder(){
        List singleMock = mock(List.class);

        singleMock.add("was added first");
        singleMock.add("was added second");

        InOrder inOrder = inOrder(singleMock);

        inOrder.verify(singleMock).add("was added first");
        inOrder.verify(singleMock).add("was added second");
        List firstMock = mock(List.class);
        List secondMock = mock(List.class);

        //using mocks
        firstMock.add("was called first");
        secondMock.add("was called second");

        //create inOrder object passing any mocks that need to be verified in order
        inOrder = inOrder(firstMock, secondMock);

        //following will make sure that firstMock was called before secondMock
        inOrder.verify(firstMock).add("was called first");
        inOrder.verify(secondMock).add("was called second");
    }

    @Test
    public void testConsecutiveCalls(){
//        when(mock.someMethod("some arg")).thenReturn(new RuntimeException()).thenReturn();
    }

    @Test
    public void testChangeDefatultBehaviorOfUnStubbedInstance(){
        List mock = mock(List.class, Mockito.RETURNS_SMART_NULLS);
        System.out.println(mock.get(0));

    }

    @Test
    public void testResetMock(){
        List mock = mock(List.class);
        when( mock.get(0)).thenReturn("Welcome");

        assertEquals("Welcome", mock.get(0));
        reset(mock);
        assertNull(mock.get(0));
    }

    @Test
    public void testBehaviorDrivenDevelopment(){
        Seller seller = mock(Seller.class);
        Shop shop = mock(Shop.class);

        given(seller.askForBread()).willReturn(new Bread("White"));
        //when
       /* Goods goods = shop.buyBread();

        //then
        assertThat(goods, containBread());*/
    }

    @Test
    public void testSerializingMock(){
        List serializableMock = mock(List.class, withSettings().serializable());
    }

    @Test
    public void testSerializingSpy(){
        List<String> realObject = new ArrayList();
        List spy = mock(ArrayList.class, withSettings().defaultAnswer(CALLS_REAL_METHODS).spiedInstance(realObject).serializable());
    }

    private class Seller {
        public Bread askForBread() {
            return new Bread("White");
        }
    }

    private class Shop {
    }

    private static class Bread  {
        private String color;

        public Bread(String color) {
            this.color = color;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }
    }

    interface Goods {
        List<Goods> askedGoods = new ArrayList<>();


        default void addGoods(Goods object){
            askedGoods.add(object);
        }

        default  boolean containsBread(){
            return askedGoods.contains(new Bread("White"));
        }
    }
}
