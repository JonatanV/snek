import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class snake extends Canvas implements Runnable {
    int height = 600;
    int width = 800;
    int x = 100;
    int y = 100;
    int x1;
    int y1;
    int vx;
    int vy;
    int fruktScore;
    Random R=new Random();
    BufferStrategy bs;
    Rectangle target;
    Rectangle striker;
    private Thread thread;
    private boolean running = false;


    public snake() {
        setSize(width, height);
        JFrame frame = new JFrame("Grafik");
        frame.add(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.addKeyListener(new kl());


        target = new Rectangle(R.nextInt(width-11), R.nextInt(height-11), 15,15);
        striker = new Rectangle(width-16, height-16,15,15);
    }

    public synchronized void start() {
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void render() {
        bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(1);

            return;
        }
        Graphics g = bs.getDrawGraphics();
        draw(g);
        g.dispose();
        bs.show();

    }

    public void draw(Graphics g) {
        g.setColor(new Color(0xfffffff));
        g.fillRect(0,0,width,height);
        snek(g);
        frukt(g);
    }

    private void snek(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(striker.x, striker.y, 15, 15);
    }

    private void frukt(Graphics g) {

        g.setColor(new Color(0x000));
        g.fillOval(target.x,target.y,15,15);
    }

    public void update() {
        striker.x+=vx;
        striker.y+=vy;
        if (striker.intersects(target)){
            target.x=R.nextInt(width);
            target.y=R.nextInt(height);
        }
    }

    @Override
    public void run() {
        double ns = 1000000000.0 / 30.0;
        double delta = 0;
        long lastTime = System.nanoTime();

        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            while (delta >= 1) {
                // Uppdatera koordinaterna
                update();
                // Rita ut bilden med updaterad data
                render();
                delta--;
            }
        }
        stop();
    }


    public static void main(String[] args) {
        snake minGrafik = new snake();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                minGrafik.setVisible(true);
            }
        });
        minGrafik.start();
    }


    class kl implements KeyListener {
        @Override
        public void keyTyped(KeyEvent keyEvent) {
            if (keyEvent.getKeyChar() == 'a') {
                if (vx==1){

                }else {
                    vx = -1;
                    vy = 0;
                }
            } else if (keyEvent.getKeyChar() == 'w') {
                if (vy==1){

                }else{
                    vy = -1;
                    vx = 0;
                }

            } else if (keyEvent.getKeyChar() == 's') {
                if(vy==-1){

                }else{
                    vy += 1;
                    vx = 0;
                }

            } else if (keyEvent.getKeyChar() == 'd') {
               if (vx==-1){

               }else{
                vx+=1;
                vy = 0;
               }


            } else if (keyEvent.getKeyChar() == '\n') {

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
