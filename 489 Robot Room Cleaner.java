//basic approach
class Solution {
    public void cleanRoom(Robot robot) {
        //when you got into trouble can't move in other 3 directions
        //get back to the point you came from, so need to record the direction
        Set<String> set = new HashSet<>();
        dfs(robot, 0, 0, 0, set);
    }

    private void dfs(Robot robot, int degree, int x, int y, Set<String> set) {
        String curr = Integer.toString(x) + "-" + Integer.toString(y);
        if (set.contains(curr)) {
            return;
        }
        robot.clean();
        set.add(curr);

        //if can move, update position
        for (int i = 0; i < 4; i++) {
            int newX = x;
            int newY = y;
            if (robot.move()) {
                if (degree == 0) {
                    newX = x - 1;
                } else if (degree == 90) {
                    newY = y + 1;
                } else if (degree == 180) {
                    newX = x + 1;
                } else if (degree == 270) {
                    newY = y - 1;
                }
                dfs(robot, degree, newX, newY, set);
                robot.turnRight();
                robot.turnRight();
                robot.move();
                //come back
                robot.turnLeft();
                robot.turnLeft();
            }
            robot.turnRight();
            degree = (degree + 90) % 360;
        }
    }
}


//optimize
class Solution {
    public void cleanRoom(Robot robot) {
        //when you got into trouble can't move in other 3 directions
        //get back to the point you came from, so need to record the direction
        Set<String> set = new HashSet<>();
        dfs(robot, 0, 0, 0, set);
    }

    private void dfs(Robot robot, int degree, int x, int y, Set<String> set) {
        String curr = Integer.toString(x) + "-" + Integer.toString(y);
        if (set.contains(curr)) {
            return;
        }
        robot.clean();
        set.add(curr);

        //if can move, update position
        for (int i = 0; i < 4; i++) {
            int newX = x;
            int newY = y;
            if (robot.move()) {
                if (degree == 0) {
                    newX = x - 1;
                } else if (degree == 90) {
                    newY = y + 1;
                } else if (degree == 180) {
                    newX = x + 1;
                } else if (degree == 270) {
                    newY = y - 1;
                }
                dfs(robot, degree, newX, newY, set);
                robot.turnRight();
                robot.turnRight();
                robot.move();
                //come back
                robot.turnLeft();
                robot.turnLeft();
            }
            robot.turnRight();
            degree = (degree + 90) % 360;
        }
    }
}