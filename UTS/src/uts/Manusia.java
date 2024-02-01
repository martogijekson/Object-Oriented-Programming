
package uts;


public abstract class Manusia {

    protected double tinggiBadan;
    private String jenisKelamin;

    public Manusia(double tinggiBadan, String jenisKelamin) {
        this.tinggiBadan = tinggiBadan;
        this.jenisKelamin = jenisKelamin;
    }

    public double getTB() {
        return tinggiBadan;
    }

    public String getJK() {
        return jenisKelamin;
    }

    public abstract double hitBBI();
}