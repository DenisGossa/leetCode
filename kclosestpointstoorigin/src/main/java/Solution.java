import java.util.*;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][2];
        double hypotenuse;
        int tmpx, tmpy;
        SortedSet<Point> treeSet = new TreeSet<>(new Comparator<Point>(){
            @Override
            public int compare(Point point1, Point point2) {
                double tmp = point1.radius - point2.radius - 0.00001;//epsilon;
                if (tmp > 0)
                    return 1;
                else if (tmp < 0)
                    return -1;
                else
                    return 0;
            }
        });
        // for each point find hypotenuse
        for (int i = 0; i < points.length ; i++) {
            tmpx = points[i][0];
            tmpy = points[i][1];
            hypotenuse = Math.sqrt(tmpx * tmpx + tmpy * tmpy);
            // put the point into treeset sorting at once
            treeSet.add(new Point(tmpx, tmpy, hypotenuse));
        }
        System.out.println("size="+treeSet.size());

        //then take k first points from treeset
        Iterator<Point> it = treeSet.iterator();
        Point tmp;
        for (int i = 0; i < k; i++) {
            tmp = it.next();
            result[i][0] = tmp.x;
            result[i][1] = tmp.y;
        }
        return result;
    }

    private class Point {
        int x;
        int y;
        double radius;//hipotenusa

        public Point(int tmpx, int tmpy, double val1) {
            x = tmpx;
            y = tmpy;
            radius = val1;
        }
    }

    public static void main(String[] args) {
        int[][] t1 = {{1, 3}, {-2, 2}};
        int[][] t2 = {{1, 3}, {-2, 2},{2,-2}};
        int[][] t3 = {{2, -2}, {-2, 2},{2,-2}};
        System.out.println("Processing");
        Solution solution = new Solution();
        t1 = solution.kClosest(t3, 3);

        for (int i = 0; i < t1.length; i++) {
            for (int j = 0; j < t1[0].length; j++) {
                System.out.print(t1[i][j] + " ");
            }
            System.out.println();
        }
    }
}