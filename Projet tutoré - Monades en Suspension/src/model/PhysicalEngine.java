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
	
	/**Unique instance of the PhysicalInstance, following the pattern Singleton*/
	private final static PhysicalEngine INSTANCE = new PhysicalEngine();
	
	/**List of the monades on the scene */
	private static List<Monade> listMonades;
	
	/**Empty builder*/
	private PhysicalEngine(){ };
	
	public static PhysicalEngine getPhysicalEngine()
	{
		return INSTANCE;
	}
	
	public static List<Monade> getListMonades()
	{
		return listMonades;
	}
	
	/**creates a new monade and inserts it in ListMonades*/
	public void createANewMonade()
	{
		Monade monade = new Monade();
		getListMonades().add(monade);
	}
	
	/**creates an animation considering parameters
	 * @param param the different parameters defined by the user
	 * */
	public void createAnimation(Parameters param){
		
	}

}
