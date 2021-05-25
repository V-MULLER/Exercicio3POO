package controle;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entidades.Acidente;
import excessoes.DadosAbertosException;

public class Teste {

	
	// List<String> acidentes = new ArrayList<>();
	private List<Acidente> acidentes = new ArrayList<>();
	
	
	public Teste() {
		
	}
	
	//Aqui tinha usado BufferedReader para ler do arquivo e depois adicionar ao array
	//Porém estou tentando implementar sem array, ainda está incompleto 
	@SuppressWarnings("rawtypes")
	public void leArquivo(Path path) throws DadosAbertosException {
		try (Scanner sc = new Scanner (Files.newBufferedReader(path, Charset.defaultCharset()))) {
			String line = sc.nextLine();
			sc.useDelimiter("[;\\n]");
			//sc.
			while (sc.hasNext()) {
				String[] fields = line.split(";");
				Integer feridos = Integer.parseInt(fields[4]);
				Integer vitimasFatais = Integer.parseInt(fields[8]);
				Integer qtdAutomoveis = Integer.parseInt(fields[9]);
				Integer qtdMotocicletas = Integer.parseInt(fields[16]);
				String id = fields[23];
				String logradouro = fields[26];
				String tipoAcidente = fields[28];
				String momentoDoDia = fields[31];

				acidentes.add(new Acidente(feridos, vitimasFatais, qtdAutomoveis, qtdMotocicletas, id, logradouro,
						tipoAcidente, momentoDoDia));

				line = br.readLine();
			}
		} catch (IOException e) {
			throw new DadosAbertosException();
		}
	}

	// guardar objeto no arquivo
	public void guardaArquivo(Path path) throws DadosAbertosException {
		try (ObjectOutputStream arq = new ObjectOutputStream(Files.newOutputStream(path))) {
			arq.writeObject(acidentes);

		} catch (IOException e1) {
			throw new DadosAbertosException();
		} catch (Exception e2) {
			throw new DadosAbertosException();
		}
	}

	// ler o objeto do arquivo
	@SuppressWarnings("unchecked")
	public void leObjeto(Path path) throws DadosAbertosException {
		try (ObjectInputStream arq = new ObjectInputStream(Files.newInputStream(path))) {

			acidentes = (ArrayList<Acidente>) arq.readObject();
			System.out.println("Arquivo lido com sucesso. ");
			

		} catch (ClassNotFoundException e1) {
			throw new DadosAbertosException();
		} catch (IOException e2) {
			throw new DadosAbertosException();
		} 
	}
	
	public String lerTodosOsDadosDoArquivo() {
		for (@SuppressWarnings("rawtypes") Acidente ac : acidentes) {
			return ac.toString();
		}
		return null;
	}
	
	public String buscar(Integer i) throws DadosAbertosException {
		if(acidentes.isEmpty()) {
			throw new DadosAbertosException();
		}
		for(@SuppressWarnings("rawtypes") Acidente ac : acidentes) {
			return ac.buscaCampos(i);		
		}
		return null;
	}
}
