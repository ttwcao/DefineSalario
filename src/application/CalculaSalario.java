package application;

import entities.Departamento;
import entities.HoraContrato;
import entities.Trabalhador;
import entities.enums.NivelTrabalhador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CalculaSalario {
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Informe do nome do departamento: ");
        String departamentoNome = sc.nextLine();

        System.out.println("== Informe os dados do trabalhador == ");
        System.out.println("Nome: ");
        String nome = sc.nextLine();
        System.out.println("Nível: ");
        String nivel = sc.nextLine();
        System.out.println("Salário base: ");
        Double salario = sc.nextDouble();

        Trabalhador trabalhador = new Trabalhador(nome, NivelTrabalhador.valueOf(nivel), salario, new Departamento(departamentoNome) );

        System.out.println("Quantos contratos o trabalhador possui? ");
        int n = sc.nextInt();

        for(int i=1; i<=n; i++){
            System.out.println("Informe o contrato #" + i + " data: ");
            System.out.print("Data (DD/MM/YYYY): ");
            Date DataContrato = simpleDateFormat.parse(sc.next());
            System.out.print("Valor por hora: ");
            double valorHora = sc.nextDouble();
            System.out.print("Duração (horas): ");
            int DurHoras = sc.nextInt();
            HoraContrato contrato = new HoraContrato(DataContrato, valorHora, DurHoras);
            trabalhador.adcionarContrato(contrato);
        }

        System.out.println();
        System.out.println("Informe o mês e ano para calcular o salário: (MM/YYYY): ");
        String mesAno = sc.next();
        //recortar a variável para obter ano e mes
        int mes = Integer.parseInt(mesAno.substring(0, 2));
        int ano = Integer.parseInt(mesAno.substring(3));

        System.out.println("Nome: " + trabalhador.getNome());
        System.out.println("Departamento: " + trabalhador.getDepartamento().getName());
        System.out.println("Salário no período: " + mesAno + ": " + String.format("%.2f", trabalhador.ganhos(ano, mes)));

        sc.close();

    }
}
