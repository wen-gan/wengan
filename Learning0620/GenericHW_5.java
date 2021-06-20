package com.wengan.Learning0620;

import javax.jws.soap.SOAPBinding;
import java.util.*;

/**
 * @author 文淦
 * @version 1.0
 */
public class GenericHW_5 {
    public static void main(String[] args){
        User user1 = new User(1, 22, "jack");
        User user2 = new User(2, 25, "mike");
        User user3 = new User(3, 17, "smith");

        DAO<User> dao = new DAO<User>();
        dao.saving("001",user1);
        dao.saving("002",user2);
        dao.saving("003",user3);
        System.out.println("===原始数据===");
        System.out.println(dao);

        List list1 = dao.list();
        System.out.println(list1);

        dao.delete("002");
        System.out.println(dao);

        System.out.println(dao.get("003"));
    }
}

class DAO<T>{
    private Map<String, T> map = new HashMap<>();

    @Override
    public String toString() {
        return "DAO{" +
                "map=" + map +
                '}';
    }

    public void saving(String id, T entity){
        map.put(id, entity);
    }
    public T get(String id){
        return map.get(id);
    }
    public void update(String id, T entity){
        map.put(id, entity);
    }
    public List<T> list(){
        //遍历map，将map的所有value(entity)封装到ArrayList返回即可
        List<T> list = new ArrayList<>();

        //遍历map存放到List中
//        Set<String> keySet = map.keySet();
//        for (String key : keySet) {
//            list.add(get(key));
//        }

        //用values
        Collection<T> values = map.values();
        for (T t : values) {
            list.add(t);
        }
        return list;
    }

    public void delete(String id){
        map.remove(id);
    }
}

class User{
    private int id;
    private int age;
    private String name;

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
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