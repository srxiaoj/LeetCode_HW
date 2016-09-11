import java.util.*;

/**
 * Suspicious List：input 是String array，每个String银行转账记录，格式是：<Name>|<Amoun>|<City>|<Time>，如：Sam|200|New York|23:12。
 * 转账记录已经按Time排序。找出所有满足下面两个条件之一的Name并返回一个List：Amount > 3000；
 * 同一个Name在不同City任意两次转账时间间隔小于60分钟。List中的Name需要按照Time排序。如果是第二种情况，时间按第一次的时间算。
 * 如Sam于10:15在City A转账，并于11:00在City B转账，那么Sam的时间为10:15
 */
public class FindFraudTransactions {
    public static void main(String[] args) {
        String[] logs = new String[]{"Jim|4000|New York|10:35", "Sam|200|New York|10:15", "Sam|200|Chicago|11:00"};
        String[] logs2 = new String[]{"Sam|200|New York|10:15", "Jim|4000|New York|10:35", "Sam|200|Chicago|11:00", "Jim|5000|LA|13:35"};
        String[] logs3 = new String[]{"Jim|200|New York|10:05", "Sam|100|New York|10:15", "Sam|200|Chicago|11:00", "Jim|5000|LA|13:35"};
//        printArray(getSuspiciousList(logs));
//        printArray(getSuspiciousList(logs2));
//        printArray(getSuspiciousList(logs3));
//        System.out.println(getSuspiciousList2(logs));
//        System.out.println(getSuspiciousList2(logs2));
        System.out.println(getSuspiciousList2(logs3));
    }

    /**
     * Idea: scan from the end and add all (possibly duplicate) fraud names into the fraud list.
     * Each time a fraud name occurs, add it into the beginning of the list to maintain the required ordering property.
     * Afterwards, filter out the duplicate ones and add the unique fraud names into a new list
     * Time complexity: O(N), amortized
     * Space complexity: O(N), worst case
     */
    static String[] getSuspiciousList(String[] transactions) {
        if (transactions == null || transactions.length == 0) return new String[0];
        int len = transactions.length;
        Map<String, Integer> map = new HashMap<>();
        List<String> res = new LinkedList<>();

        for (int i = len - 1; i >= 0; i--) {
            String[] info = transactions[i].split("\\|");
            String name = info[0];
            int amount = Integer.parseInt(info[1]);
            String city = info[2];
            String[] timeStr = info[3].split(":");
            int time = Integer.parseInt(timeStr[0]) * 60 + Integer.parseInt(timeStr[1]);

            Integer prevId = map.get(name);
            if (amount > 3000) {
                res.add(0, name);
            } else if (prevId != null) {
                String[] transactionDetailPrev = transactions[prevId].split("\\|");
                String[] newTimeStr = transactionDetailPrev[3].split(":");
                int oldTime = Integer.parseInt(newTimeStr[0]) * 60 + Integer.parseInt(newTimeStr[1]);
//                System.out.println(oldTime + " " + time);
                if (!city.equals(transactionDetailPrev[2]) && oldTime - time < 60)
                    res.add(0, name);
            }
            map.put(name, i); // add name->index map into the map; if name existed already, simply update previous index with current one
        }

        // list may contain duplicates, the following is to filter out duplicates with the help of a HashSet
        Set<String> existingFraudNames = new HashSet<>();
        List<String> uniqueFraudList = new ArrayList<>();
        for (String name : res) {
            if (!existingFraudNames.contains(name)) uniqueFraudList.add(name);
            existingFraudNames.add(name);
        }
        return uniqueFraudList.toArray(new String[0]);
    }

    public static List<String> getSuspiciousList2(String[] logs) {
        List<String> res = new ArrayList<>();
        if (logs == null || logs.length == 0) return res;
        Map<String, Integer> map = new HashMap<>();
        for (int i = logs.length - 1; i >= 0; i--) {
            String[] info = logs[i].split("\\|");
            String[] timeStr = info[3].split(":");
            String city = info[2];
            int amount = Integer.parseInt(info[1]);

            int time = Integer.parseInt(timeStr[0]) * 60 + Integer.parseInt(timeStr[1]);


            if (amount > 3000) {
                res.add(0, info[0]);
                continue;
            }
            if (!map.containsKey(info[0])) {
                map.put(info[0], i);
            } else {
                String[] lastTranscation = logs[map.get(info[0])].split("\\|");
                String[] lastTimeStr = lastTranscation[3].split(":");
                int lastTime = Integer.parseInt(lastTimeStr[0]) * 60 + Integer.parseInt(lastTimeStr[1]);
                System.out.println(time + " " + lastTime);
                if (!city.equals(lastTranscation[2]) && lastTime - time < 60) {
                    res.add(0, info[0]);
                }
                map.put(info[0], i);
            }
        }

        Set<String> set = new HashSet<>();
        List<String> uniqueRes = new ArrayList<>();
        for (String name : res) {
            if (!set.contains(name)) {
                uniqueRes.add(name);
                set.add(name);
            }
        }

        return uniqueRes;
    }

    //print array
    public static void printArray(String[] A) {
        System.out.print("[");
        for (int i = 0; i < A.length; i++) {
            if (i != A.length - 1)
                System.out.print(A[i] + ", ");
            else
                System.out.print(A[i]);
        }
        System.out.println("]");
    }
}
