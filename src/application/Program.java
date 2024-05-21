package application;

import entities.Departament;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");

        System.out.print("Entre com o nome do departamento: ");
        String departamentName = sc.nextLine();
        System.out.println("Insira os dados do trabalhador: ");
        System.out.print("Name: ");
        String workerName = sc.nextLine();
        System.out.print("Nível: ");
        String workerLevel = sc.nextLine();
        System.out.print("Salário Base: ");
        double baseSalary = sc.nextDouble();
        Worker worker = new Worker(workerName , WorkerLevel.valueOf(workerLevel), baseSalary, new Departament(departamentName));

        System.out.println("Quantos contratos esse trabalhador terá? ");
        int n = sc.nextInt();

        for (int i = 1; i<=n ; i++){
            System.out.println("Entrar no contrato " + i + " data: ");
            System.out.print("Entre com a data: ");
            Date contractDate = sdf.parse(sc.next());
            System.out.print("Valor por hora: ");
            double valuePerHour = sc.nextDouble();
            System.out.print("Duração(Horas): ");
            int hours =sc.nextInt();
            HourContract contract = new HourContract(contractDate, valuePerHour, hours);
        }

        System.out.println();
        System.out.println("Entre com mês e ano para calcular o salário(MM/YYYY): ");
        String monthAndYear = sc.next();
        int month = Integer.parseInt(monthAndYear.substring(0 , 2));
        int year = Integer.parseInt(monthAndYear.substring(3));
        System.out.println("Nome: " + worker.getName());
        System.out.println("Departamento: " + worker.getDepartament().getName());
        System.out.println("Renda para " + monthAndYear + ": " + String.format("%.2f", worker.income(month, year)));


        sc.close();
    }

}
