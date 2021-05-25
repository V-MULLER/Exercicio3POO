package controle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import entidades.Acidente;
import excessoes.DadosAbertosException;

public class Teste {


  // FIXME: alterar o tipo dessa lista para List<Acidente<TIPO_DESEJADO>>
  private List<Acidente> acidentes = new ArrayList<>();


  public Teste() {

  }

  // FIXME: não utilizar SuppressWarning. Esse warning do construtor de acidente é por que tu
  //  colocou Generics na classe, se não está usando retire o Generic.
  public void leArquivo(Path path) throws DadosAbertosException {
    try(BufferedReader reader = Files.newBufferedReader(path)) {
      acidentes = reader.lines().map(line -> {
        String[] data = line.split(";");
        return new Acidente(data);
      }).collect(Collectors.toList());
    }
    catch(IOException e) {
      throw new DadosAbertosException();
    }
  }

  // guardar objeto no arquivo
  public void guardaArquivo(Path path) throws DadosAbertosException {
    try(ObjectOutputStream arq = new ObjectOutputStream(Files.newOutputStream(path))) {
      arq.writeObject(acidentes);

    }
    catch(IOException e1) {
      throw new DadosAbertosException();
    }
    catch(Exception e2) {
      throw new DadosAbertosException();
    }
  }

  // ler o objeto do arquivo
  public void leObjeto(Path path) throws DadosAbertosException {
    try(ObjectInputStream arq = new ObjectInputStream(Files.newInputStream(path))) {

      acidentes = (ArrayList<Acidente>) arq.readObject();
      System.out.println("Arquivo lido com sucesso. ");


    }
    catch(ClassNotFoundException e1) {
      throw new DadosAbertosException();
    }
    catch(IOException e2) {
      throw new DadosAbertosException();
    }
  }

  public String lerTodosOsDadosDoArquivo() {
    for(@SuppressWarnings("rawtypes") Acidente ac : acidentes) {
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
