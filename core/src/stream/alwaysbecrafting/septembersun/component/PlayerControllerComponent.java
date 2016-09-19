package stream.alwaysbecrafting.septembersun.component;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.Input;

//==============================================================================
public class PlayerControllerComponent implements Component {
	//--------------------------------------------------------------------------

	public int btn_a = Input.Keys.Z;
	public int btn_b = Input.Keys.X;

	public int btn_up    = Input.Keys.UP;
	public int btn_down  = Input.Keys.DOWN;
	public int btn_left  = Input.Keys.LEFT;
	public int btn_right = Input.Keys.RIGHT;

	public int btn_start  = Input.Keys.ESCAPE;
	public int btn_select = Input.Keys.TAB;

	//--------------------------------------------------------------------------
}
//------------------------------------------------------------------------------
