public class MixedFraction {
    private int whole;
    private int numerator;
    private int denominator;

    public MixedFraction(int whole, int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
        this.whole = whole + (numerator / denominator);
        if (denominator < 0) {
            numerator = numerator * -1;
            denominator = denominator * -1;
        }
        this.numerator = numerator % denominator;
        this.denominator = denominator;
        this.reduce();
    }

    public MixedFraction(int numerator, int denominator) {
        this(0, numerator, denominator);
    }   

    public MixedFraction(int whole) {
        this(whole, 0, 1);
    }   

    public MixedFraction() {
        this(0, 0, 1);
    }   

    public MixedFraction(Fraction f) {
        this(f.getNumerator(), f.getDenominator());
    }   


      // and denominator by their greatest common divisor (GCD).
      private void reduce() {
        if (numerator != 0) {
            int gcd = Fraction.gcd(Math.abs(numerator), denominator);
            numerator = numerator / gcd;
            denominator = denominator / gcd;
        }
    }
    
    public MixedFraction add(MixedFraction other) {
        int newWhole = whole + other.whole;
        //int newWhole = this.whole + other.whole; // this is the same as the line above
        int newNumerator = (numerator * other.denominator + other.numerator * denominator);
        int newDenominator = denominator * other.denominator;
        return new MixedFraction(newWhole, newNumerator, newDenominator);
    }

    public MixedFraction subtract(MixedFraction other) {
        int newWhole = whole - other.whole;
        int newNumerator = (numerator * other.denominator - other.numerator * denominator);
        int newDenominator = denominator * other.denominator;
        return new MixedFraction(newWhole, newNumerator, newDenominator);
    }

    public MixedFraction multiply(MixedFraction other) {
        int newWhole = whole * other.whole;
        int newNumerator = (numerator * other.numerator);
        int newDenominator = denominator * other.denominator;
        return new MixedFraction(newWhole, newNumerator, newDenominator);
    }

    public MixedFraction divide(MixedFraction other) {
        return multiply(other.invert());
    }

    public MixedFraction invert() {
        return new MixedFraction(0, denominator, numerator);
    }

    public String toString() {
        String result;
        if (numerator == 0) {
            result = whole + "";
        } else {
            if (whole == 0) {
                result = numerator + "/" + denominator;
            } else {
                result = whole + " " + numerator + "/" + denominator;
            }
        }
        return result;
    }

    public Fraction toImaginaryFraction() {
        return new Fraction(whole * denominator + numerator, denominator);
    }

    public static void main(String[] args) {
        MixedFraction f1 = new MixedFraction(3, 3, 2);
        MixedFraction f2 = new MixedFraction(-2, 8, 3);
        MixedFraction f3 = new MixedFraction(-2, -8, 3);
        MixedFraction f4 = new MixedFraction(-2, 4, -3);
        System.out.println(f1);
        System.out.println(f2);
        System.out.println(f3);
        System.out.println(f4);
    }
    

}
