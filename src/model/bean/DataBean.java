package model.bean;

import java.util.ArrayList;

public class DataBean {
    private String data;
    private String loccodigo;
    private ArrayList<String> horas;
    private String hora;

    public DataBean() {
        this.horas = new ArrayList<>();
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public ArrayList<String> getHoras() {
        return horas;
    }

    public void setHoras(String hora) {
        this.horas.add(hora);
    }

    public String getLoccodigo() {
        return loccodigo;
    }

    public void setLoccodigo(String loccodigo) {
        this.loccodigo = loccodigo;
    }
    
    public void clear() {
        this.horas.clear();
    }
    
}
