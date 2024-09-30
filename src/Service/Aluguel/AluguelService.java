
package Service.Aluguel;

import Model.Aluguel.Aluguel;

import java.math.BigDecimal;
import java.util.List;

public interface AluguelService {
    void cadastrarAluguel(Aluguel aluguel);

    void editarAluguel(Aluguel aluguel);

    void removerAluguel(String idAluguel);

    Aluguel getAluguelById(String idAluguel);

    List<Aluguel> buscarAluguelPorNomeCliente(String nomeCliente);

    void listarAlugueis();

    BigDecimal calcularValorAluguel(Aluguel aluguel);

    String gerarComprovante(Aluguel aluguel);
}
