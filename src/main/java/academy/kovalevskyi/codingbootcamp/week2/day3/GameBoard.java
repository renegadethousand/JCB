package academy.kovalevskyi.codingbootcamp.week2.day3;

public class GameBoard {

	private char[][] table = new char[3][3];

	public void setPosition(int positionX, int positionY, char symbol) {
		table[positionX][positionY] = symbol;
	}

	public int checkResult() {
		if ((table[0][0] != '\u0000' && table[0][0] == table[0][1] && table[0][0] == table[0][2])
				|| (table[1][0] != '\u0000' && table[1][0] == table[1][1] && table[1][0] == table[1][2])
				|| (table[2][0] != '\u0000' && table[2][0] == table[2][1] && table[2][0] == table[2][2])
				|| (table[0][0] != '\u0000' && table[0][0] == table[1][0] && table[0][0] == table[2][0])
				|| (table[0][1] != '\u0000' && table[0][1] == table[1][1] && table[0][1] == table[2][1])
				|| (table[0][2] != '\u0000' && table[0][2] == table[1][2] && table[0][2] == table[2][2])
				|| (table[0][0] != '\u0000' && table[0][0] == table[1][1] && table[0][0] == table[2][2])
				|| (table[2][0] != '\u0000' && table[2][0] == table[1][1] && table[2][0] == table[0][2])) {
			return 1;
		}
		for (int i = 0; i < table.length; i++) {
			for (int y = 0; y < table[i].length; i++) {
				if (table[i][y] == '\u0000') {
					return -1;
				}
			}
		}
		return 0;
	}

	public void drawTable() {
		for (int i = 0; i < table.length; i++) {
			for (int y = 0; y < table[i].length; y++) {
				if (table[i][y] == '\u0000') {
					System.out.print(' ');
				} else {
					System.out.print(table[i][y]);
				}
				if (y != table[i].length - 1) {
					System.out.print(" | ");
				}
			}
			System.out.println();
			if (i != table.length - 1) {
				System.out.println("---------");
			}
		}
	}
}
