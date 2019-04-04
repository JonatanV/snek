import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

public class snake extends Canvas {
    public static void main(String[] args) {
        snake minGrafik=new snake();
    }
    int height=600;
    int width=800;
    BufferStrategy bs;  
    public snake(){
        setSize(width,height);
        JFrame frame = new JFrame("Grafik");
        frame.add(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.addKeyListener(new kl());
    }
    public void paint (Graphics g){
        bs = getBufferStrategy();
        if(bs == null) {
            createBufferStrategy(3);
            return;
        }
        draw(g);
        g.dispose();
        bs.show();
        repaint();
    }
    public void draw (Graphics g){
        g.setColor(new Color(0x000));
        g.fillRect(0,0,800,600);
        snakePlayer(g);
    }
    private void snakePlayer(Graphics g){
        g.setColor(Color.RED);
        g.fillRect(400,300,15,15);
    }

    private class kl implements KeyListener {
        @Override
        public void keyTyped(KeyEvent keyEvent) {

        }

        @Override
        public void keyPressed(KeyEvent keyEvent) {

        }

        @Override
        public void keyReleased(KeyEvent keyEvent) {

        }
    }
}
