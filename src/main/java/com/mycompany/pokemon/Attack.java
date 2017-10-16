/*
STORY
 */
package com.mycompany.pokemon;

/**
 *
 * @author marconte
 */
public class Attack {
   public String name;
   public int pv;
   
   public Attack(String name, int pv) {
       this.name = name;
       this.pv= pv;
   }
    public int toAttack(int pvEnnemy){
     return pvEnnemy -= this.pv;
}    
    public String getName(){
        return this.name;
    }
    
    public int getPv(){
        return this.pv;
    }
}
