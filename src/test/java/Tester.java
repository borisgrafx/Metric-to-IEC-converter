import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class Tester {
    @Test
    void engLightTest() throws Exception {
        Main.main(new String[]{"10", "kb"});
        PrintStream stream = mock(PrintStream.class);
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        System.setOut(stream);
        String params = "9 KiB 784 B";
        System.out.println(params);
        verify(stream).println(captor.capture());
        assertEquals(captor.getValue(), params);

        Main.main(new String[]{"10", "Pb", "999", "tb", "228", "gB", "3", "kb"});
        stream = mock(PrintStream.class);
        captor = ArgumentCaptor.forClass(String.class);
        System.setOut(stream);
        params = "9 PiB 787 TiB 757 GiB 347 MiB 920 KiB 952 B";
        System.out.println(params);
        verify(stream).println(captor.capture());
        assertEquals(captor.getValue(), params);
    }

    @Test
    void rusLightTest() throws Exception {
        Main.main(new String[]{"10", "киб"});
        PrintStream stream = mock(PrintStream.class);
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        System.setOut(stream);
        String params = "10 KB 240 B";
        System.out.println(params);
        verify(stream).println(captor.capture());
        assertEquals(captor.getValue(), params);

        Main.main(new String[]{"10", "Пб", "999", "тб", "228", "гБ", "3", "КБ"});
        stream = mock(PrintStream.class);
        captor = ArgumentCaptor.forClass(String.class);
        System.setOut(stream);
        params = "9 PiB 787 TiB 757 GiB 347 MiB 920 KiB 952 B";
        System.out.println(params);
        verify(stream).println(captor.capture());
        assertEquals(captor.getValue(), params);
    }

    @Test
    void crashMe() {
        Exception exception = assertThrows(NumberFormatException.class, () -> Main.main(new String[]{"10кб"}));
        String expectedMessage = "For input string: \"10кб\"";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}

