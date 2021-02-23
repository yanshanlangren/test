package elvis.leetcode;

public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int num = nums1.length + nums2.length, i1 = 0, i2 = 0;
        double mid_sum = 0.0;
        boolean isOdd = num % 2 == 1;
        int[] merged = new int[num];
        for (int i = 0; i < num; i++) {
            if (i1 >= nums1.length)
                merged[i] = nums2[i2++];
            else if (i2 >= nums2.length)
                merged[i] = nums1[i1++];
            else
                merged[i] = nums1[i1] > nums2[i2] ? nums2[i2++] : nums1[i1++];
            if (isOdd) {
                if (i == (num - 1) / 2)
                    return (double) merged[i];
            } else {
                if (i == (num / 2 - 1)) {
                    mid_sum = (double) merged[i];
                    continue;
                } else if (i == num / 2) {
                    return (mid_sum + (double) merged[i]) / 2;
                }
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        FindMedianSortedArrays fmsa = new FindMedianSortedArrays();
//        System.out.println(fmsa.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
//        System.out.println(fmsa.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
//        System.out.println(fmsa.findMedianSortedArrays(new int[]{0, 0}, new int[]{0, 0}));
//        System.out.println(fmsa.findMedianSortedArrays(new int[0], new int[]{1}));
        System.out.println(fmsa.findMedianSortedArrays(new int[]{2}, new int[0]));
    }
}
