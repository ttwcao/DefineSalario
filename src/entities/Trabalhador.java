package entities;

import entities.enums.NivelTrabalhador;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Trabalhador {

    private String nome;
    private NivelTrabalhador nivel;
    private Double salarioBase;

    //associação de classe
    //composição do tipo 'tem um'
    private Departamento departamento;

    //composição do tipo 'tem muitos' não deve ser incluído no construtor
    private List<HoraContrato> contratos = new ArrayList<>();

    public void adicionarContrato(){
    }

    public Trabalhador(String nome, NivelTrabalhador nivel, Double salarioBase, Departamento departamento) {
        this.nome = nome;
        this.nivel = nivel;
        this.salarioBase = salarioBase;
        this.departamento = departamento;
    }

    public void adcionarContrato(HoraContrato contrato){
        contratos.add(contrato);
    }

    public void removerContrato(HoraContrato contrato){
        contratos.remove(contrato);
    }

    public Double ganhos(int ano, int mes){
        double soma = salarioBase;
        Calendar calendario = Calendar.getInstance();
        for(HoraContrato c : contratos){
            //data do contrato definida como data do calendário
            calendario.setTime(c.getDate());
            int cAno = calendario.get(Calendar.YEAR);
            //mês do callendar começa com 0
            int cMes = 1 + calendario.get(Calendar.MONTH);
            if(ano == cAno && mes == cMes){
                soma += c.valorTotal();
            }
        }
        return soma;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public NivelTrabalhador getNivel() {
        return nivel;
    }

    public void setNivel(NivelTrabalhador nivel) {
        this.nivel = nivel;
    }

    public Double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(Double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<HoraContrato> getContratos() {
        return contratos;
    }

}
