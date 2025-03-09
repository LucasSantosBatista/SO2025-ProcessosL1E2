package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KillController {
	public KillController() {
		super();
	}

	// Retorna sistema operacional
	private String getOS() {
		return System.getProperty("os.name");
	}

	public void listaProcessos() {
		// Inicia buffer para a escrita do processo
		String process = "";
		StringBuffer buffer = new StringBuffer();

		// Valida sistema operacional
		if (getOS().contains("Windows")) {
			buffer.append("cmd /c ");
			process = "TASKLIST /FO TABLE";
			buffer.append(process);

		} else {
			process = "ps -ef";
			buffer.append(process);
		}

		// Utiliza buffer.toString().split() para converter em String e vetor
		try {
			Process p = Runtime.getRuntime().exec(buffer.toString().split(" "));
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

			String line = "";

			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

	public void mataPID(String entrada) {
		String process = "";
		StringBuffer buffer = new StringBuffer();
		try {
			if (getOS().contains("Windows")) {
				buffer.append("cmd /c ");
				process = "TASKKILL /PID ";
				buffer.append(process);
				buffer.append(entrada);

			} else {
				process = "kill -9 ";
				buffer.append(process);
				buffer.append(entrada);
			}
			Runtime.getRuntime().exec(buffer.toString().split(" "));
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

	public void mataNome(String entrada) {
		String process = "";
		StringBuffer buffer = new StringBuffer();
		try {
			if (getOS().contains("Windows")) {
				buffer.append("cmd /c ");
				process = "TASKKILL /IM ";
				buffer.append(process);
				buffer.append(entrada);
			} else {
				process = "pkill -f ";
				buffer.append(process);
				buffer.append(entrada);
			}
			Runtime.getRuntime().exec(buffer.toString().split(" "));
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
}
