import java.util.*;

/**
 * Created by thanksgiving on 9/21/16.
 */
public class Solution {
    private static Map<String, List<String>> map = new HashMap<>();
    private static Map<String, List<Integer>> countMap = new HashMap<>();
    private static int numOfBlock = 1;
    private static final String DELIMINATOR = " ";

    public static void main(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner scanner = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
//        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        while (true) {
            String input = scanner.nextLine();
            String res = execute(input);
            System.out.println(res);
//            bw.write(String.valueOf(res));
//            bw.newLine();
        }
    }

    public static String execute(String input) {
        if (input == null) return "";
//        System.out.println("input: " + input);
        input = input.trim();
        String command;
        String[] args = new String[1];
        if (input.contains(DELIMINATOR)) {
            Integer index = input.indexOf(DELIMINATOR);
            command = input.substring(0, index).toUpperCase();
            String arguments = input. substring(index + 1);
            args = arguments.trim().split(DELIMINATOR);
        } else {
            command = input.toUpperCase();
        }

        if (command != null) {
            switch (command) {
                case "END":
                    end();
                    return "END";
                case "BEGIN":
                    begin();
                    return "BEGIN";
                case "COMMIT":
                    commit();
                    return "COMMIT";
                case "ROLLBACK":
                    rollback();
                    return "ROLLBACK\n> NO TRANSACTION";
                case "SET":
                    if (args.length == 2) {
                        set(args[0], args[1]);
                        return input;
                    }
                    System.out.println("Invalid number of arguments");
                    return input;
                case "GET":
                    if (args.length == 1) {
                        String val = get(args[0]);
                        return input + "\n" + "> " + val;
                    }
                    System.out.println("Invalid number of arguments");
                    return "GET\n" + "> NULL";
                case "NUMEQUALTO":
                    if (args.length == 1) {
                        int val = numEqualTo(args[0]);
                        return input + "\n> " + val;
                    }
                    System.out.println("Invalid number of arguments");
                    return input + "\n" + "> NULL";
                case "UNSET":
                    if (args.length == 1) {
                        unset(args[0]);
                        return input;
                    }
                    System.out.println("Invalid number of arguments");
                    return input;
                default:
                    break;
            }
        }
        System.out.println("The inserted command does not exist!");
        return input;
    }

    public static void set(String key, String val) {
        String lastValue = get(key);
        if (lastValue == null) updateValueCount(val, 1);
        if (lastValue != null && !val.equals(lastValue)) {
            updateValueCount(lastValue, -1);
            updateValueCount(val, 1);
        }
        // handle key-val
        List<String> list;
        if (!map.containsKey(key)) {
            list = new ArrayList<>();
            for (int i = 0; i <= numOfBlock - 2; i++) {
                list.add(null);
            }
            list.add(val);
        } else {
            list = map.get(key);
            if (list.size() == numOfBlock) {
                list.set(numOfBlock - 1, val);
            } else {
                for (int i = list.size(); i <= numOfBlock - 2; i++) {
                    list.add(null);
                }
                list.add(val);
            }
        }
        map.put(key, list);
    }

    public static String get(String key) {
        // handle key-val
        if (!map.containsKey(key)) {
            return null;
        } else {
            if (map.get(key).size() < numOfBlock) return null;
            return map.get(key).get(numOfBlock - 1);
        }
    }

    public static int getValueCount(String val) {
        if (!countMap.containsKey(val)) return 0;
        List<Integer> list = countMap.get(val);
        if (list.size() < numOfBlock) return 0;
        return list.get(numOfBlock - 1);
    }

    public static void updateValueCount(String val, int interval) {
        if (!countMap.containsKey(val)) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i <= numOfBlock - 2; i++) {
                list.add(0);
            }
            list.add(1);
            countMap.put(val, list);
            return;
        }
        List<Integer> list = countMap.get(val);
        if (list.size() == numOfBlock) {
            int currentCount = list.get(numOfBlock - 1);
            currentCount += interval;
            list.set(numOfBlock - 1, currentCount);
        } else {
            for (int i = list.size(); i <= numOfBlock - 2; i++) {
                list.add(0);
            }
            list.add(1);
        }
        countMap.put(val, list);
    }

    public static void unset(String key) {
        // handle key-val
        if (!map.containsKey(key)) return;
        List<String> list = map.get(key);
        if (list.size() == numOfBlock) {
            updateValueCount(list.get(numOfBlock - 1), -1);
            list.set(numOfBlock - 1, null);
        } else {
            for (int i = list.size(); i < numOfBlock - 1; i++) {
                list.add(null);
            }
        }
    }

    public static int numEqualTo(String val) {
        if (!countMap.containsKey(val)) return 0;
        List<Integer> list = countMap.get(val);
        System.out.println("count list: " + list);
        if (list.size() < numOfBlock) return 0;
        return list.get(numOfBlock - 1);
    }

    public static void begin() {
        numOfBlock++;
        // duplicate the value from previous transaction block
        for (String key : map.keySet()) {
            List<String> list = map.get(key);
            String last = list.get(list.size() - 1);
            list.add(last);
            map.put(key, list);
        }

        for (String val : countMap.keySet()) {
            List<Integer> list = countMap.get(val);
            Integer last = list.get(list.size() - 1);
            list.add(last);
            countMap.put(val, list);
        }
    }

    public static void rollback() {
        numOfBlock--;
        // set the value at last block as null
        for (String key : map.keySet()) {
            List<String> list = map.get(key);
            if (list.size() == numOfBlock + 1) {
                list.set(numOfBlock, null);
            }
            map.put(key, list);
        }

        for (String val : countMap.keySet()) {
            List<Integer> list = countMap.get(val);
            if (list.size() == numOfBlock + 1) {
                list.set(numOfBlock, null);
            }
            countMap.put(val, list);
        }
    }

    public static void commit() {
        numOfBlock = 1;
        // update all list for key and val map
        for (String key : map.keySet()) {
            List<String> list = map.get(key);
            String last = list.get(list.size() - 1);
            list = new ArrayList<>();
            list.add(last);
            map.put(key, list);
        }

        for (String val : countMap.keySet()) {
            List<Integer> list = countMap.get(val);
            Integer last = list.get(list.size() - 1);
            list = new ArrayList<>();
            list.add(last);
            countMap.put(val, list);
        }
    }

    public static void end() {
        System.exit(0);
    }
}
