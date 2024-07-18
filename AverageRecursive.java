import java.util.ArrayList;
import java.util.List;

public class AverageRecursive {
     public boolean average(List<Integer> list) {
          if (list.size() < 3) {
               return false;
          }
          if (list.size() == 3) {
               if (list.get(0) == (list.get(1) + list.get(2)) / 2) {
                    return true;
               } else if (list.get(1) == (list.get(0) + list.get(2)) / 2) {
                    return true;
               } else return list.get(2) == (list.get(0) + list.get(1)) / 2;
          }

          List<Integer> tmp1 = new ArrayList<>();
          for (int i = 1; i < list.size(); i++) {
               tmp1.add(list.get(i));
          }
          List<Integer> tmp2 = new ArrayList<>();
          tmp2.add(list.get(0));
          for (int i = 2; i < list.size(); i++) {
               tmp2.add(list.get(i));
          }
          List<Integer> tmp3 = new ArrayList<>();
          tmp3.add(list.get(0));
          tmp3.add(list.get(1));
          for (int i = 3; i < list.size(); i++) {
               tmp3.add(list.get(i));
          }
          return average(tmp1) || average(tmp2) || average(tmp3);
     }


     public static void main(String[] args) {

          AverageRecursive ar1 = new AverageRecursive();
          System.out.println(ar1.average(List.of(1, 2, 3)));
          System.out.println(ar1.average(List.of(10, 7, 21, 14)));
          System.out.println(ar1.average(List.of(11, 36, 21, 17, 27, 35, 24)));
          System.out.println(ar1.average(List.of(77, 12, 36, 15, 80, 120)));
          System.out.println(ar1.average(List.of(100, 2, 37, 55, 150, 211, 33, 71)));
     }
}
