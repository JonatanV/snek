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
    int x=100;
    int y=100;
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
            createBufferStrategy(1);
            return;
        }
        update(g);
        draw(g);
        g.dispose();
        bs.show();

    BufferStrategy bs;   repaint();
    }
    public void draw (Graphics g){
        g.setColor(new Color(0x000));
        g.fillRect(0,0,800,600);
        snakePlayer(g);
    }
    private void snakePlayer(Graphics g){
        g.setColor(Color.RED);
        g.fillRect(x,y,15,15);
    }
    public void update(Graphics g){
        x++;
    }

    private class kl implements KeyListener {
        @Override
        public void keyTyped(KeyEvent keyEvent) {
            if (keyEvent.getKeyChar()=='a'){

            }else if(keyEvent.getKeyChar()=='w'){

            }else if(keyEvent.getKeyChar()=='s'){
                y++;
            }else if(keyEvent.getKeyChar()=='d'){

            }else if (keyEvent.getKeyChar()=='\n'){

            }
        }

        @Override
        public void keyPressed(KeyEvent keyEvent) {

        }

        @Override
        public void keyReleased(KeyEvent keyEvent) {

        }
    }
}
