import java.io.*;

public class Main {
    public static String[] ok = {"КБ", "МБ", "ГБ", "ТБ", "ПБ", "KB", "MB", "GB", "TB", "PB"};

    public static void main(String[] args) {
        try {
            if (args.length == 0)
                throw new Exception("No input given");
            else {
                for (int i = 0; i < args.length - 1; i++) {
                    if (!isNumeric(args[i]))
                        throw new Exception("NaN");
                    if (!isOK(args[i + 1]))
                        throw new Exception("Wrong format. Try these:\nКб, Мб, Гб, Тб, Пб, Kb, Mb, Gb, Tb, Pb");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public static boolean isOK(String inf) {
        for (String s : ok) {
            if (inf.toUpperCase().equals(s))
                return true;
        }
        return false;
    }
    public static boolean isNumeric(String strNum) {
        if (strNum == null)
            return false;
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}