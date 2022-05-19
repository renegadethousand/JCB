package academy.kovalevskyi.codingbootcamp.week1.day1;

import academy.kovalevskyi.codingbootcamp.week1.day0.Point;
import java.util.function.Function;

public class PointWithValue<T> extends Point {

  private T value;

  public PointWithValue(int coordinateX, int coordinateY, T value) {
    super(coordinateX, coordinateY);
    this.value = value;
  }

  public T getValue() {
    return this.value;
  }

  public <R> PointWithValue<R> mapPoint(Function<T, R> mapFunction) {
    return new PointWithValue<>(this.getX(), this.getY(), mapFunction.apply(this.value));
  }

  @Override
  public String toString() {
    return String.format("PointWithValue{" 
        + "X: %d,"
        + " Y: %d,"
        + " value: %s"
        + '}', this.getX(), this.getY(), this.value);
  }
}
