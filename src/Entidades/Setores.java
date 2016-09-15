/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Andre
 */
public class Setores implements java.io.Serializable {

    
    private Integer idSetor;
    private String nomeSetor;

     public Setores() {
    }
    
    public Setores(Integer idSetor) {
        this.idSetor = idSetor;
    }

    public Setores(Integer idSetor, String nomeSetor) {
        this.idSetor = idSetor;
        this.nomeSetor = nomeSetor;
    }

    public Integer getIdSetor() {
        return idSetor;
    }

    public void setIdSetor(Integer idSetor) {
        this.idSetor = idSetor;
    }

    public String getNomeSetor() {
        return nomeSetor;
    }

    public void setNomeSetor(String nomeSetor) {
        this.nomeSetor = nomeSetor;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Setores other = (Setores) obj;
        if (this.idSetor != other.idSetor && (this.idSetor == null || !this.idSetor.equals(other.idSetor))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + (this.idSetor != null ? this.idSetor.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return getNomeSetor();
    }
    

   
}
