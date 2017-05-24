import javaslang.collection.Tree;

import java.util.Map;

public class IdExp extends Exp {
   public final String id;

   public IdExp(String id) {
      this.id = id;
   }

   @Override
   public String toString() {
      return "IdExp{" +
             "id='" + id + '\'' +
             '}';
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
   public Integer eval(Map<String, Integer> mem) {
      Integer x = mem.get(id);
      return x == null ? 0 : x;
   }
}
