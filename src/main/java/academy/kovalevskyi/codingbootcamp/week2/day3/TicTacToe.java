package academy.kovalevskyi.codingbootcamp.week2.day3;

public class TicTacToe {

	public static void main(String[] args) {
		Announcer announcer = new Announcer();

		announcer.sayWelcome();

		Player player1 = announcer.getPlayer("X");
		Player player2 = announcer.getPlayer("O");

		GameBoard gameBoard = new GameBoard();

		Player currentPlayer = player1;
		while (true) {
			gameBoard.drawTable();
			char currentSymbol = currentPlayer.equals(player1) ? 'X' : 'O';
			System.out.println("Текущий игрок: " + currentPlayer.getName());

			int positionX = announcer.getPosition("Введите позицию X: ");
			int positionY = announcer.getPosition("Введите позицию Y: ");
			gameBoard.setPosition(positionX, positionY, currentSymbol);

			int result = gameBoard.checkResult();
			if (announcer.gameEnd(result, currentPlayer)) {
				break;
			}
			currentPlayer = currentPlayer.equals(player1) ? player2 : player1;
		}
	}
}
