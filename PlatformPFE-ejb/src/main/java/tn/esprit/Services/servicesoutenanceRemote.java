package tn.esprit.Services;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import tn.pfe.entity.Classes;
import tn.pfe.entity.GradProjectFile;
import tn.pfe.entity.Soutenance;

@Remote
public interface servicesoutenanceRemote {
public String addsoutenance(Soutenance s);
public void affecterpfetos(int idpfe,int ids);
public void affecterclassetos(int idc,int ids);
public List<Soutenance> algo(String datesoutenance ,List<GradProjectFile> pfes,List<Classes>classes )throws ParseException;
public String add(List<Soutenance> ss);
}
