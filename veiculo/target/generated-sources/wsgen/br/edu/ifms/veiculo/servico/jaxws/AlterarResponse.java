
package br.edu.ifms.veiculo.servico.jaxws;

import br.edu.ifms.veiculo.modelo.Veiculo;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "alterarResponse", namespace = "http://servico.veiculo.ifms.edu.br/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "alterarResponse", namespace = "http://servico.veiculo.ifms.edu.br/")
public class AlterarResponse {

    @XmlElement(name = "return", namespace = "")
    private Veiculo _return;

    /**
     * 
     * @return
     *     returns Veiculo
     */
    public Veiculo getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(Veiculo _return) {
        this._return = _return;
    }

}
