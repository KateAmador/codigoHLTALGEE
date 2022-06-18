import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        String hltalgee = JOptionPane.showInputDialog("Ingrese un Numero de 8 digitos HLTALGEE: ");

        //cambio

        int hl = Integer.parseInt(hltalgee.substring(0,2));
        int t = Integer.parseInt(hltalgee.substring(2,3));
        int al = Integer.parseInt(hltalgee.substring(3,5));
        int g = Integer.parseInt(hltalgee.substring(5,6));
        int ee = Integer.parseInt(hltalgee.substring(6,8));

        String g1 = "";
        int categoria = 0;
        String turno = "";
        int valorHorasLaboradas = 0;
        int valorHorasExtras = 0;
        int totalPago;
        String supervisor = "";

        if (g == 1){
            g1 = "MASCULINO";
        } else if (g == 2){
            g1 = "FEMENINO";
        }

        if (al < 10){
            categoria = 1;
        } else if (al >= 10 && al <= 15) {
            categoria = 2;
        } else if (al > 15 && al < 20) {
            categoria = 3;
        } else if (al >= 20) {
            categoria = 4;
        }

        if (t == 1){
            turno = "MAÑANA";
        } else if (t == 2) {
            turno = "TARDE";
        } else if (t == 3) {
            turno = "NOCHE";
        }


        if (categoria == 1 && hl >= 40){
            valorHorasLaboradas = (40 * 15000);
        } else if (categoria == 2 && hl >= 40) {
            valorHorasLaboradas = (40 * 20000);
        } else if (categoria == 3 && hl >= 40) {
            valorHorasLaboradas = (40 * 25000);
        } else if (categoria == 4 && hl >= 40) {
            valorHorasLaboradas = (40 * 30000);
        } else if (categoria == 1 && hl <= 40) {
            valorHorasLaboradas = hl * 15000;
        } else if (categoria == 2 && hl <= 40) {
            valorHorasLaboradas = hl * 20000;
        } else if (categoria == 3 && hl <= 40) {
            valorHorasLaboradas = hl * 25000;
        } else if (categoria == 4 && hl <= 40) {
            valorHorasLaboradas = hl * 30000;
        }

        if (categoria == 1 && hl > 40){
            valorHorasExtras = (hl - 40)* 17000;
        } else if (categoria == 2 && hl > 40) {
            valorHorasExtras = (hl - 40)* 22000;
        } else if (categoria == 3 && hl > 40) {
            valorHorasExtras = (hl - 40)* 27000;
        } else if (categoria == 4 && hl > 40) {
            valorHorasExtras = (hl - 40)* 32000;
        }

        totalPago = valorHorasLaboradas + valorHorasExtras;

        if (g1.equals("FEMENINO") && ee > 25 && ee <= 40 && hl > 40){
            supervisor = "Jornada Mañana";
        } else if (g1.equals("FEMENINO") && ee > 40 && categoria == 2 && turno.equals("TARDE")) {
            supervisor = "Jornada Tarde";
        } else if ((g1.equals("FEMENINO") || g1.equals("MASCULINO")) && turno.equals("NOCHE") && ee >= 44 && ee <= 65 && (categoria == 2 || categoria == 3)) {
            supervisor = "Jornada Noche";
        }else {
            supervisor = "NO";
        }


        String sms = "HLTALGEE\n\n";
        sms += "Horas laboradas en una semana: " + hl;
        sms += "\nTurno: " + turno;
        sms += "\nAños laborados: " + al;
        sms += "\nCategoria: " + categoria;
        sms += "\nGenero: " + g1;
        sms += "\nEdad: " + ee;
        sms += "\n\nValor horas laboradas: " + valorHorasLaboradas;
        sms += "\nValor horas extras: " + valorHorasExtras;
        sms += "\nTotal pago: " + totalPago;
        sms += "\nSupervisor: " + supervisor;

        JOptionPane.showMessageDialog(null, sms);

    }
}