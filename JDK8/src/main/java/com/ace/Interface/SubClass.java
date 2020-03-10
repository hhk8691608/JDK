package com.ace.Interface;

/***
 *
 *@Author Mark
 *@Date 2020/3/10 14 02
 *@Source 慕课网
 *@Desciption
 */
public class SubClass implements MyInterface,MyFun
{

    public String getName(){
        return "world";
    }

    public static void main(String[] args) {

        SubClass sc = new SubClass();
        System.out.println(sc.getName());

        MyInterface.show();
    }






}
