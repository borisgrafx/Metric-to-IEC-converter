

public class Main {
    public static String[] ok = {"КБ", "МБ", "ГБ", "ТБ", "ПБ", "KB", "MB", "GB", "TB", "PB",
            "КИБ", "МИБ", "ГИБ", "ТИБ","ПИБ", "KIB", "MIB", "GIB", "TIB", "PIB"};
    public static boolean isMetric = true;
    public static int biteSum = 0; //Use me in Issue 4

    public static void main(String[] args) {

        try {
            if (args.length == 0)
                throw new Exception("No input given");
            else {
                for (int i = 0; i < args.length - 1; i++) {
                    if (i % 2 == 0)
                        if (!isNumeric(args[i]))
                            throw new Exception("NaN");
                        else
                        if (!isOK(args[i + 1]))
                            throw new Exception("Wrong format. Try these:\nКб, Мб, Гб, Тб, Пб, Kb, Mb, Gb, Tb, Pb");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        int nConv = args.length / 2;
        Double[] in = new Double[nConv];
        String[] vals = new String[nConv];
        int k = 0;
        boolean chet = true;
        for (String arg : args) {
            if (chet) {
                in[k] = Double.parseDouble(arg);
                chet = false;
            } else {
                vals[k] = arg;
                k++;
                chet = true;
            }

        }

        metricToIEC(in[0], vals[0]);
    }

    public static void metricToIEC(Double data, String val) {
        double out = data / 1000 * 1024;
        char IECval;
        if (val.toCharArray()[1] == 'b' || val.toCharArray()[1] == 'B')
            IECval = 'i';
        else
            IECval = 'и';
        System.out.println(data + " " + val + " = " + out + " " + val.toCharArray()[0] + IECval + val.toCharArray()[1]);
    }

    public static void iecToMetric(Double data, String val) {
        // Use me in Issue 3
    }

    public static boolean isOK(String inf) {
        for (int i = 0; i < ok.length; i++) {
            if (inf.toUpperCase().equals(ok[i])) {
                isMetric = i < ok.length / 2;
                return true;
            }
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
