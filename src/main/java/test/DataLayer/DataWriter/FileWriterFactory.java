package  test;

public class FileWriterFactory  {

    public IFileWriter getWriter(String type){

        if(type.equalsIgnoreCase("CSV")){

            return new CSVFileWriter();
        }
        else if(type.equalsIgnoreCase("TEXT")){

            return new TextFileWriter();

        }

        return null;
    }
}