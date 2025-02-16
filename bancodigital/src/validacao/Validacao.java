/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Singleton.java to edit this template
 */
package validacao;

/**
 *
 * @author Carlos
 */
public class Validacao {
    
    private Validacao() {
    }
    
    public static Validacao getInstance() {
        return ValidacaoHolder.INSTANCE;
    }
    
    private static class ValidacaoHolder {

        private static final Validacao INSTANCE = new Validacao();
    }
    
}
