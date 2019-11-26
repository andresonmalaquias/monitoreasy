package model.bean;

public class DisciplinaBean {
    private String nome;
    private String codigo;
    private int qtd;

    public DisciplinaBean(String codigo, String nome) {
        this.nome = nome;
    }

    public DisciplinaBean() {
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
    
    
}
