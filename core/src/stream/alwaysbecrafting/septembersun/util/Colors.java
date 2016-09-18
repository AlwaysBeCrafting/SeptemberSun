package stream.alwaysbecrafting.septembersun.util;

//==============================================================================
public abstract class Colors {
	//--------------------------------------------------------------------------

	// Colors are as 0xAA_RR_GG_BB
	// AA = Alpha
	// RR = Red
	// GG = Green
	// BB = Blue

	//--------------------------------------------------------------------------

	public static float r( int color ) {
		return (( color & 0x00_ff_00_00 ) >> 16 ) / 255f;
	}

	//--------------------------------------------------------------------------

	public static float g( int color ) {
		return (( color & 0x00_00_ff_00 ) >> 8 ) / 255f;
	}

	//--------------------------------------------------------------------------

	public static float b( int color ) {
		return (( color & 0x00_00_00_ff )) / 255f;
	}

	//--------------------------------------------------------------------------

	public static float a( int color ) {
		return (( color & 0xff_00_00_00 ) >> 24 ) / 255f;
	}

	//--------------------------------------------------------------------------

	//==========================================================================
	public static abstract class Solarized {
		//----------------------------------------------------------------------

		public static final int BASE03  = 0xff002b36;
		public static final int BASE02  = 0xff073642;
		public static final int BASE01  = 0xff586e75;
		public static final int BASE00  = 0xff657b83;
		public static final int BASE0   = 0xff839496;
		public static final int BASE1   = 0xff93a1a1;
		public static final int BASE2   = 0xffeee8d5;
		public static final int BASE3   = 0xfffdf6e3;
		public static final int YELLOW  = 0xffb58900;
		public static final int ORANGE  = 0xffcb4b16;
		public static final int RED     = 0xffdc322f;
		public static final int MAGENTA = 0xffd33682;
		public static final int VIOLET  = 0xff6c71c4;
		public static final int BLUE    = 0xff268bd2;
		public static final int CYAN    = 0xff2aa198;
		public static final int GREEN   = 0xff859900;

		//----------------------------------------------------------------------
	}
	//--------------------------------------------------------------------------
}
//------------------------------------------------------------------------------
