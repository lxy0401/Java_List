package FuZaListClone;

/**
 * @author LXY
 * @email 403824215@qq.com
 * @date 2018/7/16 16:24
 */
//复杂链表复制
//输入一个复杂链表
// （每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
// 返回结果为复制后复杂链表的head。
// （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
public class Solution {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null)
        {
            return null;
        }
        //当前节点
        RandomListNode cur  = pHead;

        //克隆后的头节点
        RandomListNode cpHead = null;

        //1.将元素进行拷贝
        while(cur != null)
        {
            //要将链表中的元素进行拷贝（拷贝的位置在每个节点的后面）
            //将原链表的每一个元素进行拷贝
            RandomListNode cloneNode = new RandomListNode(cur.label);
            //拷贝的元素在被拷贝元素的下一个节点
            RandomListNode nextNode = cur.next;
            //当前节点的下一个节点指向克隆元素
            cur.next = cloneNode;
            //克隆元素的下一个位置指向之前的下一个元素
            cloneNode.next = nextNode;
            //将cur元素后移
            cur = nextNode;
        }
        //2.拷贝元素指向
        cur = pHead;
        while(cur != null)
        {
            if(cur.random == null)
            {
                cur.next.random = null;
            }
            else
            {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        //3.将两个链表进行分离
        cur = pHead;
        cpHead =  pHead.next;
        while (cur != null)
        {
            RandomListNode cloneNode = cur.next;
            cur.next = cloneNode.next;
            if(cloneNode.next == null)
            {
                cloneNode.next = null;
            }
            else
            {
                cloneNode.next = cloneNode.next.next;
            }
            cur = cur.next;
        }
        return cpHead;
    }
}
