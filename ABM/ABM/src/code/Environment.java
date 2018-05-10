package code;

import java.awt.*;
import java.util.Random;

import sim.engine.*;
import sim.field.continuous.*;
import sim.util.*;

public class Environment extends SimState
    {

    public int round=10;
    public int pn=6;
    public int sn=4;

    private static final long serialVersionUID = 1;

    public Environment(long seed)
        {
        super(seed);
        }
        
    public void kill()
    {
    	
    }
    public void start() 
    {
    	int count=0;;
    	double minValue=40;
    	double maxValue=300;
    	int ns=3;
    	int ps=3;
    	Moderator m1=new Moderator(1,ns,ps);
    	Moderator2 m2=new Moderator2(2,ns,ps);
        
    	
        super.start();  // clear out the schedule
        minValue=2; 
        double factor=getfactor();
		PAgent pa1=new PAgent(0,1,m1,m2,1,factor);
		PAgent px1=null;
		try {
			px1 = (PAgent)pa1.clone();
			px1.modid=2;
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		schedule.scheduleRepeating(pa1);
        schedule.scheduleRepeating(px1);
        factor=getfactor(); 
        PAgent pa2=new PAgent(1,1,m1,m2,2,factor);
        PAgent px2=null;
		try {
			px2 = (PAgent)pa2.clone();
			px2.modid=2;
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		schedule.scheduleRepeating(pa2);
        schedule.scheduleRepeating(px2);
        factor=getfactor();
        PAgent pa3=new PAgent(2,1,m1,m2,3,factor);
        PAgent px3=null;
		try {
			px3 = (PAgent)pa3.clone();
			px3.modid=2;
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    schedule.scheduleRepeating(pa3);
        schedule.scheduleRepeating(px3);
        factor=getsfactor();
        SAgent sa1=new SAgent(0,1,m1,m2,1,factor);
        SAgent sx1=null;
		try {
			sx1 = (SAgent)sa1.clone();
			sx1.modid=2;
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		schedule.scheduleRepeating(sa1);
        schedule.scheduleRepeating(sx1);
        factor=getsfactor();
        SAgent sa2=new SAgent(1,1,m1,m2,2,factor);
        SAgent sx2=null;
		try {
			sx2 = (SAgent)sa2.clone();
			sx2.modid=2;
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		schedule.scheduleRepeating(sa2);
        schedule.scheduleRepeating(sx2);
        factor=getsfactor();
        SAgent sa3=new SAgent(2,1,m1,m2,3,factor);
        SAgent sx3=null;
		try {
			sx3 = (SAgent)sa3.clone();
			sx3.modid=2;
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//sx3.modid=2;
        schedule.scheduleRepeating(sa3);
        schedule.scheduleRepeating(sx3);
        
        schedule.scheduleRepeating(m1);
        schedule.scheduleRepeating(m2);
        
        }
    
     public static double getfactor(){
    	Random random=new Random();
     	double rand=random.nextGaussian();
        if(rand<0)
        	rand*=-1;
        double a1=random.nextGaussian();
        if(a1<0)
        	a1*=-1;
        double fact1=rand*a1;
        rand=random.nextGaussian();
        if(rand<0)
        	rand*=-1;
        double a2=random.nextGaussian();
        if(a2<0)
        	a2*=-1;
        double fact2=rand*a2;
         
        rand=random.nextGaussian();
        if(rand<0)
        	rand*=-1;
        double a3=random.nextGaussian();
        if(a3<0)
        	a3*=-1;
        double fact3=rand*a3;

        rand=random.nextGaussian();
        if(rand<0)
        	rand*=-1;
        double a4=random.nextGaussian();
        if(a4<0)
        	a4*=-1;
        double fact4=rand*a4;
        return  fact1+fact2+fact3+fact4;
    	
    } 
     public static double getsfactor(){
    	Random random=new Random();
     	double rand=random.nextGaussian();
        if(rand<0)
        	rand*=-1;
        double a1=random.nextGaussian();
        if(a1<0)
        	a1*=-1;
        	
        double fact1=rand*a1;
        rand=random.nextGaussian();
        if(rand<0)
        	rand*=-1;
        double a2=random.nextGaussian();
        if(a2<0)
        	a2*=-1;
        double fact2=rand*a2;
         
        rand=random.nextGaussian();
        if(rand<0)
        	rand*=-1;
        double a3=random.nextGaussian();
        if(a3<0)
        	a3*=-1;
        double fact3=rand*a3;

        rand=random.nextGaussian();
        if(rand<0)
        	rand*=-1;
        double a4=random.nextGaussian();
        if(a4<0)
        	a4*=-1;
        double fact4=rand*a4;
    ////    System.out.println(a1*fact1);
        return  fact1+fact2+fact3+fact4;
        
    }    
    public static void emain(String[] args)
        {
        doLoop(Environment.class, args);
  
        System.exit(0);
        }    

    
    }
