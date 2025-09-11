import java.awt.*;
import java.awt.event.KeyEvent;

public class typeBot {
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

        //Step4: space to clickk the clear button
        robot.keyPress(KeyEvent.VK_SPACE);
        robot.keyRelease(KeyEvent.VK_SPACE);
        Thread.sleep(500);
    }
}
