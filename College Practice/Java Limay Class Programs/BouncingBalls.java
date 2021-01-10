import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BouncingBalls extends JPanel implements MouseListener {

    protected List<Ball> balls = new ArrayList<Ball>(20);
    private Container container;
    private DrawCanvas canvas;
    private int canvasWidth;
    private int canvasHeight;
    public static final int UPDATE_RATE = 30;
    int x = random(480);
    int y = random(480);
    int speedX = random(30);
    int speedY = random(30);
    int radius = random(20);
    int red = random(255);
    int green = random(255);
    int blue = random(255);
    int count = 0;

    public static int random(int maxRange) {
        return (int) Math.round((Math.random() * maxRange));
    }

    public BouncingBalls(int width, int height) {

        canvasWidth = width;
        canvasHeight = height;

        container = new Container();

        canvas = new DrawCanvas();
        this.setLayout(new BorderLayout());
        this.add(canvas, BorderLayout.CENTER);
        this.addMouseListener(this);

        start();

    }

    public void start() {

        Thread t = new Thread() {
            public void run() {

                while (true) {

                    update();
                    repaint();
                    try {
                        Thread.sleep(1000 / UPDATE_RATE);
                    } catch (InterruptedException e) {
                    }
                }
            }
        };
        t.start();
    }

    public void update() {
        for (Ball ball : balls) {
            ball.move(container);
        }
    }

    class DrawCanvas extends JPanel {

        public void paintComponent(Graphics g) {

            super.paintComponent(g);
            container.draw(g);
            for (Ball ball : balls) {
                ball.draw(g);
            }
        }

        public Dimension getPreferredSize() {

            return (new Dimension(canvasWidth, canvasHeight));
        }
    }

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame f = new JFrame("Bouncing Balls");
                f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
                f.setContentPane(new BouncingBalls(500, 500));
                f.pack();
                f.setVisible(true);
            }
        });
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mousePressed(MouseEvent e) {

        count++;
        balls.add(new Ball());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    public static class Ball {

        public int random(int maxRange) {
            return (int) Math.round(Math.random() * maxRange);
        }

        int x = random(480);
        int y = random(480);
        int speedX = random(30);
        int speedY = random(30);
        int radius = random(20);
        int red = random(255);
        int green = random(255);
        int blue = random(255);
        int i = 0;

        public void draw(Graphics g) {

            g.setColor(new Color(red, green, blue));
            g.fillOval((int) (x - radius), (int) (y - radius),
                    (int) (2 * radius), (int) (2 * radius));

        }

        public void move(Container container) {

            x += speedX;
            y += speedY;

            if (x - radius < 0) {

                speedX = -speedX;
                x = radius;
            } else if (x + radius > 500) {

                speedX = -speedX;
                x = 500 - radius;
            }

            if (y - radius < 0) {

                speedY = -speedY;
                y = radius;
            } else if (y + radius > 500) {

                speedY = -speedY;
                y = 500 - radius;
            }
        }
    }



public static class Container {

        private static final int HEIGHT = 500;
        private static final int WIDTH = 500;
        private static final Color COLOR = Color.WHITE;

        public void draw(Graphics g) {

            g.setColor(COLOR);
            g.fillRect(0, 0, WIDTH, HEIGHT);
        }
    }
}