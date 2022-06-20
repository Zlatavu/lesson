package Lesson1;

public abstract class Competitable {
    public abstract void jump(int height);

    public interface Competitable extends CanRun, CanJump {
    }
}
