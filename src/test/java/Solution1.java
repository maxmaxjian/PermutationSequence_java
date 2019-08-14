import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.swap;

public class Solution1 implements Solution {
    @Override
    public String getPermutation(int n, int k) {

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        for (int i = 0; i < k-1; i++) {
            permute(list);
        }

        StringBuilder stringBuilder = new StringBuilder();
        list.forEach(i->stringBuilder.append(i));

        return stringBuilder.toString();
    }

    private void permute(List<Integer> list) {
        int last = lastMaximum(list);
        if (last == 0) {
            Collections.sort(list);
        } else {
            int idx = last;
            for (int i = last; i < list.size(); i++) {
                if (list.get(i) > list.get(last-1)) {
                    idx = i;
                }
            }
            Collections.swap(list, last-1, idx);
            List<Integer> sub = list.subList(last, list.size());
            Collections.sort(sub);
        }
    }

    private int lastMaximum(List<Integer> list) {
        int i = list.size()-1;
        while (i > 0 && list.get(i) <= list.get(i-1)) {
            i--;
        }
        return i;
    }
}
