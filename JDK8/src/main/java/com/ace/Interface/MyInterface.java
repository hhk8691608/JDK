package com.ace.Interface;

public interface MyInterface {

    default String getName(){
        return "hello";
    }

    static void show(){
        System.out.println("接口中的静态方法");
    }

}
