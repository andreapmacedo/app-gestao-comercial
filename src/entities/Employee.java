/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;

/**
 *
 * @author Andre
 */
public class Employee implements java.io.Serializable {

    private Integer idServidor;
    private String nomeServidor;
    private String identidadeServidor;
    private String cpfServidor;
    private String carteiraTrabalhoServidor;
    private Date nascimentoServidor;
    private Date admissaoServidor;
    private Date registroServidor;
    private String sexoServidor;
    private String estCivilServidor;
    private Integer filhoServidor;
    private String emailServidor;
    private String logradouroServidor;
    private String numeroServidor;
    private String complementoServidor;
    private String cepServidor;
    private Integer funServidor;
    private Integer setServidor;
    private Integer baiServidor;
    private Integer cidServidor;

    public Employee(Integer idServidor, String nomeServidor, String identidadeServidor, String cpfServidor, String carteiraTrabalhoServidor, Date nascimentoServidor, Date admissaoServidor, Date registroServidor, String sexoServidor, String estCivilServidor, Integer filhoServidor, String emailServidor, String logradouroServidor, String numeroServidor, String complementoServidor, String cepServidor, Integer funServidor, Integer setServidor, Integer baiServidor, Integer cidServidor, Integer estServidor) {
        this.idServidor = idServidor;
        this.nomeServidor = nomeServidor;
        this.identidadeServidor = identidadeServidor;
        this.cpfServidor = cpfServidor;
        this.carteiraTrabalhoServidor = carteiraTrabalhoServidor;
        this.nascimentoServidor = nascimentoServidor;
        this.admissaoServidor = admissaoServidor;
        this.registroServidor = registroServidor;
        this.sexoServidor = sexoServidor;
        this.estCivilServidor = estCivilServidor;
        this.filhoServidor = filhoServidor;
        this.emailServidor = emailServidor;
        this.logradouroServidor = logradouroServidor;
        this.numeroServidor = numeroServidor;
        this.complementoServidor = complementoServidor;
        this.cepServidor = cepServidor;
        this.funServidor = funServidor;
        this.setServidor = setServidor;
        this.baiServidor = baiServidor;
        this.cidServidor = cidServidor;
        this.estServidor = estServidor;
    }

    public Employee(Integer idServidor) {
        this.idServidor = idServidor;
    }

    public Employee() {
    }

    public Date getRegistroServidor() {
        return registroServidor;
    }

    public void setRegistroServidor(Date registroServidor) {
        this.registroServidor = registroServidor;
    }

    public Date getAdmissaoServidor() {
        return admissaoServidor;
    }

    public void setAdmissaoServidor(Date admissaoServidor) {
        this.admissaoServidor = admissaoServidor;
    }

    public Integer getBaiServidor() {
        return baiServidor;
    }

    public void setBaiServidor(Integer baiServidor) {
        this.baiServidor = baiServidor;
    }

    public String getCarteiraTrabalhoServidor() {
        return carteiraTrabalhoServidor;
    }

    public void setCarteiraTrabalhoServidor(String carteiraTrabalhoServidor) {
        this.carteiraTrabalhoServidor = carteiraTrabalhoServidor;
    }

    public String getCepServidor() {
        return cepServidor;
    }

    public void setCepServidor(String cepServidor) {
        this.cepServidor = cepServidor;
    }

    public Integer getCidServidor() {
        return cidServidor;
    }

    public void setCidServidor(Integer cidServidor) {
        this.cidServidor = cidServidor;
    }

    public String getComplementoServidor() {
        return complementoServidor;
    }

    public void setComplementoServidor(String complementoServidor) {
        this.complementoServidor = complementoServidor;
    }

    public String getCpfServidor() {
        return cpfServidor;
    }

    public void setCpfServidor(String cpfServidor) {
        this.cpfServidor = cpfServidor;
    }

    public String getEmailServidor() {
        return emailServidor;
    }

    public void setEmailServidor(String emailServidor) {
        this.emailServidor = emailServidor;
    }

    public String getEstCivilServidor() {
        return estCivilServidor;
    }

    public void setEstCivilServidor(String estCivilServidor) {
        this.estCivilServidor = estCivilServidor;
    }

    public Integer getEstServidor() {
        return estServidor;
    }

    public void setEstServidor(Integer estServidor) {
        this.estServidor = estServidor;
    }

    public Integer getFilhoServidor() {
        return filhoServidor;
    }

    public void setFilhoServidor(Integer filhoServidor) {
        this.filhoServidor = filhoServidor;
    }

    public Integer getFunServidor() {
        return funServidor;
    }

    public void setFunServidor(Integer funServidor) {
        this.funServidor = funServidor;
    }

    public Integer getIdServidor() {
        return idServidor;
    }

    public void setIdServidor(Integer idServidor) {
        this.idServidor = idServidor;
    }

    public String getIdentidadeServidor() {
        return identidadeServidor;
    }

    public void setIdentidadeServidor(String identidadeServidor) {
        this.identidadeServidor = identidadeServidor;
    }

    public String getLogradouroServidor() {
        return logradouroServidor;
    }

    public void setLogradouroServidor(String logradouroServidor) {
        this.logradouroServidor = logradouroServidor;
    }

    public Date getNascimentoServidor() {
        return nascimentoServidor;
    }

    public void setNascimentoServidor(Date nascimentoServidor) {
        this.nascimentoServidor = nascimentoServidor;
    }

    public String getNomeServidor() {
        return nomeServidor;
    }

    public void setNomeServidor(String nomeServidor) {
        this.nomeServidor = nomeServidor;
    }

    public String getNumeroServidor() {
        return numeroServidor;
    }

    public void setNumeroServidor(String numeroServidor) {
        this.numeroServidor = numeroServidor;
    }

    public Integer getSetServidor() {
        return setServidor;
    }

    public void setSetServidor(Integer setServidor) {
        this.setServidor = setServidor;
    }

    public String getSexoServidor() {
        return sexoServidor;
    }

    public void setSexoServidor(String sexoServidor) {
        this.sexoServidor = sexoServidor;
    }



    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employee other = (Employee) obj;
        if (this.idServidor != other.idServidor && (this.idServidor == null || !this.idServidor.equals(other.idServidor))) {
            return false;
        }
        if (this.funServidor != other.funServidor && (this.funServidor == null || !this.funServidor.equals(other.funServidor))) {
            return false;
        }
        if (this.setServidor != other.setServidor && (this.setServidor == null || !this.setServidor.equals(other.setServidor))) {
            return false;
        }
        if (this.baiServidor != other.baiServidor && (this.baiServidor == null || !this.baiServidor.equals(other.baiServidor))) {
            return false;
        }
        if (this.cidServidor != other.cidServidor && (this.cidServidor == null || !this.cidServidor.equals(other.cidServidor))) {
            return false;
        }
        if (this.estServidor != other.estServidor && (this.estServidor == null || !this.estServidor.equals(other.estServidor))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + (this.idServidor != null ? this.idServidor.hashCode() : 0);
        hash = 19 * hash + (this.funServidor != null ? this.funServidor.hashCode() : 0);
        hash = 19 * hash + (this.setServidor != null ? this.setServidor.hashCode() : 0);
        hash = 19 * hash + (this.baiServidor != null ? this.baiServidor.hashCode() : 0);
        hash = 19 * hash + (this.cidServidor != null ? this.cidServidor.hashCode() : 0);
        hash = 19 * hash + (this.estServidor != null ? this.estServidor.hashCode() : 0);
        return hash;
    }
    private Integer estServidor;
}
