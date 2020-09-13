package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.Logic;
import ru.job4j.chess.OccupiedCellException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void testPosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        assertThat(bishopBlack.position(), is(Cell.C1));
    }

    @Test
    public void testCopy() {
        Figure bishopBlack = new BishopBlack(Cell.C1).copy(Cell.A3);
        assertThat(bishopBlack.position(), is(Cell.A3));
    }

    @Test
    public void testWay() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        assertThat(
                bishopBlack.way(Cell.C1, Cell.G5),
                is(new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5})
        );
    }

    @Test
    public void isDiagonalTrue() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        assertThat(bishopBlack.isDiagonal(Cell.C1, Cell.G5), is(true));
    }

    @Test(expected = IllegalStateException.class)
    public void isDiagonalFalse() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        bishopBlack.way(Cell.C1, Cell.F5);
    }

    @Test
    public void testFree() throws OccupiedCellException {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        logic.free(new Cell[] {Cell.A1, Cell.B1, Cell.C1, Cell.D1});
    }
}