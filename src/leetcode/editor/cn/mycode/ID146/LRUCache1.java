package leetcode.editor.cn.mycode.ID146;

import java.util.HashMap;


/**
 * 手写双向链表加哈希表
 */
public class LRUCache1 {
        class node{
            public int val,key;
            public node prev,next;

            public node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }
        class doubleList{
            public node tail;
            public node head;
            private int size;

            public doubleList() {
                this.size=0;
                head=new node(0,0);
                tail=new node(0,0);
                head.next=tail;
                tail.prev=head;
            }

            /**
             * 在尾部插入
             * @param x
             */
            public void addList(node x)
            {
                x.prev=tail.prev;
                x.next=tail;
                tail.prev.next=x;
                tail.prev=x;
                size++;
            }

            /**
             * 一定存在
             *
             * @param x
             */
            public void remove(node x){
            x.prev.next=x.next;
            x.next.prev=x.prev;
            size--;
            }

            public node removeFirst(){
                if(head.next==tail)
                {
                    return null;
                }
                node first = head.next;
                remove(first);
                return first;
            }

            public int size()
            {
                return size;
            }

        }



    HashMap<Integer,node> map;
    doubleList cache;

    int cap;
    public LRUCache1(int capacity) {
        this.cap=capacity;
        this.map =new HashMap<>();
        this.cache=new doubleList();
    }

    private void makeRecently(int key)
    {
        node node = map.get(key);
        cache.remove(node);
        cache.addList(node);
    }
    private void addRecently(int key ,int value)
    {
        node node = new node(key, value);
        cache.addList(node);
        map.put(key,node);
    }
    private void deleteKey(int key)
    {
        node node = map.get(key);
        cache.remove(node);
        map.remove(key);
    }

    private void removeLeastRecently(){
        node node = cache.removeFirst();
        map.remove(node.key);
    }


    public int get(int key) {
        if(!map.containsKey(key))
        {

            return -1;
        }
        makeRecently(key);
        return map.get(key).val;

    }

    public void put(int key, int value) {
        if(map.containsKey(key))
        {
            deleteKey(key);
            addRecently(key,value);
            return ;
        }
        if(cap==cache.size){
            removeLeastRecently();
        }
        addRecently(key,value);
    }


}
