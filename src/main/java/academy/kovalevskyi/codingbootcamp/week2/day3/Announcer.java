package academy.kovalevskyi.codingbootcamp.week2.day3;

import java.util.Scanner;

public class Announcer {

	Scanner scanner = new Scanner(System.in);

	public void sayWelcome() {
		System.out.println("Добро пожаловать в игру крестики нолики");
		System.out.println();
	}

	public Player getPlayer(String team) {
		System.out.print("Введите имя игрока " + team + ": ");
		Player player1 = new Player();
		player1.setName(scanner.nextLine());
		return player1;
	}

	public int getPosition(String s) {
		int position = -1;
		while (position < 0 || position > 2) {
			System.out.print(s);
			position = scanner.nextInt();
		}
		return position;
	}

	public boolean gameEnd(int result, Player player) {
		if (result == 0) {
			System.out.println("Ничья");
			return true;
		} else if (result == 1) {
			System.out.println("Победил игрок: " + player.getName());
			return true;
		}
		return false;
	}
}
