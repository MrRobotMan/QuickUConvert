package com.sodamoney.quickuconvert

import org.junit.Test

import org.junit.Assert.*

/**
 * Testing that derived units give the correct values.
 */
class DerivedUnitsUnitTests {

    @Test
    fun convertBetweenUnitTypes_isBad() {
        assertThrows(
            "Can't convert from LENGTH to FORCE. Base units are mismatched m and N",
            IllegalConversionException::class.java,
        ) { Meter.convertTo(10.0, Newton) }
    }

    @Test
    fun convertBetweenBaseUnitAndTemperature_isBad() {
        assertThrows(
            "Can't convert from LENGTH to FORCE. Base units are mismatched m and N",
            IllegalConversionException::class.java,
        ) { Kelvin.convertTo(10.0, Kilogram) }
        assertThrows(
            "Can't convert from LENGTH to FORCE. Base units are mismatched m and N",
            IllegalConversionException::class.java,
        ) { Kilogram.convertTo(10.0, Kelvin) }
    }

}

class AccelerationTests {

    @Test
    fun testInchPerSecondSquared() {
        val expected = 0.0254
        val actual = InchPerSecondSquared.convertTo(1.0, MeterPerSecondSquared)
        assertEquals(expected, actual, 1E-6)
    }

    @Test
    fun testFootPerSecondSquared() {
        val expected = 0.3048
        val actual = FootPerSecondSquared.convertTo(1.0, MeterPerSecondSquared)
        assertEquals(expected, actual, 1E-6)
    }

    @Test
    fun testCentimeterPerSecondSquared() {
        val expected = 0.01
        val actual = CentimeterPerSecondSquared.convertTo(1.0, MeterPerSecondSquared)
        assertEquals(expected, actual, 1E-6)
    }

    @Test
    fun testMillimeterPerSecondSquared() {
        val expected = 0.001
        val actual = MillimeterPerSecondSquared.convertTo(1.0, MeterPerSecondSquared)
        assertEquals(expected, actual, 1E-6)
    }

    @Test
    fun testEarthGravity() {
        val expected = EARTH_GRAVITY
        val actual = EarthGravity.convertTo(1.0, MeterPerSecondSquared)
        assertEquals(expected, actual, 1E-6)
    }
}

class ForceTests {
    @Test
    fun testKilonewton() {
        val expected = 1000.0
        val actual = Kilonewton.convertTo(1.0, Newton)
        assertEquals(expected, actual, 1E-6)
    }

    @Test
    fun testKilogramForce() {
        val expected = EARTH_GRAVITY
        val actual = KilogramForce.convertTo(1.0, Newton)
        assertEquals(expected, actual, 1E-6)
    }

    @Test
    fun testDyne() {
        val expected = 1E-5
        val actual = Dyne.convertTo(1.0, Newton)
        assertEquals(expected, actual, 1E-6)
    }

    @Test
    fun testPoundForce() {
        val expected = 4.44822
        val actual = PoundForce.convertTo(1.0, Newton)
        assertEquals(expected, actual, 1E-4)
    }

    @Test
    fun testKips() {
        val expected = 4448.22
        val actual = Kips.convertTo(1.0, Newton)
        assertEquals(expected, actual, 1.0)
    }

    @Test
    fun testPoundal() {
        val expected = 0.138_254_954_376
        val actual = Poundal.convertTo(1.0, Newton)
        assertEquals(expected, actual, 1E-6)
    }

}

class LengthTests {
    @Test
    fun testKilometer() {
        val expected = 1000.0
        val actual = Kilometer.convertTo(1.0, Meter)
        assertEquals(expected, actual, 1E-6)
    }

    @Test
    fun testCentimeter() {
        val expected = 0.01
        val actual = Centimeter.convertTo(1.0, Meter)
        assertEquals(expected, actual, 1E-6)
    }

    @Test
    fun testMillimeter() {
        val expected = 0.001
        val actual = Millimeter.convertTo(1.0, Meter)
        assertEquals(expected, actual, 1E-6)
    }

    @Test
    fun testMicrometer() {
        val expected = 1E-6
        val actual = Micrometer.convertTo(1.0, Meter)
        assertEquals(expected, actual, 1E-6)
    }

    @Test
    fun testNanometer() {
        val expected = 1E-9
        val actual = Nanometer.convertTo(1.0, Meter)
        assertEquals(expected, actual, 1E-12)
    }

    @Test
    fun testInch() {
        val expected = 0.0254
        val actual = Inch.convertTo(1.0, Meter)
        assertEquals(expected, actual, 1E-6)
    }

    @Test
    fun testFoot() {
        val expected = 0.3048
        val actual = Foot.convertTo(1.0, Meter)
        assertEquals(expected, actual, 1E-6)
    }

    @Test
    fun testYard() {
        val expected = 0.9144
        val actual = Yard.convertTo(1.0, Meter)
        assertEquals(expected, actual, 1E-6)
    }

    @Test
    fun testMile() {
        val expected = 1609.344
        val actual = Mile.convertTo(1.0, Meter)
        assertEquals(expected, actual, 1E-6)
    }

    @Test
    fun testThou() {
        val expected = 0.0000254
        val actual = Thou.convertTo(1.0, Meter)
        assertEquals(expected, actual, 1E-8)
    }

    @Test
    fun testNauticalMile() {
        val expected = 1852.0
        val actual = NauticalMile.convertTo(1.0, Meter)
        assertEquals(expected, actual, 1E-6)
    }

    @Test
    fun testFathom() {
        val expected = 1.8288
        val actual = Fathom.convertTo(1.0, Meter)
        assertEquals(expected, actual, 1E-6)
    }

    @Test
    fun testRod() {
        val expected = 5.0292
        val actual = Rod.convertTo(1.0, Meter)
        assertEquals(expected, actual, 1E-6)
    }

    @Test
    fun testChain() {
        val expected = 20.1168
        val actual = Chain.convertTo(1.0, Meter)
        assertEquals(expected, actual, 1E-6)
    }

    @Test
    fun testFurlong() {
        val expected = 201.168
        val actual = Furlong.convertTo(1.0, Meter)
        assertEquals(expected, actual, 1E-6)
    }

    @Test
    fun testAngstrom() {
        val expected = 1E-10
        val actual = Angstrom.convertTo(1.0, Meter)
        assertEquals(expected, actual, 1E-6)
    }

    @Test
    fun testLightYear() {
        val expected = SPEED_OF_LIGHT.toDouble() * 60.0 * 60.0 * 24.0 * 365.25
        val actual = LightYear.convertTo(1.0, Meter)
        assertEquals(expected, actual, 10.0)
    }

}

class TemperatureTests {
    @Test
    fun testFromCentigrade() {
        val expected = 274.15
        val actual = Centigrade.convertTo(1.0, Kelvin)
        assertEquals(expected, actual, 1E-6)
    }

    @Test
    fun testFromFahrenheit() {
        val expected = 255.9277777777
        val actual = Fahrenheit.convertTo(1.0, Kelvin)
        assertEquals(expected, actual, 1E-6)
    }

    @Test
    fun testFromRankine() {
        val expected = 1.0 / 1.8
        val actual = Rankine.convertTo(1.0, Kelvin)
        assertEquals(expected, actual, 1E-6)
    }

    @Test
    fun testToCentigrade() {
        val expected = -173.15
        val actual = Kelvin.convertTo(100.0, Centigrade)
        assertEquals(expected, actual, 1E-6)
    }

    @Test
    fun testToFahrenheit() {
        val expected = -279.67
        val actual = Kelvin.convertTo(100.0, Fahrenheit)
        assertEquals(expected, actual, 1E-6)
    }

    @Test
    fun testToRankine() {
        val expected = 180.0
        val actual = Kelvin.convertTo(100.0, Rankine)
        assertEquals(expected, actual, 1E-6)
    }

    @Test
    fun temperatureConversion() {
        val expected = 104.0
        val kelvin = 313.15
        assertEquals(kelvin, Centigrade.standardize(40.0), 1E-6)
        assertEquals(kelvin, Fahrenheit.standardize(104.0), 1E-6)
        val actual = Centigrade.convertTo(40.0, Fahrenheit)
        assertEquals(expected, actual, 1E-6)
    }
}

class TimeTests {
    @Test
    fun testMillisecond() {
        val expected = 0.001
        val actual = Millisecond.convertTo(1.0, Second)
        assertEquals(expected, actual, 1E-6)
    }

    @Test
    fun testMicrosecond() {
        val expected = 1E-6
        val actual = Microsecond.convertTo(1.0, Second)
        assertEquals(expected, actual, 1E-6)
    }

    @Test
    fun testNanosecond() {
        val expected = 1E-9
        val actual = Nanosecond.convertTo(1.0, Second)
        assertEquals(expected, actual, 1E-6)
    }

    @Test
    fun testMinute() {
        val expected = 60.0
        val actual = Minute.convertTo(1.0, Second)
        assertEquals(expected, actual, 1E-6)
    }

    @Test
    fun testHour() {
        val expected = 3600.0
        val actual = Hour.convertTo(1.0, Second)
        assertEquals(expected, actual, 1E-6)
    }

    @Test
    fun testDay() {
        val expected = 86400.0
        val actual = Day.convertTo(1.0, Second)
        assertEquals(expected, actual, 1E-6)
    }

    @Test
    fun testYear() {
        val expected = 31_557_600.0
        val actual = Year.convertTo(1.0, Second)
        assertEquals(expected, actual, 1E-6)
    }

    @Test
    fun testWeek() {
        val expected = 604_800.0
        val actual = Week.convertTo(1.0, Second)
        assertEquals(expected, actual, 1E-6)
    }

    @Test
    fun testMonth() {
        val expected = 2_629_800.0
        val actual = Month.convertTo(1.0, Second)
        assertEquals(expected, actual, 1E-6)
    }

    @Test
    fun testDecade() {
        val expected = 315_576_000.0
        val actual = Decade.convertTo(1.0, Second)
        assertEquals(expected, actual, 1E-6)
    }

    @Test
    fun testCentury() {
        val expected = 3_155_760_000.0
        val actual = Century.convertTo(1.0, Second)
        assertEquals(expected, actual, 1E-6)
    }

}

class AreaTests {

    @Test
    fun testSquareKilometer() {
        val expected = 1_000_000.0
        val actual = SquareKilometer.convertTo(1.0, SquareMeter)
        assertEquals(expected, actual, 1E-6)
    }

    @Test
    fun testSquareCentimeter() {
        val expected = 1E-4
        val actual = SquareCentimeter.convertTo(1.0, SquareMeter)
        assertEquals(expected, actual, 1E-6)
    }

    @Test
    fun testSquareMillimeter() {
        val expected = 1E-6
        val actual = SquareMillimeter.convertTo(1.0, SquareMeter)
        assertEquals(expected, actual, 1E-6)
    }

    @Test
    fun testSquareMile() {
        val expected = 2589988.110336
        val actual = SquareMile.convertTo(1.0, SquareMeter)
        assertEquals(expected, actual, 1E-6)
    }

    @Test
    fun testSquareYard() {
        val expected = 0.8361274
        val actual = SquareYard.convertTo(1.0, SquareMeter)
        assertEquals(expected, actual, 1E-6)
    }

    @Test
    fun testSquareFoot() {
        val expected = 0.092903
        val actual = SquareFoot.convertTo(1.0, SquareMeter)
        assertEquals(expected, actual, 1E-6)
    }

    @Test
    fun testSquareInch() {
        val expected = 0.0006452
        val actual = SquareInch.convertTo(1.0, SquareMeter)
        assertEquals(expected, actual, 1E-6)
    }

    @Test
    fun testHectare() {
        val expected = 10_000.0
        val actual = Hectare.convertTo(1.0, SquareMeter)
        assertEquals(expected, actual, 1E-6)
    }

    @Test
    fun testAcre() {
        val expected = 4046.8564224
        val actual = Acre.convertTo(1.0, SquareMeter)
        assertEquals(expected, actual, 1E-6)
    }
}

class VolumeTests() {

    @Test
    fun testLiter() {
        val expected = 1E-3
        val actual = Liter.convertTo(1.0, CubicMeter)
        assertEquals(expected, actual, 1E-6)
    } 
    
    @Test
    fun testDeciliter() {
        val expected = 1E-4
        val actual = Deciliter.convertTo(1.0, CubicMeter)
        assertEquals(expected, actual, 1E-6)
    } 
    
    @Test
    fun testCubicCentimeter() {
        val expected = 1E-6
        val actual = CubicCentimeter.convertTo(1.0, CubicMeter)
        assertEquals(expected, actual, 1E-7)
    } 
    
    @Test
    fun testCubicMillimeter() {
        val expected = 1E-9
        val actual = CubicMillimeter.convertTo(1.0, CubicMeter)
        assertEquals(expected, actual, 1E-10)
    } 
    
    @Test
    fun testCubicInch() {
        val expected = 0.0000163871
        val actual = CubicInch.convertTo(1.0, CubicMeter)
        assertEquals(expected, actual, 1E-10)
    } 
    
    @Test
    fun testCubicFoot() {
        val expected = 0.028316846
        val actual = CubicFoot.convertTo(1.0, CubicMeter)
        assertEquals(expected, actual, 1E-6)
    } 
    
    @Test
    fun testCubicYard() {
        val expected = 0.76455486
        val actual = CubicYard.convertTo(1.0, CubicMeter)
        assertEquals(expected, actual, 1E-6)
    } 
    
    @Test
    fun testAcreFoot() {
        val expected = 1233.4818375
        val actual = AcreFoot.convertTo(1.0, CubicMeter)
        assertEquals(expected, actual, 1E-6)
    } 
    
    @Test
    fun testGallon() {
        val expected = 0.0037854
        val actual = Gallon.convertTo(1.0, CubicMeter)
        assertEquals(expected, actual, 1E-6)
    } 
    
    @Test
    fun testWetBarrel() {
        val expected = 0.11924
        val actual = WetBarrel.convertTo(1.0, CubicMeter)
        assertEquals(expected, actual, 1E-6)
    } 
    
    @Test
    fun testWetQuart() {
        val expected = 0.00094635
        val actual = WetQuart.convertTo(1.0, CubicMeter)
        assertEquals(expected, actual, 1E-6)
    } 
    
    @Test
    fun testWetPint() {
        val expected = 0.00047318
        val actual = WetPint.convertTo(1.0, CubicMeter)
        assertEquals(expected, actual, 1E-6)
    } 
    
    @Test
    fun testCup() {
        val expected = 236.59E-6
        val actual = Cup.convertTo(1.0, CubicMeter)
        assertEquals(expected, actual, 1E-8)
    } 
    
    @Test
    fun testFluidOunce() {
        val expected = 29.574E-6
        val actual = FluidOunce.convertTo(1.0, CubicMeter)
        assertEquals(expected, actual, 1E-8)
    } 
    
    @Test
    fun testTablespoon() {
        val expected = 14.787E-6
        val actual = Tablespoon.convertTo(1.0, CubicMeter)
        assertEquals(expected, actual, 1E-8)
    } 
    
    @Test
    fun testTeaspoon() {
        val expected = 4.9289E-6
        val actual = Teaspoon.convertTo(1.0, CubicMeter)
        assertEquals(expected, actual, 1E-8)
    } 
    
    @Test
    fun testDryPint() {
        val expected = 0.5506105E-3
        val actual = DryPint.convertTo(1.0, CubicMeter)
        assertEquals(expected, actual, 1E-6)
    } 
    
    @Test
    fun testDryQuart() {
        val expected = 1.1012209E-3
        val actual = DryQuart.convertTo(1.0, CubicMeter)
        assertEquals(expected, actual, 1E-6)
    } 
    
    @Test
    fun testPeck() {
        val expected = 8.809767E-3
        val actual = Peck.convertTo(1.0, CubicMeter)
        assertEquals(expected, actual, 1E-6)
    } 
    
    @Test
    fun testBushel() {
        val expected = 35.23907E-3
        val actual = Bushel.convertTo(1.0, CubicMeter)
        assertEquals(expected, actual, 1E-6)
    } 
    
    @Test
    fun testDryBarrel     () {
        val expected = 0.11562712
        val actual = DryBarrel.convertTo(1.0, CubicMeter)
        assertEquals(expected, actual, 1E-6)
    } 
    
}

class MassTests {

    @Test
    fun testGram() {
        val expected = 0.001
        val actual = Gram.convertTo(1.0, Kilogram)
        assertEquals(expected, actual, 1E-6)
    }
    @Test
    fun testMilligram() {
        val expected = 1E-6
        val actual = Milligram.convertTo(1.0, Kilogram)
        assertEquals(expected, actual, 1E-8)
    }
    @Test
    fun testPoundMass() {
        val expected = 0.4535924
        val actual = PoundMass.convertTo(1.0, Kilogram)
        assertEquals(expected, actual, 1E-6)
    }
    @Test
    fun testOunce() {
        val expected = 0.0283495
        val actual = Ounce.convertTo(1.0, Kilogram)
        assertEquals(expected, actual, 1E-6)
    }
    @Test
    fun testStone() {
        val expected = 6.3502932
        val actual = Stone.convertTo(1.0, Kilogram)
        assertEquals(expected, actual, 1E-6)
    }
    @Test
    fun testHundredweightShort() {
        val expected = 45.359237
        val actual = Hundredwei.convertTo(1.0, Kilogram)
        assertEquals(expected, actual, 1E-6)
    }
    @Test
    fun testHundredweightLong() {
        val expected = 50.8023454
        val actual = Hundredwei.convertTo(1.0, Kilogram)
        assertEquals(expected, actual, 1E-6)
    }
    @Test
    fun testGrain() {
        val expected = 6.479892E-5
        val actual = Grain.convertTo(1.0, Kilogram)
        assertEquals(expected, actual, 1E-8)
    }
    @Test
    fun testShortTon() {
        val expected = 907.18474
        val actual = ShortTon.convertTo(1.0, Kilogram)
        assertEquals(expected, actual, 1E-6)
    }
    @Test
    fun testLongTon() {
        val expected = 1016.0469088
        val actual = LongTon.convertTo(1.0, Kilogram)
        assertEquals(expected, actual, 1E-6)
    }
    @Test
    fun testTonne() {
        val expected = 1000.0
        val actual = Tonne.convertTo(1.0, Kilogram)
        assertEquals(expected, actual, 1E-6)
    }
    @Test
    fun testCarat() {
        val expected = 0.0002
        val actual = Carat.convertTo(1.0, Kilogram)
        assertEquals(expected, actual, 1E-6)
    }
}
