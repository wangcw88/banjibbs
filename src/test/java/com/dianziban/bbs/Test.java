package com.dianziban.bbs;

public class Test extends Thread implements Runnable{
    public void run(){
        System.out.println(" this is run()");
    }
    public static void main(String[] args) {
        Thread t = new Thread(new Test());
        t.start();
    }



}
