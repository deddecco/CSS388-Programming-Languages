import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Average {

     // references to the beginning and end of the list
     static Node head = null;
     Node tail = null;


     // Node contains an int called data and a reference to a Node called next
     static class Node {
          private final int data;
          private Node next;

          // constructor initially makes the node take on the data
          // and be free-floating, only being
          // attached to the list in the right place
          // at the time of assignment after the creation of this object
          public Node(int data) {
               this.data = data;
               this.next = null;
          }
     }


     Node readIO(String filePath) throws IOException {

          // setting up I/O
          File file = new File(filePath);
          BufferedReader reader = new BufferedReader(new FileReader(file));

          // this will be what gets read and put into the list
          String line;

          while ((line = reader.readLine()) != null) {
               String[] elements = line.split("\\s+"); // split line by whitespace

               for (String element : elements) {
                    // convert the string to an int
                    int num = Integer.parseInt(element);
                    // if the list is empty, the new element is both the front and the back of the list
                    if (head == null) {
                         head = new Node(num);
                         tail = head;
                    }
                    // otherwise, add the new element to the back of the list
                    else {
                         tail.next = new Node(num);
                         tail = tail.next;
                    }
               }
          }
          // return a reference to the front of the list
          return head;
     }

     // recursive linear search
     boolean averageOfListIsInList(Node startFromHere, int average) {
          // the average is not in a null list
          if (startFromHere == null) {
               return false;
          }

          // if the list isn't null, check if the current value matches, or search through
          // the remainder of the list to see if it's there
          return startFromHere.data == average || averageOfListIsInList(startFromHere.next, average);
     }

     // calculate the sum recursively
     private int calculateSum(Node current) {
          // the sum of a null list is 0
          // but if the list is not null, then
          // the sum of a list is the current element plus the sum of the rest of the list
          return current == null ? 0 : current.data + calculateSum(current.next);
     }


     // calculate the count recursively
     private int calculateCount(Node current) {
          // there are no elements in a null list
          // but otherwise if the list is not null, then
          // the size of a list is 1 plus the size of the rest of the list
          return current == null ? 0 : 1 + calculateCount(current.next);
     }

     // calculate the average recursively
     private int calculateAverage(Node current) {
          // for a non-null element, the average is the sum / the count
          if (current != null) {
               return calculateSum(current) / calculateCount(current);
          }
          // if current is null, the answer is 0
          return 0;
     }

     public static void main(String[] args) throws IOException {
          Average average = new Average();
          // readIO returns the head of the list created from the filePath passed into the command line
          head = average.readIO(args[0]);
          // this stores the average to make the execution of the if more efficient and readable--
          // because the number is known going into the if
          int averageResult = average.calculateAverage(head);
          // if the program finds the value searching recursively from the head, then output yes and return tru
          if (average.averageOfListIsInList(head, averageResult)) {
               System.out.println("Yes");
          }
          // otherwise output no and return false
          else {
               System.out.println("No");
          }
     }

}