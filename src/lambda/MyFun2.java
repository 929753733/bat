package lambda;

/**
 * @author lvyue
 * @since 2021/2/13
 */
@FunctionalInterface
public interface MyFun2<T, R> {
    public R getValue(T t1, T t2);
}
