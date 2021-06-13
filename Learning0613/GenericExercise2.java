package com.wengan.Learning0612;

import java.util.*;

/**
 * @author 文淦
 * @version 1.0
 */
public class GenericExercise2 {
    public static void main(String[] args){
        DAO<User> dao = new DAO<>();
        dao.save("1",new User(1,20,"jack"));
        dao.save("2",new User(2,21,"john"));
        dao.save("3",new User(3,22,"mike"));

        List<User> list = dao.list();
        System.out.println("list = "+list);

        dao.update("3",new User(3,68,"milan"));
        dao.delete("3");
        list = dao.list();
        System.out.println("===修改后===");
        System.out.println("list = "+list);
    }
}

class DAO<T>{
    private Map<String, T> map = new HashMap<>();

    public void save(String id,T entity){
        map.put(id, entity);
    }

    public T get(String id){
        return map.get(id);
    }

    public void update(String id, T entity){
        map.put(id, entity);
    }
    //遍历map，将mao中所有的value(entity)，封装到Arraylist返回即可
    public List<T> list(){
        //遍历map[k-v]，将map的所有value()封装到ArrayList返回即可
        List<T> list = new ArrayList<>();

        //遍历map
        Set<String> keySet = map.keySet();
        for (String key : keySet){
            //map.get(key) 返回的就是 User对象--->放到ArrayList
            list.add(map.get(key));
        }

        return list;
    }
    //删除数据
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

    @Override
    public String toString() {
        return id +"+"+name+"+"+age;
    }
}