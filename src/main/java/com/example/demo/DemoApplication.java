package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Scanner;

//@EnableSwagger2
//@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();
//        String[][] array = new String[num][];
//        for(int i = 0; i < num; i++){
//            Scanner sc1 = new Scanner(System.in);
//            String hang = sc1.next();
////            String [] arr = hang.split(" ");
////            for(int j = 0; j < 2; j++) {
////                System.out.println(arr[j]);
////            }
//            array[i] = hang.split(" ");
//        }
//        for(int i = 0; i < num; i++) {
//            for(int j = 0; j < 3; j++) {
//                System.out.println(array[i][j]);
//            }
//        }
//    }
//    public static void sortArr(Object obj1, Object obj2){
//        Object a = new Object;
//        a = obj1;
//        obj1 = obj2;
//        obj2 = a;
//    }

}
