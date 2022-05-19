package academy.kovalevskyi.codingbootcamp.week2.day1;

public class BoxGeneratorUtils {

  public static char[][] generateBox(char angle, int width, int height, char[] text) {
    return generateBox(angle, angle, angle, angle, angle, width, height, text);
  }

  public static char[][] generateBox(char angle, char side, int width, int height) {
    return generateBox(angle, angle, angle, angle, side, width, height, null);
  }

  public static char[][] generateBox(char leftTopAngle, char rightTopAngle,
                     char leftBottomAngle, char rightBottomAngle,
                     char side, int width, int height, char[] text) {
    char[][] box = new char[height][width];
    for (int i = 0; i < height; i++) {
      if (i == 0 || i == height - 1) {
        for (int j = 0; j < width; j++) {
          box[i][j] = side;
        }
        box[i][0] = i == 0 ? leftTopAngle : leftBottomAngle;
        box[i][width - 1] = i == 0 ? rightTopAngle : rightBottomAngle;
      } else {
        for (int j = 0; j < width; j++) {
          box[i][j] = ' ';
        }
        if (text != null) {
          for (int j = 0; j < width - 4; j++) {
            box[i][j + 2] = text[j];
          }
        }
        box[i][0] = side;
        box[i][width - 1] = side;
      }
    }
    return box;
  }

  public static void print(char[][] box) {
    for (int i = 0; i < box.length; i++) {
      for (int j = 0; j < box[i].length; j++) {
        System.out.print(box[i][j]);
      }
      System.out.print("\n");
    }
  }
}

