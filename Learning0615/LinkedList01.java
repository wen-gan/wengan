package com.wengan.List;

/**
 * @author 文淦
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class LinkedList01 {
    public static void main(String[] args){
        //模拟一个简单的双向链表
        Node jack = new Node("jack");
        Node tom = new Node("tom");
        Node Gan = new Node("Gan");

        //连接三个节点，形成双向链表
        jack.next = tom;
        tom.next = Gan;
        //Gan --> tom --> jack
        Gan.pre = tom;
        tom.pre = jack;

        Node first = jack;//让first引用指向jack，就是双向链表的头节点
        Node last = Gan;//让last引用指向Gan，就是双向链表的尾节点

        //从头到尾进行遍历
        System.out.println("====从头到尾进行遍历====");
        while (true){
            if(first == null){
                break;
            }
            //输出first 信息
            System.out.println(first);
            first = first.next;
        }

        //从尾到头的遍历
        System.out.println("====从尾到头的遍历====");
        while (true) {
            if (last == null){
                break;
            }
            //输出last 信息
            System.out.println(last);
            last = last.pre;
        }

        //在tom和Gan之间插入一个对象 smith
        Node smith = new Node("smith");
        //下面就把smith加入到双向链表中了
        smith.next = Gan;
        smith.pre = tom;
        tom.next = smith;
        Gan.pre = smith;

        //让first 再次指向jack
        first = jack;
        System.out.println("====从尾到头的遍历====");
        while (true){
            if(first == null){
                break;
            }
            //输出first 信息
            System.out.println(first);
            first = first.next;
        }

    }
}

//定义一个Node 类，Node 表示双向链表的一个节点
class Node {
    public Object item; //真正存放数据
    public Node next; //指向后一个节点
    public Node pre; //指向前一个节点
    public Node(Object name){
        this.item = name;
    }
    @Override
    public String toString() {
        return "Note name = " + item;
    }
}
