import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;

public class CellComponent extends JButton implements ActionListener {
	private boolean alive;
	private ArrayList<CellComponent> neighbours;

	public CellComponent() {
		neighbours = new ArrayList<CellComponent>();
		setAlive(false);
		addActionListener(this);
		setForeground(Color.RED);
	}

	public boolean isAlive() {
		return this.alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
		if (alive) {
			this.setBackground(Color.WHITE);
		} else {
			this.setBackground(Color.BLACK);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		if (isAlive()) {
			setAlive(false);
		} else {
			setAlive(true);
		}
		 */
		boolean newValue = !this.alive;
		setAlive(newValue);
	}

	public void addNeighbour(CellComponent c) {
		neighbours.add(c);
	}

	public void getNeighbour() {
		//int count = neighbours.size();
		//setText(count + "");
		setText(Integer.toString(neighbours.size()));
	}
	
	/*public boolean getRandomBoolean() {
	    Random random = new Random();
	    return random.nextBoolean();
	}*/
}