package Components;

import java.awt.Graphics;

public class Object {
	
	public double x;
	public double y;
	public double z;
	public double length;

	public Polygon[] polygons;
	
	public Object createCube(double x, double y, double z, double length) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.length = length;
		
		Polygon[] polygons = new Polygon[12];
		
		// front
		polygons[0] = new Polygon(new Matrix[] {new Matrix(x + 0, y + 0, z + 0), new Matrix(x + length, y + 0, z + 0), new Matrix(x + length, y + length, z + 0)});
		polygons[1] = new Polygon(new Matrix[] {new Matrix(x + 0, y + 0, z + 0), new Matrix(x + length, y + length, z + 0), new Matrix(x + 0, y + length, z + 0)});
		
		// back
		polygons[2] = new Polygon(new Matrix[] {new Matrix(x + length, y + 0, z + length), new Matrix(x + length, y + length, z + length), new Matrix(x + 0, y + length, z + length)});
		polygons[3] = new Polygon(new Matrix[] {new Matrix(x + length, y + 0, z + length), new Matrix(x + 0, y + 0, z + length), new Matrix(x + 0, y + length, z + length)});
		
		// top
		polygons[6] = new Polygon(new Matrix[] {new Matrix(x + 0, y + 0, z + 0), new Matrix(x + 0, y + 0, z + length), new Matrix(x + length, y + 0, z + 0)});
		polygons[7] = new Polygon(new Matrix[] {new Matrix(x + length, y + 0, z + 0), new Matrix(x + length, y + 0, z + length), new Matrix(x + 0, y + 0, z + length)});
		
		// bottom
		polygons[4] = new Polygon(new Matrix[] {new Matrix(x + 0, y + length, z + 0), new Matrix(x + length, y + length, z + 0), new Matrix(x + length, y + length, z + length)});
		polygons[5] = new Polygon(new Matrix[] {new Matrix(x + 0, y + length, z + 0), new Matrix(x + 0, y + length, z + length), new Matrix(x + length, y + length, z + length)});
	
		// right
		polygons[8] = new Polygon(new Matrix[] {new Matrix(x + length, y + 0, z + 0), new Matrix(x + length, y + 0, z + length), new Matrix(x + length, y + length, z + length)});
		polygons[9] = new Polygon(new Matrix[] {new Matrix(x + length, y + 0, z + 0), new Matrix(x + length, y + length, z + 0), new Matrix(x + length, y + length, z + length)});
						
		// left
		polygons[10] = new Polygon(new Matrix[] {new Matrix(x + 0, y + 0, z + 0), new Matrix(x + 0, y + length, z + 0), new Matrix(x + 0, y + 0, z + length)});
		polygons[11] = new Polygon(new Matrix[] {new Matrix(x + 0, y + length, z + 0), new Matrix(x + 0, y + 0, z + length), new Matrix(x + 0, y + length, z + length)});
		
		this.polygons = polygons;
		return this;
	}
	
	public void render(Graphics g) {
		for (Polygon polygon : polygons) {
			polygon.render(g);
		}
	}
	
	public void update() {
		for (Polygon polygon : polygons) {
			polygon.update();
		}
	}
}
