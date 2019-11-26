package model.bean;

public class MonitoraBean {
    public static int mat = 0;
    private String discodigo;
    private String nomeAluno;
    private int alumatricula;
    private String local;
    private String data;
    private String hora;
    private String cicloLetivo;

    public MonitoraBean(String discodigo, int alumatricula, String data, String cicloLetivo) {
        this.discodigo = discodigo;
        this.alumatricula = alumatricula;
        this.data = data;
        this.cicloLetivo = cicloLetivo;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }


    public String getCicloLetivo() {
        return cicloLetivo;
    }

    public void setCicloLetivo(String cicloLetivo) {
        this.cicloLetivo = cicloLetivo;
    }

    
    public MonitoraBean(int alumatricula, String local) {
        this.alumatricula = alumatricula;
        this.local = local;
    }

    public MonitoraBean() {
        
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
    
    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
    
    public String getDiscodigo() {
        return discodigo;
    }

    public void setDiscodigo(String discodigo) {
        this.discodigo = discodigo;
    }

    public int getAlumatricula() {
        return alumatricula;
    }

    public void setAlumatricula(int alumatricula) {
        this.alumatricula = alumatricula;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "MonitoraBean{" + "discodigo=" + discodigo + ", alumatricula=" + alumatricula + ", local=" + local + ", data=" + data + ", hora=" + hora + '}';
    }
    
    
}
