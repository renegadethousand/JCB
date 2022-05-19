package academy.kovalevskyi.codingbootcamp.week1.day4;

import academy.kovalevskyi.codingbootcamp.week1.day2.StdString1;
import academy.kovalevskyi.codingbootcamp.week1.day2.StringUtils;

public class StdString2 extends StdString1 {
  
  public StdString2() {
  }

  public StdString2(char[] base) {
    super(base);
  }

  public StdString2(StdString2 that) {
    super(that.base);
  }

  public StdString2 toAsciiLowerCase() {
    StringBuilder stringBuilder = StringUtils.makeLowercase(this.base);
    char[] charArray = new char[stringBuilder.length()];
    stringBuilder.getChars(0, stringBuilder.length(), charArray, 0);
    return new StdString2(charArray);
  }

  public StdString2 toAsciiUpperCase() {
    StringBuilder stringBuilder = StringUtils.makeUppercase(this.base);
    char[] charArray = new char[stringBuilder.length()];
    stringBuilder.getChars(0, stringBuilder.length(), charArray, 0);
    return new StdString2(charArray);
  }

  public StdString2 subString(int from, int to) {
    if (to > length() || from > length()) {
      throw new IndexOutOfBoundsException();
    } else if (from > to) {
      throw new IllegalArgumentException();
    }
    char[] chars = new char[to - from];
    int count = 0;
    for (int i = from; i < to; i++) {
      chars[count++] = charAt(i);
    }
    return new StdString2(chars);
  }

  public StdString2 concat(StdString2... that) {
    StdString1 newString = new StdString1(this);
    for (StdString2 i : that) {
      newString = newString.append(i);
    }
    return new StdString2(newString.toCharArray());
  }


  public StdString2[] split(char separator) {
    StdString2 ss5 = this;
    int philipCounter = 0;
    for (int i = this.length() - 1; i >= 0; i--) {
      if (this.charAt(i) == separator) {
        philipCounter++;
      } else {
        break;
      }
    }
    ss5 = this.subString(0, length() - philipCounter);
    int count = 0;
    StdString2[] ss2 = new StdString2[ss5.length()];
    int fromLida = 0;
    for (int i = 0; i < ss5.length(); i++) {
      if (ss5.charAt(i) == separator) {
        ss2[count++] = ss5.subString(fromLida, i);
        fromLida = i + 1;
      }
    }
    if (ss5.length() > 0) {
      ss2[count++] = ss5.subString(fromLida, ss5.length());
    }
    StdString2[] ss2New = new StdString2[count];
    System.arraycopy(ss2, 0, ss2New, 0, count);
    return ss2New;
  }

  public StdString2 trim() {
    if (length() == 0) {
      return this;
    }
    boolean startFind = false;
    int startPosition = 0;
    int endPosition = 0;
    for (int i = 0; i < length(); i++) {
      if (this.base[i] >  ' ' && !startFind) {
        startFind = true;
        startPosition = i;
        endPosition = i;
      } else if (this.base[i] >  ' ' && startFind) {
        endPosition = i;
      }
    }
    return subString(startPosition, endPosition + 1);
  }

  public StdString2 removeCharacter(char toRemove) {
    char[] tempArray = new char[length()];
    int charCount = 0;
    for (int i = 0; i < length(); i++) {
      if (this.base[i] != toRemove) {
        tempArray[charCount++] = this.base[i];
      }
    }
    char[] newArray = new char[charCount];
    for (int i = 0; i < charCount; i++) {
      newArray[i] = tempArray[i];
    }
    return new StdString2(newArray);
  }
}
