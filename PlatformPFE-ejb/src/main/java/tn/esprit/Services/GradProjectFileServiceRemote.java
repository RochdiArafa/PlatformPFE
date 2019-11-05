package tn.esprit.Services;

import java.util.List;

import javax.ejb.Remote;

import tn.pfe.entity.GradProjectFile;

@Remote
public interface GradProjectFileServiceRemote {
	public void addPfe(GradProjectFile pfe);
	public List<GradProjectFile> GetPfe();
	public void deletepfe(int id);
	public void updatepfe(GradProjectFile pfe,int id);
	public List<GradProjectFile>GetPfeValidated();
}
