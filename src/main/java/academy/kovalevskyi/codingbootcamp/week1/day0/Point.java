package academy.kovalevskyi.codingbootcamp.week1.day0;

public class Point implements Comparable<Point> {
  private final int coordinateX;
  private final int coordinateY;

  public Point(final int coordinateX, final int coordinateY) {
    this.coordinateX = coordinateX;
    this.coordinateY = coordinateY;
  }

  public int getX() {
    return this.coordinateX;
  }

  public int getY() {
    return this.coordinateY;
  }

  public Point sum(final Point that) {
    return new Point(this.getX() + that.getX(), this.getY() + that.getY());
  }

  public Point updateX(int newX) {
    return new Point(newX, this.getY());
  }

  public Point updateY(int newY) {
    return new Point(this.getX(), newY);
  }

  public int distanceTo(Point that) {
    return (this.getX() - that.getX()) * (this.getX() - that.getX())
        + (this.getY() - that.getY()) * (this.getY() - that.getY());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) { 
      return true;
    }

    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Point otherPoint = (Point) o;

    return this.getX() == otherPoint.getX() && this.getY() == otherPoint.getY();
  }

  @Override
  public int hashCode() {
    return this.getX() + this.getY();
  }

  @Override
  public String toString() {
    return "Point{" 
        + "X: " 
        + this.getX() 
        + ", Y: " 
        + this.getY() 
        + '}';
  }

  @Override
  public int compareTo(Point o) {
    return this.hashCode() - o.hashCode();
  }
}

