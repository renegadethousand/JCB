package academy.kovalevskyi.codingbootcamp.week2.day1;

import academy.kovalevskyi.codingbootcamp.week1.day2.StringUtils;

public class TextPrinter1 {

  public static void main(String[] args) {
    if (args.length != 1) { 
      String s = "Please provide only one input argument, current amount: " + args.length;
      System.out.print(StringUtils.makeCamel(s.toCharArray()));
      return;
    }
    char[] text = args[0].toCharArray();
    int size = text.length + 4;
    char[][] chars = BoxGeneratorUtils.generateBox('/', '\\', '\\', '/',
        '#', size, 3, text);
    BoxGeneratorUtils.print(chars);
  }
}

