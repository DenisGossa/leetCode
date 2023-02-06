public class Solution {

    public static void main(String[] args) {
        int[] h = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] h2 = {3, 1, 6, 5, 2, 3,};
        Solution solution = new Solution();
        int vol = solution.maxArea(h);

        System.out.println("vol=" + vol);
    }

    private int maxArea(int[] height) {
        int resultSqare = 0;
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        int currentLevel = 1;
        int tmpSquare = 0;

        while (leftIndex < rightIndex) {
            if (currentLevel <= height[leftIndex]) {
                if (currentLevel <= height[rightIndex]) {
                    tmpSquare = (rightIndex-leftIndex)* currentLevel;
                    if (tmpSquare > resultSqare) {
                        resultSqare = tmpSquare;
                    }
                    currentLevel++;
                    continue;
                }
                rightIndex--;
                continue;
            }
            leftIndex++;
        }
        return resultSqare;
    }


}
