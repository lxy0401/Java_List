package DeleteSameNode;

/**
 * @author LXY
 * @email 403824215@qq.com
 * @date 2018/7/17 11:03
 */
//在一个排序的链表中，存在重复的结点，
// 请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
// 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
public class Solution {
    public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead == null || pHead.next == null)
        {
            return pHead;
        }
        if(pHead.val == pHead.next.val)
        {
            //遇见重复值
            ListNode nextNode = pHead.next;
            while (nextNode != null && nextNode.val == pHead.val)
            {
                //跳过全部重复值
                nextNode = nextNode.next;
            }
            return deleteDuplication(nextNode);
        }
        else
        {
            //没有到重复值
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }
}