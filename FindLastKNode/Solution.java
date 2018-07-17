package FindLastKNode;

/**
 * @author LXY
 * @email 403824215@qq.com
 * @date 2018/7/16 14:49
 */

//输入一个链表，输出该链表中倒数第k个结点。
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null || k <= 0)
        {
            return null;
        }
        //使用两个指针，开始指向链表的头部
        ListNode pre = head;
        ListNode last = head;
        //开始将pre指针向后移动k-1步（此时pre在last之后）
        for(int i = 1; i < k;i++)
        {
            if(pre.next != null)
            {
                pre = pre.next;
            }
            else
            {
                return null;
            }
        }
        //再将两个指针同时向后移动，直到pre指向链表的最后一个元素
        //此时last指向倒数第K个元素，返回last
        while (pre.next != null)
        {
            pre = pre.next;
            last = last.next;
        }
        return last;
    }
}
