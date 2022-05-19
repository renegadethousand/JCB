package academy.kovalevskyi.codingbootcamp.week2.day1;

public class BoxGenerator {

  public static void main(String[] args) {
    if (args.length != 4) {
      System.out.println("Please provide 4 input arguments, current amount: " + args.length);
      return;
    }
    int width = Integer.parseInt(args[0]);
    int height = Integer.parseInt(args[1]);
    if (args.length != 4 || args[2].length() != 1 || args[3].length() != 1
        || width < 0 || height < 0) {
      throw new IllegalArgumentException();
    }    
    char side = args[2].charAt(0);
    char angle = args[3].charAt(0);

    char[][] box = BoxGeneratorUtils.generateBox(angle, side, width, height);
    BoxGeneratorUtils.print(box);
  }
}

