package com.dongshujin.demo.test.reflect;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Created by dongsj on 16/12/2.
 */
public class ReflectTest {


    @Test
    public void testReflect() {
        try {
            TestClass testObj= new TestClass();
            //Class testClz = testObj.getClass();

            //Class testClz = TestClass.class;

            Class testClz = Class.forName("com.dongshujin.demo.test.reflect.TestClass");

            Method method = testClz.getMethod("add", int.class, int.class);
            Object resultObj = method.invoke(testObj, 3, 4);
            System.out.println("testObj.add(3, 4) =  " + resultObj);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testParadigm() {
        ArrayList<String> list1 = new ArrayList<String>();
        ArrayList list2 = new ArrayList();
        list1.add("java reflect");
        //list1.add(100);//报错

        Class c1 = list1.getClass();
        Class c2 = list2.getClass();
        System.out.println("集合类型："+ (c1 == c2));//true
        try {
            Method method = c2.getMethod("add", Object.class);
            method.invoke(list1, 100);
            System.out.println("数组大小："+list1.size());
            System.out.println("数组内容："+list1.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
