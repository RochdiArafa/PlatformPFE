package tn.esprit.Services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;

import tn.pfe.entity.GradProjectFile;


@Remote
public interface GradProjectFileServiceRemote {
	public GradProjectFile searchSheet(int id);
	public int findMaxArray(ArrayList<GradProjectFile> tab1,ArrayList<GradProjectFile> tab2,ArrayList<GradProjectFile> tab3);
	public List<GradProjectFile> getSheetsByEtat(String etat);
	public List<GradProjectFile> getSheetsByYear(String year);
	public List<GradProjectFile> getSheetsByPays(String pays);
	public List<GradProjectFile> getSheetsOfYear();
}
