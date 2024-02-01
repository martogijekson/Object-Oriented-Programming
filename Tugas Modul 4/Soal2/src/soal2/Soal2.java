package soal2;

class Bentuk {
  String warna;

  public Bentuk(String warna) {
    this.warna = warna;
  }

  public String getWarna() {
    return warna;
  }

  public void setWarna(String warna) {
    this.warna = warna;
  }

  public void printInfo() {
    System.out.println("Bentuk berwarna " + warna);
  }
}

class Lingkaran extends Bentuk {
  double radius;
  static final double PHI = 3.14;

  public Lingkaran(double radius, String warna) {
    super(warna);
    this.radius = radius;
  }

  public double getRadius() {
    return radius;
  }

  public void setRadius(double radius) {
    this.radius = radius;
  }

  public double hitungLuas() {
    return PHI * radius * radius;
  }

  @Override
  public void printInfo() {
    super.printInfo();
    System.out.println(", luas = " + hitungLuas());
  }
}

public class Soal2 {
  public static void main(String[] args) {
    Lingkaran lingkaran = new Lingkaran(5, "merah");
    lingkaran.printInfo();
  }
}