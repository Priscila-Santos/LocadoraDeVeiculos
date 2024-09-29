package Service.Aluguel;

import java.math.BigDecimal;

public interface AluguelService {
    BigDecimal calcularValorAluguel();
    String gerarComprovante();
}
