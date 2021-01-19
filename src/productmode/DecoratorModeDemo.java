package productmode;

/**
 * 装饰模式。
 * 抽象组件Component类就可以是抽象类Person，而ConcreteComponent类就可以是具体的一个人Calvin，也是要被装饰的对象。
 * 抽象装饰类Decorator持有了Calvin的引用，并且回调了Calvin本身的一个“穿内裤”的行为，
 * 并且在具体的装饰类中，即“冬夏”两个类中，分别为主人公Calvin穿上了毛裤和短裤，为对象增加了额外的功能。
 * 代码如下所示。
 * <p>
 * Decorator Pattern
 * Created by Calvin on 2017/5/10.
 */
public class DecoratorModeDemo {
    public static void main(String[] args) {
        Person calvin = new Calvin();
        PersonCloth summerCloth = new SummerCloth(calvin);
        PersonCloth winterCloth = new WinterCloth(calvin);
        summerCloth.dressed();
        winterCloth.dressed();
    }

    public static abstract class Person {
        public abstract void dressed();
    }

    public static class Calvin extends Person {
        @Override
        public void dressed() {
            System.out.println("穿件内裤");
        }
    }

    public static abstract class PersonCloth extends Person {
        Person myPerson;

        public PersonCloth(Person myPerson) {
            this.myPerson = myPerson;
        }

        @Override
        public void dressed() {
            myPerson.dressed();
        }
    }

    public static class SummerCloth extends PersonCloth {

        public SummerCloth(Person myPerson) {
            super(myPerson);
        }

        @Override
        public void dressed() {
            super.dressed();
            System.out.println("穿件短裤");
        }
    }

    public static class WinterCloth extends PersonCloth {

        public WinterCloth(Person myPerson) {
            super(myPerson);
        }

        @Override
        public void dressed() {
            super.dressed();
            System.out.println("穿件毛裤");
        }
    }
}