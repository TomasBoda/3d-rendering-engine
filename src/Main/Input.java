package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import Main.Camera.MOVEMENT;

public class Input implements KeyListener, MouseMotionListener {
	
	private int x = 0;
	private int y = 0;

	public void keyTyped(KeyEvent e) {
		
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_UP) {
			Camera.yMovement = MOVEMENT.UP;
		} else if (key == KeyEvent.VK_DOWN) {
			Camera.yMovement = MOVEMENT.DOWN;
		}
		
		if (key == KeyEvent.VK_RIGHT) {
			Camera.xMovement = MOVEMENT.RIGHT;
		} else if (key == KeyEvent.VK_LEFT) {
			Camera.xMovement = MOVEMENT.LEFT;
		}
		
		if (key == KeyEvent.VK_W) {
			Camera.zMovement = MOVEMENT.FORWARD;
		} else if (key == KeyEvent.VK_S) {
			Camera.zMovement = MOVEMENT.BACKWARD;
		}
		
		if (key == KeyEvent.VK_A) {
			Camera.xRotationSpeed = -0.02;
		} else if (key == KeyEvent.VK_D) {
			Camera.xRotationSpeed = 0.02;
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN) {
			Camera.yMovement = MOVEMENT.NONE;
		}
		
		if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_LEFT) {
			Camera.xMovement = MOVEMENT.NONE;
		}
		
		if (key == KeyEvent.VK_W || key == KeyEvent.VK_S) {
			Camera.zMovement = MOVEMENT.NONE;
		}
		
		if (key == KeyEvent.VK_A || key == KeyEvent.VK_D) {
			Camera.xRotationSpeed = 0;
		}
	}

	public void mouseDragged(MouseEvent e) {
		
	}

	public void mouseMoved(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
	}
}
