package productmode;

/**
 * 代理模式。
 *
 * @author lvyue
 * @since 2021/1/26
 */
public class ProxyMode {
    public static void main(String[] args) {
        Image image = new ProxyImage("test.jpg");
        image.display();
        System.out.println("===");
        image.display();
    }
}

interface Image {
    void display();
}

class RealImage implements Image {

    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }

    public void loadFromDisk(String fileName) {
        System.out.println("Loading " + fileName);
    }
}

class ProxyImage implements Image {

    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}