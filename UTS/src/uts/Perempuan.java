
package uts;


public class Perempuan extends Manusia {

    public Perempuan(double tinggiBadan) {
        super(tinggiBadan, "Perempuan");
    }

    @Override
    public double hitBBI() {
        return (tinggiBadan - 100) * 0.8;
    }
}