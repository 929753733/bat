/**
 * @author lvyue
 * @since 2021/1/11
 */
public class TemplateMethodMode {
    public static void main(String[] args) {
        AbstractClass abstractClass = new ConcreteClass();
        abstractClass.TemplateMethod();
    }

}


abstract class AbstractClass {
    public void TemplateMethod() {
        SpecificMethod();
        abstractMethod1();
        abstractMethod2();
    }

    public void SpecificMethod() {
        System.out.println("抽象类中的具体方法被调用！");
    }

    public abstract void abstractMethod1();

    public abstract void abstractMethod2();
}

class ConcreteClass extends AbstractClass {

    @Override
    public void abstractMethod1() {
        System.out.println("抽象方法1的实现被调用...");
    }

    @Override
    public void abstractMethod2() {
        System.out.println("抽象方法2的实现被调用...");
    }
}
