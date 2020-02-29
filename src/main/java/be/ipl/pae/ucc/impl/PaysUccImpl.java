package be.ipl.pae.ucc.impl;

import be.ipl.pae.business.impl.Pays;
import be.ipl.pae.persistance.interfaces.DalService;
import be.ipl.pae.persistance.interfaces.PaysDao;
import be.ipl.pae.ucc.interfaces.PaysUcc;

import java.util.List;

public class PaysUccImpl implements PaysUcc {

  private PaysDao paysDao;
  private DalService dalService;

  public PaysUccImpl(PaysDao paysDao, DalService dalService) {
    this.paysDao = paysDao;
    this.dalService = dalService;
  }

  @Override
  public List<Pays> listTousPays() {
    List<Pays> paysList;
    try {
      this.dalService.demarrerTransaction();
      paysList = paysDao.getTousPays();
    } catch (Exception exc) {
      this.dalService.annulerTransaction();
      throw exc;
    } finally {
      this.dalService.soumettreTransaction();
    }
    return paysList;
  }
}
