package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 341. 扁平化嵌套列表迭代器
 * 给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。
 * 列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。
 *
 * @author lvyue
 */
public class ThreeFourOne implements Iterator<Integer> {

    private List<Integer> vals;
    private Iterator<Integer> cur;

    public ThreeFourOne(List<NestedInteger> nestedIntegers) {
        vals = new ArrayList<Integer>();
        dfs(nestedIntegers);
        cur = vals.iterator();
    }



    @Override
    public boolean hasNext() {
        return cur.hasNext();
    }

    @Override
    public Integer next() {
        return cur.next();
    }

    private void dfs(List<NestedInteger> nestedList) {
        for (NestedInteger nest : nestedList) {
            if (nest.isInteger()) {
                vals.add(nest.getInteger());
            } else {
                dfs(nest.getList());
            }
        }
    }

    public static void main(String[] args) {

    }
}

interface NestedInteger {

    /**
     * @return true if this NestedInteger holds a single integer, rather than a nested list.
     */
    public boolean isInteger();

    /**
     * @return the single integer that this NestedInteger holds, if it holds a single integer
     * Return null if this NestedInteger holds a nested list
     */
    public Integer getInteger();

    /**
     * @return the nested list that this NestedInteger holds, if it holds a nested list
     */
    public List<NestedInteger> getList();
}
