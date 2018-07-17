package FindTwoListFatherNode;

import java.util.HashMap;

/**
 * @author LXY
 * @email 403824215@qq.com
 * @date 2018/7/17 10:04
 */
//输入两个链表，找出它们的第一个公共结点。
//使用HashMap的性值
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode cur1 = pHead1;
        ListNode cur2 = pHead2;
        if(pHead1 == null || pHead2 == null)
        {
            return null;
        }
        HashMap<ListNode,Integer> map = new HashMap<>();
        while (cur1 != null)
        {
            map.put(cur1,0);
            cur1 = cur1.next;
        }
        while (cur2 != null)
        {
            if(map.containsKey(cur2))
            {
                return cur2;
            }
            cur2 = cur2.next;
        }
        return null;
    }
}