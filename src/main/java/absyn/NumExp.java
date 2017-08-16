package absyn;

import io.vavr.collection.Tree;

import java.util.Map;

public class NumExp extends Exp {
   public final double num;

   public NumExp(double num) {
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
   public Double eval(Map<String, Double> mem) {
      return num;
   }
}
