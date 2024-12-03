package com.isep;

import java.util.ArrayList;
import java.util.Date;

public class Vol {
    private int numeroVol;         // 航班编号
    private String Origine;        // 出发地
    private String destination;    // 目的地
    private Date DateHeureDepart;  // 航班日期出发日期和时间
    private Date DateHeureArrivee; //航班到达时间日期
    private String Etat;           // 飞机状态
    private String pilote;         // 飞行员
    private String equipeCabine;   // 机组成员

    // 构造函数
    public Vol(int numeroVol, String Origine, String destination, Date DateHeureDepart, Date DateHeureArrivee, String Etat) {
        this.numeroVol = numeroVol;
        this.Origine = Origine;
        this.destination = destination;
        this.DateHeureDepart = DateHeureDepart;
        this.DateHeureArrivee = DateHeureArrivee;
        this.Etat = "Planifié"; // 初始化时未分配飞机
        this.pilote = null;
        this.equipeCabine = null;
    }

    // Getter 和 Setter
    public int getNumeroVol() {
        return numeroVol;
    }
    public String getOrigine() {
        return Origine;
    }
    public String getDestination() {
        return destination;
    }
    public Date getDateHeureDepart() {
        return DateHeureDepart;
    }
    public Date getDateHeureArrivee() {
        return DateHeureArrivee;
    }
    public String getEtat() {
        return Etat;
    }

    //Fonctionnalités
    public void affecterVol(String pilote, String equipeCabine) {
        this.pilote = pilote;
        this.equipeCabine = equipeCabine;
        System.out.println("Vol " + numeroVol + " , pilote - " + pilote + ", equipeCabine - " + equipeCabine);
    }

    public String obtenirVol() {
        String piloteInfo;
        if (pilote != null) {
            piloteInfo = pilote;
        } else {
            piloteInfo = "non attribué";
        }

        String equipeCabineInfo;
        if (equipeCabine != null) {
            equipeCabineInfo = equipeCabine;
        } else {
            equipeCabineInfo = "non attribué";
        }

        return "Vol ID: " + numeroVol + ", origine: " + Origine + ", destination: " + destination +
                ", dateHeureDepart: " + DateHeureDepart + ", dateHeureArrivee: " + DateHeureArrivee +
                ", etat: " + Etat + ", pilote: " + piloteInfo +
                ", equipeCabine: " + equipeCabineInfo;
    }

    // 计划航班
    public void planifierVol() {
        this.Etat = "Planifié";
        System.out.println(" numeroVol " + numeroVol + " deja planifiée");
    }

    // 取消航班
    public void annulerVol() {
        this.Etat = "Annulé";
        this.pilote = null;
        this.equipeCabine = null;
        System.out.println("numeroVol " + numeroVol + " Annulé ");
    }

}
