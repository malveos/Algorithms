/**

@Author Omkar Malve

1710. Maximum Units on a Truck

You are assigned to put some amount of boxes onto one truck. You are given a 2D array boxTypes, where boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi]:

numberOfBoxesi is the number of boxes of type i.
numberOfUnitsPerBoxi is the number of units in each box of the type i.
You are also given an integer truckSize, which is the maximum number of boxes that can be put on the truck. You can choose any boxes to put on the truck as long as the number of boxes does not exceed truckSize.

Return the maximum total number of units that can be put on the truck.



***/
class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (x, y) -> y[1] - x[1]);
        //System.out.println(Arrays.deepToString(boxTypes));

        int ans = 0;
        for (int [] e : boxTypes) {
            int load = Math.min(truckSize, e[0]);
            ans += e[1] * load;
            truckSize -= load;
            if (truckSize == 0) break;
            /*
            if (truckSize > e[0]) {
                truckSize -= e[0];
                //System.out.println("Adding " + e[0] + " * " + e[1]);
                ans += e[1] * e[0]; 
            } else if (truckSize != 0) {
                //System.out.println("Adding " + truckSize + " * " + e[1]);
                ans += truckSize * e[1];
                break;
            }*/
        }
        return ans;
    }
}