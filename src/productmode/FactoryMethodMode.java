package productmode;

/**
 * @author lvyue
 * @since 2021/1/9
 */
public class FactoryMethodMode {

    public static void main(String[] args) {
        // 需要产品A
        FmFactory fmFactoryA = new FmFactoryA();
        fmFactoryA.manufacture().show();

        // 需要产品B
        FmFactory fmFactoryB = new FmFactoryB();
        fmFactoryB.manufacture().show();
    }

}

/**
 * 抽象产品类，定义具体产品的公共接口。
 */
abstract class FmProduct {
    public abstract void show();
}

/**
 * 抽象工厂类，定义具体工厂的公共接口。
 */
abstract class FmFactory {
    public abstract FmProduct manufacture();
}


/**
 * 具体产品类A
 */
class FmProductA extends FmProduct {

    @Override
    public void show() {
        System.out.println("生产出了产品A");
    }
}

/**
 * 具体产品类B
 */
class FmProductB extends FmProduct {

    @Override
    public void show() {
        System.out.println("生产出了产品B");
    }
}

/**
 * 具体工厂类A
 */
class FmFactoryA extends FmFactory {

    @Override
    public FmProduct manufacture() {
        return new FmProductA();
    }
}

/**
 * 具体工厂类B
 */
class FmFactoryB extends FmFactory {

    @Override
    public FmProduct manufacture() {
        return new FmProductB();
    }
}
