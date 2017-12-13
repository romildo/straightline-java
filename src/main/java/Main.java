import absyn.Stm;
import error.CompilerError;
import error.FatalError;
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
         fileName = "-";
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
         System.err.printf("file not found: %s%n", args[0]);
         System.exit(1);
      }
      catch (IOException e) {
         System.err.printf("I/O error:%n%s%n", e.getLocalizedMessage());
         System.exit(2);
      }
      catch (CompilerError e) {
         System.err.printf("Compilation error:%n%s%n", e.getLocalizedMessage());
         System.exit(3);
      }
      catch (FatalError e) {
         System.err.printf("Fatal error:%n%s%n", e.getLocalizedMessage());
         System.exit(4);
      }
      catch (Exception e) {
         if (e.getMessage().equals("Can't recover from previous error(s)")) {
            System.err.printf("Fatal error:%n%s%n", e.getLocalizedMessage());
            System.exit(5);
         }
         System.out.printf("Unexpected error!");
         throw e;
      }
   }
}