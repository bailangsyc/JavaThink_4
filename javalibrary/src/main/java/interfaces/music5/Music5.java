package interfaces.music4.music5;

import com.sun.org.apache.xpath.internal.SourceTree;

import polymorphism.music.Note;

/**
 * P173
 * Created by shao on 2017/7/4.
 */
public class Music5 {
    public static void main(String[] args) {
        //new 一个乐器的数组 orchestra乐队
        Instrument[] orchestra = {

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
            i.play(Note.MIDDLE_C);
        }
    }
}

interface Instrument {
    int VALUE = 5;//static & final  静态的 final

    void play(Note note);//不声明 默认就是pulic的

    void  adjust();
}

class Wind implements Instrument {
    @Override
    public void play(Note note) {
        System.out.println(this + " play()" + note);
    }

    @Override
    /**
     * 打印自己（this）的时候会调用此方法
     */
    public String toString() {
        return "Wind";
    }

    @Override
    public void adjust() {
        System.out.println(this + "adjust()");
    }
}

class Percussion implements Instrument {
    @Override
    public void play(Note note) {
        System.out.println(this + " play()" + note);
    }

    @Override
    public void adjust() {
        System.out.println(this + "adjust()" );
    }

    @Override
    public String toString() {
        return "Percussion";
    }
}

class Stringed implements Instrument {
    @Override
    public void play(Note note) {
        System.out.println( this + " play()" + note);
    }

    @Override
    public void adjust() {
        System.out.println( this + "adjust()" );
    }

    @Override
    public String toString() {
        return "Stringed";
    }
}

class WoodWind extends Wind {
    @Override
    public String toString() {
        return "WoodWind";
    }


}

class Brass extends Wind {
    @Override
    public String toString() {
        return "Brass";
    }
}





