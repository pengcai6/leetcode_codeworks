package leetcode.editor.cn.mycode.ID146;

import java.util.LinkedHashMap;

/**
 * 使用java中自带的linkedHashMap
 */
public class LRUCache2 {
        int cap;
        LinkedHashMap<Integer,Integer> cache=new LinkedHashMap<>();


    public LRUCache2(int capacity) {
            this.cap=capacity;
    }

    public void makeRecently(int key)
    {
        Integer value = cache.get(key);
        //删除重新插入到队尾
        cache.remove(key);
        cache.put(key,value);
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        Integer value = cache.get(key);
        makeRecently(key);
    return value;
    }

    public void put(int key, int value) {
        if(cache.containsKey(key))
        {
            cache.put(key,value);
            makeRecently(key);
            return;
        }
        if(cache.size()>=cap)
        {
            //链表头部就是最久未使用的key
            Integer oldKey = cache.keySet().iterator().next();
            cache.remove(oldKey);
        }
        cache.put(key, value);
    }
}
