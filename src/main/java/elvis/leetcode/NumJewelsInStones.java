package elvis.leetcode;

public class NumJewelsInStones {
    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        for (int i = 0; i < stones.length(); i++)
            if (jewels.indexOf(stones.charAt(i)) >= 0)
                count++;
        return count;
    }

    public static void main(String[] args) {
        NumJewelsInStones njis = new NumJewelsInStones();
        System.out.println(njis.numJewelsInStones("aA", "aAAbbbb"));
    }
}
