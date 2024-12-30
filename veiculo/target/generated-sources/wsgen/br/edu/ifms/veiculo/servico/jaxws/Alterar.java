
package br.edu.ifms.veiculo.servico.jaxws;

import br.edu.ifms.veiculo.modelo.Veiculo;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "alterar", namespace = "http://servico.veiculo.ifms.edu.br/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "alterar", namespace = "http://servico.veiculo.ifms.edu.br/")
public class Alterar {

    @XmlElement(name = "arg0", namespace = "")
    private Veiculo arg0;

    /**
     * 
     * @return
     *     returns Veiculo
     */
    public Veiculo getArg0() {
        return this.arg0;
    }

    /**
     * 
     * @param arg0
     *     the value for the arg0 property
     */
    public void setArg0(Veiculo arg0) {
        this.arg0 = arg0;
    }

}
