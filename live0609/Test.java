package com.wengan.live0609;

import java.util.Arrays;
import java.util.Comparator;

public class Test {
    public static void main(String[] args){
        Teacher[] teachers = new Teacher[3];
        teachers[0] = new Lecturer(23, "男", "159", "海淀区", "讲师", "交运", 22000);
        teachers[0] = new Lecturer(23, "男", "159", "海淀区", "讲师", "交运", 25000);
        teachers[0] = new Lecturer(23, "男", "159", "海淀区", "讲师", "交运", 15000);
        Arrays.sort(teachers, new Comparator<Teacher>() {
            @Override
            public int compare(Teacher o1, Teacher o2) {
                return 0;
            }
        });
    }
}
