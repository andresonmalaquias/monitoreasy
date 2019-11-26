package model.bean;

public class ParticipaBean {
    private int monitorMatricula;
    private String nomeMonitor;
    private int alunoMatricula;
    private String local;
    private String disciplina;
    private String dataHora;

    public String getDisciplina() {
        return disciplina;
    }

    public String getNomeMonitor() {
        return nomeMonitor;
    }

    public void setNomeMonitor(String nomeMonitor) {
        this.nomeMonitor = nomeMonitor;
    }
    
    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }
    
    public int getMonitorMatricula() {
        return monitorMatricula;
    }

    public void setMonitorMatricula(int monitorMatricula) {
        this.monitorMatricula = monitorMatricula;
    }

    public int getAlunoMatricula() {
        return alunoMatricula;
    }

    public void setAlunoMatricula(int alunoMatricula) {
        this.alunoMatricula = alunoMatricula;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    
}
