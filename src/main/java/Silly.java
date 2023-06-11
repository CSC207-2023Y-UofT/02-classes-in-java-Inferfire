import java.util.Arrays;

public class Silly implements Comparable<Silly>{
    /* 1. static variable assignment as 0, increases with count static */
    public static int my_static = 0;

    // non-static attribute.
    public String name;


    /** returns the current countStatic var and increments it
     *
     * @return the value of my_static prior to its incrementation
     */
    public int countStatic() {
        // This method uses the static variable and increases it.
        int to_return = my_static;
        my_static += 1;

        return to_return;
    }

    /** creates a new Silly object using a single String
     *
     * @param name the name of this Silly instance.
     */
    public Silly(String name) {
        this.name = name;
    }

    /** 2. overloaded method creates a new Silly object using a single int
     *
     * @param number part of the name of this Silly instance.
     */
    public Silly(int number) {
        this.name = "Silly #" + number;
    }

    /** creates a new Silly object with .name attr of 2 str vars
     *
     * @param first refers to the first string input to be joined
     * @param second refers to the second string input to be joined
     */
    public Silly(String first, String second) {  // task 1: takes 2 inputs
        this.name = first + second;  // task 1: concatenates the two inputs
    }

    // main
    public static void main(String[] args) {
        Silly first_version = new Silly("single str name");
        Silly second_version = new Silly(5);
        Silly third_version = new Silly("first", "second");

        System.out.println("Silly 1: " + first_version);
        System.out.println("Silly 2: " + second_version);
        System.out.println("Silly 3: " + third_version);


        Silly x = new Silly("something");
        Silly y = new Silly("something else");

        x.countStatic();
        y.countStatic();
        x.countStatic();
        x.countStatic();

        // task 2: -sets return var, then increments
        int[] expected_values = {0, 1, 2, 3};

        System.out.println("The countStatic calls will return "
                + Arrays.toString(expected_values));
    }

    /** 3. Returns the String representation of this Silly object
     *
     * @return the name of this Silly (.name attribute).
     */
    @Override
    public String toString(){
        return this.name; // task 3: returning str representation via name attr
    }

    /** 4. Returns a boolean indicating if this.name == other.name
     *
     * @param o object to be compared.
     * @return a boolean indicating if the name comparison is True or False
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Silly)){
            return false;
        }

        Silly other = (Silly) o; // To access .name of o, we need to cast it.

        return this.name.equals(other.name); // task 4: returns .name comparison
    }

    /** 5. Returns an integer based on the comparison of .name lengths
     *
     * @param other the object to be compared.
     * @return a -ve integer, 0, or +ve int, obj.name <, =, or > than other.name
     */
    @Override
    public int compareTo(Silly other) {
        // if longer, return > 0, if shorter, return < 0, else = 0
        return this.name.length() - other.name.length();
    }
}
