package Main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Window extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 1200;
	public static final int HEIGHT = 700;
	
	private JFrame frame;
	
	private Timer timer;
	private final int framerate = 60;
	
	private Game game;
	private Input input;
	
	public Window() {
		game = new Game();
		input = new Input();
		
		frame = new JFrame("3D Engine Matrices");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		addKeyListener(input);
		addMouseMotionListener(input);
		setFocusable(true);
		
		frame.add(this);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		timer = new Timer(1000 / framerate, this);
		timer.start();
	}
	
	public void paintComponent(Graphics g) {
		game.render(g);
	}
	
	public void actionPerformed(ActionEvent e) {
		game.update();
		repaint();
	}

	public static void main(String[] args) {
		new Window();
	}
}