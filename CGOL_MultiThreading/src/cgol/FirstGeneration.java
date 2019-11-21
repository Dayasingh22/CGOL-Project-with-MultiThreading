package cgol;

public class FirstGeneration extends Thread {

	private int r, c;
	private int[][] arr ;

	public FirstGeneration(int r, int c, int[][] arr) {
		this.r=r;
		this.c=c;
		this.arr = arr;
	}

	public void run() {
		System.out.println("First / Initial Generation");
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
