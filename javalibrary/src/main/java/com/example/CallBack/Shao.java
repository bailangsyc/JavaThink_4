package com.example.CallBack;

import javax.sound.midi.Soundbank;

/**
 * shao 问   zhu 问题 和小王问小李问题一模一样
 * 练习回调的使用 只不过自己没有使用接口
 * Created by shao on 2017/7/11.
 */
public class Shao {
    private  Zhu zhu;
    public Shao (Zhu zhu) {
            this.zhu = zhu;
    }

    /**
     * shao 问朱一个问题
     *
     * @param question
     */
    public void askQeustion(String question) {
               System.out.println("shao 问zhu一个问题");
       new Thread(new Runnable() {
           @Override
           public void run() {
               //将自己的引用 和问题传递过去
               zhu.excute( Shao.this, question);
           }
       }).start();
        //自己去玩了
        play();
    }

    //去逛街
    private void play() {
        System.out.println("zhu现在在忙，shao先去逛街");
    }

    public void result(String resutlt){
        System.out.println(resutlt);
    }

    public static void main(String[] args) {
        Zhu zhu = new Zhu();
        Shao shao = new Shao(zhu);
        shao.askQeustion("1 + 1 = ?");
    }


}
