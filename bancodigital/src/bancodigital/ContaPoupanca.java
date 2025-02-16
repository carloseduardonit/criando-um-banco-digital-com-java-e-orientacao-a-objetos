package bancodigital;

/**
 *
 * @author Carlos Eduardo dos Santos 
 */
public class ContaPoupanca extends Conta {

    /**
     * Construtor
     */
    public ContaPoupanca() {
        super("poupança");
    }

    /**
     * Metodo para impressao do extrato da conta poupança
     */
    @Override
    public void impressaoExtrato() {
        System.out.println("\nExtrato da Conta Poupança");
        super.extrato();
        Saldo();
    }
    
}
