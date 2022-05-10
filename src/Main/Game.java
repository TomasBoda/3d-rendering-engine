package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import Components.Object;
import Main.Camera.MOVEMENT;

public class Game {

	public ArrayList<Object> objects;
	
	public Game() {
		objects = new ArrayList<Object>();
		
		for (int x = 0; x < 5; x++) {
			for (int z = 0; z < 5; z++) {
				objects.add(new Object().createCube(x * 50, 50, z * 50, 50));
			}
		}
	}

	public void render(Graphics g) {
		g.translate(Window.WIDTH / 2, Window.HEIGHT / 2);
		g.setColor(Color.BLACK);
		
		for (Object object : objects) {
			object.render(g);
		}
		
		g.setColor(Color.BLACK);
		g.drawString("x = " + Camera.x + ", y = " + Camera.y + ", z = " + Camera.z, 30 - (Window.WIDTH / 2), 30 - (Window.HEIGHT / 2));
	}
	
	public void update() {
		move();
		
		for (Object object : objects) {
			object.update();
		}
	}
	
	public void move() {
		if (Camera.yMovement == MOVEMENT.UP) {
			Camera.y += Camera.ySpeed;
		} else if (Camera.yMovement == MOVEMENT.DOWN) {
			Camera.y -= Camera.ySpeed;
		}
		
		if (Camera.xMovement == MOVEMENT.RIGHT) {
			Camera.x += Camera.xSpeed;
		} else if (Camera.xMovement == MOVEMENT.LEFT) {
			Camera.x -= Camera.xSpeed;
		}
		
		if (Camera.zMovement == MOVEMENT.FORWARD) {
			Camera.z += Camera.zSpeed;
		} else if (Camera.zMovement == MOVEMENT.BACKWARD) {
			Camera.z -= Camera.zSpeed;
		}
		
		//Camera.xRotation += Camera.xRotationSpeed;
		//Camera.yRotation += Camera.yRotationSpeed;
	}
}