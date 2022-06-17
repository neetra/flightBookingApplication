package unittest;
import test.*;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.*;

import static org.mockito.Mockito.times;


/**
 * Unit test for simple App.
 */

public class FileWriterFactoryTest{

    @Test
    public void ShouldReturnInstanceOfCSVFileWriter() {

        FileWriterFactory fileWriterFactory = new FileWriterFactory();
        IFileWriter csvFileWriter =  fileWriterFactory.getWriter("CSV");

        assertTrue(csvFileWriter instanceof CSVFileWriter);
        assertFalse(csvFileWriter instanceof TextFileWriter);
    }

    @Test
    public void ShouldReturnInstanceOfTextFileWriter() {

        FileWriterFactory fileWriterFactory = new FileWriterFactory();
        IFileWriter csvFileWriter =  fileWriterFactory.getWriter("Text");

        assertFalse(csvFileWriter instanceof CSVFileWriter);
        assertTrue(csvFileWriter instanceof TextFileWriter);
    }

}