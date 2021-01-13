package productmode;

/**
 * @author lvyue
 * @since 2021/1/9
 */
public class SimpleFactoryMode {
    public static void main(String[] args) {
        Factory.Manufacture("A").show();
    }
}

/**
 * 抽象产品类
 */
abstract class Product {
    public abstract void show();
}

/**
 * 具体产品类A
 */
class ProductA extends Product {

    @Override
    public void show() {
        System.out.println("生产出了产品A");
    }
}

/**
 * 具体产品类B
 */
class ProductB extends Product {

    @Override
    public void show() {
        System.out.println("生产出了产品B");
    }
}

/**
 * 具体产品类C
 */
class ProductC extends Product {

    @Override
    public void show() {
        System.out.println("生产出了产品C");
    }
}

/**
 * 工厂类
 */
class Factory {
    public static Product Manufacture(String productName) {
        switch (productName) {
            case "A":
                return new ProductA();
            case "B":
                return new ProductB();
            case "C":
                return new ProductC();
            default:
                return null;
        }
    }
}
