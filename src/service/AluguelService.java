package service;

import Model.aluguel.Aluguel;

import java.math.BigDecimal;

public interface AluguelService {
    BigDecimal calcularValorAluguel();
    String gerarComprovante();
}
