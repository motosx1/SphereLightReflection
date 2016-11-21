package gui.panels;

import structures.Sphere;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{

    public static final int FRAME_WIDTH = 600;
    public static final int FRAME_HEIGHT = 600;
    private final Sphere sphere;

    CanvasPanel canvas = null;

    public MainFrame(Sphere sphere) {
        super("Camera Simulator v1");
        this.sphere = sphere;
        this.canvas = new CanvasPanel(sphere);
//        this.actionButtons = new ActionButtons(canvas, cuboids);

        setUpFrame();
        addCanvas();

        pack();
        setVisible(true);
    }



    private void addCanvas() {
        add(canvas,BorderLayout.CENTER);
//        setKeyListener();
    }

    private void setUpFrame() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        setLocation(((int)screenSize.getWidth() - FRAME_WIDTH)/2,100);
        setLayout(new BorderLayout());
    }

//    private void addButtons(JPanel buttonsPanel) {
//        for (Map.Entry<Dict, Button> buttonMap : actionButtons.getAllTransformationButtons().entrySet()) {
//            Button button = buttonMap.getValue();
//            button.setAlignmentX(Component.CENTER_ALIGNMENT);
//            buttonsPanel.add(button);
//        }
//
//    }

    public static Dimension getCanvasPanelSize(){
        return new Dimension(FRAME_WIDTH, FRAME_HEIGHT);
    }

//    private void setKeyListener() {
//        addKeyListener(new KeyListener() {
//
//            public void keyTyped(KeyEvent e) { }
//
//            public void keyPressed(KeyEvent e) {
//                doAction(e);
//            }
//
//            public void keyReleased(KeyEvent e) {}
//        });
//
//        setFocusable(true);
//        requestFocusInWindow();
//    }

//    private void doAction(KeyEvent e) {
//        switch( e.getKeyCode() ) {
//            case KeyEvent.VK_R:
//                clickButton(Dict.RESET);
//                break;
//            case KeyEvent.VK_UP:
//                clickButton(Dict.MOVE_FORWARD);
//                break;
//            case KeyEvent.VK_DOWN:
//                clickButton(Dict.MOVE_BACKWARD);
//                break;
//            case KeyEvent.VK_LEFT:
//                clickButton(Dict.MOVE_LEFT);
//                break;
//            case KeyEvent.VK_RIGHT:
//                clickButton(Dict.MOVE_RIGHT);
//                break;
//            case KeyEvent.VK_W:
//                clickButton(Dict.ROTATE_X);
//                break;
//            case KeyEvent.VK_S:
//                clickButton(Dict.ROTATE_MINUSX);
//                break;
//            case KeyEvent.VK_A:
//                clickButton(Dict.ROTATE_Y);
//                break;
//            case KeyEvent.VK_D:
//                clickButton(Dict.ROTATE_MINUSY);
//                break;
//            case KeyEvent.VK_Q:
//                clickButton(Dict.ZOOM_IN);
//                break;
//            case KeyEvent.VK_E:
//                clickButton(Dict.ZOOM_OUT);
//                break;
//            case KeyEvent.VK_PAGE_DOWN:
//                clickButton(Dict.MOVE_DOWN);
//                break;
//            case KeyEvent.VK_PAGE_UP:
//                clickButton(Dict.MOVE_UP);
//                break;
//            default:
//
//        }
//    }
//
//    private void clickButton(Dict action) {
//        actionButtons.getAllTransformationButtons().get(action).doClick();
//    }
}
