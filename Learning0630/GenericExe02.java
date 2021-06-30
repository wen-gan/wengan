package com.wengan.Learning0630;

import javax.jws.soap.SOAPBinding;
import javax.swing.*;
import java.util.*;

/**
 * @author 文淦
 * @version 1.0
 */
public class GenericExe02 {
    public static void main(String[] args) {
        DAO<User> dao = new DAO<>();

        dao.save("001", new User(1,18, "jack"));
        dao.save("002", new User(2,24, "smith"));
        dao.save("003", new User(3,67, "tom"));

//        System.out.println(dao);
//        dao.list();
        System.out.println(dao.list());
    }
}


class DAO<T> {
    private Map<String, T> map = new HashMap<>();

    public void save(String id, T entity) {
        map.put(id, entity);
    }

    public T get(String id) {
        return map.get(id);
    }

    public void update(String id, T entity) {
        map.put(id, entity);
    }

    public List<T> list(){//遍历输出
        List<T> list = new ArrayList<>();

        //遍历List
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
//            System.out.println(key + "---" + map.get(key));
            list.add(map.get(key));
        }

        return list;
    }

    public void delete(String id) {
        map.remove(id);
    }
}

class User {
    private int id;
    private int age;
    private String name;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}