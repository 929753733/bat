package StrategyPattern;

/**
 * @author lvyue
 * @since 2021/1/30
 */
public class OperationSubtract implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}
