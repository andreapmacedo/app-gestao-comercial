package Entidades;

import java.util.Date;

public class EmployerData {

    private Integer IdPk;
    private Integer IdFK_Employer;
    private String bairro;
    private Integer IdFK_Cidade;
    private Integer IdFK_Estado;
    private String nome;
    private Date nascimento;
    private Integer idade;
    private String sexo;
    private String estadoCivil;
    private String identidade;
    private String pis; 
    private String cpf;
    private Integer filhos;
    private String logradouro;
    private String numero;
    private String complemento;
    private String email;
    private String IdentificacaoColaborador;

    public EmployerData() {
    }

    public Integer getIdPk() {
        return IdPk;
    }

    public void setIdPk(Integer IdPk) {
        this.IdPk = IdPk;
    }

    public Integer getIdFK_Employer() {
        return IdFK_Employer;
    }

    public void setIdFK_Employer(Integer IdFK_Employer) {
        this.IdFK_Employer = IdFK_Employer;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Integer getIdFK_Cidade() {
        return IdFK_Cidade;
    }

    public void setIdFK_Cidade(Integer IdFK_Cidade) {
        this.IdFK_Cidade = IdFK_Cidade;
    }

    public Integer getIdFK_Estado() {
        return IdFK_Estado;
    }

    public void setIdFK_Estado(Integer IdFK_Estado) {
        this.IdFK_Estado = IdFK_Estado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getIdentidade() {
        return identidade;
    }

    public void setIdentidade(String identidade) {
        this.identidade = identidade;
    }

    public String getPis() {
        return pis;
    }

    public void setPis(String pis) {
        this.pis = pis;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getFilhos() {
        return filhos;
    }

    public void setFilhos(Integer filhos) {
        this.filhos = filhos;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdentificacaoColaborador() {
        return IdentificacaoColaborador;
    }

    public void setIdentificacaoColaborador(String IdentificacaoColaborador) {
        this.IdentificacaoColaborador = IdentificacaoColaborador;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + (this.IdPk != null ? this.IdPk.hashCode() : 0);
        hash = 89 * hash + (this.IdFK_Employer != null ? this.IdFK_Employer.hashCode() : 0);
        hash = 89 * hash + (this.IdFK_Cidade != null ? this.IdFK_Cidade.hashCode() : 0);
        hash = 89 * hash + (this.IdFK_Estado != null ? this.IdFK_Estado.hashCode() : 0);
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
        final EmployerData other = (EmployerData) obj;
        if (this.IdPk != other.IdPk && (this.IdPk == null || !this.IdPk.equals(other.IdPk))) {
            return false;
        }
        if (this.IdFK_Employer != other.IdFK_Employer && (this.IdFK_Employer == null || !this.IdFK_Employer.equals(other.IdFK_Employer))) {
            return false;
        }
        if (this.IdFK_Cidade != other.IdFK_Cidade && (this.IdFK_Cidade == null || !this.IdFK_Cidade.equals(other.IdFK_Cidade))) {
            return false;
        }
        if (this.IdFK_Estado != other.IdFK_Estado && (this.IdFK_Estado == null || !this.IdFK_Estado.equals(other.IdFK_Estado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }


    
}
