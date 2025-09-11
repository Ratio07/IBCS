import java.awt.*;
import java.awt.event.KeyEvent;

public class TypeBot {
    public static void main(String[] args) throws AWTException, InterruptedException {
        Robot robot = new Robot();

        System.out.println("Get ready... Staring in 5 seconds");
        Thread.sleep(5000);


        //step 1: Type a message
        String message = "Hello, I am a Robot";
        typeString(robot, message);


        //Step 2:Press Tab to move to the Save button
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        Thread.sleep(1000);


        //Step 3: Press Space to "click" the button
        robot.keyPress(KeyEvent.VK_SPACE);
        robot.keyRelease(KeyEvent.VK_SPACE);
        Thread.sleep(2000);


        //Step4: tab to move the clear button
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        Thread.sleep(1000);

        //Step4: space to click the clear button
        robot.keyPress(KeyEvent.VK_SPACE);
        robot.keyRelease(KeyEvent.VK_SPACE);
        Thread.sleep(500);
    }

    public static void typeString(Robot robot, String text) {
        for (char c : text.toCharArray()) {
            int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
            if (Character.isUpperCase(c) || "!@#$%^&*()_+{}|:\"<>?".indexOf(c) != -1) {
                robot.keyPress(KeyEvent.VK_SHIFT);
            }
            robot.keyPress(keyCode);
            robot.keyRelease(keyCode);
            if (Character.isUpperCase(c) || "!@#$%^&*()_+{}|:\"<>?".indexOf(c) != -1) {
                robot.keyRelease(KeyEvent.VK_SHIFT);
            }
            robot.delay(100);
        }
    }
}
