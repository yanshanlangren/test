package elvis.leetcode;

public class ParkingSystem {
    int[] cap = new int[3];
    int[] current = new int[3];
    public ParkingSystem(int big, int medium, int small) {
        cap[0] = big;
        cap[1] = medium;
        cap[2] = small;
    }

    public boolean addCar(int carType) {
        if(cap[carType-1]>=current[carType-1]+1){
            current[carType-1]++;
            return true;
        }
        return false;
    }
}
