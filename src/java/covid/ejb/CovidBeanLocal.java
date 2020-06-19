/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covid.ejb;

import javax.ejb.Local;

/**
 *
 * @author se7en
 */
@Local
public interface CovidBeanLocal {

    public void addCorona(String diagnosa);

    public int getInfluenza();

    public int getCorona();

    public int getFlu();

    public int getDemam();

    public int getDiare();

    public int getLainnya();

    public void addCovid();

    public void addInfluenza();

    public void addFlu();

    public void addDemam();

    public void addDiare();

    public void addLainnya();
    
}
