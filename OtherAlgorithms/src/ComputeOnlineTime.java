import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by thanksgiving on 4/19/16.
 */
public class ComputeOnlineTime {
    public static void main(String[] args) {
        ComputeOnlineTime obj = new ComputeOnlineTime();
        String file = "/home/thanksgiving/leetCodeWorkSpace/OtherAlgorithms/log";
        double percent = obj.getOnlineTimePerc(file);
        System.out.println(percent);
    }

    private static SimpleDateFormat pattern = new SimpleDateFormat("MM/dd/yyyy-HH:mm:ss");
    private static String connected = "CONNECTED";
    private static String disconnected = "DISCONNECTED";
    private static String shutdown = "SHUTDOWN";
    private static String start = "START";
    public double getOnlineTimePerc(String file) {
        Scanner sc = null;
        Date startDate = null;
        long connectTime = 0;
        long totalTime = 0;
        try {
            sc = new Scanner(new File(file));
            boolean isConnect = false;
            Date connectDate = null;
            Date disConnectDate = null;
            Date shutdownDate = null;
            while (sc.hasNextLine()) {
                String[] fields = sc.nextLine().split("::");
                int endPos = fields[0].trim().indexOf(')');
                String time = fields[0].substring(1, endPos);
                if (fields[1].trim().equals(start)) {
                    startDate = pattern.parse(time);
                }
                if (fields[1].trim().equals(connected) && !isConnect) {
                    isConnect = true;
                    connectDate = pattern.parse(time);
                }
                if (fields[1].trim().equals(disconnected) && isConnect) {
                    isConnect = false;
                    disConnectDate = pattern.parse(time);
                    connectTime += disConnectDate.getTime() - connectDate.getTime();
                }
                if (fields[1].trim().equals(shutdown)) {
                    if (isConnect) {
                        isConnect = false;
                        disConnectDate = pattern.parse(time);
                        connectTime += disConnectDate.getTime() - connectDate.getTime();
                    }
                    shutdownDate = pattern.parse(time);
                    totalTime = shutdownDate.getTime() - startDate.getTime();

                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return (connectTime * 1.0) / (totalTime * 1.0);

    }
}
