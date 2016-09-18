package stream.alwaysbecrafting.septembersun.util;

//==============================================================================
public abstract class Log {
	//--------------------------------------------------------------------------

	public static void d( String message ) {
		System.out.println(
				String.format(
						"%1$tT.%1$tL\t| %2$s", // hh:mm:ss.ms
						System.currentTimeMillis(),
						message ));
	}

	//--------------------------------------------------------------------------
}
//------------------------------------------------------------------------------
