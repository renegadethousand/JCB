package academy.kovalevskyi.codingbootcamp.week2.day2;

import java.util.Random;

public class ProgressBar {

	public static void main(String[] args) throws InterruptedException {
		if (args.length == 0) {
			System.out.println("Число аргументов должно быть больше 1cd ");
			return;
		}
		int[] times;
		if (args.length == 1) {
			times = new int[]{1};
		} else {
			times = new int[args.length - 1];
			for (int i = 0; i < args.length - 1; i++) {
				times[i] = Integer.parseInt(args[i + 1]);
			}
		}
		int count = Integer.parseInt(args[0]);
		double batchSize = (double) 100 / count;
		int[][] countTime = new int[count][1];
		int time = 0;
		for (int i = 0; i < countTime.length; i++) {
			countTime[i][0] = getRandomTime(times);
			time += countTime[i][0];
		}
		for (int i = 0; i < count; i++) {
			Thread.sleep(getRandomTime(times) * 500);
			time -= countTime[i][0];
			System.out.print(getPercent(count, i + 1)
					+ " " + getProgressBar(i + 1, batchSize)
					+ " " + getProgressCount(i + 1, count)
					+ " " + getTime(time)
					+ "\r");
		}
	}

	private static String getProgressCount(int iteration, int count) {
		return iteration + "/" + count;
	}

	private static String getTime(int time) {
		return String.format("ETC %02d:%02d:%02d", getHours(time), getMinutes(time), getSeconds(time));
	}

	private static int getSeconds(int time) {
		return time % 60;
	}

	private static int getMinutes(int time) {
		return (time % 3600) / 60;
	}

	private static int getHours(int time) {
		return time / 3600;
	}

	private static int getRandomTime(int[] times) {
		if (times.length == 0) {
			return 1;
		} else if (times.length == 1) {
			return times[0];
		}
		Random random = new Random(System.currentTimeMillis());
		int i = random.nextInt(times.length - 1);
		return times[i];
	}

	private static String getProgressBar(int iteration, double batchSize) {
		StringBuilder stringBuilder = new StringBuilder();
		int currentSize = (int) (batchSize * iteration);
		stringBuilder.append("[");
		for (int i = 0; i <= 100; i++) {
			if (i < currentSize) {
				stringBuilder.append("=");
			} else if (i == currentSize) {
				stringBuilder.append(">");
			} else {
				stringBuilder.append(" ");
			}
		}
		stringBuilder.append("]");
		return stringBuilder.toString();
	}

	private static String getPercent(int count, double i) {
		int percent = (int) ((i / count) * 100);
		if (percent < 10) {
			return "  " + percent + "%";
		} else if (percent < 100) {
			return " " + percent + "%";
		} else {
			return "" + percent + "%";
		}
	}
}
