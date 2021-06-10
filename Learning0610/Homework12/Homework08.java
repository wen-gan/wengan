package com.wengan.Learning0610.Homework12;

/**
 * @author 文淦
 * @version 1.0
 */
public class Homework08 {
    public static void main(String[] args){
        Color color = Color.YELLO;
        color.show();
        switch (color){
            case YELLO:
                System.out.println("匹配到黄色");
                break;
            case GREEN:
                System.out.println("匹配到绿色");
                break;
            case BLACK:
                System.out.println("匹配到黑色");
                break;
            case BLUE:
                System.out.println("匹配到蓝色");
                break;
            case RED:
                System.out.println("匹配到红色");
                break;
            default:
                System.out.println("未匹配到颜色");
                break;
        }

    }
}

enum Color implements Showcase{
    RED(255,0,0),BLUE(0,0,255),BLACK(0,0,0),YELLO(255,0,0),GREEN(0,255,0);

    private int redValue;
    private int greenValue;
    private int blueValue;

    Color(int redValue, int greenValue, int blueValue) {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }

    @Override
    public void show() {
        System.out.println("属性值为" + redValue +","+greenValue+","+blueValue);
    }
}

interface Showcase{
    public void show();
}