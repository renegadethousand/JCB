package academy.kovalevskyi.codingbootcamp.week1.day1;

import java.util.Comparator;

public class Sorting {
  public static <T> void sort(T[] target, Comparator<T> comparator) {
    for (int i = 0; i < target.length - 1; i++) {
      for (int y = 0; y < target.length - i - 1; y++) {
        if (comparator.compare(target[y], target[y + 1]) > 0) {
          T temp = target[y];
          target[y] = target[y + 1];
          target[y + 1] = temp;
        }
      }
    }
  }

  public static <T> void sortReversedOrder(T[] target, Comparator<T> comparator) {
    sort(target, comparator.reversed());
  }
}
