package br.com.contaDeEnergia.Model;

public class TimeRota {
    private int id;
    private int funcionario_id;
    private int tarefa_rota_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFuncionario_id() {
        return funcionario_id;
    }

    public void setFuncionario_id(int funcionario_id) {
        this.funcionario_id = funcionario_id;
    }

    public int getTarefa_rota_id() {
        return tarefa_rota_id;
    }

    public void setTarefa_rota_id(int tarefa_rota_id) {
        this.tarefa_rota_id = tarefa_rota_id;
    }
}
