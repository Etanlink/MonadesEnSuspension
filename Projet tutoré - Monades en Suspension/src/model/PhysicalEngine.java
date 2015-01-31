/**
 * @aim Create an animation with different parameters
 * 
 * @date 23/01/2015
 * @author HugoPopo, Etanlink
 * @version 0.0
 *
 **/

package model;
import java.util.List;
public class PhysicalEngine {
	
	private final static PhysicalEngine INSTANCE = new PhysicalEngine();
	
	/* TODO : Add a list of Monades objects */
	private static List<Monade> listMonades;
	
	private PhysicalEngine(){ };
	
	public static PhysicalEngine getPhysicalEngine()
	{
		return INSTANCE;
	}
	
	public static List<Monade> getListMonades()
	{
		return listMonades;
	}
	
	public void createANewMonade()
	{
		Monade monade = new Monade();
		getListMonades().add(monade);
	}
	
	/* TODO : method to create an animation with parameters */
	public void createAnimation(Parameters param){
		
	}

}
