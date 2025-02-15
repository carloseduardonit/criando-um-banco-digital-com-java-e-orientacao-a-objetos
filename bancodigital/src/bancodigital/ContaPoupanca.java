package bancodigital;

/**
 *
 * @author 
 */
public class ContaPoupanca extends Conta {

    public ContaPoupanca() {
        super("poupança");
    }

    @Override
    public void impressaoExtrato() {
        System.out.println("\nExtrato da Conta Poupança");
        super.extrato();
    }
    
}
