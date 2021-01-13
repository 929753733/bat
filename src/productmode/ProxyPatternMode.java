package productmode;

/**
 * @author lvyue
 * @since 2021/1/9
 */
public class ProxyPatternMode {
}

interface Subject{
    public void buyMac();
}

class RealSubject implements Subject{

    @Override
    public void buyMac() {
        System.out.println("买一台Mac");
    }
}

class Proxy implements Subject{

    @Override
    public void buyMac() {
        RealSubject realSubject = new RealSubject();
        realSubject.buyMac();
    }
}
