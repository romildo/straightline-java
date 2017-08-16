import absyn.Stm;
import io.vavr.render.text.Boxes;
import parse.Lexer;
import parse.Parser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public class Main {

   private static void run(String[] args) throws Exception {
      java.io.Reader input;
      String fileName;

      if (args.length == 0) {
         fileName = "stdin";
         input = new java.io.InputStreamReader(System.in);
      }
      else {
         fileName = args[0];
         input = new java.io.FileReader(fileName);
      }

      Lexer lex = new Lexer(input, fileName);
      Parser p = new Parser(lex);

      Stm program = (Stm) (p.parse().value);

      System.out.println(Boxes.box(program.toTree()));
      program.interp(new HashMap<>());
   }

   public static void main(String[] args) throws java.lang.Exception {
      try {
         run(args);
      }
      catch (FileNotFoundException e) {
         System.err.printf("file not found: %s\n", args[0]);
         System.exit(1);
      }
      catch (IOException e) {
         System.err.println("I/O error");
         System.exit(2);
      }
      catch (Exception e) {
         System.out.println(e.getLocalizedMessage());
         throw e;
         //System.exit(3);
      }
   }
}