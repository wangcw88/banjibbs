package com.dianziban.bbs;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class Test{

    public void aaa() {
        for(int i =0;i<4;i++) {
            for (int j = 0; j < 5; j++) {
                if (j == 0) {
                    System.out.println("ok");
                } else if (i == 0) {
                    System.out.println("false");
                }
                else {
                    System.out.println((int)Math.pow(2,2));

                }
            }
        }

    }

    @org.junit.Test
    public void show(){
        List<Integer> squareList = generateSquareList(100);
        for(int square : squareList){
            System.out.println(Integer.MAX_VALUE);
        }
    }
    public List<Integer> generateSquareList(int n){
        List<Integer> squareList = new ArrayList<>();
        int i =1;
        int square=1;
        while(square<=n){
            squareList.add(square);
            i++;
            square=(int)Math.pow(i,2);
        }
        return squareList;
    }





}
