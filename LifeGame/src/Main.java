import java.awt.GridLayout;
import javax.swing.JFrame;

public class Main {
		private static void setNeighbourSafety(CellComponent[][] worldInput, CellComponent cInput, int rowIndex, int columnIndex) {
			if( (rowIndex > -1) && (columnIndex > -1) && (rowIndex < matrixSize) && (columnIndex < matrixSize)) {
				CellComponent c = worldInput[rowIndex][columnIndex];
				cInput.addNeighbour(c);	
			}
		}
		
		static int matrixSize = 10;
	
	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setVisible(true);
		GridLayout layout = new GridLayout(matrixSize, matrixSize);
		window.setLayout(layout);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		CellComponent [][] world = new CellComponent[matrixSize][matrixSize];
		
		//CellComponent create, world setup
		for (int i = 0; i < matrixSize; i++) {
			for (int j = 0; j < matrixSize; j++) {
				CellComponent c = new CellComponent();
				window.add(c);
				world[i][j] = c;
			}
		}

		//Neighbours setup
		for (int i = 0; i < matrixSize; i++) {
			for (int j = 0; j < matrixSize; j++) {
				CellComponent c = world[i][j];

				//bal felsõ
				setNeighbourSafety(world, c, i - 1, j - 1);

				//felsõ
				setNeighbourSafety(world, c, i - 1, j);

				//jobb felsõ
				setNeighbourSafety(world, c, i - 1, j + 1);

				//jobb
				setNeighbourSafety(world, c, i, j + 1);

				//jobb alsó
				setNeighbourSafety(world, c, i + 1, j + 1);

				//alsó
				setNeighbourSafety(world, c, i + 1, j);

				//bal alsó
				setNeighbourSafety(world, c, i + 1, j - 1);

				//bal
				setNeighbourSafety(world, c, i, j - 1);
				c.getNeighbour();
			}
		}
		window.setSize(500, 500);
	}
}