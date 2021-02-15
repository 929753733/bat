package leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * @author lvyue
 * @since 2021/1/23
 */
public class Twenty {

    public static void main(String[] args) {
        String s = "([{}])";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        int two = 2;
        int n = s.length();

        // 如果字符串的长度是奇数，肯定不符合，直接返回false。
        if (n % two == 1) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>(4);
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        /*
          LinkedList集合的底层是链表结构实现的，所以可以模拟栈（先进后出）。
         */
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            Character character = s.charAt(i);
            if (map.containsKey(character)) {
                /*
                  将元素推送到由此列表表示的堆栈上。 换句话说，在该列表的前面插入元素。
                  此方法相当于addFirst(E)。
                 */
                deque.push(map.get(character));
            } else {
                /*
                  peek():检索但不删除此列表的头（第一个元素）。
                 */
                if (deque.isEmpty() || !deque.peek().equals(character)) {
                    return false;
                }
                /*
                  从此列表表示的堆栈中弹出一个元素。 换句话说，删除并返回此列表的第一个元素。
                  此方法相当于removeFirst()。
                  这也就对应了栈的概念，新插入的元素放在了栈的第一个元素，出的时候通过pop()方法先出第一个元素。
                 */
                deque.pop();
            }
        }
        return deque.isEmpty();
    }
}
