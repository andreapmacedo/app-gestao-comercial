package entities;

import java.math.BigDecimal;

public class PayStubDescription {

    private Integer idPk;
    private String description;
    private Integer type;
    private String referenceType;
    private BigDecimal referenceValue;
    private String incidence;
    private Integer inssFocus;
    private Integer fgtsFocus;
    private Integer irFocus;

    public PayStubDescription() {
    }

    public Integer getIdPk() {
        return idPk;
    }

    public void setIdPk(Integer idPk) {
        this.idPk = idPk;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getReferenceType() {
        return referenceType;
    }

    public void setReferenceType(String referenceType) {
        this.referenceType = referenceType;
    }

    public BigDecimal getReferenceValue() {
        return referenceValue;
    }

    public void setReferenceValue(BigDecimal referenceValue) {
        this.referenceValue = referenceValue;
    }

   



    public String getIncidence() {
        return incidence;
    }

    public void setIncidence(String incidence) {
        this.incidence = incidence;
    }

    public Integer getInssFocus() {
        return inssFocus;
    }

    public void setInssFocus(Integer inssFocus) {
        this.inssFocus = inssFocus;
    }

    public Integer getFgtsFocus() {
        return fgtsFocus;
    }

    public void setFgtsFocus(Integer fgtsFocus) {
        this.fgtsFocus = fgtsFocus;
    }

    public Integer getIrFocus() {
        return irFocus;
    }

    public void setIrFocus(Integer irFocus) {
        this.irFocus = irFocus;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (this.idPk != null ? this.idPk.hashCode() : 0);
        hash = 31 * hash + (this.description != null ? this.description.hashCode() : 0);
        hash = 31 * hash + (this.type != null ? this.type.hashCode() : 0);
        hash = 31 * hash + (this.referenceType != null ? this.referenceType.hashCode() : 0);
        hash = 31 * hash + (this.referenceValue != null ? this.referenceValue.hashCode() : 0);
        hash = 31 * hash + (this.incidence != null ? this.incidence.hashCode() : 0);
        hash = 31 * hash + (this.inssFocus != null ? this.inssFocus.hashCode() : 0);
        hash = 31 * hash + (this.fgtsFocus != null ? this.fgtsFocus.hashCode() : 0);
        hash = 31 * hash + (this.irFocus != null ? this.irFocus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PayStubDescription other = (PayStubDescription) obj;
        if (this.idPk != other.idPk && (this.idPk == null || !this.idPk.equals(other.idPk))) {
            return false;
        }
        if ((this.description == null) ? (other.description != null) : !this.description.equals(other.description)) {
            return false;
        }
        if ((this.type == null) ? (other.type != null) : !this.type.equals(other.type)) {
            return false;
        }
        if (this.referenceType != other.referenceType && (this.referenceType == null || !this.referenceType.equals(other.referenceType))) {
            return false;
        }
        if ((this.referenceValue == null) ? (other.referenceValue != null) : !this.referenceValue.equals(other.referenceValue)) {
            return false;
        }
        if ((this.incidence == null) ? (other.incidence != null) : !this.incidence.equals(other.incidence)) {
            return false;
        }
        if (this.inssFocus != other.inssFocus && (this.inssFocus == null || !this.inssFocus.equals(other.inssFocus))) {
            return false;
        }
        if (this.fgtsFocus != other.fgtsFocus && (this.fgtsFocus == null || !this.fgtsFocus.equals(other.fgtsFocus))) {
            return false;
        }
        if (this.irFocus != other.irFocus && (this.irFocus == null || !this.irFocus.equals(other.irFocus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "HoleriteDescription{" + "idPk=" + idPk + ", description=" + description + ", type=" + type + ", referenceType=" + referenceType + ", referenceValue=" + referenceValue + ", incidence=" + incidence + ", inssFocus=" + inssFocus + ", fgtsFocus=" + fgtsFocus + ", irFocus=" + irFocus + '}';
    }

 

    
    
    
}