/**
 * 
 */
package devtests;

/**
 * @author jackpark
 *
 */
public class BootTest extends TestBase {

	/**
	 * 
	 */
	public BootTest() {
		System.out.println("A "+environment.getProperties());
		
		environment.shutDown();
		System.exit(0);
	}

}
