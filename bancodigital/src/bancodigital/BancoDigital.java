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
        //'Conta' is abstract; cannot be instantiated
        final Conta contapoupanca;
        contapoupanca = new ContaPoupanca().TESTE();
        contapoupanca.impressaoExtrato();
        contapoupanca.deposito(100);
        contapoupanca.saque(50);
        contapoupanca.impressaoExtrato();
        

        final Conta contacorrente;
        contacorrente = new ContaCorrente().TESTE();
        contacorrente.impressaoExtrato();
        contacorrente.deposito(100);
        contacorrente.saque(50);
        contacorrente.impressaoExtrato();
        contacorrente.withLimite();
        contacorrente.impressaoExtrato();
        contacorrente.transferencia(10, contapoupanca);
        contacorrente.impressaoExtrato();
        contapoupanca.impressaoExtrato();


    }

    
}
