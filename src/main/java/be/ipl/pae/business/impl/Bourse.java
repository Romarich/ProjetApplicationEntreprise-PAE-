package be.ipl.pae.business.impl;

public enum Bourse {
  ZERO("0"),
  SEPTANTE("70"),
  CENT("100"),
  REMBOURSER("Rembourse");

  private String label;

  Bourse(String label) {
    this.label = label;
  }

  public String getLabel() {
    return label;
  }
}
