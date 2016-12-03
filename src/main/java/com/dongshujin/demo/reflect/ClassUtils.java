package com.dongshujin.demo.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by dongsj on 16/12/2.
 */
public class ClassUtils {

    /**
     * 获取成员变量
     *
     * @param obj
     */
    public static void getClassField(Object obj) {
        Class c = obj.getClass();
        Field[] fs = c.getDeclaredFields();// c.getMethods();
        for (Field f : fs) {
            Class fieldType = f.getType();
            System.out.println("fieldTypeName: "+fieldType.getName());
            System.out.println("fieldName: " + f.getName());
            System.out.println();
        }
    }

    /**
     * 获取所有的成员方法
     *
     * @param obj
     */
    public static void getClassMethods(Object obj) {
        Class c = obj.getClass();
        System.out.println("类名为：" + c.getName());
        Method[] ms = c.getDeclaredMethods();

        for (Method m : ms) {
            System.out.print("Method: ");
            Class returnType = m.getReturnType();
            //返回值的类类型，如String-->String.class
            System.out.print(returnType.getName() + " ");
            //方法名称
            System.out.print(m.getName() + "(");
            //获取参数--参数列表的类类型
            Class[] paramTypes = m.getParameterTypes();
            int paramsNum = paramTypes.length;
            Class paramType;
            for (int i = 0; i < paramsNum; i++) {
                paramType = paramTypes[i];
                if (i == 0 || (i == paramsNum - 1))
                    System.out.print(paramType.getName());
                else
                    System.out.print(paramType.getName() + " ,");
            }
            System.out.println(")");
        }
    }

    /**
     * 获取所有的构造函数
     *
     * @param obj
     */
    public static void printConMessage(Object obj) {
        Class c = obj.getClass();
        Constructor[] cs = c.getDeclaredConstructors();
        for (Constructor constructor : cs) {
            System.out.print(constructor.getName() + " (");
            Class[] paramTypes = constructor.getParameterTypes();
            int paramsNum = paramTypes.length;
            Class paramType;
            for (int i = 0; i < paramsNum; i++) {
                paramType = paramTypes[i];
                if (i == 0 || (i == paramsNum - 1))
                    System.out.print(paramType.getName());
                else
                    System.out.print(paramType.getName() + " ,");
            }
            System.out.println(")");
        }
    }

    public static void main(String[] args) {
        //ClassUtils.getClassField("A String obj");

        //ClassUtils.getClassMethods("A String obj");

        ClassUtils.printConMessage("A String obj");
    }
}
