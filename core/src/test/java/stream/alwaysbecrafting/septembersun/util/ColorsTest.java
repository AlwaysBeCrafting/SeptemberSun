package stream.alwaysbecrafting.septembersun.util;

import org.junit.Assert;
import org.junit.Test;

public class ColorsTest {

	private final int color = 0xff002b36;

	@Test public void R_WithColorCode_ReturnsRedValueAsDecimal() {
		Assert.assertEquals(( 0 / 255.0 ), Colors.r( color ), 0.001);
	}

	@Test public void G_WithColorCode_ReturnsGreenValueAsDecimal() {
		Assert.assertEquals(( 43 / 255.0 ), Colors.g( color ), 0.001);
	}

	@Test public void B_WithColorCode_ReturnsBlueValueAsDecimal() {
		Assert.assertEquals(( 54 / 255.0 ), Colors.b( color ), 0.001);
	}

	@Test public void A_WithColorCode_ReturnsAlphaValueAsDecimal() {
		Assert.assertEquals(( 255 / 255.0 ), Colors.a( color ), 0.001);
	}
}