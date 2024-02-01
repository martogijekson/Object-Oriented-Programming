
package uts;


public class LakiLaki extends Manusia {

    public LakiLaki(double tinggiBadan) {
        super(tinggiBadan, "Laki-Laki");
    }

    @Override
    public double hitBBI() {
        return (tinggiBadan - 100) * 0.9;
    }
}