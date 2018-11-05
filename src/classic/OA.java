package classic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author create by Xiao Han 11/1/18
 * @version 1.0
 * @since jdk 1.8
 */
class OA {
    HashMap<String, Integer> blackList = new HashMap<String, Integer>();

    public String[] solution(String[] A, int Y) {


      LinkedHashMap<Integer, LinkedHashMap<String, List<Integer>>> history = new LinkedHashMap<Integer, LinkedHashMap<String, List<Integer>>>();
      LinkedHashMap<String, Integer> record = new LinkedHashMap<String, Integer>();

      Integer i = 0;
      for (String str : A) {
        String[] strArr = str.split(" ");
        String name = strArr[0];
        Integer time = Integer.parseInt(strArr[1]);
        i = time / 60 + 1;
        if (history.containsKey(i)) {
          Map<String, List<Integer>> client = history.get(i);
          if (client.containsKey(name)) {
            client.get(name).add(time);
          } else {
            List<Integer> list = new ArrayList<Integer>();
            list.add(time);
            client.put(name, list);
          }
        } else {
          LinkedHashMap<String, List<Integer>> map = new LinkedHashMap<>();
          List<Integer> list = new ArrayList<Integer>();
          list.add(time);
          map.put(name, list);
          history.put(i, map);
        }
      }

      int total = 0;
      for (Map.Entry<Integer, LinkedHashMap<String, List<Integer>>> entry : history.entrySet()) {
        int mark = entry.getKey();
        LinkedHashMap<String, List<Integer>> map = entry.getValue();

        if (total >= 10) {
          for (Map.Entry<String, Integer> e : record.entrySet()) {

            if (e.getValue()* 1.0 / total  > 0.5) {
              blackList.put(e.getKey(), mark + 2);
            }
          }
        }

        for (Map.Entry<String, List<Integer>> his : map.entrySet()) {

          String name = his.getKey();
          if (blackList.containsKey(name)) {
            System.out.println(blackList.get(name) + " " + mark);
            if (blackList.get(name) > mark) {
              continue;
            } else {
              blackList.remove(name);
            }
          }
          List<Integer> times = his.getValue();
          int count = times.size() > Y ? Y : times.size();
          if (record.containsKey(name)) {
            int val = record.get(name);
            record.put(name, val + count);
          } else {
            record.put(name, count);
          }
          total += count;
        }

      }
      String[] res = new String[record.size()];
      int count = 0;
      for (Map.Entry<String, Integer> e : record.entrySet()) {
        res[count++] = e.getKey() + " " + e.getValue();
      }

      return res;
    }


  public static void main(String[] args) {
    new OA().solution(new String[]{"client1 0", "client1 15", "client1 30", "client1 45", "client1 60", "client1 75", "client1 90", "client1 120", "client1 180", "client1 240", "client2 0", "client2 60", "client2 120", "client2 180", "client2 240", "client2 320"}, 3);
  }
}