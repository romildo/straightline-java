import javaslang.collection.Tree;

import java.util.Map;

public class NumExp extends Exp {
   public final int num;

   public NumExp(int num) {
      this.num = num;
   }

   @Override
   public String toString() {
      return "NumExp{" +
             "num=" + num +
             '}';
   }

   @Override
   public Tree.Node<String> toTree() {
      return Tree.of("NumExp " + num);
   }

   @Override
   public int maxargs() {
      return 0;
   }

    @Override
    public Integer eval(Map<String, Integer> mem) {
       return num;
    }
}

