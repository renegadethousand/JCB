
package academy.kovalevskyi.codingbootcamp.week1.day2;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class StdString1 implements Iterable<Character> {

  protected final char[] base;

  public StdString1() {
    this.base = new char[]{};
  }

  public StdString1(char[] base) {
    char[]array = new char[base.length];
    for (int i = 0; i < base.length; i++) {
      array[i] = base[i];
    }
    this.base = array;
  }

  public StdString1(StdString1 stdString1) {
    this(stdString1.base.clone());
  }

  public int length() {
    return base.length;
  }

  public StdString1 append(StdString1 that) {
    if (that == null) {
      throw new NullPointerException();
    }
    char[] newBase = new char[base.length + that.base.length];
    int count = 0;
    for (int i = 0; i < this.base.length; i++) {
      newBase[count] = this.base[i];
      count++;
    }
    for (int i = 0; i < that.base.length; i++) {
      newBase[count] = that.base[i];
      count++;
    }
    return new StdString1(newBase);
  }

  public char[] toCharArray() {
    return base.clone();
  }

  public char charAt(int index) {
    return base[index];
  }

  public int indexOf(char target) {
    for (int i = 0; i < base.length; i++) {
      if (target == base[i]) {
        return i;
      }
    }
    return -1;
  }

  @Override
  public boolean equals(final Object otherObj) {
    if (this == otherObj) {
      return true;
    }

    if (otherObj == null || getClass() != otherObj.getClass()) {
      return false;
    }

    StdString1 otherString = (StdString1) otherObj;

    if (this.base.length != otherString.base.length) {
      return false;
    }

    for (int i = 0; i < base.length; i++) {
      if (this.base[i] != otherString.base[i]) {
        return false;
      }
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = 0;
    for (int i = 0; i < base.length; i++) {
      result += (int) base[i];
    }
    return result;
  }

  @Override
  public String toString() {
    return String.valueOf(this.base);
  }
  
  @Override
  public Iterator<Character> iterator() {
    return new Iterator<Character>() {
      int count = 0;

      @Override
      public boolean hasNext() {
        return count < base.length;
      }

      @Override
      public Character next() {
        if (!hasNext()) {
          throw new NoSuchElementException();
        }
        return base[count++];
      }
    };
  }

  @Override
  public void forEach(final Consumer<? super Character> action) {
    for (int i = 0; i < this.base.length; i++) {
      action.accept(this.base[i]);
    }
  }
}
