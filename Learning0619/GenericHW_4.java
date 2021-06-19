package com.wengan.Learning0619;

import java.util.*;

/**
 * @author 文淦
 * @version 1.0
 */
public class GenericHW_4 {
    public static void main(String[] args){
        DAO<User> dao = new DAO<User>();
        dao.save("001", new User(1, 22,"jack"));
        dao.save("002", new User(2, 23,"mike"));
        dao.save("003", new User(3, 24,"tom"));

        List<User> list = dao.list();
        System.out.println("===修改前===");
        System.out.println("list = " + list);
        dao.delete("003");
        list = dao.list();
        System.out.println("===修改后===");
        System.out.println("list = " + list);
    }
}

class DAO<T>{
    private Map<String, T> map = new HashMap<String, T>();

    public void save(String id, T entity){
        map.put(id, entity);
    }
    public T get(String id){
        return map.get(id);
    }
    public void update(String id, T entity){
        map.put(id, entity);
    }

    public List<T>list() {
        //遍历map[k-v]
        List<T> list = new ArrayList<>();

        //遍历map
        Set<String> keySet = map.keySet();
        for (String key : keySet){
            //map.get(key) 返回的就是 User对象--->放到ArrayList
            list.add(map.get(key));
        }
        return list;
    }
    public void delete(String id) {
        map.remove(id);
    }

}
class User{
    private int id;
    private int age;
    private String name;

    @Override
    public String toString() {
        return id + "，" + age + "，" + name;
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
