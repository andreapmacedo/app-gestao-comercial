/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Andre
 */
public class New  {
     private Integer idServidor;
    private String Fone;

    public New() {
    }

    public New(Integer idServidor) {
        this.idServidor = idServidor;
    }

    public New(Integer idServidor, String Fone) {
        this.idServidor = idServidor;
        this.Fone = Fone;
    }

    public String getFone() {
        return Fone;
    }

    public void setFone(String Fone) {
        this.Fone = Fone;
    }

    public Integer getIdServidor() {
        return idServidor;
    }

    public void setIdServidor(Integer idServidor) {
        this.idServidor = idServidor;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final New other = (New) obj;
        if (this.idServidor != other.idServidor && (this.idServidor == null || !this.idServidor.equals(other.idServidor))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (this.idServidor != null ? this.idServidor.hashCode() : 0);
        return hash;
    }
      @Override
    public String toString() {
        return getFone();
    }
    
}
