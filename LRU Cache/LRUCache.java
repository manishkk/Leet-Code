public class LRUCache {
    
class DlinkedList{
        int key;
        int value;
        DlinkedList pre;
        DlinkedList post;        
}
    //add new node
    void addNode(DlinkedList node){
        node.pre = head;
        node.post = head.post;
        this.head.post.pre = node;
        head.post = node;
    }
    
    //remove existing node
    void removeNode(DlinkedList node){
        DlinkedList pre = node.pre;
        DlinkedList post = node.post;
        pre.post = post;
        post.pre = pre;
    }
    
    //move posinter to front
    void moveToFront(DlinkedList node){
        removeNode(node);
        addNode(node);        
    }
    
    //remove last element
    DlinkedList poptail(){
        DlinkedList temp = tail.pre;
        removeNode(temp);
        return temp;        
    }
    
    Map<Integer, DlinkedList> m = new HashMap<Integer, DlinkedList>();
    int count, capacity;
    DlinkedList head, tail;    
    
    public LRUCache(int capacity) {
        count = 0;
        this.capacity = capacity;
        head = new DlinkedList();
        head.pre = null;
        tail = new DlinkedList();
        tail.post = null;
        head.post = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        DlinkedList node = m.get(key);
        if(node == null)
            return -1;
        else{
            moveToFront(node);
            return node.value;
        }
    }
    
    public void put(int key, int value) {
        DlinkedList node = m.get(key);
        if(node == null){
            node = new DlinkedList();
            node.key = key;
            node.value = value;
            addNode(node);
            m.put(key,node);
            ++count;
            while(count > capacity){
                DlinkedList temp = poptail();
                --count;
                m.remove(temp.key);
            }
        }
        else{
            node.value = value;
            moveToFront(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
