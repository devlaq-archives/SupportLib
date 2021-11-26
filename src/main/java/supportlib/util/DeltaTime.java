package supportlib.util;

public class DeltaTime {

    private static long lastFrameTime = -1;
    private static float deltaTime;
    private static long frameId;
    private static long frameCounterStart = 0;
    private static int frames;
    private static int fps;

    public static long getFrameId() {
        return frameId;
    }

    public static float getDeltaTime() {
        return deltaTime;
    }

    public static int getFramesPerSecond() {
        return fps;
    }

    public static void update() {
        long time = System.nanoTime();
        if(lastFrameTime == -1)
            lastFrameTime = time;
        deltaTime = ( time - lastFrameTime ) / 1000000000.0f;
        lastFrameTime = time;

        if(time - frameCounterStart >= 1000000000) {
            fps = frames;
            frames = 0;
            frameCounterStart = time;
        }
        frames++;
        frameId++;
    }

}
