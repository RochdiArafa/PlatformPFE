package tn.esprit.Services;

import javax.ejb.Remote;

import tn.pfe.entity.Admin;

@Remote
public interface AdminServicesRemote {
	void payerLicence(int ida);
	  Admin getadminQuiAPaye(int ida);
}
