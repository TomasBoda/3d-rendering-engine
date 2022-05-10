package Components;

import Main.Camera;

public class Matrix {

	public double[][] value;
	
	public Matrix(double[][] value) {
		this.value = value;
	}
	
	public Matrix(double x, double y, double z) {
		double[][] value = { {x}, {y}, {z}, {1} };
		this.value = value;
	}
	
	public Matrix() {
		double[][] identity = {
				{ 1, 0, 0, 0 },
				{ 0, 1, 0, 0 },
				{ 0, 0, 1, 0 },
				{ 0, 0, 0, 1 }
		};
		
		value = identity;
	}
	
	public static Matrix translation() {
		double[][] value = {
				{ 1, 0, 0, -Camera.x },
				{ 0, 1, 0, Camera.y },
				{ 0, 0, 1, -Camera.z },
				{ 0, 0, 0, 1 }
		};
		
		return new Matrix(value);
	}
	
	public static Matrix zRotation() {
		double[][] value = {
				{ Math.cos(Camera.zRotation), -Math.sin(Camera.zRotation), 0, 0 },
				{ Math.sin(Camera.zRotation), Math.cos(Camera.zRotation), 0, 0 },
				{ 0, 0, 1, 0 },
				{ 0, 0, 0, 1 }
		};
		
		return new Matrix(value);
	}
	
	public static Matrix yRotation() {
		double[][] value = {
				{ Math.cos(Camera.yRotation), Math.sin(Camera.yRotation), 0, 0 },
				{ 0, 1, 0, 0 },
				{ -Math.sin(Camera.yRotation), Math.cos(Camera.yRotation), 1, 0 },
				{ 0, 0, 0, 1 }
		};
		
		return new Matrix(value);
	}
	
	public static Matrix xRotation() {
		double[][] value = {
				{ 1, 0, 0, 0 },
				{ 0, Math.cos(Camera.xRotation), -Math.sin(Camera.xRotation), 0 },
				{ 0, Math.sin(Camera.xRotation), Math.cos(Camera.xRotation), 0 },
				{ 0, 0, 0, 1 }
		};
		
		return new Matrix(value);
	}
	
	public static Matrix orthoProjection() {
		double[][] value = {
				{ (Camera.f * Camera.pX) / (2 * Camera.sX), Camera.s, 0, 0 },
				{ 0, (Camera.f * Camera.pY) / (2 * Camera.sY), 0, 0 },
				{ 0, -1, 1, 0 },
				{ 0, 0, 0, 1 }
		};
		
		return new Matrix(value);
	}
	
	public static Matrix perspectiveProjection(double z) {
		double[][] value = {
				{ 1 / z, 0, 0, 0 },
				{ 0, 1 / z, 0, 0 },
				{ 0, 0, 1, 0 },
				{ 0, 0, 0, 1 }
		};
		
		return new Matrix(value);
	}
	
	public static Matrix multiply(Matrix A, Matrix B) {

        int aRows = A.value.length;
        int aColumns = A.value[0].length;
        int bRows = B.value.length;
        int bColumns = B.value[0].length;

        if (aColumns != bRows) {
            throw new IllegalArgumentException("A:Rows: " + aColumns + " did not match B:Columns " + bRows + ".");
        }

        double[][] C = new double[aRows][bColumns];
        for (int i = 0; i < aRows; i++) {
            for (int j = 0; j < bColumns; j++) {
                C[i][j] = 0.00000;
            }
        }

        for (int i = 0; i < aRows; i++) { // aRow
            for (int j = 0; j < bColumns; j++) { // bColumn
                for (int k = 0; k < aColumns; k++) { // aColumn
                    C[i][j] += A.value[i][k] * B.value[k][j];
                }
            }
        }

        
        if (C[3][0] == 1) {
        		C[0][0] /= C[3][0];
        		C[1][0] /= C[3][0];
        		C[2][0] /= C[3][0];
        }
        
        return new Matrix(C);
    }
}
