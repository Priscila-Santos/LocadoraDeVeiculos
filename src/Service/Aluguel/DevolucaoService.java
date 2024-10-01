
package Service.Aluguel;

import Model.Aluguel.Devolucao;

import java.math.BigDecimal;
import java.util.List;

public interface DevolucaoService {
    void registrarDevolucao(Devolucao devolucao);

    void editarDevolucao(Devolucao devolucao);

    void removerDevolucao(String idDevolucao);

    Devolucao getDevolucaoById(String idDevolucao);

    List<Devolucao> buscarDevolucaoPorNomeCliente(String nomeCliente);

    void listarDevolucoes();

    BigDecimal calcularValorAluguel(Devolucao devolucao);

    String gerarComprovante(Devolucao devolucao);
}
