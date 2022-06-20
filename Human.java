package Lesson1;

public class Human {
   public class Human implements Competitable {
        private int jumpHeight;
        private int runLength;

        public Human(int jumpHeight, int runLength) {
            this.jumpHeight = jumpHeight;
            this.runLength = runLength;
        }

        @Override
        public void jump(int height) {
            if (height > jumpHeight) {
                System.out.println("Я человек, я не смог перепрыгнуть!");
            } else {
                System.out.println("Я человек, я смог перепрыгнуть!");
            }
        }

        @Override
        public void run(int length) {
            if (length > runLength) {
                System.out.println("Я человек, я не смог пробежать!");
            } else {
                System.out.println("Я человек, я смог пробежать!");
            }
        }
    }
}
