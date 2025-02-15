package cliente;

import java.util.Date;
import lombok.*;

/**
 *
 * @author Carlos
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Pessoa {

    private Long id;
    private String nome;
    private String documento;
    private Date dataInicial;

}
