package org.hhs;

import org.hhs.vo.User;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.sql.ResultSet;

/**
 * Created by hewater on 2017/8/30.
 */
public class Adapter<T> {
    private ResultSet resultSet;
    private Class<?> cls;
    private Object resultObj;

    public Adapter(ResultSet resultSet, Class<?> cls) {
        this.resultSet = resultSet;
        this.cls = cls;
    }

    public Field[] getFields(){
        return cls.getDeclaredFields();
    }

    public Object getResultObj() {
        Object object = null;
        try {
            object = this.cls.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return object;
    }

    public void setValues() {
        this.resultObj = getResultObj();
        for (Field field : getFields()){
            field.setAccessible(true);
            String fieldName = field.getName();
            String methodName = "get"+getClassName(field.getType().getName());
            try {
                field.set(this.resultObj,
                          invokeMethod(this.resultSet,
                                       getResultSetMethod(methodName, field),
                                        new Object[]{fieldName.toLowerCase()}));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public Method getResultSetMethod(String methodName, Field field){
        Method method = null;
        try {
            method =  resultSet.getClass().getMethod(methodName, new Class[]{String.class});
        } catch (NoSuchMethodException e) {
            try {
                method =  resultSet.getClass().getMethod(methodName, new Class[]{field.getType()});
            } catch (NoSuchMethodException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        return method;
    }

    public Object invokeMethod(Object obj, Method method, Object...args){
        Object result = null;
        method.setAccessible(true);
        try {
            result = method.invoke(obj, args);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return result;
    }

    public String getClassName(String str){
        if(!str.contains(".")){
            return str.substring(0,1).toUpperCase()+str.substring(1);
        }
        int length = str.split("\\.").length-1;
        return str.split("\\.")[length];
    }

    public T getObj(){
        setValues();
        return (T) this.resultObj;
    }

}
