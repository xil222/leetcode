//The key concept of this problem is the snake
//find the way to store all snakes position, using deque
//would be enough -->
//also need to check whether bites its body
//So deque + hashSet, --> to store most recent position
//either store most recent locs or use deque
//hashSet stores all Strings would be good enough


//be careful of the logic, is first remove then add --> makes it available to rotate
//therefore the logic is removehead in set before doing check
//around a square
/**
 0 1 1
 0 1 1
 */

class SnakeGame {
    /** Initialize your data structure here.
     @param width - screen width
     @param height - screen height
     @param food - A list of food positions
     E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */

    int[][] foods;
    int foodIdx;
    int width;
    int height;
    int score;
    Set<String> set;
    Deque<String> deque;

    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;

        set = new HashSet<>();
        deque = new ArrayDeque<>();
        String first = "0 0";
        set.add(first);
        deque.offerLast(first);
        foods = food;
        foodIdx = 0;
        score = 0;
    }

    /** Moves the snake.
     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     @return The game's score after the move. Return -1 if game over.
     Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        //calculate nextPos, check:
        //if valid:
        //  append it return score
        //else:
        //  not --> xxxxx check return false xxxx

        String prev = deque.peekLast();
        set.remove(deque.peekFirst());
        String[] pos = prev.split(" ");
        int row = Integer.valueOf(pos[0]);
        int col = Integer.valueOf(pos[1]);

        if (direction.equals("U")) {
            row -= 1;
        } else if (direction.equals("L")) {
            col -= 1;
        } else if (direction.equals("R")) {
            col += 1;
        } else {
            row += 1;
        }

        String newPos = row + " " + col;
        if (row < 0 || row >= height || col < 0 || col >= width) {
            return -1;
        } else if (set.contains(newPos)) {
            return -1;
        } else {
            set.add(newPos);
            deque.offerLast(newPos);
            if (foodIdx < foods.length && row == foods[foodIdx][0] && col == foods[foodIdx][1]) {
                foodIdx++;
                score++;
                set.add(deque.peekFirst());
            } else {
                deque.pollFirst();
            }
        }

        return score;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */