package com.sodamoney.quickuconvert

import org.junit.Test

import org.junit.Assert.*
import java.math.BigDecimal
import java.math.MathContext
import kotlin.math.pow

class DigitalStorageTests {

    @Test
    fun testByte() {
        val expected = BigDecimal(8)
        val actual = Byte.convertTo(BigDecimal(1), Bit)
        assertEquals((expected/actual).compareTo(BigDecimal(1)), 0)
    } 
    
    @Test
    fun testKiloByte() {
        val expected = BigDecimal(8_000)
        val actual = KiloByte.convertTo(BigDecimal(1), Bit)
        assertEquals((expected/actual).compareTo(BigDecimal(1)), 0)
    } 
    
    @Test
    fun testMegaByte() {
        val expected = BigDecimal(8_000_000)
        val actual = MegaByte.convertTo(BigDecimal(1), Bit)
        assertEquals((expected/actual).compareTo(BigDecimal(1)), 0)
    } 
    
    @Test
    fun testGigaByte() {
        val expected = BigDecimal(8_000_000_000)
        val actual = GigaByte.convertTo(BigDecimal(1), Bit)
        assertEquals((expected/actual).compareTo(BigDecimal(1)), 0)
    } 
    
    @Test
    fun testTeraByte() {
        val expected = BigDecimal(8_000_000_000_000)
        val actual = TeraByte.convertTo(BigDecimal(1), Bit)
        assertEquals((expected/actual).compareTo(BigDecimal(1)), 0)
    } 
    
    @Test
    fun testPetaByte() {
        val expected = BigDecimal(8_000_000_000_000_000)
        val actual = PetaByte.convertTo(BigDecimal(1), Bit)
        assertEquals((expected/actual).compareTo(BigDecimal(1)), 0)
    } 
    
    @Test
    fun testExaByte() {
        val expected = BigDecimal(8_000_000_000_000_000_000)
        val actual = ExaByte.convertTo(BigDecimal(1), Bit)
        assertEquals((expected/actual).compareTo(BigDecimal(1)), 0)
    } 
    
    @Test
    fun testKibiByte() {
        val expected = BigDecimal(1024).multiply(BigDecimal(8))
        val actual = KibiByte.convertTo(BigDecimal(1), Bit)
        assertEquals((expected/actual).compareTo(BigDecimal(1)), 0)
    } 
    
    @Test
    fun testMebiByte() {
        val expected = BigDecimal(1024).pow(2).multiply(BigDecimal(8))
        val actual = MebiByte.convertTo(BigDecimal(1), Bit)
        assertEquals((expected/actual).compareTo(BigDecimal(1)), 0)
    } 
    
    @Test
    fun testGibiByte() {
        val expected = BigDecimal(1024).pow(3).multiply(BigDecimal(8))
        val actual = GibiByte.convertTo(BigDecimal(1), Bit)
        assertEquals((expected/actual).compareTo(BigDecimal(1)), 0)
    } 
    
    @Test
    fun testTebiByte() {
        val expected = BigDecimal(1024).pow(4).multiply(BigDecimal(8))
        val actual = TebiByte.convertTo(BigDecimal(1), Bit)
        assertEquals((expected/actual).compareTo(BigDecimal(1)), 0)
    } 
    
    @Test
    fun testPebiByte() {
        val expected = BigDecimal(1024).pow(5).multiply(BigDecimal(8))
        val actual = PebiByte.convertTo(BigDecimal(1), Bit)
        assertEquals((expected/actual).compareTo(BigDecimal(1)), 0)
    } 
    
    @Test
    fun testExbiByte() {
        val expected = BigDecimal(1024).pow(6).multiply(BigDecimal(8))
        val actual = ExbiByte.convertTo(BigDecimal(1), Bit)
        assertEquals((expected/actual).compareTo(BigDecimal(1)), 0)
    } 
    
    @Test
    fun testKiloBit() {
        val expected = BigDecimal(1_000)
        val actual = KiloBit.convertTo(BigDecimal(1), Bit)
        assertEquals((expected/actual).compareTo(BigDecimal(1)), 0)
    } 
    
    @Test
    fun testMegaBit() {
        val expected = BigDecimal(1_000_000)
        val actual = MegaBit.convertTo(BigDecimal(1), Bit)
        assertEquals((expected/actual).compareTo(BigDecimal(1)), 0)
    } 
    
    @Test
    fun testGigaBit() {
        val expected = BigDecimal(1_000_000_000)
        val actual = GigaBit.convertTo(BigDecimal(1), Bit)
        assertEquals((expected/actual).compareTo(BigDecimal(1)), 0)
    } 
    
    @Test
    fun testTeraBit() {
        val expected = BigDecimal(1_000_000_000_000)
        val actual = TeraBit.convertTo(BigDecimal(1), Bit)
        assertEquals((expected/actual).compareTo(BigDecimal(1)), 0)
    } 
    
    @Test
    fun testPetaBit() {
        val expected = BigDecimal(1_000_000_000_000_000)
        val actual = PetaBit.convertTo(BigDecimal(1), Bit)
        assertEquals((expected/actual).compareTo(BigDecimal(1)), 0)
    } 
    
    @Test
    fun testExaBit() {
        val expected = BigDecimal(1_000_000_000_000_000_000)
        val actual = ExaBit.convertTo(BigDecimal(1), Bit)
        assertEquals((expected/actual).compareTo(BigDecimal(1)), 0)
    } 
    
    @Test
    fun testKibiBit() {
        val expected = BigDecimal(1024)
        val actual = KibiBit.convertTo(BigDecimal(1), Bit)
        assertEquals((expected/actual).compareTo(BigDecimal(1)), 0)
    } 
    
    @Test
    fun testMebiBit() {
        val expected = BigDecimal(1024).pow(2)
        val actual = MebiBit.convertTo(BigDecimal(1), Bit)
        assertEquals((expected/actual).compareTo(BigDecimal(1)), 0)
    } 
    
    @Test
    fun testGibiBit() {
        val expected = BigDecimal(1024).pow(3)
        val actual = GibiBit.convertTo(BigDecimal(1), Bit)
        assertEquals((expected/actual).compareTo(BigDecimal(1)), 0)
    } 
    
    @Test
    fun testTebiBit() {
        val expected = BigDecimal(1024).pow(4)
        val actual = TebiBit.convertTo(BigDecimal(1), Bit)
        assertEquals((expected/actual).compareTo(BigDecimal(1)), 0)
    } 
    
    @Test
    fun testPebiBit() {
        val expected = BigDecimal(1024).pow(5)
        val actual = PebiBit.convertTo(BigDecimal(1), Bit)
        assertEquals((expected/actual).compareTo(BigDecimal(1)), 0)
    } 
    
    @Test
    fun testExbiBit() {
        val expected = BigDecimal(1024).pow(6)
        val actual = ExbiBit.convertTo(BigDecimal(1), Bit)
        assertEquals((expected/actual).compareTo(BigDecimal(1)), 0)
    } 
}
