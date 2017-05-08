public class EseqExp extends Exp {

   public final Stm stm;
   public final Exp exp;

   public EseqExp(Stm stm, Exp exp) {
      this.stm = stm;
      this.exp = exp;
   }

   @Override
   public String toString() {
      return "EseqExp{" +
             "stm=" + stm +
             ", exp=" + exp +
             '}';
   }
}
