
import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.Rule;
import org.junit.Test;

public class MainTest {
   /*
   private void tmaxargs(absyn.Stm program, int n) {
      softly.assertThat(program.maxargs())
               .as("%s", program)
               .equals(n);
   }
   */
   @Rule
   public final JUnitSoftAssertions softly = new JUnitSoftAssertions();
   /*
   @Test
   public void testMaxArgs() {
      tmaxargs(new absyn.AssignStm("z", new absyn.NumExp(8)), 0);
   }
   */
}
