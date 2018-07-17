package FindLastKNode;

/**
 * @author LXY
 * @email 403824215@qq.com
 * @date 2018/7/16 15:11
 */
//龟兔赛跑，让兔先跑 k 步，然后龟和兔继续跑，
// 兔到终点后的继续跑结点为null表示结束，此时龟的位置就是倒数k 的结点
public class Rabbit {
    public ListNode FindKthToTail(ListNode head, int k)
    {
        if(head == null || k <= 0)
        {
            return null;
        }
        ListNode rabbit = head;
        ListNode gui = head;
        for(int i = 1; i < k ;i++)
        {
            if(rabbit.next != null)
            {
                rabbit = rabbit.next;
            }
            else
            {
                return null;
            }
        }
        while (rabbit.next != null)
        {
            rabbit = rabbit.next;
            gui = gui.next;
        }
        return gui;
    }
}
