package panzer.models.miscellaneous;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import panzer.contracts.Assembler;
import panzer.contracts.AttackModifyingPart;
import panzer.contracts.DefenseModifyingPart;
import panzer.contracts.HitPointsModifyingPart;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.List;

public class VehicleAssemblerTest {
    private Assembler vehicleAssembler;
    private AttackModifyingPart attackModifyingPart;
    private DefenseModifyingPart defenceModifyingPart;
    private HitPointsModifyingPart hitPointsModifyingPart;

    @Before
    public void setUp() throws Exception {
        // true instance on tested class
        this.vehicleAssembler = new VehicleAssembler();

        // mocked the inner classes
        this.attackModifyingPart = Mockito.mock(AttackModifyingPart.class);
        this.defenceModifyingPart = Mockito.mock(DefenseModifyingPart.class);
        this.hitPointsModifyingPart = Mockito.mock(HitPointsModifyingPart.class);

        // added the parts to the vehicleAssembler collections
        this.vehicleAssembler.addArsenalPart(this.attackModifyingPart);
        this.vehicleAssembler.addShellPart(this.defenceModifyingPart);
        this.vehicleAssembler.addEndurancePart(this.hitPointsModifyingPart);
    }

    @Test
    public void getTotalWeight() {
        // Arrange
        Mockito.when(this.attackModifyingPart.getWeight()).thenReturn(10.0);
        Mockito.when(this.defenceModifyingPart.getWeight()).thenReturn(20.0);
        Mockito.when(this.hitPointsModifyingPart.getWeight()).thenReturn(30.0);

        // Act
        double actualTotalWeight = this.vehicleAssembler.getTotalWeight();

        double expectedTotalWeight = 60;

        // Assert
        Assert.assertEquals(expectedTotalWeight, actualTotalWeight, 0.1);
    }

    @Test
    public void getTotalPrice() {
        // Arrange
        Mockito.when(this.attackModifyingPart.getPrice()).thenReturn(BigDecimal.ZERO);
        Mockito.when(this.defenceModifyingPart.getPrice()).thenReturn(BigDecimal.ONE);
        Mockito.when(this.hitPointsModifyingPart.getPrice()).thenReturn(BigDecimal.TEN);

        // Act
        BigDecimal actualTotalPrice = this.vehicleAssembler.getTotalPrice();
        BigDecimal expectedTotalPrice = BigDecimal.valueOf(11);

        // Assert
        Assert.assertEquals(expectedTotalPrice, actualTotalPrice);
    }

    @Test
    public void getTotalAttackModification() {
        // Arrange
        Mockito.when(this.attackModifyingPart.getAttackModifier()).thenReturn(50);
        AttackModifyingPart attackModifyingPart = Mockito.mock(AttackModifyingPart.class);

        Mockito.when(attackModifyingPart.getAttackModifier()).thenReturn(120);
        this.vehicleAssembler.addArsenalPart(attackModifyingPart);

        // Act
        long actualTotalAttackModification = this.vehicleAssembler.getTotalAttackModification();
        long expectedTotalAttackModification = 170;

        // Arrange
        Assert.assertEquals(expectedTotalAttackModification, actualTotalAttackModification, 0.1);
    }

    @Test
    public void getTotalDefenseModification() {
        // Arrange
        Mockito.when(this.defenceModifyingPart.getDefenseModifier()).thenReturn(50);
        DefenseModifyingPart defenseModifyingPart = Mockito.mock(DefenseModifyingPart.class);

        Mockito.when(defenseModifyingPart.getDefenseModifier()).thenReturn(120);
        this.vehicleAssembler.addShellPart(defenseModifyingPart);

        // Act
        long actualTotalDefenceModification = this.vehicleAssembler.getTotalDefenseModification();
        long expectedTotalDefenceModification = 170;

        // Arrange
        Assert.assertEquals(expectedTotalDefenceModification, actualTotalDefenceModification, 0.1);
    }

    @Test
    public void getTotalHitPointModification() {
        // Arrange
        Mockito.when(this.hitPointsModifyingPart.getHitPointsModifier()).thenReturn(50);
        HitPointsModifyingPart hitPointsModifyingPart = Mockito.mock(HitPointsModifyingPart.class);

        Mockito.when(hitPointsModifyingPart.getHitPointsModifier()).thenReturn(120);
        this.vehicleAssembler.addEndurancePart(hitPointsModifyingPart);

        // Act
        long actualTotalHitPointsModification = this.vehicleAssembler.getTotalHitPointModification();
        long expectedTotalHitPointsModification = 170;

        // Arrange
        Assert.assertEquals(expectedTotalHitPointsModification, actualTotalHitPointsModification, 0.1);
    }

    @Test
    public void addArsenalPart() {
        // Arrange
        Assembler assembler = new VehicleAssembler();
        AttackModifyingPart part = Mockito.mock(AttackModifyingPart.class);
        AttackModifyingPart part1 = Mockito.mock(AttackModifyingPart.class);
        AttackModifyingPart part2 = Mockito.mock(AttackModifyingPart.class);

        // Act
        assembler.addArsenalPart(part);
        assembler.addArsenalPart(part1);
        assembler.addArsenalPart(part2);

        int actualSize = 0;
        try {
            Field arsenalParts = assembler.getClass().getDeclaredField("arsenalParts");
            arsenalParts.setAccessible(true);
            List<AttackModifyingPart> parts = (List<AttackModifyingPart>) arsenalParts.get(assembler);

            actualSize = parts.size();

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        int expectedSize = 3;

        //  Assert
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void addShellPart() {
        // Arrange
        Assembler assembler = new VehicleAssembler();
        DefenseModifyingPart part = Mockito.mock(DefenseModifyingPart.class);
        DefenseModifyingPart part1 = Mockito.mock(DefenseModifyingPart.class);
        DefenseModifyingPart part2 = Mockito.mock(DefenseModifyingPart.class);

        // Act
        assembler.addShellPart(part);
        assembler.addShellPart(part1);
        assembler.addShellPart(part2);

        int actualSize = 0;
        try {
            Field shellParts = assembler.getClass().getDeclaredField("shellParts");
            shellParts.setAccessible(true);
            List<DefenseModifyingPart> parts = (List<DefenseModifyingPart>) shellParts.get(assembler);

            actualSize = parts.size();

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        int expectedSize = 3;

        //  Assert
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void addEndurancePart() {
        // Arrange
        Assembler assembler = new VehicleAssembler();
        HitPointsModifyingPart part = Mockito.mock(HitPointsModifyingPart.class);
        HitPointsModifyingPart part1 = Mockito.mock(HitPointsModifyingPart.class);
        HitPointsModifyingPart part2 = Mockito.mock(HitPointsModifyingPart.class);

        // Act
        assembler.addEndurancePart(part);
        assembler.addEndurancePart(part1);
        assembler.addEndurancePart(part2);

        int actualSize = 0;
        try {
            Field enduranceParts = assembler.getClass().getDeclaredField("enduranceParts");
            enduranceParts.setAccessible(true);
            List<HitPointsModifyingPart> parts = (List<HitPointsModifyingPart>) enduranceParts.get(assembler);

            actualSize = parts.size();

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        int expectedSize = 3;

        //  Assert
        Assert.assertEquals(expectedSize, actualSize);
    }
}