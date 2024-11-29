import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Avion {
    private int Immatriculation;// 飞机编号
    private String model;     // 飞机型号
    private int capacite;     // 飞机容量
    private boolean disponible; // 是否可用
    private List<Vol> volsAssocies;//关联航班列表

    // 构造函数
    public Avion(int Immatriculation, String model, int capacite) {
        this.Immatriculation = Immatriculation;
        this.model = model;
        this.capacite = capacite;
        this.disponible = true; // 默认飞机可用
        this.volsAssocies = new ArrayList<>();
    }
    // Getter 和 Setter
    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public int getCapacite() {
        return capacite;
    }
    // 设置飞机的可用状态
    public void setDisponibilite(boolean disponible) {
        this.disponible = disponible;
    }

    //Fonctionnalités
    public boolean verifierDisponibilite(Vol vol) {
        for (Vol v : volsAssocies) {
            Date departExistant = v.getDateHeureDepart();
            Date arriveeExistant = v.getDateHeureArrivee();
            Date departNouveau = vol.getDateHeureDepart();
            Date arriveeNouveau = vol.getDateHeureArrivee();

            // 检查时间是否冲突
            if (departExistant.before(arriveeNouveau) && arriveeExistant.after(departNouveau)) {
                // 时间有冲突，飞机不可用
                System.out.println("Conflit:vol existant " + v.getNumeroVol() + " Le temps chevauche celui du nouveau vol! ");
                return false;
            }
        }
        return true;
    }

    // 分配航班到飞机
    public void affecterVol(Vol vol) {
        if (verifierDisponibilite(vol)) {
            volsAssocies.add(vol);
            System.out.println("vol " + vol.getNumeroVol() + " Affecté avec succès à l'avion " + Immatriculation);
        } else {
            System.out.println("vol " + vol.getNumeroVol() + " Impossible d'attribuer, conflit d'heure！");
        }
    }

}
