package Components;

import java.awt.Color;
import java.awt.Graphics;

import Main.Camera;
import Main.Camera.MOVEMENT;
import Main.Window;

public class Polygon {

	public Matrix[] vertices;
	public Matrix[] projections;
	
	public Polygon(Matrix[] vertices) {
		this.vertices = vertices;
		projections = new Matrix[vertices.length];
		calculateProjection();
	}
	
	public void render(Graphics g) {
		//g.drawLine((int) projections[0].value[0][0], (int) projections[0].value[1][0], (int) projections[1].value[0][0], (int) projections[1].value[1][0]);
		//g.drawLine((int) projections[1].value[0][0], (int) projections[1].value[1][0], (int) projections[2].value[0][0], (int) projections[2].value[1][0]);
		//g.drawLine((int) projections[2].value[0][0], (int) projections[2].value[1][0], (int) projections[0].value[0][0], (int) projections[0].value[1][0]);
	
		int[] xValues = { (int) projections[0].value[0][0], (int) projections[1].value[0][0], (int) projections[2].value[0][0] };
		int[] yValues = { (int) projections[0].value[1][0], (int) projections[1].value[1][0], (int) projections[2].value[1][0] };
		
		g.setColor(Color.BLACK);
		g.drawPolygon(xValues, yValues, 3);
	}
	
	public void calculateProjection() {
		for (int i = 0; i < vertices.length; i++) {
			Matrix translation = Matrix.multiply(Matrix.translation(), vertices[i]);
			Matrix zRotation = Matrix.multiply(Matrix.zRotation(), translation);
			Matrix yRotation = Matrix.multiply(Matrix.yRotation(), zRotation);
			Matrix xRotation = Matrix.multiply(Matrix.xRotation(), yRotation);
			Matrix orthoProjection = Matrix.multiply(Matrix.orthoProjection(), xRotation);
			Matrix perspectiveProjection = Matrix.multiply(Matrix.perspectiveProjection(orthoProjection.value[2][0]), orthoProjection);
			
			double x = perspectiveProjection.value[0][0];
			double y = perspectiveProjection.value[1][0];
			double w = perspectiveProjection.value[3][0];
			Matrix projection = new Matrix((x / w) * Window.WIDTH, (y / w) * Window.WIDTH, 0);
			
			projections[i] = projection;
		}
	}
	
	public void update() {
		calculateProjection();
	}
}
