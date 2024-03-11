import java.util.*;

// structure of the Node
class CDLLNode {
    int key;
    int value;
    CDLLNode prev;
    CDLLNode next;
    public CDLLNode(int key, int value){

        this.key = key;
        this.value = value;
        
    }
}

// 1. insert at front
// 2. del last node
// 3. move any given node in front
class CDLL{
    CDLLNode head = null;
    CDLLNode insertAtBegin(int k, int v){
        CDLLNode nn = new CDLLNode(k, v); // new node
        nn.next = nn; nn.prev = nn;
        if(head == null){
            head = nn;
        } else { // LL is not empty
            CDLLNode last = head.prev;
            nn.next = head;
            head.prev = nn;
            nn.prev = last;
            last.next = nn;
            head = nn;
        }
        return head;
    }

    void printCDLL(){
        if(head == null) return;
        CDLLNode temp = head, last = head.prev;
        while(true){
            System.out.print(temp.key + "," + temp.value + "  ");
            if(temp == last)
                break;
            temp = temp.next;
        }
        System.out.println();
    }
    int delLastNode(){
        if(head == null) return -1; // no deletion reqd
        CDLLNode last = head.prev;
        if(head == last) { // 1-node
            head = null;
        } else {
            last.prev.next = head;
            head.prev = last.prev;
        }
        return last.key;
    }

    void moveNodeInFront(CDLLNode node){
        if(head == node) return;
        node.prev.next = node.next;
        node.next.prev = node.prev;

        CDLLNode last = head.prev;
        node.next = head;
        head.prev = node;
        node.prev = last;
        last.next = node;
        head = node;
    }
}

class LRUCache {
    int capacity;
    int size = 0; // current elemt count
    CDLL ll = new CDLL(); // CDLL to maintain most-recet / least-recent
    Map<Integer, CDLLNode> mp = new HashMap<>();
    public LRUCache(int capacity){
        this.capacity = capacity;
    }

    int get(int key){ // O(1)
        if(mp.containsKey(key)){
            CDLLNode node = mp.get(key);
            ll.moveNodeInFront(node);
            return node.value;
        } else {
            return -1;
        }
    }

    void put(int key, int value){
        if(mp.containsKey(key)){ // we need to update the value
            CDLLNode node = mp.get(key);
            node.value = value;
            ll.moveNodeInFront(node);
        } else {
            if(size < capacity){
                CDLLNode node = ll.insertAtBegin(key, value);
                mp.put(key, node);
                size++;
            }  else { // size is full
                int k = ll.delLastNode();
                mp.remove(k);
                CDLLNode node = ll.insertAtBegin(key, value);
                mp.put(key, node);
            }
        }
    }
}

class Main{
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        System.out.println(cache.get(1));
        cache.put(2,2);
        cache.put(4,4);
        cache.put(2,5);
        System.out.println(cache.get(2));
        cache.put(3,3);
        cache.put(9,9);
        System.out.println(cache.get(4));
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        cache.put(7,6);
        System.out.println(cache.get(7));
        System.out.println(cache.get(9));

    }
}