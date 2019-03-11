/*
 * $
 *
 * Copyright (c) 2018  Pegasystems Inc.
 * All rights reserved.
 *
 * This  software  has  been  provided pursuant  to  a  License
 * Agreement  containing  restrictions on  its  use.   The  software
 * contains  valuable  trade secrets and proprietary information  of
 * Pegasystems Inc and is protected by  federal   copyright law.  It
 * may  not be copied,  modified,  translated or distributed in  any
 * form or medium,  disclosed to third parties or used in any manner
 * not provided for in  said  License Agreement except with  written
 * authorization from Pegasystems Inc.
 */
package java8features.streams;


import com.google.common.base.Function;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.*;

/**
 * @author champ
 * @version $ 9/28/2018
 */
public class StringAndStream
{


    public static void main(String[] args) {
        final List<Employee> employeeList = Employee.getEmployeeList();
        final List<Clipboard> csvList = Lists.newArrayList();
        csvList.add( new Clipboard(("1,2,3")));
        csvList.add( new Clipboard());

        List<String[]> csvValues = csvList.stream().map(Clipboard::getCsv).filter(Objects::nonNull).map(index -> index.split(",")).collect(Collectors.toList());



    }



    private static void nullCheckTest() {
        String test =null;
        if( Objects.nonNull(test)){
            System.out.println("not null value");
        }
        if(StringUtils.isEmpty(test)){
            System.out.println("Empty String");
        }
    }


    private static void collectStringFromListofObject() {
        final List<Employee> employeeList = Employee.getEmployeeList();
        String joinValue = String.join(",",employeeList.stream().map(Employee::getName).collect(Collectors.toList()));
        System.out.println(joinValue);

        String result = employeeList.stream().map(Employee::getName).collect(Collectors.joining(","));
        System.out.println(result);
    }
}
