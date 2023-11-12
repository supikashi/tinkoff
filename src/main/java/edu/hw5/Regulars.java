package edu.hw5;

import java.util.regex.Pattern;

public class Regulars {
    private Regulars() {
    }

    // Task4
    public static Pattern strongPasswordPattern = Pattern.compile("[~!@#$%^&*|]");

    // Task5
    public static Pattern vehicleRegistrationPlates =
        Pattern.compile("^[АВЕКМНОРСТУХ]\\d{3}[АВЕКМНОРСТУХ]{2}\\d{2,3}$");

    // Task7
    public static Pattern binaryString1 = Pattern.compile("^[01]{2}0[01]*$");
    public static Pattern binaryString2 = Pattern.compile("^[0|1]$|^1[01]*1$|^0[01]*0$");
    public static Pattern binaryString3 = Pattern.compile("^[01]{1,3}$");

    // Task8
    // строка нечётной длинны
    public static Pattern binaryString4 = Pattern.compile("^[01]([01]{2})*$");
    // начинается с 0 и имеет нечетную длину, или начинается с 1 и имеет четную длину
    public static Pattern binaryString5 = Pattern.compile("^0([01]{2})*$|^1[01]([01]{2})*$");
}
