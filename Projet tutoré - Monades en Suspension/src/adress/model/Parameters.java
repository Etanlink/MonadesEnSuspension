/**
 * @aim Define different parameters to create the animation with the Physical Engine
 * 
 * @date 23/01/2015
 * @author HugoPopo, Etanlink
 * @version 0.0
 *
 **/

package adress.model;

public class Parameters {
	
	public int nbMinMonades;
	public int nbMaxMonades;
	public float percentOfMonades;
	//public float speedCoefficient;
	//public float animationScale;

	/**
	 * Constructor of the Parameters class
	 * @param nbMinMonades
	 * @param nbMaxMonades
	 * @param percentOfMonades
	 * @param speedCoefficient
	 * @param animationScale
	 */
	public Parameters(int nbMinMonades, int nbMaxMonades,
			float percentOfMonades/*, float speedCoefficient, float animationScale*/) {
		super();
		this.nbMinMonades = nbMinMonades;
		this.nbMaxMonades = nbMaxMonades;
		this.percentOfMonades = percentOfMonades;
		//this.speedCoefficient = speedCoefficient;
		//this.animationScale = animationScale;
	}

}
