package com.valyrian.core.main;

public class MainClass extends JavaPlugin {
  
  private static MainClass m;
  
  public void onEnable() {
    m = this;
  }
  
  public void onDisable() {
    m = null;
  }
  
  public MainClass get() {
    return m;
  }
  
}
