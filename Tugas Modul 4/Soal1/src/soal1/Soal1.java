package soal1;

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

class BujurSangkar extends Bentuk {
  double sisi;

  public BujurSangkar(double sisi, String warna) {
    super(warna);
    this.sisi = sisi;
  }

  public double getSisi() {
    return sisi;
  }

  public void setSisi(double sisi) {
    this.sisi = sisi;
  }

  public double hitungLuas() {
    return sisi * sisi;
  }

  @Override
  public void printInfo() {
    super.printInfo();
    System.out.println(", luas = " + hitungLuas());
  }
}

public class Soal1 {
  public static void main(String[] args) {
    Bentuk bujurSangkar = new BujurSangkar(5, "merah");
    bujurSangkar.printInfo();
  }
}