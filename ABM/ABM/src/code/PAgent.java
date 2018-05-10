package code;

import java.awt.*;
import java.util.Random;

import ec.util.MersenneTwisterFast;
import sim.portrayal.*;
import sim.util.*;
import sim.engine.*;

public class PAgent implements Steppable,Cloneable
{	
	int modid;
    private static final long serialVersionUID = 1;
    public int minV;
    public  int timer=2;
    int cont=1;
    int id;
    int cur_pos;
    double oldvalue=0;
    Moderator m1;
    Moderator2 m2;
    int pp;
    int indicator;
    int counn=0;
    int mybid;
    int numBlocks;
    int counter=0;
    public PAgent(int id1,int mid,Moderator m11,Moderator2 m22,int nb,double factor){
    	modid=mid;
    	m1=m11;
    	m2=m22;
    	this.id=id1;
    	this.indicator=nb;
   // 	System.out.println("PAgent "+id1+" factor: "+factor);
    	Random rand=new Random();
    	int temp=rand.nextInt(1000);
    	if(modid==1)
    		oldvalue=m1.giveavg();
    	else if(modid==2)
    		oldvalue=m2.giveavg();
        this.minV=(int)(factor*1000);
        this.mybid=minV;
       // System.out.println("In pAgent constr"+this.mybid);
    }
    public Object clone() throws CloneNotSupportedException{
    	PAgent  t = (PAgent)super.clone();
    	return t;
    }
    
    public void step( final SimState state ){   
        if(timer%2==0&&cont==1){
            Environment environment = (Environment)state;
            if(counter==0){
            	if(modid==1)
            		m1.setpr(id,minV,this,counn++);
            	else if(modid==2)
            		m2.setpr(id,minV,this,counn++);
            }
            counter=1;
            if(timer<Gen.number);
            //System.out.println("PAgent "+id+"  timer: "+timer);
            }
        else if(timer%2==0&&timer<Gen.number)
        	System.out.println("I'm OUT");
        timer++;
        //Gen.gtimer++;
    }
}
