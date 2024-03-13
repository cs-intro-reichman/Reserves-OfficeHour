/** Represents a signed fraction, e.g. 2/3 or -1/5.
 * @author IDC Intro to CS staff
 */
public class Fraction {

    // The fields of this Fraction object
    private int numerator;
    private int denominator;
  
    /** Constructs a fraction.
     *  The newly constructed fraction is reduced.
     *  For example, given 6 and 9, constructs the fraction 2/3.
     *  If the denominator is negative, switches the signs of both the numerator and the denominator.
     *  For example, 2/-3 becomes -2/3, and -2/-3 becomes 2/3.     
     * @param numerator    can be signed
     * @param denominator  can be signed
     */
    public Fraction (int numerator, int denominator) {
        // Handles the signs of the numerator and denominator
    	if (denominator < 0) {
            numerator = numerator * -1;
            denominator = denominator * -1;
        }
        // Initializes the object's fields
        this.numerator = numerator;
        this.denominator = denominator;
        // Divides the numerator and denominator by their greatest common divisor
        this.reduce();   
    }

    /** Returns the numerator of this fraction.
     * @return the numerator of this fraction
     */
    public int getNumerator() {
        return numerator;
    }

    /** Returns the denominator of this fraction.
     * @return the denominator of this fraction
     */
    public int getDenominator() {
        return denominator;
    }

    /** Returns a fraction which is the reciprocal of this fraction.
     * @return the reciprocal of this fraction
     */
    public Fraction invert() {
        return new Fraction(denominator, numerator);
    }

    /** Returns a fraction which is the sum of this fraction and the other one.
     * @param other   the fraction to which this fraction is added
     * @return        a fraction which is the sum of this fraction and the other one
     */
    public Fraction add(Fraction other) {
        return new Fraction (
                     (numerator * other.denominator + other.numerator * denominator) ,
                      denominator * other.denominator );
    }

    /** Returns a fraction which is the product of this fraction and the other one.
     * @param other  the fraction by which this fraction is multiplied
     * @return       a fraction which is the product of this fraction and the other one
     */
    public Fraction multiply(Fraction other) {
        return new Fraction (
        		    numerator * other.numerator,
                    denominator * other.denominator);
    }

    /** Returns a fraction which is the division of this fraction and the other one.
     * @param   other the fraction by which this fraction is divided
     * @return  a fraction which is the division of this fraction and the other one
     */
     public Fraction divide(Fraction other) {
         return multiply(other.invert());
     } 

    /** Returns a string representation of this fraction, in the form "numerator/denominator".
     * Special cases:
     * If the numerator is 0, returns "0". If the denominator is 1, returns the numerator.
     * @return A textual representation of this Fraction, in the form "numerator/denominator
     */
    public String toString () {
        String result;
        if (numerator == 0)
            result = "0";
        else
            if (denominator == 1)
                result = numerator + ""; 
            else
                result = numerator + "/" + denominator;
        return result;
    }
    
    // Reduces this fraction, by dividing both the numerator
    // and denominator by their greatest common divisor (GCD).
    private void reduce() {
        if (numerator != 0) {
            int gcd = gcd (Math.abs(numerator), denominator);
            numerator = numerator / gcd;
            denominator = denominator / gcd;
        }
    }

    // Helper function (will be best to put it in another class, e.g. MyMath).
    // Computes and returns the greatest common divisor of two positive numbers.
    // Uses Euclid's algorithm.
    static int gcd(int x, int y) {
        int rem;
        while (y != 0) {
            rem = x % y;
            x = y;
            y = rem;     
        }
        return x;
    }
}