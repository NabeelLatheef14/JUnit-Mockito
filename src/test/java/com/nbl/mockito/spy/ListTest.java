package com.nbl.mockito.spy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ListTest {

    @Spy
    List<String> myList = new ArrayList<>();

    @BeforeEach
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test(){
        myList.add("Nabeel");
        myList.add("Shafna");

        Mockito.doReturn(3).when(myList).size();
        Assertions.assertSame(3, myList.size());
    }

}
