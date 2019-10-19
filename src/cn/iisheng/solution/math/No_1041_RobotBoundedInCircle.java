package cn.iisheng.solution.math;

/**
 * @author iisheng
 * @date 2019/07/21 18:34:23
 */
public class No_1041_RobotBoundedInCircle {

    public static void main(String[] args) {
        System.out.println(new No_1041_RobotBoundedInCircle().isRobotBounded("LLGRL"));
    }

    public boolean isRobotBounded(String instructions) {
        // 判断移动能否成为一个环
        // 如果成为一个环 返回 true 否则 返回 false
        // 方向
        int direction = 0;
        // 坐标 x
        int x = 0;
        // 坐标 y
        int y = 0;

        for (int j = 0; j < 4; j++) {

            for (int i = 0; i < instructions.length(); i++) {
                // G 计算
                if (instructions.charAt(i) == 'G') {
                    switch (direction) {
                        case 0:
                            y++;
                            break;
                        case 1:
                            x--;
                            break;
                        case 2:
                            y--;
                            break;
                        case 3:
                            x++;
                            break;
                    }
                }
                // L R 方向
                if (instructions.charAt(i) == 'L') {
                    direction += 1;
                }
                if (instructions.charAt(i) == 'R') {
                    direction += 3;
                }
                direction %= 4;
            }

            if (x == 0 && direction == 0 && y == 0) {
                return true;
            }
        }
        return false;

    }

}
