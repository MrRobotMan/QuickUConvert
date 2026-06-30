package com.sodamoney.quickuconvert

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class DerivedUnitsUnitTests {

    @Test
    fun lengthConversion_isCorrect() {
        val expected = 10.0
        val actual = Millimeter.convertTo(100.0, Centimeter)
        assertEquals(expected, actual, 1E-6)
    }

    @Test
    fun lengthConvertBetweenSystems() {
        val expected = 38.1
        val actual = Inch.convertTo(1.5, Millimeter)
        assertEquals(expected, actual,1E-6)
    }

    @Test
    fun convertBetweenUnitTypes_isBad() {
        assertThrows(
            "Can't convert from LENGTH to FORCE. Base units are mismatched m and N",
            IllegalConversionException::class.java,
            { Meter.convertTo(10.0, Newton) })
    }

    @Test
    fun convertBetweenBaseUnitAndTemperature_isBad() {
        assertThrows(
            "Can't convert from LENGTH to FORCE. Base units are mismatched m and N",
            IllegalConversionException::class.java,
            { Kelvin.convertTo(10.0, Kilogram) })
        assertThrows(
            "Can't convert from LENGTH to FORCE. Base units are mismatched m and N",
            IllegalConversionException::class.java,
            { Kilogram.convertTo(10.0, Kelvin) })
    }

    @Test
    fun temperatureConversion_isCorrect() {
        val expected = 104.0
        val kelvin = 313.15
        assertEquals(kelvin, Centigrade.standardize(40.0) ,1E-6)
        assertEquals(kelvin, Fahrenheit.standardize(104.0), 1E-6)
        val actual = Centigrade.convertTo(40.0, Fahrenheit)
        assertEquals(expected, actual, 1E-6)
    }

    @Test
    fun convertToLightYears() {
        val expected = SPEED_OF_LIGHT.toDouble() * 60.0 * 60.0 * 24.0 * 365.25
        val actual = LightYear.convertTo(1.0, Meter)
        assertEquals(expected, actual, 10.0)
    }

    @Test
    fun testInchPerSecondSquared() {
        val expected = 0.0254
        val actual = InchPerSecondSquared.convertTo(1.0, MeterPerSecondSquared)
        assertEquals(expected, actual, 1e-6)
    }

    @Test
    fun testFootPerSecondSquared() {
        val expected = 0.3048
        val actual = FootPerSecondSquared.convertTo(1.0, MeterPerSecondSquared)
        assertEquals(expected, actual, 1e-6)
    }

    @Test
    fun testCentimeterPerSecondSquared() {
        val expected = 0.01
        val actual = CentimeterPerSecondSquared.convertTo(1.0, MeterPerSecondSquared)
        assertEquals(expected, actual, 1e-6)
    }

    @Test
    fun testMillimeterPerSecondSquared() {
        val expected = 0.001
        val actual = MillimeterPerSecondSquared.convertTo(1.0, MeterPerSecondSquared)
        assertEquals(expected, actual, 1e-6)
    }

    @Test
    fun testEarthGravity() {
        val expected = EARTH_GRAVITY
        val actual = EarthGravity.convertTo(1.0, MeterPerSecondSquared)
        assertEquals(expected, actual, 1e-6)
    }

    @Test
    fun testKilonewton() {
        val expected = 1000.0
        val actual = Kilonewton.convertTo(1.0, Newton)
        assertEquals(expected, actual, 1e-6)
    }

    @Test
    fun testKilogramForce() {
        val expected = EARTH_GRAVITY
        val actual = KilogramForce.convertTo(1.0, Newton)
        assertEquals(expected, actual, 1e-6)
    }

    @Test
    fun testDyne() {
        val expected = 1E-5
        val actual = Dyne.convertTo(1.0, Newton)
        assertEquals(expected, actual, 1e-6)
    }

    @Test
    fun testPoundForce() {
        val expected = 4.44822
        val actual = PoundForce.convertTo(1.0, Newton)
        assertEquals(expected, actual, 1e-4)
    }

    @Test
    fun testKips() {
        val expected = 4448.22
        val actual = Kips.convertTo(1.0, Newton)
        assertEquals(expected, actual, 1.0)
    }

    @Test
    fun testPoundal() {
        val expected = 0.13825
        val actual = Poundal.convertTo(1.0, Newton)
        assertEquals(expected, actual, 1e-6)
    }

    @Test
    fun testKilometer() {
        val expected = 1000.0
        val actual = Kilometer.convertTo(1.0, Meter)
        assertEquals(expected, actual, 1e-6)
    }

    @Test
    fun testCentimeter() {
        val expected = 0.01
        val actual = Centimeter.convertTo(1.0, Meter)
        assertEquals(expected, actual, 1e-6)
    }

    @Test
    fun testMillimeter() {
        val expected = 0.001
        val actual = Millimeter.convertTo(1.0, Meter)
        assertEquals(expected, actual, 1e-6)
    }

    @Test
    fun testMicrometer() {
        val expected = 1e-6
        val actual = Micrometer.convertTo(1.0, Meter)
        assertEquals(expected, actual, 1e-6)
    }

    @Test
    fun testNanometer() {
        val expected = 1e-9
        val actual = Nanometer.convertTo(1.0, Meter)
        assertEquals(expected, actual, 1e-12)
    }

    @Test
    fun testInch() {
        val expected = 0.0254
        val actual = Inch.convertTo(1.0, Meter)
        assertEquals(expected, actual, 1e-6)
    }

    @Test
    fun testFoot() {
        val expected = 0.3048
        val actual = Foot.convertTo(1.0, Meter)
        assertEquals(expected, actual, 1e-6)
    }

    @Test
    fun testYard() {
        val expected = 0.9144
        val actual = Yard.convertTo(1.0, Meter)
        assertEquals(expected, actual, 1e-6)
    }

    @Test
    fun testMile() {
        val expected = 1609.344
        val actual = Mile.convertTo(1.0, Meter)
        assertEquals(expected, actual, 1e-6)
    }

    @Test
    fun testThou() {
        val expected = 0.0000254
        val actual = Thou.convertTo(1.0, Meter)
        assertEquals(expected, actual, 1e-8)
    }

    @Test
    fun testNauticalMile() {
        val expected = 1852.0
        val actual = NauticalMile.convertTo(1.0, Meter)
        assertEquals(expected, actual, 1e-6)
    }

    @Test
    fun testFathom() {
        val expected = 1.8288
        val actual = Fathom.convertTo(1.0, Meter)
        assertEquals(expected, actual, 1e-6)
    }

    @Test
    fun testRod() {
        val expected = 5.0292
        val actual = Rod.convertTo(1.0, Meter)
        assertEquals(expected, actual, 1e-6)
    }

    @Test
    fun testChain() {
        val expected = 20.1168
        val actual = Chain.convertTo(1.0, Meter)
        assertEquals(expected, actual, 1e-6)
    }

    @Test
    fun testFurlong() {
        val expected = 201.168
        val actual = Furlong.convertTo(1.0, Meter)
        assertEquals(expected, actual, 1e-6)
    }

    @Test
    fun testAngstrom() {
        val expected = 1E-10
        val actual = Angstrom.convertTo(1.0, Meter)
        assertEquals(expected, actual, 1e-6)
    }

    @Test
    fun testLightYear() {
        val expected = SPEED_OF_LIGHT.toDouble() * 60.0 * 60.0 * 24.0 * 365.25
        val actual = LightYear.convertTo(1.0, Meter)
        assertEquals(expected, actual, 10.0)
    }

    @Test
    fun testCentigrade() {
        val expected = 274.15
        val actual = Centigrade.convertTo(1.0, Kelvin)
        assertEquals(expected, actual, 1e-6)
    }

    @Test
    fun testFahrenheit() {
        val expected = 255.9278
        val actual = Fahrenheit.convertTo(1.0, Kelvin)
        assertEquals(expected, actual, 1e-6)
    }

    @Test
    fun testRankine() {
        val expected = 1.0 / 1.8
        val actual = Rankine.convertTo(1.0, Kelvin)
        assertEquals(expected, actual, 1e-6)
    }

    @Test
    fun testMillisecond() {
        val expected = 0.001
        val actual = Millisecond.convertTo(1.0, Second)
        assertEquals(expected, actual, 1e-6)
    }

    @Test
    fun testMicrosecond() {
        val expected = 1E-6
        val actual = Microsecond.convertTo(1.0, Second)
        assertEquals(expected, actual, 1e-6)
    }

    @Test
    fun testNanosecond() {
        val expected = 1E-9
        val actual = Nanosecond.convertTo(1.0, Second)
        assertEquals(expected, actual, 1e-6)
    }

    @Test
    fun testMinute() {
        val expected = 60.0
        val actual = Minute.convertTo(1.0, Second)
        assertEquals(expected, actual, 1e-6)
    }

    @Test
    fun testHour() {
        val expected = 3600.0
        val actual = Hour.convertTo(1.0, Second)
        assertEquals(expected, actual, 1e-6)
    }

    @Test
    fun testDay() {
        val expected = 86400.0
        val actual = Day.convertTo(1.0, Second)
        assertEquals(expected, actual, 1e-6)
    }

    @Test
    fun testYear() {
        val expected = 31_557_600.0
        val actual = Year.convertTo(1.0, Second)
        assertEquals(expected, actual, 1e-6)
    }

    @Test
    fun testWeek() {
        val expected = 604_800.0
        val actual = Week.convertTo(1.0, Second)
        assertEquals(expected, actual, 1e-6)
    }

    @Test
    fun testMonth() {
        val expected = 2_629_800.0
        val actual = Month.convertTo(1.0, Second)
        assertEquals(expected, actual, 1e-6)
    }

    @Test
    fun testDecade() {
        val expected = 315_576_000.0
        val actual = Decade.convertTo(1.0, Second)
        assertEquals(expected, actual, 1e-6)
    }

    @Test
    fun testCentury() {
        val expected = 3_155_760_000.0
        val actual = Century.convertTo(1.0, Second)
        assertEquals(expected, actual, 1e-6)
    }
}
