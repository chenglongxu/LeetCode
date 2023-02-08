package Year2023.Month02;

import java.util.*;

/**
 * https://leetcode.cn/problems/decode-the-message/
 *
 * @author xuchenglong
 */
public class LeetCode1604 {

    public static void main(String[] args) {
        System.out.println(alertNames(new String[]{"daniel", "daniel", "daniel", "luis", "luis", "luis", "luis"}, new String[]{"10:00", "10:40", "11:00", "09:00", "11:00", "13:00", "15:00"}));
        System.out.println(alertNames(new String[]{"alice", "alice", "alice", "bob", "bob", "bob", "bob"}, new String[]{"12:01", "12:00", "18:00", "21:00", "21:20", "21:30", "23:00"}));
        System.out.println(alertNames(new String[]{"john", "john", "john"}, new String[]{"23:58", "23:59", "00:01"}));
        System.out.println(alertNames(new String[]{"leslie", "leslie", "leslie", "clare", "clare", "clare", "clare"}, new String[]{"13:00", "13:20", "14:00", "18:00", "18:51", "19:30", "19:49"}));
        System.out.println(alertNames(new String[]{"leslie", "leslie", "leslie", "clare", "clare", "clare", "clare"}, new String[]{"13:00", "13:20", "14:00", "18:00", "18:51", "19:30", "19:49"}));
        System.out.println(alertNames(new String[]{"a", "a", "a", "a", "a", "a", "b", "b", "b", "b", "b"}, new String[]{"23:27", "03:14", "12:57", "13:35", "13:18", "21:58", "22:39", "10:49", "19:37", "14:14", "10:41"}));
    }

    public static List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<String>> peopleMap = new HashMap<>(keyName.length * 2);
        for (int i = 0; i < keyName.length; i++) {
            peopleMap.computeIfAbsent(keyName[i], f -> new ArrayList<>()).add(keyTime[i]);
        }
        List<String> returnList = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : peopleMap.entrySet()) {
            if (entry.getValue().size() < 3) {
                continue;
            }
            int count = 1;
            int timeDifference = 0;
            String beforeTime = null;
            for (int i = 0; i < entry.getValue().size(); i++) {
                String time = entry.getValue().get(i);
                if (beforeTime != null) {
                    if (beforeTime.compareTo(time) >= 0) {
                        count = 1;
                        timeDifference = 0;
                    } else {
                        count++;
                        String[] befores = beforeTime.split(":");
                        String[] currents = time.split(":");
                        timeDifference += (Integer.parseInt(currents[0]) - Integer.parseInt(befores[0])) * 60 + Integer.parseInt(currents[1]) - Integer.parseInt(befores[1]);
                    }
                }
                if (timeDifference >= 60) {
                    i -= count - 1;
                    count = 1;
                    timeDifference = 0;
                    beforeTime = null;
                    continue;
                }
                if (count == 3) {
                    returnList.add(entry.getKey());
                    break;
                }
                beforeTime = time;
            }
        }
        Collections.sort(returnList);
        return returnList;
    }

}
