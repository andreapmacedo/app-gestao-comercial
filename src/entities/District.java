/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;



/**
 *
 * @author Andre
 */
public class District implements java.io.Serializable {

    
    private Integer idBairro;
    private String nomeBairro;
    private Integer idCidade;

    public District(Integer idBairro) {
        this.idBairro = idBairro;
    }

    public District(Integer idBairro, String nomeBairro, Integer idCidade) {
        this.idBairro = idBairro;
        this.nomeBairro = nomeBairro;
        this.idCidade = idCidade;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final District other = (District) obj;
        if (this.idBairro != other.idBairro && (this.idBairro == null || !this.idBairro.equals(other.idBairro))) {
            return false;
        }
        if (this.idCidade != other.idCidade && (this.idCidade == null || !this.idCidade.equals(other.idCidade))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + (this.idBairro != null ? this.idBairro.hashCode() : 0);
        hash = 67 * hash + (this.idCidade != null ? this.idCidade.hashCode() : 0);
        return hash;
    }

    public Integer getIdBairro() {
        return idBairro;
    }

    public void setIdBairro(Integer idBairro) {
        this.idBairro = idBairro;
    }

    public Integer getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Integer idCidade) {
        this.idCidade = idCidade;
    }

    public String getNomeBairro() {
        return nomeBairro;
    }

    public void setNomeBairro(String nomeBairro) {
        this.nomeBairro = nomeBairro;
    }

    public District() {
    }

    @Override
    public String toString() {
        return getNomeBairro();
    }
}
