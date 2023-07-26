import java.sql.SQLOutput;
import java.util.Scanner;

class Node
{
    int value;
    Node next;
    public  Node(int value)
    {
        this.value=value;
    }
}
public class linkedlist {
    static Node head;
    static Node tail;
    static int length;
    linkedlist(int value)
    {
        Node newNode = new Node(value);
            head = newNode;
            tail = newNode;
            length = 1;
    }
    public static void append(int value)
    {
        Node newNode = new Node(value);
        if(length==0)
        {
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next=newNode;
            tail = newNode;
        }
        length++;
        System.out.println("append sucessfully");
    }

    public static void print(){
        Node temp=head;
        while(temp!=null)
        {
            System.out.println(temp.value);
            temp=temp.next;
        }
    }
    public static void getHead()
    {
        System.out.println("Head element:"+head.value);
    }
    public static void getTail()
    {
        System.out.println("Tail element:"+tail.value);
    }
    public static void getLength()
    {
        System.out.println("Length of linkedlist:"+length);
    }
    Node removeFromLast(){
        if(length==0)
        {
            return null;
        }
        Node temp = head;
        Node prev =  head;
        while(temp.next!=null)
        {
            prev = temp;
            temp = temp.next;
        }
        tail = prev;
        tail.next=null;
        length--;
        if(length ==0)
        {
            head = null;
            tail=null;
        }
        System.out.println("removed sucessfully");
        return temp;
    }

    void prepend(int value)
    {
        Node newNode = new Node(value);
        if(length==0)
        {
            head = newNode;
            tail = newNode;
        }
        else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    Node removeFromFirst()
    {
        if(length ==0)
        {
            return null;
        }
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if(length==0)
        {
            tail = null;
        }
        return temp;
    }

    Node getNode(int index)
    {
        if(index<0 || index>=length)
        {
            return null;
        }
        Node temp = head;
        for(int i=0;i<index;i++)
        {
            temp = temp.next;
        }
        return temp;
    }

    boolean set(int index,int value)
    {
        Node temp = getNode(index);
        if(temp!=null)
        {
            temp.value = value;
            return true;
        }
        return false;
    }

    boolean insert(int index, int value)
    {
        if(index<0 || index >length)
        {
            return false;
        }
        if(index==0)
        {
            prepend(value);
            return true;
        }
        if(index==length)
        {
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node temp = getNode(index-1);
        newNode.next=temp.next;
        temp.next=newNode;
        length ++;
        return true;
    }

    Node remove(int index) {
        if (index < 0 || index >= length) {
            return null;
        }
        if (index == 0) {
            return removeFromFirst();
        }
        if (index == length - 1) {
            return removeFromLast();
        }
        Node prev = getNode(index - 1);
        Node temp = getNode(index);
        prev.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }

    void reverse()
    {
        Node temp = head;
        head = tail;
        tail = temp;
        Node before = null;
        Node after = temp.next;
        for(int i=0;i<length;i++)
        {
            after = temp.next;
            temp.next=before;
            before=temp;
            temp=after;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        linkedlist myList = new linkedlist(num);
        num = scanner.nextInt();
        while (num!=-1)
        {
            myList.append(num);
            num = scanner.nextInt();
        }
        int index,value;
        System.out.println("1-Prepend\n2-Remove From First\n3-Get Node\n4-Update node\n5-Insert a node\n6-Remove At An Index\n7-Reverse\n8-Exit\n9-Print\n10-length of linked list");
        int choice = scanner.nextInt();
        do{
            switch(choice) {
                case 1:
                    System.out.println("Enter a value to insert:");
                     value = scanner.nextInt();
                    myList.prepend(value);
                    break;
                case 2:
                    System.out.println("Removed value :"+myList.removeFromFirst().value);
                    break;
                case 3:
                    System.out.println("Enter an index to see the value:");
                     index = scanner.nextInt();
                    System.out.println("The element is:"+myList.getNode(index).value);
                    break;
                case 4:
                    System.out.println("Enter an element and index to update a node:");
                    index = scanner.nextInt();
                    value= scanner.nextInt();
                    myList.set(index,value);
                    break;
                case 5:
                    System.out.println("Enter an element and index to add a node:");
                    value = scanner.nextInt();
                    index = scanner.nextInt();
                    myList.insert(index,value);
                    break;
                case 6:
                    System.out.println("Enter an index to remove an element:");
                    index = scanner.nextInt();
                    myList.remove(index);
                    break;
                case 7:
                    System.out.println("The linked list is now reversed:");
                    myList.reverse();
                    myList.print();
                    break;
                case 9:
                    System.out.println("The linked list is:");
                    myList.print();
                    break;
                case 10:
                    System.out.println("Length is: "+myList.length);
                    break;
                default:
                    System.out.println("Worng choice.");
            }
            System.out.println("1-Prepend\n2-Remove From First\n3-Get Node\n4-Update node\n5-Insert a node\n6-Remove At An Index\n7-Reverse\n8-Exit\n9-Print\n10-length of linked list");
            choice = scanner.nextInt();
        }while(choice!=8);














//        linkedlist mList = new linkedlist();
//        System.out.print("Enter a num: ");
//        int num2 = scanner.nextInt();
//        mList.Append(num2);
//        System.out.print("Enter a num: ");
//        int num3 = scanner.nextInt();
//        mList.Append(num3);
//        System.out.print("Enter a num: ");
//        int num4 = scanner.nextInt();
//        mList.Append(num4);
//        mList.getHead();
//        mList.getTail();
//        mList.getLength();
//        System.out.println("removed value:"+mList.removeFromLast().value);
//        mList.print();
//        System.out.println("removed value:"+mList.removeFromLast().value);
//        mList.print();

    }
}
