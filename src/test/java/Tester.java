import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
        Main.main(new String[]{"10", "кб"});
        PrintStream stream = mock(PrintStream.class);
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        System.setOut(stream);
        String params = "9 KiB 784 B";
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
}

