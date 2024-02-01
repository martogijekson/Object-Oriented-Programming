
package soal3;


class Lingkaran {
  double radius;
  String warna;

  Lingkaran(double radius, String warna) {
    this.radius = radius;
    this.warna = warna;
  }

  double getLuas() {
    return Math.PI * radius * radius;
  }

  void printInfo() {
    System.out.println("Lingkaran berwarna " + warna + ", luas = " + getLuas());
  }
}

class Silinder extends Lingkaran {
  double tinggi;

  Silinder(double tinggi, double radius, String warna) {
    super(radius, warna);
    this.tinggi = tinggi;
  }

  double hitungVolume() {
    return getLuas() * tinggi;
  }

  void printInfo() {
    super.printInfo();
    System.out.println(", volume = " + hitungVolume());
  }
}

public class Soal3 {
  public static void main(String[] args) {
    Silinder silinder = new Silinder(10, 5, "Merah");

    silinder.printInfo();
  }
}