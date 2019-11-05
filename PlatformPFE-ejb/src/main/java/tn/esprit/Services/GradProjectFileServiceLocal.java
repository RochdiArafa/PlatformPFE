package tn.esprit.Services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;

import tn.pfe.entity.GradProjectFile;

@Local
public interface GradProjectFileServiceLocal {
	public GradProjectFile searchSheet(int id);
	public List<GradProjectFile> getSheetsByEtat(String etat);
	public List<GradProjectFile> getSheetsByYear(String year);
	public List<GradProjectFile> getSheetsByPays(String pays);
	public List<GradProjectFile> getSheetsOfYear();
	public List<GradProjectFile> getWaitingDefense();
}
