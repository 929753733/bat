/**
 * 自增变量.
 * 1.赋值=，最后计算。
 * 2.=右边的从左到右加载至依次压入操作数栈。
 * 3.实际先算哪个，看运算符优先级。
 * 4.自增、自减操作都是直接修改变量的值，不经过操作数栈。
 * 5.最后的赋值之前，临时结果也是存储在操作数栈中。
 *
 * @author lvyue
 * @since 2020/8/16
 */
public class AutoregressiveVariableDemo {

    public static void main(String[] args) {
        int i = 1;
        i = i++;
        int j = i++;
        int k = i + ++i * i++;
        System.out.println("i=" + i);
        System.out.println("j=" + j);
        System.out.println("k=" + k);
    }
}
