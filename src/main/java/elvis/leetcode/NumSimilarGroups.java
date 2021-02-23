package elvis.leetcode;

public class NumSimilarGroups {
    int[] father;

    public int numSimilarGroups(String[] strs) {
        father = new int[strs.length];
        for (int i = 0; i < strs.length; i++)
            father[i] = i;
        for (int i = 0; i < strs.length - 1; i++) {
            for (int j = i + 1; j < strs.length; j++)
                if (isSimilar(strs[i], strs[j]))
                    merge(i, j);
        }
        int count = 0;
        for (int i = 0; i < strs.length; i++)
            count += father[i] == i ? 1 : 0;
        return count;
    }

    public boolean isSimilar(String str1, String str2) {
        int count = 0;
        int[] NE = new int[2];
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                if (count >= 2)
                    return false;
                NE[count++] = i;
            }
        }
        if (str1.charAt(NE[0]) == str2.charAt(NE[1]) && str1.charAt(NE[1]) == str2.charAt(NE[0]))
            return true;
        return false;
    }


    public int find(int i) {
        return father[i] == i ? i : (father[i] = find(father[i]));
    }

    public void merge(int i, int j) {
        father[find(i)] = find(j);
    }

    public static void main(String[] args) {
        long t0 = System.currentTimeMillis();
        NumSimilarGroups nsg = new NumSimilarGroups();
        System.out.println(nsg.numSimilarGroups(new String[]{"tars", "rats", "arts", "star"}));
//        System.out.println(nsg.numSimilarGroups(new String[]{"omv", "ovm"}));
        System.out.println((System.currentTimeMillis() - t0) + " ms");
    }
}
