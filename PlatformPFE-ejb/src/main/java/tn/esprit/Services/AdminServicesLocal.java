package tn.esprit.Services;

import javax.ejb.Local;

import tn.pfe.entity.Admin;

@Local
public interface AdminServicesLocal {
   void payerLicence(int ida);
   Admin getadminQuiAPaye(int ida);
}
