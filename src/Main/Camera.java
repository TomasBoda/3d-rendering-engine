package Main;

public class Camera {

	public static double x = 0;
	public static double y = 0;
	public static double z = -1000;
	
	public static double xRotation = 0;
	public static double yRotation = 0;
	public static double zRotation = 0;
	
	public static double f = 1.6;
	public static double s = 0.0;
	
	public static double sX = Window.WIDTH;
	public static double sY = Window.HEIGHT;
	
	public static double pX = Window.WIDTH;
	public static double pY = Window.HEIGHT;
	
	public enum MOVEMENT {NONE, UP, DOWN, RIGHT, LEFT, FORWARD, BACKWARD};
	
	public static MOVEMENT xMovement = MOVEMENT.NONE;
	public static MOVEMENT yMovement = MOVEMENT.NONE;
	public static MOVEMENT zMovement = MOVEMENT.NONE;
	
	public static double xSpeed = 10;
	public static double ySpeed = 10;
	public static double zSpeed = 10;
	
	public static double xRotationSpeed = 0;
	public static double yRotationSpeed = 0;
}
