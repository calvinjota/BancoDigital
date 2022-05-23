package BancoDigital;

import java.util.ArrayList;
import java.util.List;

class Contas {
    List<ContaDigital> listaDeContas = new ArrayList<>();
    ExtratoCartao extratoCartao = new ExtratoCartao();

    Contas() {
        listaDeContas.add(new ContaDigital("João", 11, 111, 1200, 400, 2000, extratoCartao.extratoJoao));
        listaDeContas.add(new ContaDigital("Paulo", 22, 222, 10000, 4000, 7000, extratoCartao.extratoJoao));
        listaDeContas.add(new ContaDigital("Maria", 33, 333, 2400, 1200, 1800, extratoCartao.extratoJoao));
    }

}
