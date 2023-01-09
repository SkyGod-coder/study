package me.skygod.test;

import java.util.*;

public class Options {
    private int[] nums;
    public int max = 0;
    public int min = 0;
    public int maxTimes = 0;
    public int minTimes = 0;

    public Options() {
        nums = new int[]{-1, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    }

    public boolean next() {
        nums[0]++;
        for (int i = 0; i < 10; i++) {
            if (nums[9] == 4) return false;
            else if (nums[i] == 4) {
                nums[i] = 0;
                nums[i + 1]++;
            }
        }
        return true;
    }

    public int[] getNums() {
        return nums;
    }

    private String getKey(Map<String, Integer> timesMap, int value) {
        for (String s : timesMap.keySet()) {
            if (timesMap.get(s) == value) return s;
        }
        return null;
    }

    public void sort() {
        Map<String, Integer> timesMap = new HashMap<>();
/*        timesMap.put("0",0);//A
        timesMap.put("1",0);//B
        timesMap.put("2",0);//C
        timesMap.put("3",0);//D*/
        for (int i = 0; i < 10; i++) {
            switch (nums[i]) {
                case 0:
                    timesMap.put("0", timesMap.containsKey("0") ? timesMap.get("0") + 1 : 0);
                    break;
                case 1:
                    timesMap.put("1", timesMap.containsKey("1") ? timesMap.get("1") + 1 : 0);
                    break;
                case 2:
                    timesMap.put("2", timesMap.containsKey("2") ? timesMap.get("2") + 1 : 0);
                    break;
                case 3:
                    timesMap.put("3", timesMap.containsKey("3") ? timesMap.get("3") + 1 : 0);
                    break;
            }
        }
        Object[] times = timesMap.values().toArray();
        Arrays.sort(times);
        List<Object> timesRemove = new ArrayList<>(Arrays.asList(times));
        timesRemove.remove(times[0]);
        timesRemove.remove(times[times.length - 1]);
        if (timesRemove.contains(times[0]) || timesRemove.contains(times[times.length - 1])) {
            //��ֵ�ظ�
            max = 6;
            min = 6;
        } else {
            min = Integer.parseInt(getKey(timesMap, (Integer) times[0]));
            max = Integer.parseInt(getKey(timesMap, (Integer) times[times.length - 1]));
            min = (int) times[0];
            max = (int) times[times.length - 1];
        }
    }

    @Override
    public String toString() {
        return "Options{" +
                "nums=" + Arrays.toString(nums) +
                '}';
    }
}
