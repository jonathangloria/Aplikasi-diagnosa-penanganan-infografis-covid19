/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covid.ejb;

import javax.ejb.Stateful;

/**
 *
 * @author se7en
 */
@Stateful
public class CovidBean implements CovidBeanLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private int corona, influenza, flu, diare, demam, lainnya;
    
    @Override
    public void addCorona(String diagnosa){
        if ("corona".equals(diagnosa)){
            corona++;
        }
        else if ("influenza".equals(diagnosa)){
            influenza++;
        }
        else if ("flu".equals(diagnosa)){
            flu++;
        }
        else if ("diare".equals(diagnosa)){
            diare++;
        }
        else if ("demam".equals(diagnosa)){
            demam++;
        }
        else if ("lainnya".equals(diagnosa)){
            lainnya++;
        }
        else{
            
        }
    }
    @Override
    public void addCovid(){
        corona++;
    }
    @Override
    public void addInfluenza(){
        influenza++;
    }
    @Override
    public void addFlu(){
        flu++;
    }
    @Override
    public void addDemam(){
        demam++;
    }
    @Override
    public void addDiare(){
        diare++;
    }
    @Override
    public void addLainnya(){
        lainnya++;
    }
    @Override
    public int getInfluenza(){
        return influenza;
    }
    @Override
    public int getCorona(){
        return corona;
    }
    @Override
    public int getFlu(){
        return flu;
    }
    @Override
    public int getDemam(){
        return demam;
    }
    @Override
    public int getDiare(){
        return diare;
    }
    @Override
    public int getLainnya(){
        return lainnya;
    }
    
    public void reset(){
        corona = 0;
        influenza = 0;
        flu = 0;
        diare = 0;
        demam = 0;
        lainnya =0;
    }
}
