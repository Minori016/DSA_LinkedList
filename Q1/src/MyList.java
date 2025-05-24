/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;

public class MyList {

    Node head, tail;

    MyList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = head;
        while (p != null) {
            fvisit(p, f); // You will use this statement to write information of the node p to the file
            p = p.next;
        }
        f.writeBytes("\r\n");
    }

    void loadData(int k) { //do not edit this function
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            addLast(a[i], b[i], c[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART=========
//===========================================================================
//===========================================================================
/* 
   Khong su dung tieng Viet co dau de viet ghi chu.
   Neu dung khi chay truc tiep se bao loi va nhan 0 diem
     */
    void addLast(String xSource, int xPrice, int xType) {
        //You should write here appropriate statements to complete this function.
        //or write like this 
        if(xSource.charAt(0)=='D' || xPrice<=0) 
        return;
        
         Node q=  new Node(new Watermelon(xSource,xPrice,xType));
         if(this.isEmpty()) {
             head = tail = q;
        
    }   
         else{ 
             tail.next = q;
             tail = q;
         }
        
        //----------------------------------------------------------------------
    }
      
 
    void addFirst(String xSource, int xPrice, int xType) {
        //You should write here appropriate statements to complete this function.
        //or write like this 
        // if(xSource.charAt(0)=='D' || xPrice<=0) 
        //return;
        if((xSource.charAt(0)!='D'&&xPrice>0)) {
         Node q=  new Node(new Watermelon(xSource,xPrice,xType));
         if(this.isEmpty()) {
             head = tail = q;
        
    }   
         else{ 
             q.next = head;
             head = q;
         }
        
        
        
        
        
        
        
        
        //----------------------------------------------------------------------
    }
      }
    
    
    void insert(Node x, int k) {
        if(k<2) { // try catch truong hop int ng dung nhap so am 
            x.next = head;
            head = x; // return ve vi tri dau cua danh sach
            return ;
        }
        Node p = head;
        int count=1;
        
        while(p!=null && count <k-1) {
            p = p.next;
            count++;
        }
        
        if ( p==null) {
            tail.next = x; // neu vuot qua size cua danh sach  thi cu them vao cuoi danh sach;
            tail = x; 
            return;
        }
        x.next = p.next; // Node x trỏ tới node mà p đang trỏ tới
        p.next = x;      // Node p trỏ tới x
        
        
    }
    
    
    void delete(int k) {
    if (this.isEmpty() || k < 1) {
        return;
    }

    if (k == 1) {
        head = head.next;
        return;
    }

    Node p = head;
    int count = 1;

    while (p != null && count < k - 1) {
        p = p.next;
        count++;
    }

    if (p == null || p.next == null) {
        return;
    }

    p.next = p.next.next;
}

    void deleteFirst(RandomAccessFile f) throws Exception {
        if(this.isEmpty()) {
            return;
        }
        if ( head==tail) {
            head = tail = null;
        }
        head = head.next;
    }
    void deleteLast(RandomAccessFile f) throws Exception {
        Node p = head; // cho bien p = head;
        while(p.next!=tail) { // duyet mang toi truoc tail
            p = p.next;
        }
        // p hien dang tro den node ngay truoc tail
         if(this.isEmpty()) {
            return;
        }
        if ( head==tail) {
            head = tail = null;
        }
        p.next=null; //cat bo node cuoi
        tail = p; // cap nhat tail tro den node cuoi moi
    }
       Node getPosition(int k) {
    Node p = head;
    int count = 1;
    while (p != null && count < k) {
        p = p.next;
        count++;
    }
    return p; // Tra ve null neu k > do dai cua list
}
    
   void swap(int i,int j) {
       Node x = getPosition(i);
       Node y = getPosition(j);
       Watermelon temp = x.info;
       x.info = y.info;
       y.info=temp;
   }
    void f1() throws Exception {
        clear();
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        f.close();
    }

    //==================================================================
    void f2() throws Exception {
        clear();
        loadData(5);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        Watermelon g;
        Watermelon h;
        g = new Watermelon("G", 2, 3);
        h = new Watermelon("H", 5, 6);
        Node x = new Node(g);
        Node y = new Node(h);
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        /*x=y.next; 
        x.next=head.next;
        head.next =y; */

        insert(y, 2);
        insert(x, 3);
        
        
        
        
        
        //---------------------------------------------------------
        ftraverse(f);
        f.close();
    }
    

   

    //==================================================================
    void f3() throws Exception {
        clear();
        loadData(9);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        delete(3);
        delete(3);
        //---------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    //==================================================================
    void f4() throws Exception {
        clear();
        loadData(13);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------

        
        
        
        //---------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    //==================================================================
    void f5() throws Exception {
        clear();
        loadData(17);
        String fname = "f5.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        deleteLast(f);
      
        
        
        //---------------------------------------------------------
        ftraverse(f);
        f.close();
    }
    //==================================================================
    void f6() throws Exception {
        clear();
        loadData(21);
        String fname = "f6.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        deleteFirst(f);
        
        
        
        //---------------------------------------------------------
        ftraverse(f);
        f.close();
    }
    void f7() throws Exception {
        clear();
        loadData(25);
        String fname = "f7.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        swap(3, 6);
        
        
        
        //---------------------------------------------------------
        ftraverse(f);
        f.close();
    }
}
