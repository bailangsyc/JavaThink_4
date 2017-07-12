package com.example.CallBack;

import javax.sound.midi.Soundbank;

/**
 * shao ��   zhu ���� ��С����С������һģһ��
 * ��ϰ�ص���ʹ�� ֻ�����Լ�û��ʹ�ýӿ�
 * Created by shao on 2017/7/11.
 */
public class Shao {
    private  Zhu zhu;
    public Shao (Zhu zhu) {
            this.zhu = zhu;
    }

    /**
     * shao ����һ������
     *
     * @param question
     */
    public void askQeustion(String question) {
               System.out.println("shao ��zhuһ������");
       new Thread(new Runnable() {
           @Override
           public void run() {
               //���Լ������� �����⴫�ݹ�ȥ
               zhu.excute( Shao.this, question);
           }
       }).start();
        //�Լ�ȥ����
        play();
    }

    //ȥ���
    private void play() {
        System.out.println("zhu������æ��shao��ȥ���");
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
