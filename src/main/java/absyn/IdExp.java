package absyn;

import io.vavr.collection.Tree;

import java.util.Map;

public class IdExp extends Exp {
   public final String id;

   public IdExp(String id) {
      this.id = id;
   }

   @Override
   public Tree.Node<String> toTree() {
      return Tree.of("IdExp " + id);
   }

   @Override
   public int maxargs() {
      return 0;
   }

   @Override
   public Double eval(Map<String, Double> mem) {
      Double x = mem.get(id);
      return x == null ? 0 : x;
   }
}
