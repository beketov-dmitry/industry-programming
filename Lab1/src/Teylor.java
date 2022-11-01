import java.text.NumberFormat;

public class Teylor {
    public static String ln(double x, int k){
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMaximumFractionDigits(3);
        double lim = Math.pow(10, -k);
        double temp = (double) x;
        double touf = temp;
        double sum = 0;
        double div = 1;
        while(true){
            if(Math.abs(temp) < lim) break;
            sum += temp;
            div +=1;
            touf*=-x;
            temp = touf/div;
        }
        String res = formatter.format(sum);
        return res;
    }
}
