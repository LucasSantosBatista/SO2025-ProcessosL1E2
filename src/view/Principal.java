package view;

import javax.swing.JOptionPane;

import controller.KillController;

public class Principal {
	public static void main(String[] args) {
		KillController control = new KillController();
		String entrada = "";
		
		while (true) {
			String[] options = { "Listar Processos", "Matar Processo por PID", "Matar Processo por Nome", "Sair" };
			int opt = JOptionPane.showOptionDialog(null, "Escolha um processo para executar: ", "Chamada de Processos",
					JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
			switch (opt) {
			case 0: 
				control.listaProcessos();
				break;
			case 1: 
				entrada = JOptionPane.showInputDialog("Digite um PID para matar o processo: ");
				control.mataPID(entrada);
				break;
			case 2:
				entrada = JOptionPane.showInputDialog("Digite um nome para matar o processo: ");
				control.mataNome(entrada);
				break;
			case 3:
				System.exit(0);
				break;
			}
		}
		
	}
}
