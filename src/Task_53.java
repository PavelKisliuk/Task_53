import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Task_53 {
	public static void main(String[] args) {
		String outputPath = "OUTPUT.TXT";
		String inputPath = "INPUT.TXT";
		Painter test = new Painter(inputPath);
		try (BufferedWriter output = Files.newBufferedWriter(Paths.get(outputPath))) {
			output.write(test.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class Painter {
	private int red;
	private int green;
	private int blue;
	private int black;

	public Painter(String path) {
		try (final BufferedReader input = Files.newBufferedReader(Paths.get(path))) {
			String[] data = input.readLine().split(" ");
			int row = Integer.parseInt(data[0]);
			int column = Integer.parseInt(data[1]);
			for (int i = 1; i <= row; i++) {
				for (int j = 1; j <= column; j++) {
					int result = i * j;
					if (result % 5 == 0) {
						blue++;
					} else if (result % 3 == 0) {
						green++;
					} else if (result % 2 == 0) {
						red++;
					} else {
						black++;
					}
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "RED : " + red +
				"\nGREEN : " + green +
				"\nBLUE : " + blue +
				"\nBLACK : " + black;
	}
}