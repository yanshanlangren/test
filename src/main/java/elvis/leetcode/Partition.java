package elvis.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Partition {
    List<List<String>> ans;

    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        backtrace(new ArrayList<>(), s);
        return ans;
    }

    public void backtrace(List<String> path, String s) {
        if (s == null || s.length() == 0) {
            ans.add(path);
            return;
        }
        for (int i = 1; i <= s.length(); i++) {
            String str = s.substring(0, i);
            if (isHuiwen(str)) {
                List<String> l = new ArrayList<>(path);
                l.add(str);
                backtrace(l, s.substring(i, s.length()));
            }
        }
    }

//    public List<List<String>> partition_loop(String s) {
//        int len = s.length();
//        List<List<String>>[] dp = new ArrayList[len + 1];
//        for (int i = 0; i <= len; i++)
//            dp[i] = new ArrayList();
//        for (int i = 0; i <= len; i++) {
//            for (int j = i + 1; j <= len; j++) {
//                String str = s.substring(i, j);
//                if (isHuiwen(str)) {
//                    if (dp[i].size() == 0) {
//                        List<String> l = new ArrayList<>();
//                        l.add(str);
//                        dp[j].add(l);
//                    } else {
//                        for (List<String> l : dp[i]) {
//                            List<String> newlist = new ArrayList(l);
//                            newlist.add(str);
//                            dp[j].add(newlist);
//                        }
//                    }
//                }
//            }
//        }
//        return dp[len];
//    }

    public boolean isHuiwen(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--)
            sb.append(s.charAt(i));
        return sb.toString().equals(s);
    }

    public static void main(String[] args) {
        Partition p = new Partition();
        System.out.println(p.partition("abbab"));
    }
}
