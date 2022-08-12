import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode1282 {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            List<Integer> orDefault = map.getOrDefault(groupSizes[i], new ArrayList<>());
            orDefault.add(i);
            map.put(groupSizes[i], orDefault);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int k : map.keySet()) {
            List<Integer> integers = map.get(k);
            List<Integer> track = new ArrayList<>();
            for (int i = 0; i < integers.size(); i++) {
                track.add(integers.get(i));
                if (track.size() == k) {
                    res.add(track);
                    track = new ArrayList<>();
                }
            }
        }
        return res;
    }
}
