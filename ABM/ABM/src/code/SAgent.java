package code;

import java.awt.*;
import java.util.Random;

import ec.util.MersenneTwisterFast;
import sim.portrayal.*;
import sim.util.*;
import sim.engine.*;

public class SAgent implements Steppable,Cloneable
{
    private static final long serialVersionUID = 1;
    public int minV;
    public int timer=2;
    int cont=1;
    int cur_pos;
    public int id;
    int modid;
    Moderator m1;
    Moderator2 m2;
    double oldvalue=0;;
    int indicator=1;
    int counnn=0;
    int mybid;
    int iffirst=0;
    double factor;
    
    public SAgent(int id1,int mid,Moderator m11,Moderator2 m22,int nb,double ff){
    	this.factor=ff;
    	modid=mid;
    	m1=m11;
    	m2=m22;
    	this.indicator=nb;
    	//System.out.println("SAgent "+id1+" factor: "+factor);
    	if(modid==1)
    		oldvalue=m1.giveavg();
    	else if(modid==2)
    		oldvalue=m2.giveavg();
    	Random rand=new Random();
    	int temp=rand.nextInt(1000)+(int)oldvalue;
    	MersenneTwisterFast mf=new MersenneTwisterFast(temp);
        this.minV=mf.nextInt(2000);
       this.id=id1;
    	 this.minV=(int)(factor*1000);
         this.mybid=minV;
        
    	m1.setsr(id,minV,this,counnn);
    	m2.setsr(id,minV,this,counnn);
        
     }
    
    public Object clone() throws CloneNotSupportedException{
    	SAgent  t = (SAgent)super.clone();
    	return t;
    }

    public void step( final SimState state ){
    	if(timer<2*Gen.number&&timer%2==0&&cont==1){
    		
            Environment environment = (Environment)state;
            if(modid==1)
            	oldvalue=m1.giveavg();
            else if(modid==2)
            	oldvalue=m2.giveavg();
            Random rand=new Random();
            if(iffirst>0){
            	double tt=(double)this.mybid;
            	tt=tt*factor/100;
            	this.mybid=(int)(oldvalue+tt);
            	this.minV=mybid;
            }
            iffirst=1;
            if(modid==1)
            	m1.setsr(id,minV,this,counnn);
            else if(modid==2)
            	m2.setsr(id,minV,this,counnn);
            counnn=1;
            }
            
                timer++;
               // Gen.gtimer++;
    }
    
}
