/**
 * @aim Create an animation with different parameters
 * 
 * @date 23/01/2015
 * @author HugoPopo, Etanlink
 * @version 0.0
 *
 **/

package model;
import java.util.ArrayList;
public class AnimationMonades {
	
	/**Unique instance of the PhysicalInstance, following the pattern Singleton*/
	private final static AnimationMonades INSTANCE = new AnimationMonades();
	
	/**List of the monades on the scene */
	private static ArrayList<Monade> listMonades;
	
	/**Empty builder*/
	private AnimationMonades(){ };
	
	public static AnimationMonades getPhysicalEngine()
	{
		return INSTANCE;
	}
	
	public static ArrayList<Monade> getListMonades()
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
		while(listMonades.size()<=3)
		{
			createANewMonade();
		}
		if(listMonades.size()<10)
		{
			createANewMonade();
		}
		updateListMonades();
		
			
		
	}

	/**updates listMonades calculating each monade's nextPosition*/
	private void updateListMonades() {
		// TODO Auto-generated method stub
		for(Monade m : listMonades)
		{
			m.calculateNextPosition();
		}
	}

}
