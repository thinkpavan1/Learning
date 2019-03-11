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
package java8features.enums;


/**
 * @author champ
 * @version $ 10/8/2018
 */
public enum ModelTypes {
    ADM("adm"),OXL("oxl");

    private String modelType;

    ModelTypes(String modelType){
        this.modelType = modelType;
    }

    @Override
    public String toString() {
        return modelType;
    }
}


class Test{
    public static void main(String[] args) {
        ModelTypes  x = ModelTypes.ADM;
        if( x.equals(ModelTypes.ADM)){
            System.out.println("this is " + x);
        }

        System.out.println(x.name());
    }
}