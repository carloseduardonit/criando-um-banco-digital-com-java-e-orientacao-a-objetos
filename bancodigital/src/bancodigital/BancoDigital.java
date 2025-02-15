package bancodigital;

/**
 *
 * @author Carlos
 */
public class BancoDigital {

    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final Conta contapoupanca;
        contapoupanca = new ContaPoupanca().withConta();
        contapoupanca.impressaoExtrato();
        contapoupanca.deposito(100);
        

        final Conta contacorrente;
        contacorrente = new ContaCorrente().withNomeCliente().withnNumeroConta().withAgencia();
        contacorrente.impressaoExtrato();
        contacorrente.deposito(100);
    }

    
}
