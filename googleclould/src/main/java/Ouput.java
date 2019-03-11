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


import java.util.Optional;

/**
 * @author champ
 * @version $ 10/11/2018
 */
public class Ouput {
    public static void main(String[] args) {
        Optional<String> o = Optional.empty();
        System.out.println(o.isPresent());

        Test t = new Test();
        String n = t.getName();
        System.out.println(n);
        n = "1";
        System.out.println(t.getName());
    }

    static class Test{
        private String name = "Test";

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
