package interfaces.music4;

import javax.sound.midi.Soundbank;

import polymorphism.music.Note;

/**
 *
 * java编程 P170
 * Created by shao on 2017/7/4.
 */

public class Music4 {
    public static void main(String[] args) {
        //new 一个乐器的数组 orchestra乐队
        Instrument[] orchestra = {
                //这里边都发生了向上转型
                new Wind(),
                new Percussion(),
                new Stringed(),
                new WoodWind(),
                new Brass()
        };

        tuneAll(orchestra);

    }

    private static void tuneAll(Instrument[] orchestra) {
        for (Instrument i : orchestra) {
            i.play(Note.MIDDLE_C);//在此处又发生了向下转型 因为动态绑定，所以它会自动调用对应子类的方法
        }
    }


}

//Instrument 乐器
abstract class Instrument {
    private int i;

    public abstract void play(Note n);

    public abstract void adjust();

    public String what() {
        return "Instrument";
    }
}

/**
 * Wind 管乐
 */
class Wind extends Instrument {

    @Override
    public void play(Note n) {
        System.out.println("Wind.play()" + n);
    }

    @Override
    public void adjust() {

    }


    public String what() {
        return "Wind";
    }
}

/**
 * Percussion 打击乐器
 */
class Percussion extends Instrument {
    @Override
    public void play(Note n) {
        System.out.println("Percussion.play()" + n);
    }

    public String what() {
        return "Percussion";
    }

    @Override
    public void adjust() {

    }
}

/**
 * Stringed 弦乐器
 */
class Stringed extends Instrument {
    @Override
    public void play(Note n) {
        System.out.println("Stringed.play()" + n);
    }

    public String what() {
        return "Stringed";
    }

    @Override
    public void adjust() {

    }
}

/**
 * WoodWind 木管乐器
 */
class WoodWind extends Wind {

    public void play(Note note) {
        System.out.println("WoodWind.play()" + note);
    }

    public String what() {
        return "WoodWind";
    }

}

/**
 * Brass 铜管乐器
 */
class Brass extends Wind {
    public void play(Note note) {
        System.out.println("Brass.play()" + note);
    }

    @Override
    public void adjust() {
        System.out.println("Brass.adjust()");
    }

}






