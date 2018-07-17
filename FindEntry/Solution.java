package FindEntry;

/**
 * @author LXY
 * @email 403824215@qq.com
 * @date 2018/7/17 10:34
 */
//给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
public class Solution {
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead == null)
        {
            return null;
        }
        ListNode meetNode = MeetNode(pHead);
        if(pHead == null)
        {
            return null;
        }
        ListNode cur1 = pHead;
        ListNode cur2 = meetNode;
        //带环链表，开始点到入口点的距离 = 入口点到相遇点的距离
        while (cur1 != cur2)
        {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur2;
    }
    public ListNode MeetNode(ListNode pHead)
    {
        if(pHead == null)
        {
            return null;
        }
        ListNode fast = pHead;
        ListNode slow = pHead;
        //让fast一次移动两步，让slow一次移动一步
        //最终两个指针相遇，该点为相遇点
        while (fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)
            {
                return fast;
            }
        }
        return null;
    }
}
