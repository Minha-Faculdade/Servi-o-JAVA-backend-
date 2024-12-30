
package br.edu.ifms.veiculo.servico.jaxws;

import java.util.List;
import br.edu.ifms.veiculo.modelo.Veiculo;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "listarResponse", namespace = "http://servico.veiculo.ifms.edu.br/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listarResponse", namespace = "http://servico.veiculo.ifms.edu.br/")
public class ListarResponse {

    @XmlElement(name = "return", namespace = "")
    private List<Veiculo> _return;

    /**
     * 
     * @return
     *     returns List<Veiculo>
     */
    public List<Veiculo> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(List<Veiculo> _return) {
        this._return = _return;
    }

}
