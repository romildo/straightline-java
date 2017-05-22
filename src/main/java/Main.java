import javaslang.collection.List;
import javaslang.render.text.Box;
import javaslang.render.text.Boxes;

public class Main {

   public static void main(String[] args) {

      Stm p = new CompoundStm(new AssignStm("x",
                                            new OpExp(new NumExp(2),
                                                      new OpExp(new NumExp(3),
                                                                new NumExp(4),
                                                                OpExp.Op.TIMES),
                                                      OpExp.Op.PLUS)),
                              new PrintStm(List.of(new IdExp("x"))));

      System.out.println(p);
      System.out.println(p.toTree().draw());
      System.out.println(Boxes.box(p.toTree()));

   }
}
